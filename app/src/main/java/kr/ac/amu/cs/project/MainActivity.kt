package kr.ac.amu.cs.project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.TextView
import java.text.SimpleDateFormat
import kotlin.math.log10


class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY=2
    val THIRD_ACTIVITY=3
    val FORTH_ACTIVITY=4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        var hour = intent.getIntExtra("hour",0)
        var min = intent.getIntExtra("minute",0)
        Toast.makeText(this,"Alarm : $hour 시 $min 분", Toast.LENGTH_LONG).show()

        textView2.text = "$hour 시"
        textView3.text = "$min 분"



        button10.setOnClickListener { view ->
            var intent= Intent(this,Main4Activity::class.java)

            var oCalendar = Calendar.getInstance()
            var lasthour:Int = oCalendar.get(Calendar.HOUR_OF_DAY)-3
            var lastminute:Int = oCalendar.get(Calendar.MINUTE)

            var a = lasthour.toLong()
            var b = lastminute.toLong()


            var sss: Long = /*((hour+(a))*60*1000) +*/ (min - b)*60*1000


            val mTimer = Timer()
            mTimer.run { try {
                Thread.sleep(sss)
                vibrator.vibrate(2000);

                startActivityForResult(intent,FORTH_ACTIVITY)
            } catch (e: Exception) {
                e.printStackTrace()
            } }

            button.setOnClickListener { view ->
                mTimer.cancel();
                super.onDestroy();
            }
        }
        button2.setOnClickListener { view->
            var intent= Intent(this,Main2Activity::class.java)
            startActivityForResult(intent,SECOND_ACTIVITY)
        }
        button3.setOnClickListener { view->
            var intent= Intent(this,Main3Activity::class.java)
            startActivityForResult(intent,THIRD_ACTIVITY)
        }
    }
}
