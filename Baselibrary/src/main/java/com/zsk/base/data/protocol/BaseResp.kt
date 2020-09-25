package com.zsk.base.data.protocol

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 9:38
 * @Description:
 */
class BaseResp<T>(val status:Int,val message:String,val data:T){
}