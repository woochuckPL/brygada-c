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
        fillTable(db, createDaysList());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Day> findAllDays (SQLiteDatabase db) {
        List<Day> days = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, new String[] {COL0_ID, COL1_WEEK, COL2_MONTH, COL3_DATE, COL4_DAY, COL5_EMP0, COL6_EMP1, COL7_EMP2, COL8_EMP3, COL9_EMP4, COL10_EMP5, COL11_EMP6, COL12_EMP7, COL13_EMP8, COL14_EMP9, COL15_EMP10}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String week = cursor.getString(1);
            String month = cursor.getString(2);
            int date = cursor.getInt(3);
            String day = cursor.getString(4);
            String shiftEmp0 = cursor.getString(5);
            String shiftEmp1 = cursor.getString(6);
            String shiftEmp2 = cursor.getString(7);
            String shiftEmp3 = cursor.getString(8);
            String shiftEmp4 = cursor.getString(9);
            String shiftEmp5 = cursor.getString(10);
            String shiftEmp6 = cursor.getString(11);
            String shiftEmp7 = cursor.getString(12);
            String shiftEmp8 = cursor.getString(13);
            String shiftEmp9 = cursor.getString(14);
            String shiftEmp10 = cursor.getString(15);

            days.add(new Day(id, week, month, date, day, shiftEmp0, shiftEmp1, shiftEmp2, shiftEmp3, shiftEmp4, shiftEmp5, shiftEmp6, shiftEmp7, shiftEmp8, shiftEmp9, shiftEmp10));
        }

        cursor.close();
        return days;
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

    private void fillTable (SQLiteDatabase db, List<Day> days) {
        for (Day day : days) {
            insertDay(db, day);
        }
    }

    private void insertDay (SQLiteDatabase db, Day day) {
        ContentValues dayValues = new ContentValues();
        dayValues.put(COL1_WEEK, day.getWeek());
        dayValues.put(COL2_MONTH, day.getMonth());
        dayValues.put(COL3_DATE, day.getDate());
        dayValues.put(COL4_DAY, day.getDay());
        dayValues.put(COL5_EMP0, day.getShiftEmp0());
        dayValues.put(COL6_EMP1, day.getShiftEmp1());
        dayValues.put(COL7_EMP2, day.getShiftEmp2());
        dayValues.put(COL8_EMP3, day.getShiftEmp3());
        dayValues.put(COL9_EMP4, day.getShiftEmp4());
        dayValues.put(COL10_EMP5, day.getShiftEmp5());
        dayValues.put(COL11_EMP6, day.getShiftEmp6());
        dayValues.put(COL12_EMP7, day.getShiftEmp7());
        dayValues.put(COL13_EMP8, day.getShiftEmp8());
        dayValues.put(COL14_EMP9, day.getShiftEmp9());
        dayValues.put(COL15_EMP10, day.getShiftEmp10());
        db.insert(TABLE_NAME, null, dayValues);
    }

    public void updateDay (SQLiteDatabase db, Day day) {
        ContentValues dayValues = new ContentValues();
        dayValues.put(COL6_EMP1, day.getShiftEmp1());
        dayValues.put(COL7_EMP2, day.getShiftEmp2());
        dayValues.put(COL8_EMP3, day.getShiftEmp3());
        dayValues.put(COL9_EMP4, day.getShiftEmp4());
        dayValues.put(COL10_EMP5, day.getShiftEmp5());
        dayValues.put(COL11_EMP6, day.getShiftEmp6());
        dayValues.put(COL12_EMP7, day.getShiftEmp7());
        dayValues.put(COL13_EMP8, day.getShiftEmp8());
        dayValues.put(COL14_EMP9, day.getShiftEmp9());
        dayValues.put(COL15_EMP10, day.getShiftEmp10());
        db.update(TABLE_NAME, dayValues, COL0_ID + " = ?", new String[] {Integer.toString(day.getId())});
    }

    private List<Day> createDaysList () {
        List<Day> days = new ArrayList<>();
        days.add(new Day("KW53", "STY", 1, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW53", "STY", 2, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW53", "STY", 3, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW1", "STY", 4, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW1", "STY", 5, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW1", "STY", 6, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW1", "STY", 7, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW1", "STY", 8, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW1", "STY", 9, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW1", "STY", 10, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW2", "STY", 11, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW2", "STY", 12, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW2", "STY", 13, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW2", "STY", 14, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW2", "STY", 15, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW2", "STY", 16, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW2", "STY", 17, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW3", "STY", 18, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW3", "STY", 19, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW3", "STY", 20, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW3", "STY", 21, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW3", "STY", 22, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW3", "STY", 23, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW3", "STY", 24, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW4", "STY", 25, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW4", "STY", 26, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW4", "STY", 27, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW4", "STY", 28, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW4", "STY", 29, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW4", "STY", 30, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW4", "STY", 31, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW5", "LUT", 1, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW5", "LUT", 2, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW5", "LUT", 3, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW5", "LUT", 4, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW5", "LUT", 5, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW5", "LUT", 6, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW5", "LUT", 7, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW6", "LUT", 8, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW6", "LUT", 9, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW6", "LUT", 10, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW6", "LUT", 11, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW6", "LUT", 12, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW6", "LUT", 13, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW6", "LUT", 14, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW7", "LUT", 15, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW7", "LUT", 16, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW7", "LUT", 17, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW7", "LUT", 18, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW7", "LUT", 19, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW7", "LUT", 20, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW7", "LUT", 21, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW8", "LUT", 22, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW8", "LUT", 23, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW8", "LUT", 24, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW8", "LUT", 25, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW8", "LUT", 26, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW8", "LUT", 27, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW8", "LUT", 28, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW9", "MAR", 1, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW9", "MAR", 2, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW9", "MAR", 3, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW9", "MAR", 4, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW9", "MAR", 5, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW9", "MAR", 6, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW9", "MAR", 7, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW10", "MAR", 8, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW10", "MAR", 9, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW10", "MAR", 10, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW10", "MAR", 11, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW10", "MAR", 12, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW10", "MAR", 13, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW10", "MAR", 14, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW11", "MAR", 15, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW11", "MAR", 16, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW11", "MAR", 17, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW11", "MAR", 18, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW11", "MAR", 19, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW11", "MAR", 20, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW11", "MAR", 21, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW12", "MAR", 22, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW12", "MAR", 23, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW12", "MAR", 24, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW12", "MAR", 25, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW12", "MAR", 26, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW12", "MAR", 27, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW12", "MAR", 28, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW13", "MAR", 29, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW13", "MAR", 30, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW13", "MAR", 31, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW13", "KWI", 1, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW13", "KWI", 2, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW13", "KWI", 3, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW13", "KWI", 4, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW14", "KWI", 5, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW14", "KWI", 6, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW14", "KWI", 7, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW14", "KWI", 8, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW14", "KWI", 9, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW14", "KWI", 10, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW14", "KWI", 11, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW15", "KWI", 12, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW15", "KWI", 13, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW15", "KWI", 14, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW15", "KWI", 15, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW15", "KWI", 16, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW15", "KWI", 17, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW15", "KWI", 18, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW16", "KWI", 19, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW16", "KWI", 20, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW16", "KWI", 21, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW16", "KWI", 22, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW16", "KWI", 23, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW16", "KWI", 24, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW16", "KWI", 25, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW17", "KWI", 26, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW17", "KWI", 27, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW17", "KWI", 28, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW17", "KWI", 29, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW17", "KWI", 30, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW17", "MAJ", 1, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW17", "MAJ", 2, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW18", "MAJ", 3, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW18", "MAJ", 4, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW18", "MAJ", 5, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW18", "MAJ", 6, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW18", "MAJ", 7, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW18", "MAJ", 8, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW18", "MAJ", 9, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW19", "MAJ", 10, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW19", "MAJ", 11, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW19", "MAJ", 12, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW19", "MAJ", 13, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW19", "MAJ", 14, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW19", "MAJ", 15, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW19", "MAJ", 16, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW20", "MAJ", 17, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW20", "MAJ", 18, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW20", "MAJ", 19, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW20", "MAJ", 20, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW20", "MAJ", 21, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW20", "MAJ", 22, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW20", "MAJ", 23, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW21", "MAJ", 24, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW21", "MAJ", 25, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW21", "MAJ", 26, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW21", "MAJ", 27, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW21", "MAJ", 28, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW21", "MAJ", 29, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW21", "MAJ", 30, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW22", "MAJ", 31, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW22", "CZE", 1, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW22", "CZE", 2, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW22", "CZE", 3, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW22", "CZE", 4, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW22", "CZE", 5, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW22", "CZE", 6, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW23", "CZE", 7, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW23", "CZE", 8, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW23", "CZE", 9, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW23", "CZE", 10, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW23", "CZE", 11, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW23", "CZE", 12, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW23", "CZE", 13, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW24", "CZE", 14, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW24", "CZE", 15, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW24", "CZE", 16, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW24", "CZE", 17, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW24", "CZE", 18, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW24", "CZE", 19, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW24", "CZE", 20, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW25", "CZE", 21, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW25", "CZE", 22, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW25", "CZE", 23, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW25", "CZE", 24, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW25", "CZE", 25, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW25", "CZE", 26, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW25", "CZE", 27, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW26", "CZE", 28, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW26", "CZE", 29, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW26", "CZE", 30, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW26", "LIP", 1, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW26", "LIP", 2, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW26", "LIP", 3, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW26", "LIP", 4, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW27", "LIP", 5, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW27", "LIP", 6, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW27", "LIP", 7, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW27", "LIP", 8, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW27", "LIP", 9, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW27", "LIP", 10, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW27", "LIP", 11, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW28", "LIP", 12, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW28", "LIP", 13, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW28", "LIP", 14, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW28", "LIP", 15, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW28", "LIP", 16, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW28", "LIP", 17, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW28", "LIP", 18, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW29", "LIP", 19, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW29", "LIP", 20, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW29", "LIP", 21, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW29", "LIP", 22, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW29", "LIP", 23, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW29", "LIP", 24, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW29", "LIP", 25, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW30", "LIP", 26, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW30", "LIP", 27, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW30", "LIP", 28, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW30", "LIP", 29, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW30", "LIP", 30, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW30", "LIP", 31, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW30", "SIE", 1, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW31", "SIE", 2, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW31", "SIE", 3, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW31", "SIE", 4, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW31", "SIE", 5, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW31", "SIE", 6, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW31", "SIE", 7, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW31", "SIE", 8, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW32", "SIE", 9, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW32", "SIE", 10, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW32", "SIE", 11, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW32", "SIE", 12, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW32", "SIE", 13, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW32", "SIE", 14, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW32", "SIE", 15, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW33", "SIE", 16, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW33", "SIE", 17, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW33", "SIE", 18, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW33", "SIE", 19, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW33", "SIE", 20, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW33", "SIE", 21, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW33", "SIE", 22, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW34", "SIE", 23, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW34", "SIE", 24, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW34", "SIE", 25, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW34", "SIE", 26, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW34", "SIE", 27, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW34", "SIE", 28, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW34", "SIE", 29, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW35", "SIE", 30, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW35", "SIE", 31, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW35", "WRZ", 1, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW35", "WRZ", 2, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW35", "WRZ", 3, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW35", "WRZ", 4, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW35", "WRZ", 5, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW36", "WRZ", 6, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW36", "WRZ", 7, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW36", "WRZ", 8, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW36", "WRZ", 9, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW36", "WRZ", 10, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW36", "WRZ", 11, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW36", "WRZ", 12, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW37", "WRZ", 13, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW37", "WRZ", 14, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW37", "WRZ", 15, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW37", "WRZ", 16, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW37", "WRZ", 17, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW37", "WRZ", 18, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW37", "WRZ", 19, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW38", "WRZ", 20, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW38", "WRZ", 21, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW38", "WRZ", 22, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW38", "WRZ", 23, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW38", "WRZ", 24, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW38", "WRZ", 25, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW38", "WRZ", 26, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW39", "WRZ", 27, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW39", "WRZ", 28, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW39", "WRZ", 29, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW39", "WRZ", 30, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW39", "PAŹ", 1, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW39", "PAŹ", 2, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW39", "PAŹ", 3, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW40", "PAŹ", 4, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW40", "PAŹ", 5, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW40", "PAŹ", 6, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW40", "PAŹ", 7, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW40", "PAŹ", 8, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW40", "PAŹ", 9, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW40", "PAŹ", 10, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW41", "PAŹ", 11, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW41", "PAŹ", 12, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW41", "PAŹ", 13, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW41", "PAŹ", 14, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW41", "PAŹ", 15, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW41", "PAŹ", 16, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW41", "PAŹ", 17, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW42", "PAŹ", 18, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW42", "PAŹ", 19, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW42", "PAŹ", 20, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW42", "PAŹ", 21, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW42", "PAŹ", 22, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW42", "PAŹ", 23, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW42", "PAŹ", 24, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW43", "PAŹ", 25, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW43", "PAŹ", 26, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW43", "PAŹ", 27, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW43", "PAŹ", 28, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW43", "PAŹ", 29, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW43", "PAŹ", 30, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW43", "PAŹ", 31, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW44", "LIS", 1, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW44", "LIS", 2, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW44", "LIS", 3, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW44", "LIS", 4, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW44", "LIS", 5, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW44", "LIS", 6, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW44", "LIS", 7, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW45", "LIS", 8, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW45", "LIS", 9, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW45", "LIS", 10, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW45", "LIS", 11, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW45", "LIS", 12, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW45", "LIS", 13, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW45", "LIS", 14, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW46", "LIS", 15, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW46", "LIS", 16, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW46", "LIS", 17, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW46", "LIS", 18, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW46", "LIS", 19, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW46", "LIS", 20, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW46", "LIS", 21, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW47", "LIS", 22, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW47", "LIS", 23, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW47", "LIS", 24, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW47", "LIS", 25, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW47", "LIS", 26, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW47", "LIS", 27, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW47", "LIS", 28, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW48", "LIS", 29, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW48", "LIS", 30, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW48", "GRU", 1, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW48", "GRU", 2, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW48", "GRU", 3, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW48", "GRU", 4, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW48", "GRU", 5, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW49", "GRU", 6, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW49", "GRU", 7, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW49", "GRU", 8, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW49", "GRU", 9, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW49", "GRU", 10, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW49", "GRU", 11, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW49", "GRU", 12, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW50", "GRU", 13, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW50", "GRU", 14, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW50", "GRU", 15, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW50", "GRU", 16, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW50", "GRU", 17, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW50", "GRU", 18, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW50", "GRU", 19, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW51", "GRU", 20, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW51", "GRU", 21, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW51", "GRU", 22, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW51", "GRU", 23, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW51", "GRU", 24, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW51", "GRU", 25, "SB", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW51", "GRU", 26, "N", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW52", "GRU", 27, "PN", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW52", "GRU", 28, "WT", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW52", "GRU", 29, "ŚR", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW52", "GRU", 30, "CZ", "", "", "", "", "", "", "", "", "", "", ""));
        days.add(new Day("KW52", "GRU", 31, "PT", "", "", "", "", "", "", "", "", "", "", ""));
        return days;
    }
}