package com.zsk.base.rx

import com.zsk.base.presenter.view.BaseView
import rx.Subscriber

/**
 *
 * @Description:
 * @Author:         zsk
 * @CreateDate:     2020/9/14 17:03
 */
open class BaseSubscribe<T>(private val baseView:BaseView):Subscriber<T> (){
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if(e is BaseException){
            baseView.onError(e.msg)
        }
    }
}