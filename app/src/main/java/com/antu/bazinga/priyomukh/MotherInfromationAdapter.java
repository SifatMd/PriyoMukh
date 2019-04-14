package com.antu.bazinga.priyomukh;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Antu on 13-Nov-18.
 */
public class MotherInfromationAdapter extends ArrayAdapter<MotherInformation> {
    public MotherInfromationAdapter( Context context, int resource, List<MotherInformation> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater()
                    .inflate(R.layout.item_information,parent,false);
        }
        TextView headingTextView = (TextView) convertView.findViewById(R.id.headingTextView);
        TextView infoTextView = (TextView) convertView.findViewById(R.id.infoTextView);

        MotherInformation motherInformation= getItem(position);


        headingTextView.setVisibility(View.VISIBLE);
//        photoImageView.setVisibility(View.GONE);
        headingTextView.setText(motherInformation.getHeading());

        infoTextView.setText(motherInformation.getData());

        return convertView;
    }
}
