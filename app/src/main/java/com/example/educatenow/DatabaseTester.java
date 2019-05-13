package com.example.educatenow;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseTester extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public DatabaseTester(Context context){
        super(context,"app.db",null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table appusers(user_id integer  not null primary key  autoincrement,fullname varchar(50) not null, username varchar(50) ,password varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS appusers");
        onCreate(db);
    }
    public boolean addUserData(String name,String user, String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fullname",name);
        contentValues.put("username",user);
        contentValues.put("password",pass);
        long sendData=db.insert("appusers",null,contentValues);
        if (sendData==-1){
            return false;
        }
        else{
            return true;
        }

    }
    public boolean signInUserWithUserNameAndPassword(String name,String pass){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * from appusers where username=? and password=?",new String[]{name,pass});
        if (cursor.getCount()>0){
            return true;
        }
        else
            return false;

    }
}
