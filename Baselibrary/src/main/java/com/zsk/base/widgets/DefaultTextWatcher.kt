package com.zsk.base.widgets

import android.text.Editable
import android.text.TextWatcher

/**
* @创建日期: 2020/9/17 9:29
* @作者: zsk
* @描述: 默认TextWatcher，空实现
*/
open class DefaultTextWatcher:TextWatcher{
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}
