package com.miracakkoyun.recyclerviewkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.miracakkoyun.recyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var pizza=yemek("Pizza",250,R.drawable.pizza)
        var corba=yemek("Çorba",100,R.drawable.corba)
        var doner=yemek("Döner",200,R.drawable.doner)
        var hamburger=yemek("Hamburger",250,R.drawable.kofteburger)

        var yemekListesi=ArrayList<yemek>()
        yemekListesi.add(pizza)
        yemekListesi.add(corba)
        yemekListesi.add(doner)
        yemekListesi.add(hamburger)

        //recyclerview optimizasyon için daha mantıklı çümkü tüm nesneleri yüklemek yerine sayfadaki nesneler kadar laan kaplıyor

        var adapter=MyAdapter(yemekListesi)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)



    }
}