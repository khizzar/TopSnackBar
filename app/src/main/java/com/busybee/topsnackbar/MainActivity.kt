package com.busybee.topsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.busybee.topsnackbar.snack_bar.ActionBtnSetup
import com.busybee.topsnackbar.snack_bar.SnackBarDataModel
import com.busybee.topsnackbar.snack_bar.TopSnackBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnShowSnackBar).setOnClickListener {
            TopSnackBar.makeSnackBar(SnackBarDataModel(
                rootView = it.rootView,
                displayMsg = "Top SnackBar Working!",
                bgColorID = getColor(android.R.color.black),
                txtColorID = getColor(android.R.color.white),
                displayIconID = R.drawable.status_ok,
                actionBtnSetup = ActionBtnSetup(
                    showActionButton = true,
                    actionBtnText = "Action",
                    btnBgColor = getColor(android.R.color.holo_blue_bright),
                    textColor = getColor(android.R.color.white),
                    action = {
                        Toast.makeText(this, "Working", Toast.LENGTH_LONG).show()
                    }
                )
            ))
        }
    }
}