package com.example.e_commerceapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
    private TextView amountText;
    private Button payButton;
    private double totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);

        amountText = findViewById(R.id.totalAmount);

        payButton = findViewById(R.id.btnMpay);


        // Retrieve total amount from intent
        totalAmount = getIntent().getDoubleExtra("totalAmount", 0.0);
        amountText.setText("KES " + totalAmount);

        payButton.setOnClickListener(v -> {
            Toast.makeText(this, "Processing Payment of KES " + totalAmount, Toast.LENGTH_SHORT).show();
            // Call M-Pesa STK Push API here
        });
    }
}
