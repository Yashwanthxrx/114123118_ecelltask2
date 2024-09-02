package com.example.ecelltask2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class ProductActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)


        val recyclerView: RecyclerView = findViewById(R.id.rv_products)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val products = listOf(
            Product("Shoe 1", "$100", R.drawable.shoeimage1),
            Product("Shoe 2", "$120", R.drawable.shoeimage2),
            Product("Shoe 3", "$150", R.drawable.shoeimage3),
            Product("Shoe 4", "$180", R.drawable.shoeimage4)
        )
        val adapter = ProductAdapter(products)
        recyclerView.adapter = adapter

        // Initialize NavigationView
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                startActivity(Intent(this, HomeActivity::class.java))
                return true
            }
            R.id.nav_settings -> {
                startActivity(Intent(this, ProductActivity::class.java))
                return true
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}