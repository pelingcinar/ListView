package com.pelingulcinar.listview

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colessum")
        landmarkNames.add("London Bridge")
        landmarkNames.add("Eiffel")

        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colosseum)
        val londonbridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)

        val landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colosseum)
        landmarkImages.add(londonbridge)
        landmarkImages.add(eiffel)


        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, landmarkNames)
        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->


            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("name", landmarkNames[i])
            val bitmap = landmarkImages[i]
            val chosen = Globals.Chosen
            chosen.chosenImage = bitmap
            startActivity(intent)


        }

    }
}
