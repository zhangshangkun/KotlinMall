package com.zsk.base.injection.module

import android.content.Context
import com.zsk.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/15 14:39
 * @Description:
 */
@Module
class AppModule(private val context: BaseApplication) {

    @Singleton
    @Provides
    fun provideContext():Context{
        return context
    }
}