package com.sew.rewardsapp.activity;

import android.content.ContentValues;
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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Typeface tfArial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        TextView mTextView = (TextView) findViewById(R.id.email);
        mTextView.setTypeface(tfArial);
        mTextView = (TextView) findViewById(R.id.password);
        mTextView.setTypeface(tfArial);
        mTextView = (TextView) findViewById(R.id.first_name);
        mTextView.setTypeface(tfArial);
        mTextView = (TextView) findViewById(R.id.last_name);
        mTextView.setTypeface(tfArial);
        mTextView = (TextView) findViewById(R.id.address);
        mTextView.setTypeface(tfArial);
        mTextView = (TextView) findViewById(R.id.phone_number);
        mTextView.setTypeface(tfArial);
        mTextView = (TextView) findViewById(R.id.email);
        mTextView.setTypeface(tfArial);

        getSupportActionBar().hide();
    }

    public void signIn(View view) {

        TextView mTextView = (TextView) findViewById(R.id.email);
        String email = mTextView.getText().toString();
        mTextView = (TextView) findViewById(R.id.password);
        String password = mTextView.getText().toString();
        mTextView = (TextView) findViewById(R.id.first_name);
        String firstname = mTextView.getText().toString();
        mTextView = (TextView) findViewById(R.id.last_name);
        String lastname = mTextView.getText().toString();
        mTextView = (TextView) findViewById(R.id.address);
        String address = mTextView.getText().toString();
        mTextView = (TextView) findViewById(R.id.phone_number);
        String phone = mTextView.getText().toString();

        if(checkIfUserExists(email) == 0) {
            addUser(firstname, lastname, phone, address, email, password);
            Toast.makeText(this, "User successfully created", Toast.LENGTH_SHORT).show();
            Intent homeIntent = new Intent(this, LoginActivity.class);
            startActivity(homeIntent);
        } else {
            Toast.makeText(this, "This user already exists! Try another email", Toast.LENGTH_SHORT).show();
            mTextView = (TextView) findViewById(R.id.email);
            mTextView.setText("");
        }
    }

    private void addUser(String firstname, String lastname, String phone, String address, String email, String password) {

        SQLiteDatabase database = new SQLiteDBHelper(this).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_FIRSTNAME, firstname);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_LASTNAME, lastname);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PHONE, phone);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS, address);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, email);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PASSWORD, password);
        long rowId = database.insert(FeedReaderContract.FeedEntry.LOGIN_TABLE_NAME, null, values);

    }

    private int checkIfUserExists(String username) {
        SQLiteDatabase database = new SQLiteDBHelper(this).getReadableDatabase();
        String[] projection = {FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, FeedReaderContract.FeedEntry.COLUMN_NAME_PASSWORD};
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL + " = ?";
        String[] selectionArgs = {username};
        Cursor cursor = database.query(FeedReaderContract.FeedEntry.LOGIN_TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

}
