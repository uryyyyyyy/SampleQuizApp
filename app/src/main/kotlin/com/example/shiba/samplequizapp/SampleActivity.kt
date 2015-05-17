//package com.example.shiba.samplequizapp
//
//import android.app.Activity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.LinearLayout
//import android.widget.TextView
//import com.ogaclejapan.rx.binding.RxActions
//import com.ogaclejapan.rx.binding.RxProperty
//import com.ogaclejapan.rx.binding.RxView
//
//
//public class SampleActivity : Activity() {
//
//	override fun onCreate(savedInstanceState: Bundle?) {
//		//Activity生成の決まり文句
//		super.onCreate(savedInstanceState)
//
//		//properties用意
//		val text = RxProperty.create<String>()
//
//		//Component用意
//		val linearlayout = LinearLayout(this)
//		linearlayout.setOrientation(LinearLayout.HORIZONTAL)
//
//		val button = Button(this)
//		button.setText("change")
//
//		val textView = TextView(this)
//
//		//Event・配線
//		RxView.of(textView).bind(text, RxActions.setText())
//
//		button.setOnClickListener{v -> text.set(text.get() + "1")}
//
//
//		//Component配置
//		setContentView(linearlayout)
//		linearlayout.addView(button)
//		linearlayout.addView(textView)
//
//
//		//初期実行
//		text.set("hello")
//	}
//}