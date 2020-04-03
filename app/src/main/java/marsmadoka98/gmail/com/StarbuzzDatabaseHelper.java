package marsmadoka98.gmail.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import marsmadoka98.gmail.com.StarbuzzConstants.*;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "starbuzz";
    private static final int DB_VERSION = 2;
    public StarbuzzDatabaseHelper(Context context) {
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
            final String SQL_CREATE_STARBUZZLIST_TABLE = "CREATE TABLE " + StarbuzzEntry.TABLE_NAME
                    + " (" + StarbuzzEntry._ID + " INTEGER PRIMARY KEY, "
                    + StarbuzzEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_DESCRIPTION  + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_LATITUDE + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_LONGITUDE + " TEXT NOT NULL" + ");";
            db.execSQL(SQL_CREATE_STARBUZZLIST_TABLE);
            insertHotel(db, "HILTONHOTEL","0.5KM from your destination","56","56");
            insertHotel(db, "KFC","5KM from your destination","60","70");
            insertHotel(db, "LUCINACAFE","13KM from your destination","80","70");
            insertHotel(db, "AMPELHOTEL","17.5KM from your destination","40","33");
            insertHotel(db, "KIMPSINKY","21 from your destination","20","45");
            insertHotel(db, "MARDSENHOTEL","37KM from your destination","10","45");
            insertHotel(db, "JUMIACAFR","50KM from your destination","70","45");
            insertHotel(db, "SODABASE","77KM from your destination","10","15");
            insertHotel(db, "YAKOHOTEL","82KM from your destination","30","45");
            insertHotel(db, "SISIKWASISI","92KM from your destination","40","40");
            insertHotel(db, "LWADAHOTEL","102KM from your destination","50","44");
            insertHotel(db, "VINCEHOTEL","104KM from your destination","60","49");
            insertHotel(db, "SENIORCAFE","105KM from your destination","70","59");
            insertHotel(db, "BAMBURISTARS","112KM from your destination","10","95");
            insertHotel(db, "CHINAEXPRESS","120KM from your destination","10","85");
            insertHotel(db, "DANDORACALTEX","130KM from your destination","30","45");
            insertHotel(db, "ELEPHANTPARKS","132KM from your destination","20","85");

/**
            final String SQL_CREATE_CATEGOY_TABLE ="CREATE TABLE " + CategoryEntry.TABLE_NAME
                    + " (" + CategoryEntry._ID + " INTEGER PRIMARY KEY, "
                    + CategoryEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + CategoryEntry.COLUMN_IMAGE + " INTERGER" + ");";
            db.execSQL(SQL_CREATE_CATEGOY_TABLE);
            insertCategoryItems(db,"FOODS",R.drawable.diavolo );
            insertCategoryItems(db,"DRINKS",R.drawable.cappuccino);
            insertCategoryItems(db,"FRUITS",R.drawable.restaurant);
*/

        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE HOTELS ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertHotel(SQLiteDatabase db, String name,String description,String lati,String longi){
        ContentValues hotelsValues=new ContentValues();
        hotelsValues.put("NAME",name);
        hotelsValues.put("DESCRIPTION",description);
        hotelsValues.put("LATITUDE",lati);
        hotelsValues.put("LONGITUDE",longi);
        db.insert("HOTELS",null,hotelsValues);
    }
/**
    private static void insertCategoryItems(SQLiteDatabase db,String catename,int image){
        ContentValues categoryValues= new ContentValues();
        categoryValues.put("NAME",catename);
        categoryValues.put("IMAGE",image);
        db.insert("CATEGORYITEMS",null,categoryValues);

    }

 */
}
/*  final String SQL_CREATE_STARBUZZLIST_TABLE = "CREATE TABLE " + StarbuzzEntry.TABLE_NAME
            + " (" + StarbuzzEntry._ID + " INTEGER PRIMARY KEY, "
                    + StarbuzzEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_LATITUDE + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_LONGITUDE + " TEXT NOT NULL" +");";
                   // + StarbuzzEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL" +");";
            db.execSQL(SQL_CREATE_STARBUZZLIST_TABLE);
            insertHotel(db, "HILTONHOTEL","0.5KM from your destination","56","56");
            insertHotel(db, "KFC","5KM from your destination","60","70");
            insertHotel(db, "LUCINACAFE","13KM from your destination","80","70");
            insertHotel(db, "AMPELHOTEL","17.5KM from your destination","40","33");
            insertHotel(db, "KIMPSINKY","21 from your destination","20","45");
            insertHotel(db, "MARDSENHOTEL","37KM from your destination","10","45");
            insertHotel(db, "JUMIACAFR","50KM from your destination","70","45");
            insertHotel(db, "SODABASE","77KM from your destination","10","15");
            insertHotel(db, "YAKOHOTEL","82KM from your destination","30","45");
            insertHotel(db, "SISIKWASISI","92KM from your destination","40","40");
            insertHotel(db, "LWADAHOTEL","102KM from your destination","50","44");
            insertHotel(db, "VINCEHOTEL","104KM from your destination","60","49");
            insertHotel(db, "SENIORCAFE","105KM from your destination","70","59");
            insertHotel(db, "BAMBURISTARS","112KM from your destination","10","95");
            insertHotel(db, "CHINAEXPRESS","120KM from your destination","10","85");
            insertHotel(db, "DANDORACALTEX","130KM from your destination","30","45");
            insertHotel(db, "ELEPHANTPARKS","132KM from your destination","20","85");

        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE HOTELS ADD COLUMN FAVORITE NUMERIC;");
        }
    }
    private static void insertHotel(SQLiteDatabase db, String name,String description,String lati,String longi){
        ContentValues hotelsValues=new ContentValues();
        hotelsValues.put("NAME",name);
        hotelsValues.put("DESCRIPTION",description);
        hotelsValues.put("LATITUDE",lati);
        hotelsValues.put("LONGITUDE",longi);
        db.insert("HOTELS",null,hotelsValues);
    }*/
