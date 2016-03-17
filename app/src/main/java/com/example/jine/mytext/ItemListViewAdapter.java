package com.example.jine.mytext;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;

/**
 * Created by jine on 16-03-16.
 * create a Items List adapter to map from Firebase to Android
 */
public class ItemListViewAdapter extends FirebaseListAdapter<Items> {

    public ItemListViewAdapter(Activity activity, Class<Items> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
    }


    //view is an instance of two_line_list_item
    //map the field from items to the correct TextView controls from the view
    @Override
     protected void populateView(View view, Items items, int position) {
        Items rowItem = getItem(position);
        ((TextView) view.findViewById(android.R.id.text1)).setText(rowItem.getItemname());
        ((TextView) view.findViewById(android.R.id.text2)).setText(rowItem.getPostBy());
    }
}