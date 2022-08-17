package com.example.customlistview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.customlistview);
        listview.adapter = MyCustomAdapter(this@MainActivity, Writer.writerList)

        listview.setOnItemClickListener { parent, view, position,id ->
            val intent = Intent(this@MainActivity, WriterDetail::class.java)
            intent.putExtra("writerid", position)
            startActivity(intent)
        }
    }

    private class MyCustomAdapter(val context: Context, val items: Array<Writer>): BaseAdapter() {
        private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // No of rows in the list
        override fun getCount(): Int {
            return items.size;
        }

        override fun getItem(p0: Int): Any {
            return items[p0] as Writer
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        // Responsible for rendering each row
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val rowView = inflater.inflate(R.layout.list_item, p2, false)
            val imageView = rowView.findViewById<ImageView>(R.id.listimageview)
            val textTitle = rowView.findViewById<TextView>(R.id.textview1)
            val textDesc = rowView.findViewById<TextView>(R.id.textview2)
            imageView.setImageResource(items[p0].image)
            textTitle.text = items[p0].name
            textDesc.text = items[p0].description
            return rowView
        }

    }
}