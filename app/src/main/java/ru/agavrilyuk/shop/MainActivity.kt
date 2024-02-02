package ru.agavrilyuk.shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.agavrilyuk.shop.fragments.RegistrationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RegistrationFragment.newInstance())
            .commit()
    }

    
}