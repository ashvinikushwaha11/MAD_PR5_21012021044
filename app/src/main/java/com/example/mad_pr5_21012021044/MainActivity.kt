package com.example.mad_pr5_21012021044

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browseButton:Button = findViewById(R.id.button_browse)
        val editTextBrowser:EditText=findViewById(R.id.editTextText2)

        browseButton.setOnClickListener {
            onBrowser(editTextBrowser.text.toString())
        }
        val callButton:Button = findViewById(R.id.call_button)
        val editTextCall:EditText=findViewById(R.id.editTextText)

        callButton.setOnClickListener {
            onCall(editTextCall.text.toString())
        }
    }
    fun onBrowser(url:String){
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun onCall(call:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$call")).also { startActivity(it) }
    }
    fun onCallLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun onGallery(){
        Intent(Intent.ACTION_VIEW).setType("Image/*").also { startActivity(it) }
    }
    fun onCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun onAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }
}