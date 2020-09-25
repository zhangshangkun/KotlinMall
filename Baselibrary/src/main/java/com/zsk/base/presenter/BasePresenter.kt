package com.zsk.base.presenter

import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import com.zsk.base.presenter.view.BaseView
import com.zsk.base.utils.NetWorkUtils
import javax.inject.Inject

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/14 15:30
 * @Description:
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    //Dagger注入，Rx生命周期管理
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}