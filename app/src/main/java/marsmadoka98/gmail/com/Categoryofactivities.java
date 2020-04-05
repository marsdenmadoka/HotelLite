package marsmadoka98.gmail.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Categoryofactivities extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "cateNo";
    //  public static final String EXTRA_CATEGORY = "categoryNo";
    private SQLiteDatabase db;
    private CategoryactivitiesAdapter cAdapter;//this variable is want links us to our adpater

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryofactivities);

        StarbuzzDatabaseHelper dbHelper = new StarbuzzDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        RecyclerView recyclerView =findViewById(R.id.Caterecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cAdapter=new CategoryactivitiesAdapter(this,getCateItems());
        recyclerView.setAdapter(cAdapter);

        cAdapter.setListener(new CategoryactivitiesAdapter.Listener(){


            @Override
            public void cateItemClick(int position) {

            }
        });

    }

    private Cursor getCateItems(){

        return db.query(
                StarbuzzConstants.CategoryEntry.TABLE_NAME,
                null,null,null,null,null,null
        );
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        getCateItems().close();
        db.close();

    }

}
