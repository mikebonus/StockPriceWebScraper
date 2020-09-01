package com.sampler.webscraper.adapter

import android.text.Html
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sampler.webscraper.R
import com.sampler.webscraper.model.Gold
import com.sampler.webscraper.util.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gold.view.*

class RecyclerViewAdapter(private val goldList: List<Gold>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // override method #1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedNews = parent.inflate(
            R.layout.item_gold,
            false
        )       // inflate() from utils... unlike in JAVA
        return ViewHolder(inflatedNews)
    }

    // override method #2
    override fun getItemCount(): Int {
        return goldList.size
    }

    // override method #3
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCard = goldList[position]
        holder.bindSet(itemCard)
    }


    // View-Holder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var view: View = itemView
        var goldList: Gold? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }

        fun bindSet(goldList: Gold) {
            this.goldList = goldList

            view.txtGoldId.text = goldList.name
            view.txtGoldPrice.text = goldList.value
//            Picasso.get().load(itemPrice.imageUrl).into(view.itemPhoto)
        }
    }
}