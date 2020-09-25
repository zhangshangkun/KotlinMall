package com.zsk.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*
import kotlin.system.exitProcess

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/16 10:27
 * @Description:    管理类
 */
class AppManager private constructor() {

    private val activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy {
            AppManager()
        }
    }

    /**
     * 添加Activity
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 获取栈顶Activity
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }
    /**
     * 退出应用程序
     */
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager=context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        exitProcess(0)
    }
}