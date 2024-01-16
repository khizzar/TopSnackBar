package com.busybee.topsnackbar.snack_bar

import android.content.res.ColorStateList
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.busybee.topsnackbar.R
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Khizzar
 * Dated 15-01-2024
 * */

object TopSnackBar {

    private lateinit var alertSnackBar: Snackbar

    fun makeSnackBar(snackBarDataModel: SnackBarDataModel) {
        try {
            val context = snackBarDataModel.rootView.context ?: return

            if (this::alertSnackBar.isInitialized && alertSnackBar.isShownOrQueued) {
                return
            }

            val mInflater = LayoutInflater.from(context)

            // set the length of snackBar
            alertSnackBar = Snackbar.make(
                snackBarDataModel.rootView,
                snackBarDataModel.displayMsg,
                snackBarDataModel.viewDuration
            )

            // settings for default snackBar view
            val layout = alertSnackBar.view as Snackbar.SnackbarLayout
            val textView =
                layout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.visibility = View.INVISIBLE
            layout.getChildAt(0).layoutParams.height = 0
            layout.setBackgroundColor(context.resources.getColor(android.R.color.transparent, null))

            // inflate custom snackBar layout
            val snackView: View = mInflater.inflate(R.layout.generic_snackbar_view, null)
            val linearParent = snackView.findViewById<LinearLayout>(R.id.linearSnackParent)
            val textViewTop = snackView.findViewById<TextView>(R.id.tvMsg)
            val ivIcon = snackView.findViewById<AppCompatImageView>(R.id.barIcon)
            val actionBtn = snackView.findViewById<AppCompatButton>(R.id.btnAction)

            // set the BG color if provided
            snackBarDataModel.bgColorID?.let {
                linearParent.backgroundTintList = ColorStateList.valueOf(it)
            }

            // set the text color if provided
            snackBarDataModel.txtColorID?.let {
                textViewTop.setTextColor(it)
            }

            // set the icon if provided
            snackBarDataModel.displayIconID?.let {
                ivIcon.setImageResource(it)
            } ?: kotlin.run {
                ivIcon.visibility = View.INVISIBLE
            }

            // set action btn visibility and action
            makeActionBtn(actionBtn, snackBarDataModel)

            // set the msg to display
            textViewTop.text = snackBarDataModel.displayMsg


            //If the view is not covering the whole snackBar layout, add this line
            layout.setPadding(0, 80, 0, 0)

            // Add the view to the SnackBar's layout
            layout.addView(snackView, 0)

            //this will move the snackBar to the top
            val layoutParams = snackView.rootView.layoutParams as FrameLayout.LayoutParams
            layoutParams.gravity = Gravity.TOP
            snackView.rootView.layoutParams = layoutParams
            alertSnackBar.duration = snackBarDataModel.viewDuration
            alertSnackBar.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun makeActionBtn(actionBtn: AppCompatButton, snackBarDataModel: SnackBarDataModel) {
        if (snackBarDataModel.actionBtnSetup.showActionButton){
            actionBtn.visibility = View.VISIBLE
            snackBarDataModel.actionBtnSetup.btnBgColor?.let { actionBtn.backgroundTintList = ColorStateList.valueOf(it) }
            snackBarDataModel.actionBtnSetup.textColor?.let { actionBtn.setTextColor(it) }
            actionBtn.text = snackBarDataModel.actionBtnSetup.actionBtnText
            actionBtn.setOnClickListener { snackBarDataModel.actionBtnSetup.action.invoke() }
        } else actionBtn.visibility = View.GONE
    }


}