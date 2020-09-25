package com.zsk.base.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/15 14:54
 * @Description:
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope