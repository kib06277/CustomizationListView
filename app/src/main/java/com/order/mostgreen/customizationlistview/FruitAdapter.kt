package com.order.mostgreen.customizationlistview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(activity: Activity, val resourceId:Int, data:List<Fruit>): ArrayAdapter<Fruit>(activity,resourceId,data) {

    //用来缓存控件实例的内部类
    inner class ViewHolder(val fruitImage:ImageView,val fruitName:TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view:View
        val viewHolder:ViewHolder

        //如果之前没有缓存过
        if(convertView == null){

            //自动缓存布局
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)

            //获取控件实例
            val fruitImage:ImageView = view.findViewById(R.id.fruitImage)
            val fruitName:TextView = view.findViewById(R.id.fruitName)

            //缓存控件实例
            viewHolder = ViewHolder(fruitImage,fruitName)

            //调用View的setTag()方法将ViewHolder对象存储在View中
            view.tag = viewHolder

        } else {

            //如果已经缓存过了
            //复用缓存的布局
            view = convertView

            //调用getTag()方法将ViewHolder实例取出
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)

        if(fruit!=null) {

            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name

        }

        return view
    }

    /*
    //重寫 getView 方法，每當子項目被滾入螢幕時呼叫此方法來構建子項目
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //為子項目布局
        val view = LayoutInflater.from(context).inflate(resourceId,parent,false)

        //分別獲取佈局中的物件
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)

        //獲取當前在 ArrayList<Fruit> 中的 Fruit 資料
        val fruit = getItem(position)

        //設置圖片和文字
        if(fruit != null){
            fruitImage.setImageResource(fruit.imageId)
            fruitName.text = fruit.name
        }

        //回傳布局
        return view
    }
    */
}