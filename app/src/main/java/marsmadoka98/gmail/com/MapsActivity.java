package marsmadoka98.gmail.com;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String EXTRA_MAPS = "MapsNo";
    private GoogleMap mMap;
     private  LocationManager locationManager;
     private   LocationListener locationListener;
     private LatLng latLng;
     final int position = 0;
     private  long MIN_TIME = 1000;
     private  long MIN_DIST = 5;
     private SQLiteDatabase db;
     Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        StarbuzzDatabaseHelper dbHelper = new StarbuzzDatabaseHelper(this);



    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        int  MapsNo= (Integer) getIntent().getExtras().get(EXTRA_MAPS);
//        Intent intent=getIntent();
  //      String mNames=intent.getStringExtra("mNAME");
    //    String desc=intent.getStringExtra("iDESC");
        mMap = googleMap;
         double latitude=0;
         double longitude=0;
        // Add a marker in Sydney and move the camera
        //latLng = new LatLng(latitude, longitude);
        StarbuzzDatabaseHelper dbHelper = new StarbuzzDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        cursor = db.query(StarbuzzConstants.StarbuzzEntry.TABLE_NAME,
                new String[] {StarbuzzConstants.StarbuzzEntry.COLUMN_LATITUDE,StarbuzzConstants.StarbuzzEntry.COLUMN_LONGITUDE},
                "_ID = ?",new String[]{Integer.toString(MapsNo)},null,null,null,null);
        if(cursor.moveToPosition(position)){
            latitude =  cursor.getDouble(cursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_LATITUDE));
            longitude= cursor.getDouble(cursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_LONGITUDE));
        }

        latLng=new LatLng(latitude, longitude);
        Geocoder geocoder;
        List<Address> addresses;
        geocoder=new Geocoder(this, Locale.getDefault());

        String address=null;
        String city=null;
        String state=null;
        String country=null;
        String postalCode=null;
        String knownName=null;

        try {

            addresses=geocoder.getFromLocation(latitude, longitude, 1);
            if(addresses != null && addresses.size() > 0) {
                address = addresses.get(0).getAddressLine(0);
                city = addresses.get(0).getLocality();
                state = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
                postalCode = addresses.get(0).getPostalCode();
                knownName = addresses.get(0).getFeatureName();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in :"+address+city+state+country+postalCode+knownName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));



        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title("MY position"));

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }

            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //    if (checkLocationPermission()) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DIST, locationListener);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DIST, locationListener);
            }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

}

/**
    public boolean checkLocationPermission() {
        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 0: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
*/






