
/**package marsmadoka98.gmail.com;

import android.database.Cursor;
import android.widget.Filter;

public class CustomFilter extends Filter {
    private recycleAdapter mAdapter;
    private Cursor mCursor;
    public CustomFilter(recycleAdapter mAdapter, Cursor mCursor) {
        this.mAdapter = mAdapter;
        this.mCursor = mCursor;
    }

    @Override
    protected FilterResults performFiltering(CharSequence consraint) {
        FilterResults results = new FilterResults();
        if(consraint != null && consraint.length()>0){
            consraint=consraint.toString().toUpperCase();
            Cursor filterModels;
                for (int i=0; i < mCursor.getCount(); i++){
                    //String name = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME).);
                   // if(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
                 //  if(mCursor.getColumnIndex(S))
                }
            }


        return null;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

    }
}
**/