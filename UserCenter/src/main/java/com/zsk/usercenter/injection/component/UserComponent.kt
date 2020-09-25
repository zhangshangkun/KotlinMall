package com.zsk.usercenter.injection.component

import com.zsk.base.injection.PerComponentScope
import com.zsk.base.injection.component.ActivityComponent
import com.zsk.usercenter.injection.module.UserModule
import com.zsk.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 12:12
 * @Description:
 */
@PerComponentScope
@Component(dependencies = [ActivityComponent::class],modules = [UserModule::class])
interface UserComponent {
    fun inject(activity:RegisterActivity)
}