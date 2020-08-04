package com.example.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mJump.setOnClickListener {
            //明确指定从当前指定跳到masure界面
           Intent(this,masure::class.java).apply {
               putExtra("first",mFirst.text.toString().toInt())
               putExtra("second",mSecond.text.toString().toInt())
               //startActivity(intent)
           }.also {
               startActivityForResult(it,1)
           }
        }
        share.setOnClickListener{
            Intent().apply {
                action = "yjss.wechat"
                data = Uri.parse("content:今天完成了Activity的跳转，很棒！")
            }.also {
                startActivityForResult(it,2)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK) {
                val resultData = data?.getIntExtra("return",0)
                tv.text = resultData.toString()
            }
        }else if(requestCode == 2){
                data?.getStringExtra("shareResult").also {
                    Toast.makeText(this,it,Toast.LENGTH_LONG).show()
                }
        }

    }

}
