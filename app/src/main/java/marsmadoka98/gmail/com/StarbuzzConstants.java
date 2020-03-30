package marsmadoka98.gmail.com;

import android.provider.BaseColumns;

public class StarbuzzConstants {
    private StarbuzzConstants(){

    }
    public static final class StarbuzzEntry implements BaseColumns {
        public static final String TABLE_NAME="HOTELS";
        public static final String COLUMN_NAME="name";
        public static final  String COLUMN_DESCRIPTION="description";

    }
}
