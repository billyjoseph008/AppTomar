package com.brainstormideas.apptomar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.brainstormideas.apptomar.data.models.Store
import com.brainstormideas.apptomar.databinding.ItemRowBinding
import com.bumptech.glide.Glide

class StoreMenuAdapter(private val storesList: MutableList<Store>): RecyclerView.Adapter<StoreMenuAdapter.StoreMenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreMenuViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreMenuViewHolder(binding)
    }

    override fun getItemCount()= storesList.size

    override fun onBindViewHolder(holder: StoreMenuViewHolder, position: Int) {
        with(holder){
            with(storesList[position]){

                binding.storeNameTextView.text = name
                binding.storeDescriptionTextView.text = description

                Glide.with(holder.itemView.context)
                    .load(pictures[0].toString())
                    .into(binding.storeCircleImageView)

                holder.itemView.setOnClickListener {
                    Toast.makeText(it.context, pictures[0],
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    inner class StoreMenuViewHolder(val binding: ItemRowBinding)
        :RecyclerView.ViewHolder(binding.root)
}