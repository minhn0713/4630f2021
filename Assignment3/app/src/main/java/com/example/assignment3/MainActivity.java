package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button invest_port_button;
    private Button facts_button;
    private Button self_intro_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // self intro button
        self_intro_button = (Button) findViewById(R.id.self_intro_button);
        self_intro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelfIntro();
            }
        });

        // facts about me button
        facts_button = (Button) findViewById(R.id.facts_button);
        facts_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacts();
            }
        });

        // invest portfolio button
        invest_port_button = (Button) findViewById(R.id.invest_port_button);
        invest_port_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInvestPort();
            }
        });
    }

    // open self intro activity
    public void openSelfIntro() {
        Intent intent = new Intent(this, SelfIntroActivity.class);
        startActivity(intent);
    }

    // open facts about me activity
    public void openFacts() {
        Intent intent = new Intent(this, FactsAboutMeActivity.class);
        startActivity(intent);
    }

    // open investment portfolio activity
    public void openInvestPort() {
        Intent intent = new Intent(this, InvestPortActivity.class);
        startActivity(intent);
    }

}