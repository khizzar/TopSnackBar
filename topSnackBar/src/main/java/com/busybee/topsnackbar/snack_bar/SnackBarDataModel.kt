package com.busybee.topsnackbar.snack_bar

import android.view.View

/**
* Created by Khizzar
 * Dated 15-01-2024
* */
data class SnackBarDataModel (
    var rootView: View,
    var displayMsg: String,
    var bgColorID: Int? = null,
    var txtColorID: Int? = null,
    var displayIconID: Int? = null,
    var viewDuration: Int = 2000 // time in millis but is Int cause duration is set in Int
)