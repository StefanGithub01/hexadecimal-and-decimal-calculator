package com.example.tema_1_dam

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        val info = intent.getStringExtra("key")
        val history = findViewById<EditText>(R.id.history)
        history.setText(info)
        val info_baraText1 = intent.getStringExtra("key1")
        val info_baraText2 = intent.getStringExtra("key2")


        val emailButton = findViewById<Button>(R.id.email)

        emailButton.setOnClickListener {
            val historyData = history.text.toString()
            val subject = "History Data"
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("recipient-email@example.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, historyData)
            startActivity(Intent.createChooser(emailIntent, "Send Email"))
        }
        // Set color1, color2, and color3 to respective TextViews in a similar way

        val button_onscreen1 = findViewById<Button>(R.id.button_calculator)
        button_onscreen1.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            intent.putExtra("istoric", info) //
            intent.putExtra("bara1", info_baraText1)
            intent.putExtra("bara2", info_baraText2)
            intent.putExtra("token", 1)
            startActivity(intent)
        }
    }


}
