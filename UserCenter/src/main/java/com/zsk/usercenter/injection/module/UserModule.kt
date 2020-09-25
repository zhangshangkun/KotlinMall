package com.zsk.usercenter.injection.module

import com.zsk.usercenter.service.UserService
import com.zsk.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 11:37
 * @Description:
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}