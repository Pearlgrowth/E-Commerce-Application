package com.example.e_commerceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView featuredProductsRecyclerView;
    private FeaturedProductsAdapter featuredProductsAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize button for checkout
        Button btnCheckout = findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CheckoutActivity.class);
            startActivity(intent);
        });

        // Initialize button to view products
        Button viewProductsButton = findViewById(R.id.viewProductsButton);
        viewProductsButton.setOnClickListener(v -> {
            // Navigate to Product List screen
            Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
            startActivity(intent);
        });

        // Initialize person icon for login
        ImageView personIcon = findViewById(R.id.personIcon);
        personIcon.setOnClickListener(v -> {
            // Navigate to LoginActivity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Initialize the RecyclerView for featured products
        featuredProductsRecyclerView = findViewById(R.id.featuredProductsRecyclerView);
        featuredProductsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the product list
        productList = new ArrayList<>();

        // Add products to the list
        productList.add(new Product("Basic White T-Shirt", 15.99, R.drawable.white));
        productList.add(new Product("Slim Fit Denim Jeans", 39.99, R.drawable.jeans));

        // Initialize the adapter and set it to the RecyclerView
        featuredProductsAdapter = new FeaturedProductsAdapter(productList);
        featuredProductsRecyclerView.setAdapter(featuredProductsAdapter);
    }
}
