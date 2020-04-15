package marsmadoka98.gmail.com;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.ViewHolder> {
    private Context mContetx;
    private Cursor mCursor;
   private Listener listener;

    public FruitsAdapter(Context context, Cursor cursor) {
        mContetx = context;
        mCursor = cursor;
    }

    public interface Listener {
        void btnOrderClick(int position);
        void CardClick(int position);
    }
    public void setListener(Listener listener){ //Activity’s will use this method to register as a listener.
        this.listener = listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v; }
    }
    @Override
    public FruitsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruits_items,parent,false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(FruitsAdapter.ViewHolder holder, final int position) {
        CardView cardview = holder.cardView;
        if (mCursor.moveToPosition(position)) {

         String name=mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.FruitsEntry.COLUMN_NAME));
         int price = mCursor.getInt(mCursor.getColumnIndex(StarbuzzConstants.FruitsEntry.COLUMN_PRICE));
         int drawable=mCursor.getInt(mCursor.getColumnIndex(StarbuzzConstants.FruitsEntry.COLUMN_IMAGE));
         String desc=mCursor.getString(mCursor.getColumnIndex(StarbuzzConstants.FruitsEntry.COLUMN_DESCRPTION));

            TextView textview1= cardview.findViewById(R.id.text_view1);
            textview1.setText(name);

            TextView textView2=cardview.findViewById(R.id.desc_view);
            textView2.setText(desc);

            TextView textView3=cardview.findViewById(R.id.price_view);
            textView3.setText(new StringBuilder().append("$").append(price).toString());

            ImageView photo = cardview.findViewById(R.id.image_view);
            photo.setImageResource(drawable);
        }

        Button btn =cardview.findViewById(R.id.btnOrder);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    listener.CardClick(position);
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    listener.btnOrderClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}
