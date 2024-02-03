package ru.agavrilyuk.shop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.agavrilyuk.shop.databinding.FragmentCatalogBinding


class CatalogFragment : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding ?: throw IllegalStateException("Binding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CatalogFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}