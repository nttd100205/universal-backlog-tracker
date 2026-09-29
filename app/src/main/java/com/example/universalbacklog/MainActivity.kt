package com.example.universalbacklog

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addItemButton = findViewById<Button>(R.id.addItemButton)
        val emptyText = findViewById<TextView>(R.id.emptyText)

        addItemButton.setOnClickListener {
            val input = EditText(this)
            input.hint = "Enter backlog item"

            AlertDialog.Builder(this)
                .setTitle("Add Item")
                .setView(input)
                .setPositiveButton("Add") { _, _ ->
                    val item = input.text.toString().trim()

                    if (item.isNotEmpty()) {
                        emptyText.text = item
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }
}