package com.example.kamatechs_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        val actionbar = supportActionBar
        actionbar!!.title = "Storage Device Status"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}