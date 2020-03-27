package marsmadoka98.gmail.com;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import static android.provider.Settings.NameValueTable.NAME;
import static android.provider.Settings.NameValueTable._ID;

public class MainActivity extends ListActivity {
    private SQLiteDatabase db; //We’re adding these as private variables so we can close the database and the cursor in our onDestroy method.
    private Cursor cursor;
    public String name=NAME;
    public String id=_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            name = savedInstanceState.getString("NAME");
            id= savedInstanceState.getString("_ID");
        }
        hotelsstart();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("id", id);
        savedInstanceState.putString("name", name);
    }
    void hotelsstart(){


        ListView listHotels = getListView();

        try {
            SQLiteOpenHelper HotelNames = new HotelNamesdbhelper(this);
            db = HotelNames.getReadableDatabase();
            cursor = db.query("HOTELS", new String[]{"_id", "NAME"},
                    null, null, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, //This is the same layout we used with the array adapter. It displays a single value for each row in the list view.
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listHotels.setAdapter(listAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable" , Toast.LENGTH_SHORT);
            toast.show();

        }


    }
@Override
public void onRestart() {
    super.onRestart();
    hotelsstart();
}

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

}
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    } */

