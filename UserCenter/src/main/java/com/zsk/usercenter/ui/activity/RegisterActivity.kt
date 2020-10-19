package com.zsk.usercenter.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.zsk.base.common.AppManager
import com.zsk.base.ext.enable
import com.zsk.base.ext.onClick
import com.zsk.base.ui.activity.BaseMvpActivity
import com.zsk.usercenter.R
import com.zsk.usercenter.injection.component.DaggerUserComponent
import com.zsk.usercenter.injection.module.UserModule
import com.zsk.usercenter.presenter.RegisterPresenter
import com.zsk.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    private var mExitTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView() {
        mRegisterBtn.enable(mMobileEt) { isBtnEnable() }
        mRegisterBtn.enable(mVerifyCodeEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdConfirmEt) { isBtnEnable() }
        mVerifyBtn.onClick(this)
        mRegisterBtn.onClick(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule())
            .build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.mVerifyBtn -> {
                mVerifyBtn.requestSendVerifyNumber()
            }
            R.id.mRegisterBtn -> {
                mPresenter.register(
                    mMobileEt.text.toString(),
                    mVerifyCodeEt.text.toString(),
                    mPwdEt.text.toString()
                )
            }
        }

    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode === KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                toast("再按一次退出程序")
                mExitTime = System.currentTimeMillis()
            } else {
                AppManager.instance.exitApp(this)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}