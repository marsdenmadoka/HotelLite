package marsmadoka98.gmail.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import marsmadoka98.gmail.com.StarbuzzConstants.*;
public class categoryDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "categories";
    private static final int DB_VERSION = 2;
    public categoryDatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, 0, DB_VERSION);
    }
    private void updateMyDatabase(SQLiteDatabase db,int oldVersion, int newVersion)  {
        if (oldVersion < 1) {

            final String SQL_CREATE_CATEGOY_TABLE ="CREATE TABLE " + CategoryEntry.TABLE_NAME
                    + " (" + CategoryEntry._ID + " INTEGER PRIMARY KEY, "
                    + CategoryEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + CategoryEntry.COLUMN_IMAGE + " INTERGER" + ");";
            db.execSQL(SQL_CREATE_CATEGOY_TABLE);
            insertCategoryItems(db,"FOODS",R.drawable.diavolo );
            insertCategoryItems(db,"DRINKS",R.drawable.cappuccino);
            insertCategoryItems(db,"FRUITS",R.drawable.restaurant);


        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE HOTELS ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertCategoryItems(SQLiteDatabase db,String catename,int image){
        ContentValues categoryValues= new ContentValues();
        categoryValues.put("NAME",catename);
        categoryValues.put("IMAGE",image);
        db.insert("CATEGORYITEMS",null,categoryValues);

    }


}
