package com.example.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_masure.*

class masure : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masure)
        val first = intent.getIntExtra("first",0)
        val second = intent.getIntExtra("second",0)
        mBackBtn.setOnClickListener {
            val reData = first + second
            val intent = Intent()
            intent.putExtra("return",reData)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        call.setOnClickListener{
            Intent().apply {
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel:19946920474")
            }.also {
                startActivity(it)
            }
        }
    }
}
