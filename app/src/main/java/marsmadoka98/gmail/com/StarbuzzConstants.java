package marsmadoka98.gmail.com;

import android.provider.BaseColumns;

public class StarbuzzConstants {
    private StarbuzzConstants(){

    }
    public static final class StarbuzzEntry implements BaseColumns {
        public static final String TABLE_NAME="HOTELS";
        public  static final String COLUMN_ID="ID";
        public static final String COLUMN_NAME="NAME";
        public static final  String COLUMN_DESCRIPTION="DESCRIPTION";
        public static final String COLUMN_LATITUDE="LATITUDE";
        public static final String COLUMN_LONGITUDE="LONGITUDE";


    }

    public static final class CategoryEntry implements BaseColumns {
        public static final String TABLE_NAME="CATEGORYITEMS";
        public  static final String COLUMN_ID="ID";
        public static final String COLUMN_NAME="NAME";
        public static final  String COLUMN_IMAGE="IMAGE";

    }
public static class FruitsEntry implements BaseColumns{
        public static final String TABLE_NAME="FRUITS";
    public static final String COLUMN_NAME="FRUIITSNAME";
    public static final String COLUMN_PRICE="FRUITSPRICE";
    public static final String COLUMN_IMAGE="FRUITSIMAGE";
    public static final String COLUMN_DESCRPTION="FRUITSDESCRPTION";


}
public static class DrinksEntry implements BaseColumns{


}
public static class FoodsEntry implements BaseColumns{


}
}
