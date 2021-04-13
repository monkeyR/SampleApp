package com.example.sampleapp.presentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentUserListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class UserListFragment : Fragment() {

    private val viewModel by viewModel<UserListViewModel>()
    private lateinit var binding: FragmentUserListBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observe()
        viewModel.onViewCreated()
    }

    private fun initRecyclerView() {
        adapter = UserListAdapter(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerView.context,
            VERTICAL
        )
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun observe() {
        viewModel.data.observe(this.viewLifecycleOwner, Observer {
            it.data?.let {
                adapter.items = it
            }
        })
    }
}