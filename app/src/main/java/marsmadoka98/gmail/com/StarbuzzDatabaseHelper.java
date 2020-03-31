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
                    + StarbuzzEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL" + ");";
            db.execSQL(SQL_CREATE_STARBUZZLIST_TABLE);
            insertHotel(db, "HILTONHOTEL","we are located in nairobi");
            insertHotel(db, "KFC","we are located in nairobi");
            insertHotel(db, "LUCINACAFE","we are located in nairobi");
            insertHotel(db, "AMPELHOTEL","we are located in nairobi");
            insertHotel(db, "KIMPSINKY","we are located in nairobi");
            insertHotel(db, "MARDSENHOTEL","we are located in nairobi");
            insertHotel(db, "JUMIACAFR","we are located in nairobi");
            insertHotel(db, "SODABASE","we are located in nobi");
            insertHotel(db, "YAKOHOTEL","we are located in nrobi");
            insertHotel(db, "SISIKWASISI","we are located in nairobi");
            insertHotel(db, "LWADAHOTEL","we are located in nairbi");
            insertHotel(db, "VINCEHOTEL","we are located in nairobi");
            insertHotel(db, "SENIORCAFE","we are located in airobi");
            insertHotel(db, "BAMBURISTARS","we are located in nairob");
            insertHotel(db, "CHINAEXPRESS","we are located in nairbi");
            insertHotel(db, "DANDORACALTEX","we are located in narobi");
            insertHotel(db, "ELEPHANTPARKS","we are located in nairobi");

        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE HOTELS ADD COLUMN FAVORITE NUMERIC;");
        }
    }
    private static void insertHotel(SQLiteDatabase db, String name,String description){
        ContentValues hotelsValues=new ContentValues();
        hotelsValues.put("NAME",name);
        hotelsValues.put("DESCRIPTION",description);
        db.insert("HOTELS",null,hotelsValues);
    }

}
