package com.sew.rewardsapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by siddharthkumar on 17/1/18.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper{

    public SQLiteDBHelper(Context context) {
        super(context, "trading_db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //clearData(sqLiteDatabase);

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "  + FeedReaderContract.FeedEntry.LOGIN_TABLE_NAME + " (" +
                FeedReaderContract.FeedEntry.COLUMN_NAME_FIRSTNAME + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_LASTNAME + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_PHONE + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL + " TEXT PRIMARY KEY," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_PASSWORD + " TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOGIN");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.LOGIN_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void clearData(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("delete from " + FeedReaderContract.FeedEntry.LOGIN_TABLE_NAME);
    }
}
