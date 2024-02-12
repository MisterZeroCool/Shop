package ru.agavrilyuk.shop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
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


    fun validateName(etFirstName: EditText, etNameTIL: TextInputEditText): Boolean {
        return when {
            etFirstName.text.toString().trim().isEmpty() -> {
                etNameTIL.error = "Required"
                false
            }

            else -> {
                etNameTIL.error = null
                true
            }
        }
    }
}