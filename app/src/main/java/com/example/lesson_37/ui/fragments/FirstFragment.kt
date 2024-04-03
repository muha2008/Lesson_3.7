package com.example.lesson_37.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson_37.R
import com.example.lesson_37.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPlus()
        btnMinus()
        savedInstanceState?.let {
            count = it.getInt(NUMBER, 0)
            binding.tvZero.text = count.toString()
        }

    }

    private fun btnPlus() = with(binding) {
        tvPlus.setOnClickListener {
            tvZero.text = count++.toString()
            if (count < 10) {
            } else {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, SecondFragment())
                    .addToBackStack("First Fragment")
                    .commit()
            }
        }
    }

    private fun btnMinus() = with(binding) {
        tvMinus.setOnClickListener {
            if (count <= 0){
                tvMinus.isEnabled
            }else{
                count--
                tvZero.text = count.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val NUMBER = "count"
    }
}