package vorkapic.com.dropit.database;

import android.provider.BaseColumns;

/**
 * Created by dvor on 19/07/16.
 */
public class DropItContract {

    public DropItContract() {}

    public static abstract class DropItEntry implements BaseColumns {

        public static final String TABLE_DROPS = "drop";
        public static final String COLUMN_NAME_DROP_TITLE = "title";
        public static final String COLUMN_NAME_DROP_CONTENT = "content";
        public static final String COLUMN_NAME_DROP_LONGITUDE = "longitude";
        public static final String COLUMN_NAME_DROP_LATITUDE = "latitude";
        public static final String COLUMN_NAME_DROP_BIRTH = "birth";

        public static final String TABLE_CONTENT = "content";
        public static final String COLUMN_NAME_CONTENT_TEXT = "text";
        public static final String COLUMN_NAME_CONTENT_ATTACHMENT = "attachment";

        public static final String TYPE_TEXT = " TEXT";
        public static final String TYPE_INTEGER = " INTEGER";
        public static final String TYPE_REAL = " REAL";
        public static final String TYPE_BLOB = " BLOB";
        public static final String DEFAULT_NULL = " DEFAULT NULL";
        public static final String DEFAULT_ZERO = " DEFAULT 0";
        public static final String NOT_NULL = " NOT NULL";
        public static final String AUTOINCREMENT_KEY = TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT";
        public static final String COMMA_SEPARATOR = ",";

        public static final String[] DROP_TABLE_COLUMNS = {
            _ID + AUTOINCREMENT_KEY,
            COLUMN_NAME_DROP_TITLE + TYPE_TEXT + NOT_NULL,
            COLUMN_NAME_DROP_CONTENT + TYPE_INTEGER + NOT_NULL,
            COLUMN_NAME_DROP_LONGITUDE + TYPE_REAL + NOT_NULL,
            COLUMN_NAME_DROP_LATITUDE + TYPE_REAL + NOT_NULL,
            COLUMN_NAME_DROP_BIRTH + TYPE_TEXT + NOT_NULL
        };

        public static final String[] CONTENT_TABLE_COLUMNS = {
                _ID + AUTOINCREMENT_KEY,
                COLUMN_NAME_CONTENT_TEXT + TYPE_TEXT + NOT_NULL,
                COLUMN_NAME_CONTENT_ATTACHMENT + TYPE_TEXT + DEFAULT_NULL
        };
    }
}
