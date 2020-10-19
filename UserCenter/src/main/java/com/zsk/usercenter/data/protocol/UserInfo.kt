package com.zsk.usercenter.data.protocol

/**
 *
 * @Author:         zsk
 * @CreateDate:     2020/9/15 9:44
 * @Description:    用户实体类
 */
data class UserInfo(
    val id: String,
    val userIcon: String,
    val userName: String,
    val userGender: String,
    val userMobile: String,
    val userSign: String
)
