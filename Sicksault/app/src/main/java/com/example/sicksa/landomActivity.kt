package com.example.sicksa

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.landom_lan.*
import kotlinx.android.synthetic.main.landom_lan.*
import java.util.*
import kotlin.collections.ArrayList


class landomActivity : AppCompatActivity() {

    val BallList = ArrayList<Bitmap>()

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.landom_lan)

//        Toast.makeText(this@landomActivity, "Create lottovall image.", Toast.LENGTH_SHORT).show()
            for( i in 0..7)
            {

                var bmp : Int = getResources().getIdentifier("food" + (i + 1), "drawable", packageName )
                var bitmap:Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), bmp), 350,350, false)
                BallList.add(bitmap)
            }

        val btn : Button = findViewById<Button>(R.id.random1)


        btn.setOnClickListener{
//            Toast.makeText(this@landomActivity, "button start.", Toast.LENGTH_SHORT).show()

            var set: TreeSet<Int> = TreeSet()
            while(set.size < 1){
                val random = Random()
                val num = random.nextInt(8)
                set.add(num)
            }

//            Toast.makeText(this@landomActivity, "ball check.", Toast.LENGTH_SHORT).show()

            var nCount = 0
            for( i in set)
            {
                var tmpID : Int = getResources().getIdentifier("foodview" + (nCount + 1),
                    "id", packageName )
                val imgView = findViewById<ImageView>(tmpID)
                imgView.setImageBitmap(BallList.get(i))
                nCount++
            }

//            Toast.makeText(this@landomActivity, "button end.", Toast.LENGTH_SHORT).show()


        }


    }
}