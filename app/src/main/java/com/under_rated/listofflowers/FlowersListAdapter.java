package com.under_rated.listofflowers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.under_rated.listofflowers.Model.Flower;

import java.util.List;

/**
 * Created by dave on 8/3/15.
 */
public class FlowersListAdapter extends ArrayAdapter<Flower> {

    String url = "http://services.hanselandpetal.com/photos/";
    private List<Flower> flowerList;

    public FlowersListAdapter(Context context, int resource, List<Flower> objects) {
        super(context, resource, objects);
        this.flowerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        Flower flower = flowerList.get(position);
        ViewHolder viewHolder;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            viewHolder = new ViewHolder();
            rowView = inflater.inflate(R.layout.listview_entry, parent, false);
            viewHolder.photo = (ImageView)rowView.findViewById(R.id.photo);
            viewHolder.name = (TextView)rowView.findViewById(R.id.name);
            viewHolder.instructions = (TextView)rowView.findViewById(R.id.instructions);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)rowView.getTag();
        }

        //load the image with picasso
        Picasso.with(getContext()).load(url + flower.getPhoto()).resize(200,200).into(viewHolder.photo);

        //set the text
        viewHolder.name.setText(flower.getName());
        viewHolder.instructions.setText(flower.getInstructions());

        return rowView;

    }

    public static class ViewHolder {
        public ImageView photo;
        public TextView name;
        public TextView instructions;
    }
}
