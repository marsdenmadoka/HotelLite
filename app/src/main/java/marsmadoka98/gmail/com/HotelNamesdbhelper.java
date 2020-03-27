package marsmadoka98.gmail.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HotelNamesdbhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "HotelDB";
    private static final int DB_VERSION = 2;
    public HotelNamesdbhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        UpdateHotelData(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,  int oldVersion, int newVersion) {
        UpdateHotelData(db, 0, DB_VERSION);
    }
    private void UpdateHotelData(SQLiteDatabase db,int oldVersion, int newVersion)  {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE HOTELS (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT,"
                    + "DESCRIPTION TEXT);");
        insertHotelNames(db, "HILTONHOTEL","we are located in nairobi");
        insertHotelNames(db, "KFC","we are located in nairobi");
        insertHotelNames(db, "LUCINA CAFE","we are located in nairobi");
        insertHotelNames(db, "AMPEL HOTEL","we are located in nairobi");
        insertHotelNames(db, "KIMPSINKY","we are located in nairobi");
        insertHotelNames(db, "MARDSEN HOTEL","we are located in nairobi");
        insertHotelNames(db, "JUMIA CAFR","we are located in nairobi");
        insertHotelNames(db, "SODA BASE","we are located in nairobi");
        insertHotelNames(db, "YAKO HOTEL","we are located in nairobi");
        insertHotelNames(db, "SISI KWA SISI","we are located in nairobi");
        insertHotelNames(db, "LWADA HOTEL","we are located in nairobi");
        insertHotelNames(db, "VINCE HOTEL","we are located in nairobi");
        insertHotelNames(db, "SENIOR CAFE","we are located in nairobi");
        insertHotelNames(db, "BAMBURI STARS","we are located in nairobi");
        insertHotelNames(db, "CHINA EXPRESS","we are located in nairobi");
        insertHotelNames(db, "DANDORA CALTEX","we are located in nairobi");
        insertHotelNames(db, "ELEPHANT PARKS","we are located in nairobi");

        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE HOTELS ADD COLUMN FAVORITE NUMERIC;");
        }
    }
    //Hotelsnames
    private static void insertHotelNames(SQLiteDatabase db, String name,String description){
        ContentValues hotelsValues=new ContentValues();
        hotelsValues.put("NAME",name);
        hotelsValues.put("DESCRIPTION", description);
        db.insert("HOTELS,",null,hotelsValues);
    }
}
