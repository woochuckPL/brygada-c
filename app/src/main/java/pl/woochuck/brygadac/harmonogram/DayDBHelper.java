package pl.woochuck.brygadac.harmonogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DayDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "HARMONOGRAM";
    private static final String TABLE_NAME = "HARMONOGRAM";
    private static final String COL0_ID = "_id";
    private static final String COL1_WEEK = "WEEK";
    private static final String COL2_MONTH = "MONTH";
    private static final String COL3_DATE = "DATE";
    private static final String COL4_DAY = "DAY";
    private static final String COL5_EMP0 = "EMP0";
    private static final String COL6_EMP1 = "EMP1";
    private static final String COL7_EMP2 = "EMP2";
    private static final String COL8_EMP3 = "EMP3";
    private static final String COL9_EMP4 = "EMP4";
    private static final String COL10_EMP5 = "EMP5";
    private static final String COL11_EMP6 = "EMP6";
    private static final String COL12_EMP7 = "EMP7";
    private static final String COL13_EMP8 = "EMP8";
    private static final String COL14_EMP9 = "EMP9";
    private static final String COL15_EMP10 = "EMP10";

    public DayDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createSqlQueryForTableCreating());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createSqlQueryForTableCreating() {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" + COL0_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL1_WEEK + " TEXT, "
                + COL2_MONTH + " TEXT, "
                + COL3_DATE + " INTEGER, "
                + COL4_DAY + " TEXT, "
                + COL5_EMP0 + " TEXT, "
                + COL6_EMP1 + " TEXT, "
                + COL7_EMP2 + " TEXT, "
                + COL8_EMP3 + " TEXT, "
                + COL9_EMP4 + " TEXT, "
                + COL10_EMP5 + " TEXT, "
                + COL11_EMP6 + " TEXT, "
                + COL12_EMP7 + " TEXT, "
                + COL13_EMP8 + " TEXT, "
                + COL14_EMP9 + " TEXT, "
                + COL15_EMP10 + " TEXT);";
        return sqlQuery;
    }
}
