package com.masorone.retrofit2.presentation.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masorone.retrofit2.R
import com.masorone.retrofit2.presentation.fragments.QuestListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, QuestListFragment())
            .commit()
    }
}