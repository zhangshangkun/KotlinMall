package com.zsk.base.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.zsk.base.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*

/**
 * @Author:         zsk
 * @CreateDate:     2020/9/16 12:05
 * @Description:
 */
class HeaderBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isShowBack = true
    private var titleText: String? = null
    private var rightText: String? = null

    init {
        context.obtainStyledAttributes(attrs, R.styleable.HeaderBar).apply {
            isShowBack = getBoolean(R.styleable.HeaderBar_isShowBack, true)
            titleText = getString(R.styleable.HeaderBar_titleText)
            rightText = getString(R.styleable.HeaderBar_rightText)
            initView();
            recycle()
        }
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_header_bar, this)
        mLeftIv.visibility = if (isShowBack) View.VISIBLE else View.GONE

        titleText?.let {
            mTitleTv.text = it
        }
        rightText?.let {
            mRightTv.text = it
            mRightTv.visibility = View.VISIBLE
        }
    }
    fun getRightTView():TextView{
        return mRightTv
    }
}