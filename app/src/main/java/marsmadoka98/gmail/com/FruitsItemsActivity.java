package marsmadoka98.gmail.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.internal.service.Common;
import com.nex3z.notificationbadge.NotificationBadge;

public class FruitsItemsActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private FruitsAdapter cAdapter;
    private Context mContetx;
    NotificationBadge badge;
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
                int clickcount =0;
               clickcount ++;
                    //first time clicked to do this
                    badge.setVisibility(View.VISIBLE);
                    badge.setText(String.valueOf(clickcount));




 /*
               // Toast.makeText(getApplicationContext(),"item "+position+" added to cart",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder=new AlertDialog.Builder(FruitsItemsActivity.this);
               // builder.setTitle("exit");
              //  builder.setMessage("item added to cart");
               // View itemView= LayoutInflater.from(mContetx)
               builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                   public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    }
                });
                builder.setNegativeButton("item added to cart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });
                builder.show();
**//**
                final AlertDialog.Builder myAlert=new AlertDialog.Builder(FruitsItemsActivity.this);
                myAlert.setMessage("are you sure you want to add item to cart?");

                myAlert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int count;
                        count=i;
                        //finish(); //say what should happen when one clicks yes
                        //Intent intent = new Intent(FruitsItemsActivity.this, Categoryofactivities.class);
                        //intent.putExtra(Categoryofactivities.EXTRA_CATEGORY,position);
                       // startActivity(intent);
                       // if(badge == null) return;
                        dialogInterface.count
                        badge.setVisibility(View.VISIBLE);
                        badge.setText(String.valueOf(position));

                    }
                });
                myAlert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });
                myAlert.setCancelable(false);
                myAlert.show();
                */

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fruits_ordercart, menu);
View view = menu.findItem(R.id.cartmenu).getActionView();
 badge=(NotificationBadge)view.findViewById(R.id.badge);
 // updateCartCount();
        return true;
    }

    /**private void updateCartCount() {
        if(badge == null) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(.countCartItems()==0)
                    badge.setVisibility(View.INVISIBLE);
                else{

                    badge.setVisibility(View.VISIBLE);
                    badge.setText(String.valueOf(comm));
                }
            }
        });
    }
**/

    @Override
    public void onDestroy(){
        super.onDestroy();
        getAllFruits().close();
        db.close();

    }
}
