package com.zsk.usercenter.presenter.view

import com.zsk.base.presenter.view.BaseView
import com.zsk.usercenter.data.protocol.UserInfo

/**
 * @Author:         zsk
 * @CreateDate:     2020/10/19 16:19
 * @Description:
 */
interface LoginView :BaseView {
    fun onLoginResult(result:UserInfo)
}