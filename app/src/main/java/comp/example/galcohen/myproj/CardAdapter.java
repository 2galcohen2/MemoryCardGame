package comp.example.galcohen.myproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


/**
 * card class
 */

public class CardAdapter extends BaseAdapter {

    private final Context mContext;
    private final Card[] cards;

    public CardAdapter(Context context, Card[] cards) {
        this.mContext = context;
        this.cards = cards;
    }

    @Override
    public int getCount() {
        return cards.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Relate to the xml
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_card, null);
        }

        //Set the card image
        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        Card currCard = cards[position];

        if (currCard.IsCardClicked()) {
            imageView.setImageResource(R.drawable.back);
        }
        else
            imageView.setImageResource(currCard.GetImageResource());

        return convertView;
    }
}
