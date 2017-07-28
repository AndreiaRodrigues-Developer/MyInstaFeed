package com.andreiarodrigues.myinstafeed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.andreiarodrigues.myinstafeed.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter to be used on user's screen to show user's images
 */
public class UserMediaRecentAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<String> userImages;

    public UserMediaRecentAdapter(Context context, List<String> userImages) {
        this.mContext = context;
        this.userImages = userImages;
    }

    @Override
    public int getCount() {
        return userImages.size();
    }

    @Override
    public Object getItem(int position) {
        return userImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_user_pictures, null);
        }

        final ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_user_picture);
        Picasso.with(mContext).load(userImages.get(position)).into(imageView);

        return convertView;
    }

}
