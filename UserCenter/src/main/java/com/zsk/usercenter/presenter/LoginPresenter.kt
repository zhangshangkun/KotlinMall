package com.zsk.usercenter.presenter

import com.zsk.base.ext.execute
import com.zsk.base.presenter.BasePresenter
import com.zsk.base.rx.BaseSubscribe
import com.zsk.usercenter.data.protocol.UserInfo
import com.zsk.usercenter.presenter.view.LoginView
import com.zsk.usercenter.service.UserService
import javax.inject.Inject

/**
 * @Author:         zsk
 * @CreateDate:     2020/10/19 16:18
 * @Description:
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserService

    fun login(mobile:String,pwd:String,pushId:String){
        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.login(mobile,pwd,pushId).execute(object :BaseSubscribe<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                    mView.onLoginResult(t)
            }
        },lifecycleProvider)

    }
}