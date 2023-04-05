package com.ashu.fooddeliverydemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ashu.fooddeliverydemo.R
import com.ashu.fooddeliverydemo.adapter.RetrofitAdapter
import com.ashu.fooddeliverydemo.api.repository
import com.ashu.fooddeliverydemo.data.Item
import com.ashu.fooddeliverydemo.databinding.FragmentHeatBinding
import com.ashu.fooddeliverydemo.viewmodel.ViewModel
import com.ashu.fooddeliverydemo.viewmodel.ViewModelFactory

class HeatFragment : Fragment() {
    private lateinit var binding: FragmentHeatBinding
    lateinit var adapter: RetrofitAdapter
    lateinit var viewModel: ViewModel
    private lateinit var itemList:ArrayList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeatBinding.inflate(layoutInflater,container, false)
        return binding.root
        setupRecyclerView()

        val repository = repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ViewModel::class.java)
        viewModel.getItem()
        viewModel.response.observe(viewLifecycleOwner, Observer {
            if (it.isSuccessful){
                it.body().let {
                    if (it != null) {
                        itemList.addAll(it.items)
                    }


                }
            }
        })


    }

    private fun setupRecyclerView() {
        adapter = RetrofitAdapter(itemList)
        binding.apply {
            heatRecyclerView.adapter =adapter
            heatRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}