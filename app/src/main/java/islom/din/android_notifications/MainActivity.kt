package islom.din.android_notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import islom.din.android_notifications.databinding.ActivityMainBinding

//1) notification channel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var notificationManager: NotificationManager

    private var notificationId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        binding.button.setOnClickListener {
            createNotification()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun createNotification() {
        val notification = NotificationCompat.Builder(this, "channel_id")
            .setContentTitle("Я нотификация!") //!!
            .setContentText("Привет братан! Я сообщение") //!!
            .setColor(ContextCompat.getColor(this, R.color.purple_700))
            .setSmallIcon(R.drawable.baseline_check_circle_outline) //!!
            .setStyle(NotificationCompat.BigTextStyle())
            .setAutoCancel(true)
            .build()
        notificationManager.notify(notificationId++, notification)
    }
}