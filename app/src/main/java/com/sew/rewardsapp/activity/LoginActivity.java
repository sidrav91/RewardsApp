package com.sew.rewardsapp.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sew.rewardsapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Typeface tfArial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        TextView mTextView = (TextView) findViewById(R.id.email);
        mTextView.setTypeface(tfArial);
        mTextView = (TextView) findViewById(R.id.password);
        mTextView.setTypeface(tfArial);

        getSupportActionBar().hide();

    }

    public void registerNewUser(View view) {
        Intent homeIntent = new Intent(this, RegisterActivity.class);
        startActivity(homeIntent);
    }

    public void signIn(View view) {
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }

}
