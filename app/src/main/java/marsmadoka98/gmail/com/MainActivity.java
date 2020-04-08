package marsmadoka98.gmail.com;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db; //We’re adding these as private variables so we can close the database and the cursor in our onDestroy method.
    //private Cursor cursor;
    private recycleAdapter mAdapter; //creating a member variable for our adapter class
    private Cursor mCursor;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         StarbuzzDatabaseHelper dbHelper = new StarbuzzDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();

        RecyclerView recyclerView =findViewById(R.id.myrecyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new recycleAdapter(this,getAllItems());

        recyclerView.setAdapter(mAdapter);//mAdapter
        mAdapter.setListener(new recycleAdapter.Listener(){
            @Override
            public void onitemClick(int position) {
                    Intent intent = new Intent(MainActivity.this, Categoryofactivities.class);
                  intent.putExtra(Categoryofactivities.EXTRA_CATEGORY,position);
                    startActivity(intent);
                Toast.makeText(getApplicationContext(), "you clicked"+position, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onbtnClick(int position) {

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra(MapsActivity.EXTRA_MAPS , position);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "you clicked"+position, Toast.LENGTH_SHORT).show();



            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem Item=menu.findItem(R.id.app_bar_search);
        SearchView searchView =(SearchView) MenuItemCompat.getActionView(Item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }
    //fetching from_db
    private  Cursor getAllItems(){
        return db.query( StarbuzzConstants.StarbuzzEntry.TABLE_NAME,
         new String[] {StarbuzzConstants.StarbuzzEntry.COLUMN_NAME,StarbuzzConstants.StarbuzzEntry.COLUMN_DESCRIPTION}, StarbuzzConstants.StarbuzzEntry._ID,null,null,null,null,null
        );


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getAllItems().close();
        db.close();
    }


}

