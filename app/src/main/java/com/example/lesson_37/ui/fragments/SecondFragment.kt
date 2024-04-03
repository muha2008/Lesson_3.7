package com.example.lesson_37.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson_37.R
import com.example.lesson_37.databinding.FragmentSecondBinding
import com.example.lesson_37.ui.adapter.CarAdapter
import com.example.lesson_37.ui.models.Car

class SecondFragment : Fragment() {

    private  var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val carAdapter = CarAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        imageCar()
    }

    private fun initialize() {
        binding.rvCar.adapter = carAdapter
    }

    private fun imageCar() {
        val imageCar = mutableListOf<Car>(
            Car(R.drawable.lexus,"Lexus"),
            Car(R.drawable.ford,"ford"),
            Car(R.drawable.gtr,"gtr"),
            Car(R.drawable.bugatti,"bugatti"),
            Car(R.drawable.jaguar,"jaguar"),
            Car(R.drawable.mercedes,"mercedes"),
            Car(R.drawable.ferrari,"ferrari"),

        )

        carAdapter.setCar(imageCar)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}