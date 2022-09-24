package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var wishlist: MutableList<WishItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishItemsRv = findViewById<RecyclerView>(R.id.wishItemsRv)


        // Create adapter passing in the list of wish items
        val adapter = WishItemAdapter(wishlist)
        // Attach the adapter to the RecyclerView to populate items
        wishItemsRv.adapter = adapter
        // Set layout manager to position the items
        wishItemsRv.layoutManager = LinearLayoutManager(this)

        var nameInput = findViewById<EditText>(R.id.nameEditText)
        var priceInput = findViewById<EditText>(R.id.priceEditText)
        var urlInput = findViewById<EditText>(R.id.urlEditText)


        findViewById<Button>(R.id.button).setOnClickListener {


            // Get text form EditText views and create wish item
            val newWishItem = WishItem(nameInput.text.toString(), priceInput.text.toString(), urlInput.text.toString())
            // Add new item to existing list of wish items
            wishlist.add(newWishItem)
            // Notify the adapter there's a new wish item so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()

            nameInput.setText("")
            priceInput.setText("")
            urlInput.setText("")
        }
    }
}