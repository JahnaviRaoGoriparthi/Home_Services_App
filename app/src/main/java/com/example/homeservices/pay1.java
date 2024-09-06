package com.example.homeservices;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class pay1 extends AppCompatActivity {
    private List<CheckBox> checkboxes;
    String amount;
    private TextView paymentTextView;
    private CheckBox confirmCheckbox;
    private Button onlinePaymentButton;
    private Button offlinePaymentButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay1);
        Bundle bundle = getIntent().getExtras();
        String SPname=bundle.getString("SPname");
        String SPaddress=bundle.getString("SPaddress");
        String SPmobile=bundle.getString("SPmobile");
        String Bname=bundle.getString("Bname");
        String Bnumber=bundle.getString("Bnumber");
        String Baddress=bundle.getString("Baddress");
        checkboxes = new ArrayList<>();
        checkboxes.add(findViewById(R.id.checkbox_option1));
        checkboxes.add(findViewById(R.id.checkbox_option2));
        checkboxes.add(findViewById(R.id.checkbox_option3));

        // Add more checkboxes as needed

        paymentTextView = findViewById(R.id.textview_payment_amount);
        confirmCheckbox = findViewById(R.id.checkbox_confirm_payment);
        onlinePaymentButton = findViewById(R.id.button_online_payment);
        offlinePaymentButton = findViewById(R.id.button_offline_payment);

        Button calculatePaymentButton = findViewById(R.id.button_calculate_payment);
        calculatePaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 double totalPayment = calculateTotalPayment();
                paymentTextView.setText(String.valueOf(totalPayment));
                confirmCheckbox.setVisibility(View.VISIBLE);
            }
        });

        confirmCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onlinePaymentButton.setEnabled(confirmCheckbox.isChecked());
                offlinePaymentButton.setEnabled(confirmCheckbox.isChecked());
            }
        });

        onlinePaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SPmessage="Customer "+Bnumber+"chooses Online Payment so verify receipt from customer.";
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(""+SPmobile, null, SPmessage, null,null);
                amount=""+paymentTextView.getText().toString();

                Intent i1=new Intent(pay1.this,pay2.class);
                i1.putExtra("SPname",SPname);
                i1.putExtra("SPmobile",SPmobile);
                i1.putExtra("SPaddress",SPaddress);
                i1.putExtra("Bname",Bname);
                i1.putExtra("Bnumber",Bnumber);
                i1.putExtra("Baddress",Baddress);
                i1.putExtra("amount",amount);
                startActivity(i1);
            }
        });

        offlinePaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SPmessage="Customer "+Bnumber+"chooses HandCash method so collect amount"+amount+" from customer.";
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(""+SPmobile, null, SPmessage, null,null);
                Intent i2=new Intent(pay1.this,Endpage.class);
                startActivity(i2);
            }
        });
    }

    private double calculateTotalPayment() {
        double totalPayment = 0.0;
        for (CheckBox checkbox : checkboxes) {
            if (checkbox.isChecked()) {

                totalPayment += 500.0; // Example value
            }
        }
        return totalPayment;
    }
}