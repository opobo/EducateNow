package com.example.educatenow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //Instantiating the Buttons
        //Setting the Onclick Listener to launch the primary

    }

    public void continueNow(View view) {
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}
