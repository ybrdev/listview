package com.listview.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import com.listview.listview.imageloader.ImageLoader;

/**
 * Created by user on 022, 22 Feb 2015.
 */
public class ListCustomAdapter extends BaseAdapter {
    ArrayList<HashMap<String, String>> items;
    Context context;
    ImageLoader imgLoader;

    public ListCustomAdapter(Context context, ArrayList<HashMap<String, String>> clubs) {
        imgLoader = new ImageLoader(context);
        items = clubs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public HashMap<String, String> getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.listview_item, null);

        TextView textHeader = (TextView) v.findViewById(R.id.listTextHeader);
        TextView textDetail = (TextView) v.findViewById(R.id.listTextDetail);
        ImageView imgLogo = (ImageView) v.findViewById(R.id.listImage);

        textHeader.setText(getItem(position).get("name"));
        textDetail.setText(getItem(position).get("stadium"));
        imgLoader.DisplayImage(items.get(position).get("logo"), imgLogo);

        return v;
    }


}
