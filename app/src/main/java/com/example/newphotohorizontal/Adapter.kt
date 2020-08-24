package com.example.newphotohorizontal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import kotlinx.android.synthetic.main.item_button_add.view.*
import kotlinx.android.synthetic.main.item_image.view.*
import kotlin.math.min

class Adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: MutableList<Int> = mutableListOf(1)
    inner class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item:Int){
                itemView.iv_item.load(R.drawable.image_res)
            itemView.iv_close.load(R.drawable.ic_baseline_close_24)
                itemView.iv_close.setOnClickListener {
                    delete(item)
                }
        }
    }
    inner class PlaceViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(){
                itemView.iv_add.load(R.drawable.ic_baseline_add_24)
                itemView.iv_add.visibility = View.VISIBLE
                itemView.iv_add.setOnClickListener {
                    addList()
                }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == list.size){
            VIEW_TYPE_END
        }else{
            VIEW_TYPE_CELL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_CELL){
            ItemViewHolder(itemView = inflater.inflate(R.layout.item_image, parent, false))
        }else{
            PlaceViewHolder(itemView = inflater.inflate(R.layout.item_button_add, parent, false))
        }
    }

    override fun getItemCount(): Int {
      return min(list.size+1,5)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            VIEW_TYPE_END -> (holder as PlaceViewHolder).bind()
            VIEW_TYPE_CELL -> (holder as ItemViewHolder).bind(list[position])
        }
    }
    fun updateList(list:MutableList<Int>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    fun delete(item:Int){
        list.remove(item)
        notifyDataSetChanged()
    }
    fun addList(){
        if (list.isNullOrEmpty()){
            list.add(1)
        }else{
            list.add(list[list.size-1]+1)
        }
        notifyDataSetChanged()
    }
    companion object{
       const val VIEW_TYPE_END = 1
        const  val VIEW_TYPE_CELL = 0
    }
}