package com.example.e_commerceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.e_commerceapplication.CartItem;

public class CheckoutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView totalAmountText;
    private Button proceedToPayBtn;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

        // Initialize views
        recyclerView = findViewById(R.id.cartRecyclerView);
        totalAmountText = findViewById(R.id.totalAmount);
        proceedToPayBtn = findViewById(R.id.btnProceedToPay);

        // Sample cart data (Replace with real database data)
        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Laptop", 50000.0, 1));
        cartItems.add(new CartItem("Mouse", 1000.0, 2));
        cartItems.add(new CartItem("Keyboard", 2500.0, 1));

        cartAdapter = new CartAdapter(cartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        updateTotalPrice();

        // Set up button click listener to go to payment screen
        proceedToPayBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CheckoutActivity.this, PaymentActivity.class);
            intent.putExtra("totalAmount", calculateTotal()); // Pass the total amount
            startActivity(intent);
        });
    }

    private double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    private void updateTotalPrice() {
        totalAmountText.setText("Total: KES " + calculateTotal());
    }
}
