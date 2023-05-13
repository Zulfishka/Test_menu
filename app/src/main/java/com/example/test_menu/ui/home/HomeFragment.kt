package com.example.test_menu.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.test_menu.R
import com.example.test_menu.databinding.FragmentHomeBinding
import com.example.test_menu.ui.home.adapter.FoodAdapter
import com.example.test_menu.ui.home.model.Food

class HomeFragment : Fragment() {
    private lateinit var list: ArrayList<Food>
    private lateinit var adapter: FoodAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        adapter = FoodAdapter(list, this::onClick)
        loadData()
    }

    private fun loadData() {
        list.add(Food(R.drawable.burger, "Burger Craze", "OPEN", 4.6, 601, "American", "Burgers", "FREE", 10))
        list.add(Food(R.drawable.pizza, "Vegetarian Pizza", "OPEN", 4.6, 601, "Italian", "Pizza", "FREE", 10))
    }

    private fun onClick(position: Int) {
        val bundle = Bundle()
        bundle.putSerializable("food", list)
        bundle.putInt("position", position)
        findNavController().navigate(R.id.resultFragment, bundle)
    }
}