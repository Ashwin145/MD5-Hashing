package com.example.md5hashing

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import java.math.BigInteger
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {

    private lateinit var filePathEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filePathEditText = findViewById(R.id.file_path_edit_text)
        calculateButton = findViewById(R.id.calculate_button)
        resultTextView = findViewById(R.id.result_text_view)

        calculateButton.setOnClickListener {


            val filePath = filePathEditText.text.toString()

            if (filePath.isNotEmpty()) {

                val md5Hash = md5(filePath)
                resultTextView.text = md5Hash
            }

        }

    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }


}