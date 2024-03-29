package com.example.fifthprogram;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    private static final int Db_Version = 1;
    private static final String Db_name="users", Table_name="user", User_id="id", User_name="name", User_password="password";

    public DbHandler(MainActivity context) {
        super(context, Db_name, null, Db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create_Table = "CREATE TABLE " + Table_name + "(" + User_id + " INTEGER PRIMARY KEY," + User_name + " VARCHAR," + User_password + " VARCHAR)";
        sqLiteDatabase.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(sqLiteDatabase);
    }

    public void addUser(User usr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(User_name, usr.getName());
        cv.put(User_password, usr.getPassword());
        db.insert(Table_name, null, cv);
        db.close();
    }

    public int checkUser(User usr) {
        int id = -1;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM user WHERE name = ? and password = ?", new String[] {
                usr.getName(), usr.getPassword()
        });
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(0);
            cursor.close();
        }
        return id;
    }
}
