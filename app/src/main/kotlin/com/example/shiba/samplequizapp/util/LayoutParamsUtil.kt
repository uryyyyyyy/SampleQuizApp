package com.example.shiba.samplequizapp.util

import android.view.ViewGroup
import android.widget.LinearLayout
import kotlin.platform.platformStatic

public object LayoutParamsUtil {
	platformStatic fun generateDefault():LinearLayout.LayoutParams {
		return LinearLayout.LayoutParams(
				0,
				0)
	}

	platformStatic fun generateWrapContent():LinearLayout.LayoutParams {
		return LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT)
	}

}