package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // self intro button
        Button self_intro_button = (Button) findViewById(R.id.self_intro_button);
        self_intro_button.setOnClickListener(v -> openSelfIntro());

        // facts about me button
        Button facts_button = (Button) findViewById(R.id.facts_button);
        facts_button.setOnClickListener(v -> openFacts());

        // more facts about me button
        Button more_facts_button = (Button) findViewById(R.id.more_facts_button);
        more_facts_button.setOnClickListener(v -> openMoreFacts());

        // invest portfolio button
        Button invest_port_button = (Button) findViewById(R.id.invest_port_button);
        invest_port_button.setOnClickListener(v -> openInvestPort());

        Button resume_button = (Button) findViewById(R.id.resume_button);
        resume_button.setOnClickListener(v -> openResume());
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

    // open more facts about me activity
    public void openMoreFacts() {
        Intent intent = new Intent(this, MoreFactsAboutMeActivity.class);
        startActivity(intent);
    }

    // open investment portfolio activity
    public void openInvestPort() {
        Intent intent = new Intent(this, InvestPortActivity.class);
        startActivity(intent);
    }

    // open my resume link
    public void openResume() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/1DIijGViD4-7gA5FWW1K7p4QNjjsp1lDx/edit?usp=sharing&amp;ouid=109571095316197278402&amp;rtpof=true&amp;sd=true"));
        startActivity(intent);
    }

}