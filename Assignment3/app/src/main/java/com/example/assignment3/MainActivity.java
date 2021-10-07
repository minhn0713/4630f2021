package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button invest_port_button;
    private Button facts_button;
    private Button self_intro_button;
    private Button resume_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView text = (TextView) findViewById(R.id.resume_textview);
        //text.setMovementMethod(LinkMovementMethod.getInstance());

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

        resume_button = (Button) findViewById(R.id.resume_button);
        resume_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResume();
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

    // open my resume link
    public void openResume() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/1DIijGViD4-7gA5FWW1K7p4QNjjsp1lDx/edit?usp=sharing&amp;ouid=109571095316197278402&amp;rtpof=true&amp;sd=true"));
        startActivity(intent);
    }

}