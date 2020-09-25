package com.zsk.base.ext

import android.view.View
import com.trello.rxlifecycle.LifecycleProvider
import com.zsk.base.data.protocol.BaseResp
import com.zsk.base.rx.BaseFunc
import com.zsk.base.rx.BaseFuncBoolean
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