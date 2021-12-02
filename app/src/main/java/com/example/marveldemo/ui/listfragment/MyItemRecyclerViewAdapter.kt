package com.example.marveldemo.ui.listfragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.marveldemo.R
import com.example.marveldemo.utils.OnClickList
import com.example.marveldemo.databinding.FragmentItemBinding
import com.example.marveldemo.domain.model.Results

import com.example.marveldemo.ui.placeholder.PlaceholderContent.PlaceholderItem


class MyItemRecyclerViewAdapter(
    private val onClickList: OnClickList
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

private val items: MutableList<Results> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.fragment_item, parent, false
        )
        return ViewHolder(view)

    }

    fun addData(list: List<Results>){
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int):Results{
        return items[position] as Results
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Results){
            val itm = binding as FragmentItemBinding
            itm.itemNumber.text = "ID: ${item.id}"
            itm.content.text =  "Description: ${item.title}"

            itemView.setOnClickListener {
                onClickList.goToFragement(item.id,it)
            }
        }
    }

}