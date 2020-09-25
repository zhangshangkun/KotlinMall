package com.zsk.base.presenter.view

/**
 *
 * @Description:
 * @Author:         zsk
 * @CreateDate:     2020/9/14 15:33
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}