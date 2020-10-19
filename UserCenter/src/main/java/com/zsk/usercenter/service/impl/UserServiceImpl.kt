package com.zsk.usercenter.service.impl

import com.zsk.base.ext.convert
import com.zsk.base.ext.convertBoolean
import com.zsk.usercenter.data.protocol.UserInfo
import com.zsk.usercenter.data.repository.UserRepository
import com.zsk.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 *
 * @Description:
 * @Author:         zsk
 * @CreateDate:     2020/9/14 16:17
 */
class UserServiceImpl @Inject constructor():UserService {
    @Inject
    lateinit var repository:UserRepository
    //注册
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode)
            .convertBoolean()
    }
    //登录
    override fun login(mobile: String,pwd: String,pushId:String):Observable<UserInfo>{
        return repository.login(mobile,pwd,pushId)
            .convert()
    }
}
