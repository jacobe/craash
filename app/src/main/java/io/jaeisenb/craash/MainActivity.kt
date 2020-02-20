package io.jaeisenb.craash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.hockeyapp.android.CrashManager
import net.hockeyapp.android.metrics.MetricsManager
import net.hockeyapp.android.utils.HockeyLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //var appId = "a5a59fd397d4aed6682388ca45abd6c2" // training
        var appId = "132034fc22ab459bbb87be5c299d9f6a" // rink
        //var appSecret = "020f0181863e4f1d906abeb8546d5bba" // training
        HockeyLog.setLogLevel(Log.DEBUG)
        MetricsManager.register(application, appId)
        MetricsManager.enableUserMetrics()
        MetricsManager.trackEvent("App is starting up")
        //CrashManager.register(this, "https://training.hockeyapp.net/", appId, null)
        CrashManager.register(this, appId)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MetricsManager.trackEvent("MainActivity loaded")
    }

    fun triggerDivisionByZero(view: android.view.View) {
        var i = 1
        this.title = "Attempt ${i/(--i)}"
    }
}
