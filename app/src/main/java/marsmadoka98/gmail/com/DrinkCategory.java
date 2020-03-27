package marsmadoka98.gmail.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;

/**
 * THIS ACTIVITY SHOULD DISPLAY THE DRINK ITEMS EG WATER.SODA.WINE.BLACKWINE,REDWINE,ORANGE JUICE ETC...
 */
public class DrinkCategory extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
    }
}
