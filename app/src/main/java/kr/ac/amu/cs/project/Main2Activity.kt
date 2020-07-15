package kr.ac.amu.cs.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    val FIRST_ACTIVITY=1
    val THIRD_ACTIVITY=3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button4.setOnClickListener { view->
            var intent= Intent(this,MainActivity::class.java)
            startActivityForResult(intent,FIRST_ACTIVITY)
        }
        button6.setOnClickListener { view->
            var intent= Intent(this,Main3Activity::class.java)
            startActivityForResult(intent,THIRD_ACTIVITY)
        }
    }
}
