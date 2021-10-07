package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InvestPortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investmentport);

        // my portfolio button
        Button my_port_button = (Button) findViewById(R.id.my_port_button);
        my_port_button.setOnClickListener(v -> openMyPort());

        // family portfolio button
        Button family_port_button = (Button) findViewById(R.id.family_port_button);
        family_port_button.setOnClickListener(v -> openFamilyPort());

        // partner portfolio button
        Button partner_port_button = (Button) findViewById(R.id.partner_port_button);
        partner_port_button.setOnClickListener(v -> openPartnerPort());
    }

    // open my portfolio activity
    public void openMyPort() {
        Intent intent = new Intent(this, MyPortActivity.class);
        startActivity(intent);
    }

    // open family portfolio activity
    public void openFamilyPort() {
        Intent intent = new Intent(this, FamilyPortActivity.class);
        startActivity(intent);
    }

    // open partner portfolio activity
    public void openPartnerPort() {
        Intent intent = new Intent(this, PartnerPortActivity.class);
        startActivity(intent);
    }
}