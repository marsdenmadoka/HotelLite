package marsmadoka98.gmail.com;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db; //We’re adding these as private variables so we can close the database and the cursor in our onDestroy method.
    //private Cursor cursor;
    private recycleAdapter mAdapter; //creating a member variable for our adapter class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         StarbuzzDatabaseHelper dbHelper = new StarbuzzDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        RecyclerView recyclerView =findViewById(R.id.myrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter= new recycleAdapter(this,getAllItems());
        recyclerView.setAdapter(mAdapter);

        /**
        ListView listHotels = getListView();
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();
            cursor = db.query("HOTELS", new String[]{"_id","NAME"},
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


        } */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem SearchItem=menu.findItem(R.id.app_bar_search);

        return super.onCreateOptionsMenu(menu);
    }
    //fetching fromdb
    private  Cursor getAllItems(){
        return db.query(
                StarbuzzConstants.StarbuzzEntry.TABLE_NAME,
                null,null,null,null,null,null
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getAllItems().close();
        db.close();
    }


}

