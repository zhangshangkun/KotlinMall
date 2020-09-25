//package com.zsk.baselibrary.widgets
//
//import android.app.Dialog
//import android.content.Context
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.view.*
//import android.widget.LinearLayout
//import android.widget.TextView
//import cn.itzhong.itzhong.R
//import com.zsk.baselibrary.R
//
//class loadDialog(context: Context) : Dialog(context) {
//    private val context: Context
//    private val loadingDialog: Dialog
//    private val tvMessage: TextView
//
//    fun setMessage(message: String?) {
//        tvMessage.text = message
//    }
//
//    /**
//     * 关闭
//     * @return
//     */
//    override fun dismiss() {
//        if (loadingDialog.isShowing) {
//            loadingDialog.dismiss()
//        }
//    }
//
//    /**
//     * 显示
//     * @return
//     */
//    override fun show() {
//        if (!loadingDialog.isShowing) {
//            loadingDialog.show()
//        }
//    }
//
//    init {
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        this.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        setCanceledOnTouchOutside(false)
//        this.context = context
//        val inflater = LayoutInflater.from(context)
//        val v: View = inflater.inflate(R.layout.dialog_loading, null) // 得到加载view
//        val layout = v.findViewById<LinearLayout>(R.id.dialog_loading_view) // 加载布局
//        // 提示文字
//        tvMessage = v.findViewById(R.id.tipTextView)
//        // 创建自定义样式dialog
//        loadingDialog = Dialog(context, R.style.MyDialogStyle)
//        loadingDialog.setCancelable(true) // 是否可以按“返回键”消失
//        loadingDialog.setCanceledOnTouchOutside(false) // 点击加载框以外的区域
//        loadingDialog.setContentView(
//            layout, LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT
//            )
//        ) // 设置布局
//        val window = loadingDialog.window
//        val lp = window!!.attributes
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
//        window.setGravity(Gravity.CENTER)
//        window.attributes = lp
//        //        window.setWindowAnimations(R.style.PopWindowAnimStyle);
//    }
//}