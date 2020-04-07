package marsmadoka98.gmail.com;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.data.DataHolder;

import java.util.Map;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.ViewHolder> {

  //  private String[] captions;
    //private String [] distdescription;
    //private int[] imageIds;
    private Context mContetx;
    private Cursor mCursor;
    private Listener listener;
    private recycleAdapter mAdapter;

    public recycleAdapter(Context context, Cursor cursor) { //cursor is fetches our data from db  to display them
       mContetx=context;
       mCursor=cursor;
    }
    public static interface Listener {
        public void onitemClick(int position);
        public void onbtnClick( int position);
    }
    public void setListener(Listener listener){ //Activity’s will use this method to register as a listener.
        this.listener = listener;
    }

    //Define the adapter’s ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v) { //Each ViewHolder will display a CardView.
            super(v);
            cardView = v;
        }

    }

    //create the adapter,s viewHolder
    @Override
    public recycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_images,parent,false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CardView cardview = holder.cardView;
        if (mCursor.moveToPosition(position)) {

            String name = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
            String description = mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_DESCRIPTION));
            // ImageView imageView=cardview.findViewById(R.id.image_view);
            //imageView.setImageDrawable(String.valueOf(drawable));

            TextView textView1 = cardview.findViewById(R.id.text_view1);
            textView1.setText(name);
            TextView textView2 = cardview.findViewById(R.id.text_view2);
            textView2.setText(description);
        }
        Button btn =cardview.findViewById(R.id.button1);

       cardview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(listener !=null) {
                   //int position = mCursor.getPosition();
                   //if(position != RecyclerView.NO_POSITION){
                       listener.onitemClick(position);


                   //}
               }

           }
       });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    listener.onbtnClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount ();
    }
    /**
    public void swapCursor(Cursor newCursor){
     if(mCursor != null){
         mCursor.close();
     }
     mCursor = newCursor;
     if(newCursor != null){
         notifyDataSetChanged();
     }

    }*/
}
