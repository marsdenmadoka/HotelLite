package marsmadoka98.gmail.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.FrameLayout;

import com.google.android.gms.common.data.FreezableUtils;

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
                    + " (" + StarbuzzEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + StarbuzzEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_DESCRIPTION  + " TEXT NOT NULL, "
                    + StarbuzzEntry.COLUMN_LATITUDE + " DOUBLE, "
                    + StarbuzzEntry.COLUMN_LONGITUDE + " DOUBLE" + ");";
            db.execSQL(SQL_CREATE_STARBUZZLIST_TABLE);
            insertHotel(db, "HILTONHOTEL","0.5KM from your destination",56.3,56.0);
            insertHotel(db, "KFC","5KM from your destination",60.4,70.1);
            insertHotel(db, "LUCINACAFE","13KM from your destination",80.5,70.5);
            insertHotel(db, "AMPELHOTEL","17.5KM from your destination",40.6,33.5);
            insertHotel(db, "KIMPSINKY","21 from your destination",20.5,45.1);
            insertHotel(db, "MARDSENHOTEL","37KM from your destination",10.5,45.9);
            insertHotel(db, "JUMIACAFR","50KM from your destination",70.5,45.5);
            insertHotel(db, "SODABASE","77KM from your destination",10.2,85.6);
            insertHotel(db, "YAKOHOTEL","82KM from your destination",30.1,45.5);
            insertHotel(db, "SISIKWASISI","92KM from your destination",40.8,40.9);
            insertHotel(db, "LWADAHOTEL","102KM from your destination",50.1,44.0);
            insertHotel(db, "VINCEHOTEL","104KM from your destination",60.7,49.4);
            insertHotel(db, "SENIORCAFE","105KM from your destination",70.2,59.0);
            insertHotel(db, "BAMBURISTARS","112KM from your destination",10.1,95.9);
            insertHotel(db, "CHINAEXPRESS","120KM from your destination",10.2,85.8);
            insertHotel(db, "DANDORACALTEX","130KM from your destination",30.4,45.7);
            insertHotel(db, "ELEPHANTPARKS","132KM from your destination",20.5,85.6);


            final String SQL_CREATE_CATEGORY_TABLE ="CREATE TABLE " + CategoryEntry.TABLE_NAME
                    + " (" + CategoryEntry._ID + " INTEGER PRIMARY KEY, "
                    + CategoryEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + CategoryEntry.COLUMN_IMAGE + " INTERGER" + ");";
            db.execSQL(SQL_CREATE_CATEGORY_TABLE);
            insertCategoryItems(db,"FOODS",R.drawable.diavolo );
            insertCategoryItems(db,"DRINKS",R.drawable.cappuccino);
            insertCategoryItems(db,"FRUITS",R.drawable.restaurant);

            final String SQL_CREATE_FRUITS_TABLE ="CREATE TABLE "+ FruitsEntry.TABLE_NAME
                    + " (" + FruitsEntry._ID + " INTEGER PRIMARY KEY, "
                    +  FruitsEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + FruitsEntry.COLUMN_PRICE + " INTEGER, "
                    + FruitsEntry.COLUMN_DESCRPTION + " TEXT NOT NULL, "
                    + FruitsEntry.COLUMN_IMAGE + " INTEGER" + ");";
            db.execSQL(SQL_CREATE_FRUITS_TABLE);
            insertFruits(db,"ORANGE", 50,R.drawable.diavolo,"sweet mango can produce mango juice deliouus helps in vitamin c");
            insertFruits(db,"AVOCADO",45,R.drawable.cappuccino,"Avacado helps in vitamin c its alos a fruits");
            insertFruits(db,"BANANA",10,R.drawable.restaurant,"produces banana juice helps in vision");
            insertFruits(db,"WATERMELON",60,R.drawable.diavolo,"watery juice cools down your temperatures");
            insertFruits(db,"PINEAPPLE",20,R.drawable.restaurant,"you will enjoy it try it man");
            insertFruits(db,"MANGO",13,R.drawable.cappuccino,"my favourite fruit i really miss it");

        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE HOTELS ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE CATEGORYITEMS ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE FRUITS ADD COLUMN FAVOURITE NUMERIC");
        }
    }

    private static void insertHotel(SQLiteDatabase db, String name,String description,Double lati,Double longi){
        ContentValues hotelsValues=new ContentValues();
        hotelsValues.put("NAME",name);
        hotelsValues.put("DESCRIPTION",description);
        hotelsValues.put("LATITUDE",lati);
        hotelsValues.put("LONGITUDE",longi);
        db.insert("HOTELS",null,hotelsValues);
    }

    private static void insertCategoryItems(SQLiteDatabase db,String catename,int image){
        ContentValues categoryValues= new ContentValues();
        categoryValues.put("NAME",catename);
        categoryValues.put("IMAGE",image);
        db.insert("CATEGORYITEMS",null,categoryValues);

    }

    private static void insertFruits(SQLiteDatabase db,String fruitname,int fruitprice,int fruitimage,String fruitdescription){
        ContentValues FruitsValues=new ContentValues();
        FruitsValues.put("FRUIITSNAME",fruitname);
        FruitsValues.put("FRUITSPRICE",fruitprice);
        FruitsValues.put("FRUITSIMAGE",fruitimage);
        FruitsValues.put("FRUITSDESCRPTION",fruitdescription);
        db.insert("FRUITS",null,FruitsValues);

    }



}

