package com.zsk.usercenter.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import com.zsk.base.common.AppManager
import com.zsk.base.ext.onClick
import com.zsk.base.ui.activity.BaseMvpActivity
import com.zsk.usercenter.R
import com.zsk.usercenter.injection.component.DaggerUserComponent
import com.zsk.usercenter.injection.module.UserModule
import com.zsk.usercenter.presenter.RegisterPresenter
import com.zsk.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    private var mExitTime:Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
//        mRegisterBtn.setOnClickListener {
//            mPresenter.register(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
//        }
//        mRegisterBtn.onClick(View.OnClickListener { mPresenter.register(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString()) })
        mRegisterBtn.onClick {
            mPresenter.register(
                mMobileEt.text.toString(),
                mVerifyCodeEt.text.toString(),
                mPwdEt.text.toString()
            )
        }
        mVerifyBtn.onClick {
            mVerifyBtn.requestSendVerifyNumber()
        }

    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule())
            .build().inject(this)
        mPresenter.mView = this
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode===KeyEvent.KEYCODE_BACK){
           if (System.currentTimeMillis()-mExitTime>2000){
               toast("再按一次退出程序")
               mExitTime=System.currentTimeMillis()
           }else{
               AppManager.instance.exitApp(this)
           }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}