package com.zsk.usercenter.data.repository

import com.zsk.base.data.net.RetrofitFactory
import com.zsk.base.data.protocol.BaseResp
import com.zsk.usercenter.data.api.UserApi
import com.zsk.usercenter.data.protocol.LoginReq
import com.zsk.usercenter.data.protocol.RegisterReq
import com.zsk.usercenter.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 9:57
 * @Description:
 */
class UserRepository @Inject constructor() {
    fun register(mobile:String,pwd:String,verifyCode:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile,pwd,verifyCode))
    }
    fun login(mobile:String,pwd:String,pushId:String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile,pwd,pushId))
    }
}