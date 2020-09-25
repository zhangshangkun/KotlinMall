package com.zsk.base.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/15 16:05
 * @Description:
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider:LifecycleProvider<*>) {

    @Provides
    fun providesLifecycleProvider():LifecycleProvider<*>{
        return lifecycleProvider
    }
}