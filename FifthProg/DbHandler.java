package com.example.fifthpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {
    private static final int Db_version = 1;
    private final String table_name = "user", user_name = "name", user_password = "password", user_id = "Id";
    public DbHandler(Context context) {
        super(context, "users", null, Db_version);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table = "CREATE TABLE IF NOT EXISTS " + table_name + "(" + user_id + " INTEGER PRIMARY KEY, " + user_name + " VARCHAR, " + user_password + " VARCHAR);";
        sqLiteDatabase.execSQL(create_table);
    }

    public void addUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(user_name, user.getName());
        cv.put(user_password, user.getPassword());
        db.insert(table_name, null, cv);
        db.close();
    }

    public int checkUser(User user) {
        int id = -1;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT Id from user WHERE name = ? and password = ?", new String[] {
                user.getName(), user.getPassword()
        });
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

}
