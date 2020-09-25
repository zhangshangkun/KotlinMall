package com.zsk.base.injection.module

import android.app.Activity
import com.zsk.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/15 14:39
 * @Description:
 */
@Module
class ActivityModule(private val activity: Activity) {
    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return activity
    }
}