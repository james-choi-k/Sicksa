package com.example.sicksa

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.listview.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)
        val items = mutableListOf<ListViewItem>()
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "14000원", "쭈꾸미도사"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "25000원", "봉추찜닭"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "4700원", "알촌"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "8000원", "손큰할매순대국"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "5000원", "부대통령뚝배기"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "5600원", "한솥도시락"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "8000원", "풍년식당"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "9000원", "알마루"))

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "20000원", "원조밥사랑"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "10000원", "육수당"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "20000원", "먹거리식당"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "8500원", "바른닭갈비"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "9000원", "명가춘천닭갈비"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "10500원", "혼밥의 고수"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "6000원", "ksk수육국밥"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "11000원", "엉터리생고기"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "6000원", "백악관식당"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "7000원", "장금이한식뷔페"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.hansil)!!, "8000원", "떼보네"))

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.yangsik)!!, "16000원", "파노파니"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.yangsik)!!, "8000원", "그랑드와"))




        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img33)!!, "8000원", "소룡각"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img33)!!, "6000원", "탕화쿵푸마라탕"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img33)!!, "10000원", "야미마라탕"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img33)!!, "12000원", "중국성"))



        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img44)!!, "8000원", "하나요리당고"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img44)!!, "11500원", "얌쿡"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img44)!!, "5400원", "최고당돈가스"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img44)!!, "15000원", "백야"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img44)!!, "11500원", "돈젠"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img44)!!, "6500원", "치쿠린"))

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img55)!!, "14000원", "성난즉석떡볶이"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img55)!!, "2000원", "맛드림김밥랜드"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img55)!!, "3500원", "신포우리만두"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img55)!!, "3000원", "김밥마루"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img55)!!, "4000원", "감탄떡볶이"))


        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img22)!!, "7000원", "피자스쿨"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img22)!!, "14000원", "꿀닭"))

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img66)!!, "16900원", "천사곱창"))

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.fastfood)!!, "9200원", "버거킹"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.fastfood)!!, "8900원", "맥도날드"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.fastfood)!!, "6200원", "롯데리아"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.fastfood)!!, "3100원", "이삭토스트"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.fastfood)!!, "5800원", "맘스터치"))


        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "2300원", "더 리터"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "2900원", "디저트39"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "3500원", "신동커피"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "3000원", "빈앤빈"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "2500원", "띵동와플"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "1500원", "쥬씨"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "2000원", "백다방"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "4700원", "뚜레쥬르"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "3900원", "공차"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "8900원", "배스킨라빈스"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "3000원", "스며들어와"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "4000원", "Mar Rueda"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "4800원", "커피명가"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "2000원", "커피콩"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "2000원", "메가커피"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "7900원", "설빙"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.img77)!!, "3500원", "커피 판다"))




        val adapter = ListViewAdapter(items)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = parent.getItemAtPosition(position) as ListViewItem
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }

    }
}
