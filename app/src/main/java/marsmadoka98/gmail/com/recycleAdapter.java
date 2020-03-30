package marsmadoka98.gmail.com;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.ViewHolder> {

  //  private String[] captions;
    //private String [] distdescription;
    //private int[] imageIds;
    private Context mContetx;
    private Cursor mCursor;
    private Listener listener;


    public recycleAdapter(Context context, Cursor cursor) { //cursor is fetches our data from db  to display them
       mContetx=context;
       mCursor=cursor;
    }
    public static interface Listener {
        public void onClick(int position);
    }
    public void setListener(Listener listener){ //Activity’s will use this method to register as a listener.
        this.listener = listener;
    }

    //Define the adapter’s ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v) { //Each ViewHolder will display a CardView.
            super(v);
            cardView = v; }
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
        if(!mCursor.moveToPosition(position)){
            return;
        }
        String name=mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_NAME));
         String description=mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_DESCRIPTION));
         //int drawable=mCursor.getInt(mCursor.getColumnIndex(StarbuzzConstants.StarbuzzEntry.COLUMN_DRAWABLE));

        CardView cardview=holder.cardView;

       // ImageView imageView=cardview.findViewById(R.id.image_view);
        //imageView.setImageDrawable(String.valueOf(drawable));

        TextView textView1=cardview.findViewById(R.id.text_view1);
        textView1.setText(name);
        TextView textView2=cardview.findViewById(R.id.text_view2);
        textView2.setText(description);                              //dislay to show location HELP! HELP! HELP!

        //Button btn =cardview.findViewById(R.id.button1);
        //help! when the button is clicked it should display the location

       cardview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(listener !=null){
                   listener.onClick(position);
               }

           }
       });

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    //regular updating db
    public void swapCursor(Cursor newCursor){
     if(mCursor != null){
         mCursor.close();
     }
     mCursor = newCursor;
     if(newCursor != null){
         notifyDataSetChanged();
     }

    }
}
