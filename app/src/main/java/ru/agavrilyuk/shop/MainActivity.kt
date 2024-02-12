package ru.agavrilyuk.shop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.agavrilyuk.shop.databinding.ActivityMainBinding
import ru.agavrilyuk.shop.fragments.BasketFragment
import ru.agavrilyuk.shop.fragments.CatalogFragment
import ru.agavrilyuk.shop.fragments.DiscountFragment
import ru.agavrilyuk.shop.fragments.MainFragment
import ru.agavrilyuk.shop.fragments.ProfileFragment
import ru.agavrilyuk.shop.fragments.RegistrationFragment

class MainActivity : AppCompatActivity(), RegistrationFragment.OnButtonClickInFragment {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(RegistrationFragment())
        binding.bottomNavigationView.visibility = View.GONE


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.btMain -> replaceFragment(MainFragment())
                R.id.btCatalog -> replaceFragment(CatalogFragment())
                R.id.btBasket -> replaceFragment(BasketFragment())
                R.id.btDiscount -> replaceFragment(DiscountFragment())
                R.id.btProfile -> replaceFragment(ProfileFragment())

                else -> {
                }
            }
            true
        }

    }

    override fun onClickButtonInRegFragment() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}