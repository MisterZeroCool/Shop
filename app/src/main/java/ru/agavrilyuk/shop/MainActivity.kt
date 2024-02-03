package ru.agavrilyuk.shop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.agavrilyuk.shop.databinding.ActivityMainBinding
import ru.agavrilyuk.shop.fragments.RegistrationFragment

class MainActivity : AppCompatActivity(), RegistrationFragment.OnButtonClickInFragment {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RegistrationFragment.newInstance())
            .commit()

        binding.bottomNavigationView.visibility = View.GONE
    }

    override fun onClickButtonInRegFragment() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}