package com.pinslog.androidunitysample

import android.annotation.SuppressLint
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.unity3d.player.IUnityPlayerLifecycleEvents
import com.unity3d.player.UnityPlayer
import com.unity3d.player.UnityPlayerActivity
import kotlin.system.exitProcess

private const val TAG = "CustomUnityActivityTest"
class CustomUnityActivity : UnityPlayerActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        mUnityPlayer = UnityPlayer(applicationContext)

        val glesMode = mUnityPlayer.settings.getInt("glesMode", 1)
        mUnityPlayer.init(glesMode, false)
        setContentView(R.layout.activity_custom_unity)

        val relativeLayout = findViewById<RelativeLayout>(R.id.custom_unity_layout)
        relativeLayout.addView(mUnityPlayer.view)
        
        val fab = findViewById<FloatingActionButton>(R.id.custom_unity_fab)
        fab.setOnClickListener {
            relativeLayout.removeAllViews()
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("CustomUnityActivityTest", "CustomUnityActivity: ${android.os.Process.myPid()}")
    }

    override fun onDestroy() {
        mUnityPlayer.removeAllViews()
        mUnityPlayer.quit()
        super.onDestroy()
    }

}