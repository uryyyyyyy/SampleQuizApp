package com.example.shiba.samplequizapp

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.shiba.samplequizapp.db.UserContract
import com.example.shiba.samplequizapp.db.UserOpenHelper
import com.example.shiba.samplequizapp.util.LayoutParamsUtil
import com.example.shiba.samplequizapp.util.SizeUtil
import com.ogaclejapan.rx.binding.RxActions
import com.ogaclejapan.rx.binding.RxProperty
import com.ogaclejapan.rx.binding.RxView


public class MainActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		//Activity生成の決まり文句
		super.onCreate(savedInstanceState)
		val context = getApplicationContext()

		//properties用意
		val text = RxProperty.create<String>()

		val userOpenHelper = UserOpenHelper(this)
		val db = userOpenHelper.getWritableDatabase()

		UserOpenHelper.selectSample(db)

		// close db
		db.close();

		//Component配置
		val linearLayout = LinearLayout(this)
		linearLayout.setOrientation(LinearLayout.VERTICAL)
		setContentView(linearLayout)

		val score_TV = TextView(this)
		score_TV.setText("Score 0 / 0")
		val p1 = LayoutParamsUtil.generateWrapContent()
		p1.gravity = Gravity.RIGHT
		linearLayout.addView(score_TV, p1)

		val question_TV = TextView(this)
		question_TV.setGravity(Gravity.CENTER)
		question_TV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32f)
		question_TV.setTypeface(Typeface.DEFAULT_BOLD)
		question_TV.setText("Question")
		val p2 = LayoutParamsUtil.generateDefault()
		p2.width = ViewGroup.LayoutParams.MATCH_PARENT
		p2.height = SizeUtil.pxToDp(0, context)
		p2.weight = 2f
		linearLayout.addView(question_TV, p2)

		val a1_BT = Button(this)
		a1_BT.setText("A1")
		a1_BT.setTag("A1")
		val ansParams = LayoutParamsUtil.generateDefault()
		ansParams.width = ViewGroup.LayoutParams.MATCH_PARENT
		ansParams.height = SizeUtil.pxToDp(0, context)
		ansParams.weight = 1f
		linearLayout.addView(a1_BT, ansParams)

		val a2_BT = Button(this)
		a2_BT.setText("A2")
		a2_BT.setTag("A2")
		linearLayout.addView(a2_BT, ansParams)

		val a3_BT = Button(this)
		a3_BT.setText("A3")
		a3_BT.setTag("A3")
		linearLayout.addView(a3_BT, ansParams)

		val a4_BT = Button(this)
		a4_BT.setText("A4")
		a4_BT.setTag("A4")
		linearLayout.addView(a4_BT, ansParams)

		val next_BT = Button(this)
		next_BT.setText("Next")
		val p3 = LayoutParamsUtil.generateWrapContent()
		p3.gravity = Gravity.RIGHT
		p3.topMargin = SizeUtil.pxToDp(0, context)
		linearLayout.addView(next_BT, p3)

		//Event・配線
		RxView.of(question_TV).bind(text, RxActions.setText())
		val answerClickE:(View) -> Unit = {v -> Log.d("clickEvent", "${v.getTag() as String} clicked")}

		a1_BT.setOnClickListener(answerClickE)
		a2_BT.setOnClickListener(answerClickE)
		a3_BT.setOnClickListener(answerClickE)
		a4_BT.setOnClickListener(answerClickE)
		next_BT.setOnClickListener { v -> Log.d("clickEvent", "next") }

		//初期実行
		//text.set("hello")
	}
}