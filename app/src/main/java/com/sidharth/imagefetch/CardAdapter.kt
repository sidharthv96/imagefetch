package com.sidharth.imagefetch

/**
 * Created by sidharthvinod on 24/05/17.
 */

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import java.util.*


class CardAdapter(val mContext: Context) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    internal var mItems: MutableList<Worldpopulation> = ArrayList()

    fun addData(country: Worldpopulation) {
        mItems.add(country)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.fragment_item, viewGroup, false)
        val viewHolder = ViewHolder(v)
        return viewHolder
    }

    fun showImage(flagView: ImageView) {
        val builder = Dialog(mContext)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.window.setBackgroundDrawable(
                ColorDrawable(android.graphics.Color.TRANSPARENT))
        builder.setOnDismissListener({
        })

        val imageView = ImageView(mContext)
        imageView.setImageDrawable(flagView.drawable)
        builder.addContentView(imageView, RelativeLayout.LayoutParams(600, 400))
        builder.show()
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val country = mItems[i]
        Picasso.with(mContext).load(country.flag).resize(300,200).into(viewHolder.flag)
        viewHolder.name.text = country.country
        viewHolder.population.text = country.population
        viewHolder.flag.setOnClickListener({ v ->
            Toast.makeText(mContext, country.country, Toast.LENGTH_SHORT).show()
            showImage(viewHolder.flag)
        })
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var flag: ImageView = itemView.findViewById(R.id.flag) as ImageView
        var name: TextView = itemView.findViewById(R.id.name) as TextView
        var population: TextView = itemView.findViewById(R.id.population) as TextView

    }
}