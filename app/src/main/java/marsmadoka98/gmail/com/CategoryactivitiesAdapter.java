package marsmadoka98.gmail.com;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryactivitiesAdapter extends RecyclerView.Adapter<CategoryactivitiesAdapter.ViewHolder> {
    private Context mContetx;
    private Cursor mCursor;
    private Listener listener;

    public CategoryactivitiesAdapter(Context context, Cursor cursor) { //cursor is fetches our data from db  to display them
        mContetx=context;
        mCursor=cursor;
    }
    public static interface Listener {
        public void cateItemClick(int position);

    }
    public void setListener(Listener listener){ //Activity’s will use this method to register as a listener.
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v) { //Each ViewHolder will display a CardView.
            super(v);
            cardView = v; }
    }

    //create the adapter,s viewHolder
    @Override
    public CategoryactivitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_items,parent,false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CategoryactivitiesAdapter.ViewHolder holder,final int position) {
        if(!mCursor.moveToPosition(position)){
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.CategoryEntry.COLUMN_NAME));
        int drawable =mCursor.getInt(mCursor.getColumnIndex(StarbuzzConstants.CategoryEntry.COLUMN_IMAGE));

        CardView cardview=holder.cardView;

        ImageView photo =cardview.findViewById(R.id.info_image);
        photo.setImageResource(drawable );

        TextView textView=cardview.findViewById(R.id.info_text);
        textView.setText(name);

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    listener.cateItemClick(position);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}
