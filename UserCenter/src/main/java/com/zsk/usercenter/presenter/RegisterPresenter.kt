package com.zsk.usercenter.presenter

import com.zsk.base.ext.execute
import com.zsk.base.presenter.BasePresenter
import com.zsk.base.rx.BaseSubscribe
import com.zsk.usercenter.presenter.view.RegisterView
import com.zsk.usercenter.service.UserService
import javax.inject.Inject


/**
 *
 * @Description:
 * @Author:         zsk
 * @CreateDate:     2020/9/14 15:42
 */
class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {
    @Inject
    lateinit var userService: UserService

    fun register(mobile:String,verifyCode:String,pwd:String){
       /*
       * 业务逻辑
       */
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.register(mobile,verifyCode,pwd)
            .execute(object : BaseSubscribe<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    if (t)
                    mView.onRegisterResult("注册成功")

                }
            },lifecycleProvider)
    }
}

