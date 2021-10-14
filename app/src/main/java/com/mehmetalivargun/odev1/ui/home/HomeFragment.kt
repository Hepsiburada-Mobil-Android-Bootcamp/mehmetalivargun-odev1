package com.mehmetalivargun.odev1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mehmetalivargun.odev1.R
import com.mehmetalivargun.odev1.databinding.FragmentHomeBinding
import com.mehmetalivargun.odev1.movieAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(HomeRepo())
        }
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=viewLifecycleOwner
        binding.viewModel = viewModel
        val spinner =binding.spinner

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.categories,
            R.layout.spinner_item_category
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}