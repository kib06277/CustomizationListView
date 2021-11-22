package com.order.mostgreen.customizationlistview

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //创建数据源
    private val fruitList = ArrayList<Fruit>()
    lateinit var my_listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //初始化數據列表
        initfruit()

        //創建適配器
        val adapter = FruitAdapter(this,R.layout.fruit_item,fruitList)

        //init 關聯
        my_listView = this.findViewById(R.id.my_listView)

        //將適配器對象傳入 ListView ,從而建立 ListView 和數據聯繫
        my_listView.adapter = adapter

        //使用setOnItemClickListener()方法为每一项创建监听
        my_listView.setOnItemClickListener{parent,view,position,id->
            val fruit = fruitList[position]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }
    }

    private fun initfruit(){
        repeat(2){
            fruitList.add(Fruit("Apple",R.drawable.apple_pic))
            fruitList.add(Fruit("Banana",R.drawable.banana_pic))
            fruitList.add(Fruit("Orange",R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon",R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear",R.drawable.pear_pic))
            fruitList.add(Fruit("Grape",R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple",R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry",R.drawable.strawberry_pic))
        }
    }
}