package com.zsk.usercenter.service.impl

import com.zsk.base.ext.convertBoolean
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

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode)
            .convertBoolean()
    }
}
