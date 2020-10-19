package com.zsk.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.zsk.base.ext.enable
import com.zsk.base.ext.onClick
import com.zsk.base.ui.activity.BaseMvpActivity
import com.zsk.usercenter.R
import com.zsk.usercenter.data.protocol.UserInfo
import com.zsk.usercenter.injection.component.DaggerUserComponent
import com.zsk.usercenter.injection.module.UserModule
import com.zsk.usercenter.presenter.LoginPresenter
import com.zsk.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt) { isBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isBtnEnable() }
        mLoginBtn.onClick(this)
        mHeaderBar.getRightTView().onClick(this)
        mForgetPwdTv.onClick(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule())
            .build().inject(this)
        mPresenter.mView=this
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.mRightTv->{ startActivity<RegisterActivity>() }
            R.id.mLoginBtn -> {
                 mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
            }
            R.id.mForgetPwdTv->{

            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }

    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
    }

}