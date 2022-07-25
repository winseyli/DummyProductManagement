package com.example.android.dummyproductmanagement.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.dummyproductmanagement.R
import com.example.android.dummyproductmanagement.databinding.ProductItemBinding
import com.example.android.dummyproductmanagement.model.Product

class ProductListAdapter: RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var products: List<Product> = listOf()

    fun setProducts(products: List<Product>) {
        this.products = products
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ProductItemBinding.bind(view)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.binding.textViewTitle.text = products[position].title
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = products.size

}