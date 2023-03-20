package com.pinslog.androidunitysample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class BridgeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bridge)

        val button = findViewById<Button>(R.id.unity_btn)

        button.setOnClickListener {
            val intent = Intent(this, CustomUnityActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("CustomUnityActivityTest", "BridgeActivity: ${android.os.Process.myPid()}")
    }
}