package com.example.text

import android.Manifest
import android.app.Activity
import android.app.LauncherActivity.ListItem
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.text.databinding.ActivityMainBinding
import com.googlecode.tesseract.android.TessBaseAPI
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    val itemList = arrayListOf<translationItem>()
    val listAdapter = ListAdapter(itemList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //리사이클러 뷰
        binding.translationList.layoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.translationList.adapter = listAdapter
        itemList.add(translationItem("번역본 1"))
        itemList.add(translationItem("번역본 2"))
        itemList.add(translationItem("번역본 3"))
        itemList.add(translationItem("번역본 4"))
        itemList.add(translationItem("번역본 5"))
        itemList.add(translationItem("번역본 6"))


        val intent = Intent(this, OCR_page::class.java)
        binding.ocrPageBtn.setOnClickListener{startActivity(intent)}

    }


}