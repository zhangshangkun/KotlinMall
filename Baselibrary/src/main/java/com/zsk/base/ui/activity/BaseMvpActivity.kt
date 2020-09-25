package com.zsk.base.ui.activity

import android.os.Bundle
import com.zsk.base.common.BaseApplication
import com.zsk.base.injection.component.ActivityComponent
import com.zsk.base.injection.component.DaggerActivityComponent
import com.zsk.base.injection.module.ActivityModule
import com.zsk.base.injection.module.LifecycleProviderModule
import com.zsk.base.presenter.BasePresenter
import com.zsk.base.presenter.view.BaseView
import com.zsk.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 *
 * @Description:
 * @Author:         zsk
 * @CreateDate:     2020/9/14 15:36
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T
    private lateinit var mProgressDialog: ProgressLoading
    lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        injectComponent()
        mProgressDialog = ProgressLoading.crateDialog(this)
    }

    abstract fun injectComponent()

    private fun initInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
        mProgressDialog.showLoading()
    }

    override fun hideLoading() {
        mProgressDialog.hideLoading()
    }

    override fun onError(text:String) {
        toast(text)
    }
}