package com.zsk.usercenter.service

import com.zsk.usercenter.data.protocol.UserInfo
import rx.Observable


/**
 *
 * @Description:
 * @Author:         zsk
 * @CreateDate:     2020/9/14 16:09
 */
interface UserService {
    fun register(mobile:String,verifyCode:String,pwd:String): Observable<Boolean>
    fun login(mobile:String,pwd:String,pushId:String): Observable<UserInfo>
}