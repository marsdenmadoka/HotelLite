package marsmadoka98.gmail.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
/**
 * THIS ACTIVITY SHOULD DISPLAY THE ITEMS OF FOODS EG PILAU,UGALI,CHOMA,ETC...
 * */
public class FoodCategory extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
    }
}
