package com.example.ecelltask2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecelltask2.R

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.tvShoeName.text = product.name
        holder.tvShoePrice.text = product.price
        holder.ivShoeImage.setImageResource(product.imageResId)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivShoeImage: ImageView = itemView.findViewById(R.id.iv_shoe_image)
        val tvShoeName: TextView = itemView.findViewById(R.id.tv_shoe_name)
        val tvShoePrice: TextView = itemView.findViewById(R.id.tv_shoe_price)
    }
}