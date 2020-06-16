package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    var sumval=0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)


        button.onClick {

            var msg_date = editText.text.toString()
            var msg = msg_input.text.toString()
            var msg_money = editText2.text.toString()
            sumval+=msg_money.toFloat()
            if (msg!=""){
                myAdapter.insert("日期: "+msg_date+"  名稱: "+msg+"  金額: "+msg_money, 0)
            }
            msg_input.setText("")
            editText.setText("")
            editText2.setText("")
            textView3.setText("總金額: "+sumval.toString())


        }
        main_listview.setOnItemClickListener { parent, view, i, id ->
            var msg=myAdapter.getItem(i)
            alert ("確定要刪除$msg?"){
                yesButton { myAdapter.remove(msg) }
                noButton {  }
            }.show()

        }
        main_listview.adapter= myAdapter
    }
}
