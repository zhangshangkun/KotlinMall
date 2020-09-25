package com.zsk.base.injection.component

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import com.zsk.base.injection.ActivityScope
import com.zsk.base.injection.module.ActivityModule
import com.zsk.base.injection.module.LifecycleProviderModule
import dagger.Component

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 14:38
 * @Description:
 */
@ActivityScope
@Component(dependencies = [AppComponent::class],modules = [ActivityModule::class,LifecycleProviderModule::class])
interface ActivityComponent {
    fun activity():Activity
    fun context():Context
    fun lifecycleProvider():LifecycleProvider<*>
}