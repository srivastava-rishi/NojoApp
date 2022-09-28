package com.rsstudio.nojoto.ui.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.rsstudio.nojoto.R
import com.rsstudio.nojoto.data.network.model.Data

class MainAdapter(
    private var context: Context,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var list: MutableList<Data> = mutableListOf()

    var logTag = "@MainAdapter"

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var container: RelativeLayout = view.findViewById(R.id.rlRoot)

        @SuppressLint("UseCompatLoadingForColorStateLists")
        fun onBind() {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_post_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is MainAdapter.ItemViewHolder) {
            holder.container.animation = AnimationUtils.loadAnimation(context,R.anim.anim_fade_scale)
            holder.onBind()
        }
    }


    override fun getItemCount(): Int {
        return 20
    }

}