package com.sew.rewardsapp.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.db.FeedReaderContract;
import com.sew.rewardsapp.db.SQLiteDBHelper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        changeFont();

    }

    private void changeFont() {
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

    private int authenticateUser(String username, String password) {
        SQLiteDatabase database = new SQLiteDBHelper(this).getReadableDatabase();
        String[] projection = {FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, FeedReaderContract.FeedEntry.COLUMN_NAME_PASSWORD};
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL + " = ? AND " + FeedReaderContract.FeedEntry.COLUMN_NAME_PASSWORD + " = ?";
        String[] selectionArgs = {username,password};
        Cursor cursor = database.query(FeedReaderContract.FeedEntry.LOGIN_TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void signIn(View view) {
        TextView mTextView = (TextView) findViewById(R.id.email);
        String email = mTextView.getText().toString();
        mTextView = (TextView) findViewById(R.id.password);
        String password = mTextView.getText().toString();
        if(authenticateUser(email, password) == 1){
            Toast.makeText(this, "Successfully logged in!", Toast.LENGTH_SHORT).show();
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
        } else {
            Toast.makeText(this, "Invalid login credentials!", Toast.LENGTH_SHORT).show();
        }
    }

}
