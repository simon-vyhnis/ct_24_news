package com.simon.ct24news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.list)
        HttpDao.getArticles().observe(viewLifecycleOwner) {
            val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
            recyclerView.adapter = RecyclerViewAdapter(it.data, viewModel)
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        return root
    }
}

