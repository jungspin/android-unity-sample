package com.pinslog.androidunitysample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.unity3d.player.UnityPlayerActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.unity_btn)

        button.setOnClickListener {
            val intent = Intent(this, BridgeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("CustomUnityActivityTest", "MainActivity: ${android.os.Process.myPid()}")
    }
}