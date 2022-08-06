package islom.din.android_notifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi

class App : Application() {

    private lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //если версия андроид выше чем ОРЕО тогда запустить эту фнкцию
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "channel_id",
            "Android Pro Skills, :-)",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.description = "Канал для уведомлений"
        channel.enableLights(true)
        channel.lightColor = Color.GREEN
        notificationManager.createNotificationChannel(channel)
    }
}