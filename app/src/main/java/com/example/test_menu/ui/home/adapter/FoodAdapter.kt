package com.example.test_menu.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_menu.databinding.ItemFoodBinding
import com.example.test_menu.ui.home.model.Food

class FoodAdapter(
    private val list: ArrayList<Food>,
    private val onClick:(position:Int) -> Unit
    ) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FoodViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(food: Food) {
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
            binding.apply {
                ivFood.setImageResource(food.image)
                tvName.text=food.name
                tvOpen.text=food.name
                tvReiting.text=food.reiting.toString()
                tvVoices.text=food.voices.toString()
                tvCountry.text=food.country
                tvMeal.text=food.meal
                tvDelivery.text=food.delivery
                tvPrice.text=food.price.toString()
            }
        }
    }
}
