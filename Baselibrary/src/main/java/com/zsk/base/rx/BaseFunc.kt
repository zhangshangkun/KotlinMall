package com.zsk.base.rx

import com.zsk.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/15 16:25
 * @Description:
 */
class BaseFunc<T>:Func1<BaseResp<T>,Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }
}