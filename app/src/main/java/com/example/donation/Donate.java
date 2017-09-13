package com.example.donation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.NumberPicker;
import android.widget.ProgressBar;

public class Donate extends AppCompatActivity {

    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private int totalDonated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton = (Button)findViewById(R.id.donateButton);
        paymentMethod = (RadioGroup)findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        amountPicker = (NumberPicker)findViewById(R.id.amountPicker);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        progressBar.setMax(10000);
    }

    public void donateButtonPressed(View view) {
        totalDonated = totalDonated + amountPicker.getValue();
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.payPal ? "PayPal" : "Direct";
        progressBar.setProgress(totalDonated);
        Log.v("Donate", amountPicker.getValue() + ", method: " + method + "\nCurrent total " + totalDonated);
    }
}