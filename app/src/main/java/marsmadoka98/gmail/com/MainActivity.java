package marsmadoka98.gmail.com;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

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
                //Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                //intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO, position);
                //getActivity().startActivity(intent);
                //Toast.makeText(getApplicationContext(), "you clicked"+position, Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(MainActivity.this, Categoryofactivities.class);
                //intent.putExtra(Categoryofactivities.EXTRA_CATEGORY , position);
                //startActivity(intent);
                //if (mCursor.moveToPosition(position)) {
                  //  String name = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
                    //  name= String.valueOf(mCursor.getPosition());
                    //String description = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_DESCRIPTION));
                    // description =String.valueOf(mCursor.getPosition());

                    Intent intent = new Intent(MainActivity.this, Categoryofactivities.class);
                  intent.putExtra(Categoryofactivities.EXTRA_CATEGORY,position);
                //intent.putExtra("descript", description);
                    startActivity(intent);
                Toast.makeText(getApplicationContext(), "you clicked"+position, Toast.LENGTH_SHORT).show();

               // }

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
        MenuItem SearchItem=menu.findItem(R.id.app_bar_search);

        return super.onCreateOptionsMenu(menu);
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

