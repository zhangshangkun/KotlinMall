package com.zsk.usercenter.data.api

import com.zsk.base.data.protocol.BaseResp
import com.zsk.usercenter.data.protocol.LoginReq
import com.zsk.usercenter.data.protocol.RegisterReq
import com.zsk.usercenter.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 9:42
 * @Description:
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req:RegisterReq): Observable<BaseResp<String>>

    @POST("userCenter/login")
    fun login(@Body req:LoginReq): Observable<BaseResp<UserInfo>>
}