package kr.ac.amu.cs.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TimePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*

class Main3Activity : AppCompatActivity() {

    val FIRST_ACTIVITY=1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var mTimePicker = findViewById<TimePicker>(R.id.time_picker) //타임피커 객체 생성
        button7.setOnClickListener { view ->
            finish()
        }
        button8.setOnClickListener { view ->
            finish()
        }
        button9.setOnClickListener { view->
            var intent= Intent(this,MainActivity::class.java)
                var hour:Int //시간
                var min:Int //분
                val alarm_on = findViewById<View>(R.id.button9)

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) { //버전에 따라서 함수가 다름
                    hour = mTimePicker.getHour()
                    min = mTimePicker.getMinute()

                    intent.putExtra("hour",hour) //인텐트에 시간
                    intent.putExtra("minute",min) //인텐트에 분 붙이기
                }
                else {
                    hour = mTimePicker.getCurrentHour()
                    min = mTimePicker.getCurrentMinute()

                    intent.putExtra("hour",hour) //인텐트에 시간
                    intent.putExtra("minute",min) //인텐트에 분 붙이기
                }
                Toast.makeText(this,"Alarm 예정 $hour 시 $min 분",Toast.LENGTH_LONG).show()
                startActivityForResult(intent,FIRST_ACTIVITY)
        }
    }

}
