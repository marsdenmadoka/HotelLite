
/**package marsmadoka98.gmail.com;

import android.database.Cursor;
import android.widget.Filter;

public class CustomFilter {
    //private recycleAdapter mAdapter;
    private static Cursor mCursor;
    private String name;
    private String descrption;
    public CustomFilter(String name,String descrption) {
        this.name = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
        this.descrption=mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_DESCRIPTION));
    }

    public static final CustomFilter[] myitems={
      // new CustomFilter(mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME),mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_DESCRIPTION)))
    };
    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption =mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
    }

    //mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
   public void setName(String name) {
        this.name = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
    }


    public String getName() {
        return name;
    }


}
**/