//package com.example.sicksa
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//
//class sadariActivity : AppCompatActivity() {
//
//    override fun onCreate(saveInstanceState: Bundle?) {
//        super.onCreate(saveInstanceState)
//        setContentView(R.layout.sadari)
//
//    }
//}

package com.example.sicksa

//import android.R
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class moleActivity : AppCompatActivity() {

    var time: TextView? = null
    var count: TextView? = null
    var start: Button? = null
    var img_array = arrayOfNulls<ImageView>(9)
    var imageID = intArrayOf(
        R.id.imageView1,
        R.id.imageView2,
        R.id.imageView3,
        R.id.imageView4,
        R.id.imageView5,
        R.id.imageView6,
        R.id.imageView7,
        R.id.imageView8,
        R.id.imageView9
    )
    val TAG_ON = "on" //태그용
    val TAG_OFF = "off"
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mole)

        time = findViewById<View>(R.id.time) as TextView
        count = findViewById<View>(R.id.count) as TextView
        start = findViewById<View>(R.id.start) as Button

        for (i in img_array.indices) {
/*int img_id = getResources().getIdentifier("imageView"+i+1, "id", "com.example.pc_20.molegame");*/
            img_array[i] = findViewById<View>(imageID[i]) as ImageView
            img_array[i]!!.setImageResource(R.drawable.duda1)
            img_array[i]!!.tag = TAG_OFF
            img_array[i]!!.setOnClickListener { v ->

                //두더지이미지에 온클릭리스너
                if ((v as ImageView).tag.toString() == TAG_ON) {
                    Toast.makeText(applicationContext, "good", Toast.LENGTH_LONG).show()
                    count!!.text = score++.toString()
                    v.setImageResource(R.drawable.duda1)
                    v.setTag(TAG_OFF)
                } else {
                    Toast.makeText(applicationContext, "bad", Toast.LENGTH_LONG).show()
                    if (score <= 0) {
                        score = 0
                        count!!.text = score.toString()
                    } else {
                        count!!.text = score--.toString()
                    }
                    v.setImageResource(R.drawable.duda)
                    v.setTag(TAG_ON)
                }
            }
        }
        time!!.text = "30초"
        count!!.text = "0마리"
        start!!.setOnClickListener {
            start!!.visibility = View.GONE
            count!!.visibility = View.VISIBLE
            Thread(timeCheck()).start()
            for (i in img_array.indices) {
                Thread(DThread(i)).start()
            }
        }
    }

    var onHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            img_array[msg.arg1]!!.setImageResource(R.drawable.duda)
            img_array[msg.arg1]!!.tag = TAG_ON //올라오면 ON태그 달아줌
        }
    }
    var offHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            img_array[msg.arg1]!!.setImageResource(R.drawable.duda1)
            img_array[msg.arg1]!!.tag = TAG_OFF //내려오면 OFF태그 달아줌
        }
    }

    inner class DThread internal constructor(index: Int) : Runnable {
        //두더지를 올라갔다 내려갔다 해줌
        var index = 0 //두더지 번호
        override fun run() {
            while (true) {
                try {
                    val msg1 = Message()
                    val offtime = Random().nextInt(5000) + 500
                    Thread.sleep(offtime.toLong()) //두더지가 내려가있는 시간
                    msg1.arg1 = index
                    onHandler.sendMessage(msg1)
                    val ontime = Random().nextInt(1000) + 500
                    Thread.sleep(ontime.toLong()) //두더지가 올라가있는 시간
                    val msg2 = Message()
                    msg2.arg1 = index
                    offHandler.sendMessage(msg2)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

        init {
            this.index = index
        }
    }

    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            time!!.text = msg.arg1.toString() + "초"
        }
    }

    inner class timeCheck : Runnable {
        val MAXTIME = 30
        override fun run() {
            for (i in MAXTIME downTo 0) {
                val msg = Message()
                msg.arg1 = i
                handler.sendMessage(msg)
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            // val intent = Intent(this@sadariActivity, ResultActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
    }
}

//class MainActivity : AppCompatActivity() {
//    var time: TextView? = null
//    var count: TextView? = null
//    var start: Button? = null
//    var img1: ImageView? = null
//    var img2: ImageView? = null
//    var img3: ImageView? = null
//    var img4: ImageView? = null
//    var img5: ImageView? = null
//    var img6: ImageView? = null
//    var img7: ImageView? = null
//    var img8: ImageView? = null
//    var img9: ImageView? = null
//    var thread: Thread? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        time = findViewById(R.id.time)
//        count = findViewById(R.id.count)
//        start = findViewById(R.id.start)
//        img1 = findViewById(R.id.imageView1)
//        img2 = findViewById(R.id.imageView2)
//        img3 = findViewById(R.id.imageView3)
//        img4 = findViewById(R.id.imageView4)
//        img5 = findViewById(R.id.imageView5)
//        img6 = findViewById(R.id.imageView6)
//        img7 = findViewById(R.id.imageView7)
//        img8 = findViewById(R.id.imageView8)
//        img9 = findViewById(R.id.imageView9)
//        time.setText("30초")
//        count.setText("0마리")
//        start.setOnClickListener(View.OnClickListener {
//            start.setVisibility(View.GONE)
//            count.setVisibility(View.VISIBLE)
//            thread = Thread(timeCheck())
//            thread!!.start()
//        })
//    }
//
//    var handler: Handler = object : Handler() {
//        override fun handleMessage(msg: Message) {
//            time!!.text = msg.arg1.toString() + "초"
//            if (msg.arg1 == 0) {
//                startActivity(Intent(this@MainActivity, ResultActivity::class.java))
//                thread!!.interrupt()
//            }
//        }
//    }
//
//    inner class timeCheck : Runnable {
//        override fun run() {
//            var i = 30
//            while (true) {
//                try {
//                    val msg = Message()
//                    msg.arg1 = i--
//                    Thread.sleep(1000)
//                    handler.sendMessage(msg)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                    return
//                }
//            }
//        }
//    }
//}
