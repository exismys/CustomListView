package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class WriterDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writer_detail)

        val textView = findViewById<TextView>(R.id.nameview)
        val imageView = findViewById<ImageView>(R.id.imageview)
        val descView = findViewById<TextView>(R.id.descview)

        val writerid = intent.extras?.get("writerid") as Int
        val writer = Writer.writerList[writerid]
        textView.text = writer.name
        imageView.setImageResource(writer.image)
        descView.text = writer.description
    }
}