package com.zsk.base.ui.activity

import android.os.Bundle
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import com.zsk.base.common.AppManager

/**
 *
 * @Description:
 * @Author:         zsk
 * @CreateDate:     2020/9/14 15:35
 */
open class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}