package com.example.android_lab_08

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // THE IS OF THE NOTIFACTION CHANNEL
        val mNotificationMager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = "my_channel_02"

        // the user visibale name of the channel
        var name  = getString(R.string.abc_action_bar_home_description)

        // the user visible descripotion
        val decription = getString(R.string.abc_action_bar_home_description)
        val important = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(id , name , important)

        mChannel.description = decription
        mChannel.enableLights(true)

        // set the notification light6 color for notifuication

        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        mNotificationMager.createNotificationChannel(mChannel)

        url_address.setOnClickListener{
            gotoweb(it)
        }
        gobtn.setOnClickListener{
            gotoweb(it)
        }

    }
    //adding menu option
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu , menu)
        return true
    }


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        mywebview.setWebViewClient(WebViewClient())

        when(item?.itemId){
            R.id.item1 ->{mywebview.loadUrl("http://www.android.com")
                // this is the notifiaction code
                val channel_id = "my_channel_i02"

                    // using notificationmanager.builder to add the notification object

                val mBundler = NotificationCompat.Builder(this , channel_id)
                    .setContentTitle("androi atc norifcation " )
                    .setContentText("check android atc nw=ew course")

                var resultIntent = Intent(this ,Result_activity ::class.java)


                val stackBuilder =TaskStackBuilder.create(this)

                stackBuilder.addNextIntent(resultIntent)
                val resultPendingIntent = stackBuilder.getPendingIntent(0 ,PendingIntent.FLAG_UPDATE_CURRENT)
                mBundler.setContentIntent(resultPendingIntent)
                val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


                //wqdeqwdwq

                mNotificationManager.notify(2,mBundler.build())

            return super.onOptionsItemSelected(item)}

            R.id.item2 ->{mywebview.loadUrl("http://www.google.com")
                return super.onOptionsItemSelected(item)}

            else -> return super.onOptionsItemSelected(item)
        }

    }
// this code here allow the user to  search anything pretty much
    fun gotoweb(view:View){
            // CONFIGREATE YOUR WEBVIEW TO enable javascript download

            mywebview.setWebViewClient(WebViewClient())
            mywebview.settings.javaScriptEnabled = true
            mywebview.settings.loadsImagesAutomatically = true

            val url = url_address.text.toString()

            // to avoid webview to lunch the default browser
            mywebview.setWebViewClient(WebViewClient())

            // show the url
           mywebview.loadUrl(url)
        }
}
