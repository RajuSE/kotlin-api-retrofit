package com.example.kotlin_api_retrofit;

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_user_list.view.*

class MyAdapter(usersList: List<Item>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val mItems: List<Item>
    private val mOnClickListener: View.OnClickListener

    init {
        mItems = usersList

        mOnClickListener = View.OnClickListener { v ->
            notifyDataSetChanged()
        }
    }


    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        holder?.textView?.setText(mItems[position].login)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        return MyViewHolder(layoutInflater.inflate(R.layout.item_user_list, parent, false))
    }

    override fun getItemCount(): Int {

       return mItems.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.textviewData
    }
}