package com.zsk.base.injection.component

import android.content.Context
import com.zsk.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/15 14:38
 * @Description:
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context():Context
}