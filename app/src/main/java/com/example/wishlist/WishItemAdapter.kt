package com.example.wishlist

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishItemAdapter(private val wishlist: List<WishItem>) : RecyclerView.Adapter<WishItemAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Your holder should contain a member variable for any view that will be set as you render
        // a row
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val itemUrlTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            itemNameTextView = itemView.findViewById(R.id.itemNameTv)
            itemPriceTextView = itemView.findViewById(R.id.itemPriceTv)
            itemUrlTextView = itemView.findViewById(R.id.itemUrlTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishItem = wishlist.get(position)
        // Set item views based on views and data model
        holder.itemNameTextView.text = wishItem.name
        holder.itemPriceTextView.text = wishItem.price
        holder.itemUrlTextView.text = wishItem.url
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }


}