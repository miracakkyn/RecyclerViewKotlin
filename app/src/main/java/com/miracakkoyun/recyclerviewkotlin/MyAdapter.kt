package com.miracakkoyun.recyclerviewkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var yemekListesi:List<yemek>)
    :RecyclerView.Adapter<MyAdapter.myViewHolder>(){
    class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //textview ile iamgeViewi burda tanımlayacağız
        //aşağıda bu class için tanımlı fonksiyonlar bulunmaktadır

        var textYemek=itemView.findViewById<TextView>(R.id.recyclerRowText)
        var imageyemek=itemView.findViewById<ImageView>(R.id.recycleRowImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.recycle_row,parent,false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.textYemek.text=yemekListesi[position].name
        holder.imageyemek.setImageResource(yemekListesi[position].image)
        holder.itemView.setOnClickListener{
            var intent= Intent(holder.itemView.context,Detay::class.java)
            intent.putExtra("image",yemekListesi[position].image)
            intent.putExtra("yazi","deneme")
            holder.itemView.context.startActivity(intent)
        }
    }


}