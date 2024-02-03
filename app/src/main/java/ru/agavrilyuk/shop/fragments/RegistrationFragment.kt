package ru.agavrilyuk.shop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.agavrilyuk.shop.R
import ru.agavrilyuk.shop.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private var onButtonClick: OnButtonClickInFragment? = null
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding ?: throw IllegalStateException("Binding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onButtonClick = activity as OnButtonClickInFragment
        binding.btEnter.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction().apply {
                    replace(R.id.fragment_container, MainFragment())
                }.commit()

            onButtonClick?.onClickButtonInRegFragment()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    interface OnButtonClickInFragment {
        fun onClickButtonInRegFragment()
    }
}