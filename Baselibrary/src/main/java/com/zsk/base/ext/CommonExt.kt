package com.zsk.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.trello.rxlifecycle.LifecycleProvider
import com.zsk.base.data.protocol.BaseResp
import com.zsk.base.rx.BaseFunc
import com.zsk.base.rx.BaseFuncBoolean
import com.zsk.base.widgets.DefaultTextWatcher
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/14 17:08
 * @Description:
 */
fun <T> Observable<T>.execute(subscriber: Subscriber<T>,lifecycleProvider: LifecycleProvider<*>){
    this.observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribeOn(Schedulers.io())
        .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(listener:View.OnClickListener){
    this.setOnClickListener(listener)
}
fun View.onClick(method:()->Unit){
    this.setOnClickListener{method()}
}
fun Button.enable(et:EditText,method: () -> Boolean){
    val btn=this
    et.addTextChangedListener(object : DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            super.onTextChanged(s, start, before, count)
            btn.isEnabled=method()
        }
    })
}