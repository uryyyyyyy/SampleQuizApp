package com.example.shiba.samplequizapp.util

import android.content.Context
import android.util.DisplayMetrics
import kotlin.platform.platformStatic

public object SizeUtil {
	platformStatic fun dpToPx(dp:Int, con: Context):Int {
		val displayMetrics = con.getResources().getDisplayMetrics()
		return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
	}

	platformStatic fun pxToDp(px:Int, con: Context):Int {
		val displayMetrics = con.getResources().getDisplayMetrics()
		return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
	}

}
