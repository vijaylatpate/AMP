package com.sbvc.amp2022;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String name = "office";
    private static final String Database_Table = "Employee";
    private static final String id = "id";
    private static final String sname = "sname";
    private SQLiteDatabase db;
    String query = "CREATE Table " + Database_Table + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT," + sname + " TEXT NOT NULL)";

    String query1 = "";
    List<Employee> employees = new ArrayList<Employee>();

    public MyDBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Database_Table);
        onCreate(sqLiteDatabase);
    }

    public boolean AddEmployee(Employee employee) {
        db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sname", employee.getSName());
            db.insert(Database_Table, null, contentValues);
            return true;
        } catch (Exception ex) {
            Log.d("SBVC_Database", ex.getMessage().toString());
            return false;
        } finally {
            db.close();
        }
    }

    public List<Employee> getAllEmployees() {
        query1 = "SELECT * from " + Database_Table;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query1, null);
        if (cursor.moveToFirst()) {
            do {
                Employee e = new Employee();
                e.setId(cursor.getInt(0));
                e.setSName(cursor.getString(1));
                employees.add(e);
            } while (cursor.moveToNext());
        }
        return employees;
    }
}
