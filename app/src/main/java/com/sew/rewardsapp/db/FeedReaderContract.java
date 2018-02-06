package com.sew.rewardsapp.db;

import android.provider.BaseColumns;

/**
 * Created by siddharthkumar on 17/1/18.
 */

public class FeedReaderContract {

    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String LOGIN_TABLE_NAME = "login";
        public static final String COLUMN_NAME_FIRSTNAME = "firstanme";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_EMAIL = "Email";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }
}
