package com.android.instrumentation_test.moreui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.instrumentation_test.R
import com.android.instrumentation_test.ui.MainActivity



class SampleUi : AppCompatActivity() {
    private val note: EditText
        get() = findViewById(R.id.note)

    private val note_description: EditText
        get() = findViewById(R.id.note_description)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_ui)
    }

    fun onSubmit(view: View) {
        val msg = "Note: ${note.text} \nDescription: ${note_description.text}"
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("msg", msg)
        startActivity(intent)
    }


}