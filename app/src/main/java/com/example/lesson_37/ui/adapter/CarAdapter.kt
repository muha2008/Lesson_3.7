package com.example.lesson_37.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_37.databinding.ItemCarBinding
import com.example.lesson_37.ui.models.Car

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    var _carList = mutableListOf<Car>()


    fun setCar(carList: MutableList<Car>) {
        _carList = carList
    }

    inner class CarViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(car: Car) {
            binding.ivCar.setImageResource(car.image)
            binding.tvCar.text = car.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun getItemCount() = _carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(_carList[position])
    }
}