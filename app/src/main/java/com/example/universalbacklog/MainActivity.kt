package com.example.universalbacklog

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addItemButton = findViewById<Button>(R.id.addItemButton)
        val emptyText = findViewById<TextView>(R.id.emptyText)
        val backlogList = findViewById<LinearLayout>(R.id.backlogList)

        addItemButton.setOnClickListener {
            val input = EditText(this)
            input.hint = "Enter backlog item"

            AlertDialog.Builder(this)
                .setTitle("Add Item")
                .setView(input)
                .setPositiveButton("Add") { _, _ ->
                    val item = input.text.toString().trim()

                    if (item.isNotEmpty()) {
                        emptyText.visibility = View.GONE

                        val itemText = TextView(this)
                        itemText.text = "• $item"
                        itemText.textSize = 16f
                        itemText.setPadding(0, 8, 0, 8)

                        backlogList.addView(itemText)
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }
}