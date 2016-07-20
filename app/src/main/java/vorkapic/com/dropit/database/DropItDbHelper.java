package vorkapic.com.dropit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vorkapic.com.dropit.dataModels.Drop;

/**
 * Created by dvor on 19/07/16.
 */
public class DropItDbHelper extends SQLiteOpenHelper {

    // Database settings
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DropIt.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEPARATOR = ",";
    private static final String SQL_CREATE_ENTRIES_DROP =
            "CREATE TABLE " + DropItContract.DropItEntry.TABLE_DROPS + " (" +
                    DropItContract.DropItEntry._ID + " INTEGER PRIMARY KEY," +
                    DropItContract.DropItEntry.COLUMN_NAME_DROP_TITLE + TEXT_TYPE + COMMA_SEPARATOR +
                    DropItContract.DropItEntry.COLUMN_NAME_DROP_CONTENT + TEXT_TYPE + COMMA_SEPARATOR +
                    DropItContract.DropItEntry.COLUMN_NAME_DROP_BIRTH + TEXT_TYPE + COMMA_SEPARATOR +
                    DropItContract.DropItEntry.COLUMN_NAME_DROP_LATITUDE + TEXT_TYPE + COMMA_SEPARATOR +
                    DropItContract.DropItEntry.COLUMN_NAME_DROP_LONGITUDE + TEXT_TYPE + COMMA_SEPARATOR +
                    " )";
    private static final String SQL_CREATE_ENTRIES_CONTENT =
            "CREATE TABLE " + DropItContract.DropItEntry.TABLE_CONTENT + " (" +
                    DropItContract.DropItEntry._ID + " INTEGER PRIMARY KEY," +
                    DropItContract.DropItEntry.COLUMN_NAME_CONTENT_TEXT + TEXT_TYPE + COMMA_SEPARATOR +
                    DropItContract.DropItEntry.COLUMN_NAME_CONTENT_ATTACHMENT + TEXT_TYPE + COMMA_SEPARATOR +
                    " )";

    private static final String SQL_DELETE_ENTRIES_DROP = "DROP TABLE IF EXISTS " + DropItContract.DropItEntry.TABLE_DROPS;
    private static final String SQL_DELETE_ENTRIES_CONTENT = "DROP TABLE IF EXISTS " + DropItContract.DropItEntry.TABLE_CONTENT;

    public DropItDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        setupDatabase(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES_DROP);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES_CONTENT);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db, oldVersion, newVersion);
    }

    private void setupDatabase(SQLiteDatabase db) {
        db.execSQL(SqlUtil.createTable(DropItContract.DropItEntry.TABLE_DROPS, DropItContract.DropItEntry.DROP_TABLE_COLUMNS, null));
        db.execSQL(SqlUtil.createTable(DropItContract.DropItEntry.TABLE_CONTENT, DropItContract.DropItEntry.CONTENT_TABLE_COLUMNS, null));
    }

    public long insertDrop(Drop drop) {
        long contentRowIndex = -1;
        long dropRowIndex = -1;

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DropItContract.DropItEntry.COLUMN_NAME_CONTENT_TEXT, drop.getMessage());
        contentValues.put(DropItContract.DropItEntry.COLUMN_NAME_CONTENT_ATTACHMENT, drop.getAttachment());
        contentRowIndex = db.insert(DropItContract.DropItEntry.TABLE_CONTENT, null, contentValues);

        ContentValues dropValues = new ContentValues();
        dropValues.put(DropItContract.DropItEntry.COLUMN_NAME_DROP_TITLE, drop.getTitle());
        dropValues.put(DropItContract.DropItEntry.COLUMN_NAME_DROP_BIRTH, drop.getBirth().toString());
        dropValues.put(DropItContract.DropItEntry.COLUMN_NAME_DROP_LATITUDE, drop.getLatitude());
        dropValues.put(DropItContract.DropItEntry.COLUMN_NAME_DROP_LONGITUDE, drop.getLongitude());
        dropValues.put(DropItContract.DropItEntry.COLUMN_NAME_DROP_CONTENT, contentRowIndex);
        dropRowIndex = db.insert(DropItContract.DropItEntry.TABLE_DROPS, null, dropValues);

        return dropRowIndex;
    }
}
