package com.reift.multi_stepform.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reift.multi_stepform.databinding.ItemCheckboxFormBinding

class CheckBoxAdapter(val listCheckbox: List<String>) :
    RecyclerView.Adapter<CheckBoxAdapter.CheckBoxViewHolder>() {

    class CheckBoxViewHolder(val binding: ItemCheckboxFormBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CheckBoxViewHolder(
        ItemCheckboxFormBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CheckBoxViewHolder, position: Int) {
        holder.binding.tvCheckboxTitle.text = listCheckbox[position]
    }

    override fun getItemCount() = listCheckbox.size
}