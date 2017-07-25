package com.example.dokgo.chisw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView counterView;
    private TextView emailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        int counter = CounterService.getCounter(getApplicationContext());

        counterView.setText(Integer.toString(counter));
        emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:" + getString(R.string.email));
                intent.setData(data);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        counterView = (TextView) findViewById(R.id.counter_view);
        emailView = (TextView) findViewById(R.id.email_view);
    }
}
