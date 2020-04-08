package marsmadoka98.gmail.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FoodItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //En able the Up icon so it can be used by the ActionBarDrawerToggle.
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }
}
