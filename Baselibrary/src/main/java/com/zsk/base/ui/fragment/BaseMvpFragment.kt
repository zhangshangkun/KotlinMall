package com.zsk.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zsk.base.common.BaseApplication
import com.zsk.base.injection.component.ActivityComponent
import com.zsk.base.injection.component.DaggerActivityComponent
import com.zsk.base.injection.module.ActivityModule
import com.zsk.base.injection.module.LifecycleProviderModule
import com.zsk.base.presenter.BasePresenter
import com.zsk.base.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/14 15:36
 * @Description:    Fragment基类，业务相关
 */
abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initInjection()
        injectComponent()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun injectComponent()

    private fun initInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((activity?.application as BaseApplication).appComponent)
            .activityModule(ActivityModule(activity!!))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
        toast(text)
    }
}