package com.example.LocalDelicacies;

import android.provider.BaseColumns;

/**
 * Created by rsampath on 7/25/14.
 */
public class DBContract {
    public DBContract() {
    }

    public static abstract class DBEntry implements BaseColumns{
        public static final String LOCATION_TABLE_NAME = "Location";
        public static final String LOCATION_COLUMN_NAME = "name";
        public static final String LOCATION_COLUMN_DESCRIPTION = "description";
        public static final String LOCATION_COLUMN_IMAGE_URL = "image_url";
        public static final String LOCATION_COLUMN_PINNED = "pinned";

        public static final String DELICACY_TABLE_NAME = "Delicacy";
        public static final String DELICACY_COLUMN_NAME = "name";
        public static final String DELICACY_COLUMN_DESCRIPTION = "description";
        public static final String DELICACY_COLUMN_IMAGE_URL = "image_url";
        public static final String DELICACY_COLUMN_PINNED = "pinned";
        public static final String DELICACY_COLUMN_RATING = "rating";
    }
}
