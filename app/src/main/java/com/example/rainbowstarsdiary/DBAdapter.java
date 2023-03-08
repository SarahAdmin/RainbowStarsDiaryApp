package com.example.rainbowstarsdiary;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.sql.SQLDataException;
import java.sql.SQLException;
public class DBAdapter {
   myDatabaseHelper myHelper;
   public DBAdapter (Context contextOne) {

       myHelper = new myDatabaseHelper(contextOne);
   }
   public long insertData(String date, String time, String book_title, String pages_read,
                          Float rating, String comments) {
       SQLiteDatabase dbb = myHelper.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(myDatabaseHelper.DATE, date);
       contentValues.put(myDatabaseHelper.TIME, time);
       contentValues.put(myDatabaseHelper.BOOK_TITLE, book_title);
       contentValues.put(myDatabaseHelper.PAGES_READ, pages_read);
       contentValues.put(myDatabaseHelper.RATING, rating);
       contentValues.put(myDatabaseHelper.TEACHER_COMMENT, comments);
       long id = dbb.insert(myDatabaseHelper.TABLE_NAME, null, contentValues);
       return id;
   }
    public String getData () {
       SQLiteDatabase db = myHelper.getWritableDatabase();
       String[] columns = {myDatabaseHelper.ID,myDatabaseHelper.DATE,myDatabaseHelper.TIME,
               myDatabaseHelper.BOOK_TITLE, myDatabaseHelper.PAGES_READ, myDatabaseHelper.RATING, myDatabaseHelper.TEACHER_COMMENT};
               Cursor cursorOne = db.query(myDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
               StringBuffer bufferOne = new StringBuffer();
               while(cursorOne.moveToNext()) {
                   int cid = cursorOne.getInt(cursorOne.getColumnIndexOrThrow(myDatabaseHelper.ID));
                   int date = cursorOne.getInt(cursorOne.getColumnIndexOrThrow(myDatabaseHelper.DATE));
                   int time = cursorOne.getInt(cursorOne.getColumnIndexOrThrow(myDatabaseHelper.TIME));
                   String book_title = cursorOne.getString(cursorOne.getColumnIndexOrThrow(myDatabaseHelper.BOOK_TITLE));
                   int pages_read = cursorOne.getInt(cursorOne.getColumnIndexOrThrow(myDatabaseHelper.PAGES_READ));
                   int rating = cursorOne.getInt(cursorOne.getColumnIndexOrThrow(myDatabaseHelper.RATING));
                   int comments = cursorOne.getInt(cursorOne.getColumnIndexOrThrow(myDatabaseHelper.TEACHER_COMMENT));
                   bufferOne.append(cid+ " "+ date+ " "+ time+ " "+ book_title + " " + pages_read+ " " +rating+ " " + comments + " /n");
               }
               return bufferOne.toString();
    }
    public int delete(String uname) {
       SQLiteDatabase db = myHelper.getWritableDatabase();
       String[] whereArgs = {uname};
       int count = db.delete(myDatabaseHelper.TABLE_NAME, myDatabaseHelper.BOOK_TITLE+" = ? ",whereArgs);
       return count;
    }
    public int modify(String oldBook, String newBook) {
       SQLiteDatabase db = myHelper.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
        contentValues.put(myDatabaseHelper.BOOK_TITLE, newBook);
      String[] whereArgs = {oldBook};
      int count = db.update(myDatabaseHelper.TABLE_NAME, contentValues, myDatabaseHelper.BOOK_TITLE+" = ?",whereArgs);
      return count;
    }
   static class myDatabaseHelper extends SQLiteOpenHelper {
       private static final String DATABASE_NAME = "myDBOne";
       private static final String TABLE_NAME = "Diary";
       private static final int DATABASE_version = 1;
       private static final String ID = "_id";
       private static final String DATE = "Date";
       private static final String TIME = "Time";
       private static final String BOOK_TITLE = "Book Title";
       private static final String PAGES_READ = "Pages Read";
       private static final String RATING = "Rating";
       private static final String TEACHER_COMMENT = "Comments";

       private Context contextOne;

       public myDatabaseHelper(Context contextOne) {
           super(contextOne, DATABASE_NAME, null, DATABASE_version);
           this.contextOne = contextOne;
       }

       public void onCreate(SQLiteDatabase db) {
               db.execSQL("CREATE TABLE "+DATABASE_NAME + TABLE_NAME +"(" +
                       ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                       DATE + "DATE NOT NULL,"
                       + TIME + "INTEGER NOT NULL,"
                       + BOOK_TITLE + "VARCHAR NOT NULL,"
                         + PAGES_READ + "INTEGER NOT NULL,"
                         + RATING + "INTEGER NOT NULL,"
                       +TEACHER_COMMENT + "VARCHAR NOT NULL);" );
       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
         onCreate(db);
           }
       }
   }
