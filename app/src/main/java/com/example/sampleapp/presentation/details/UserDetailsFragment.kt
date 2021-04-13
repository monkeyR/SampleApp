package com.example.sampleapp.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentUserDetailsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class UserDetailsFragment : Fragment() {

    companion object {
        private const val USER_ID_PARAMS = "USER_ID_PARAMS"

        fun getInstance(userId: Int) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putInt(USER_ID_PARAMS, userId)
            }
        }
    }

    private val viewModel by viewModel<UserDetailsViewModel>()
    private lateinit var binding: FragmentUserDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_details, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated(requireArguments().getInt(USER_ID_PARAMS))
    }
}