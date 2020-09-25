package com.zsk.base.common

import android.app.Application
import android.content.Context
import com.zsk.base.injection.component.AppComponent
import com.zsk.base.injection.component.DaggerAppComponent
import com.zsk.base.injection.module.AppModule

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 14:40
 * @Description:
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initInjection()
        context = this
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var context: Context
    }
}