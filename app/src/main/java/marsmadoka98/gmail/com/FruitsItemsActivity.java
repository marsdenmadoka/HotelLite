package marsmadoka98.gmail.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class FruitsItemsActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private FruitsAdapter cAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_items);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //En able the Up icon so it can be used by the ActionBarDrawerToggle.
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        StarbuzzDatabaseHelper dbHelper = new StarbuzzDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        RecyclerView recyclerView =findViewById(R.id.fruitsrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cAdapter=new FruitsAdapter(this,getAllFruits());
        recyclerView.setAdapter(cAdapter);
        cAdapter.setListener(new FruitsAdapter.Listener(){


            @Override
            public void btnOrderClick(int position) {

            }

            @Override
            public void CardClick(int position) {

            }
        });

    }


    public Cursor getAllFruits(){

        return db.query(StarbuzzConstants.FruitsEntry.TABLE_NAME,
                null,null,null,null,null,null);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        getAllFruits().close();
        db.close();

    }
}
