package kr.ac.amu.cs.project

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main4.*
import android.R.raw
import java.util.*


class Main4Activity : AppCompatActivity() {
    val FIRST_ACTIVITY=1
    //var player: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var oCalendar = Calendar.getInstance()
        var lasthour:Int = oCalendar.get(Calendar.HOUR_OF_DAY)
        var lastminute:Int = oCalendar.get(Calendar.MINUTE)

        textView2.text = "$lasthour : $lastminute"

        startService(Intent(this@Main4Activity, SoundService::class.java))


        button2.setOnClickListener { view->
            stopService(Intent(this@Main4Activity, SoundService::class.java))

            //super.onDestroy()
            var intent= Intent(this,MainActivity::class.java)
            startActivityForResult(intent,FIRST_ACTIVITY)
        }
    }
}
