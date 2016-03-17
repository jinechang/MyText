package com.example.jine.mytext;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.firebase.client.Firebase;

/**
 * Created by jine on 16-03-16.
 */
public class ListDatabaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_items);

        //look up ListView
        ListView itemView = (ListView) findViewById(R.id.listOfItems);

        //connect to Firebase
        Firebase.setAndroidContext(this);
        final Firebase rootRef = new Firebase("https://garbagehunters.firebaseio.com/items");

        ItemListViewAdapter itemListViewAdapter = new ItemListViewAdapter(this,Items.class,android.R.layout.simple_list_item_1,rootRef);
        itemView.setAdapter(itemListViewAdapter);




        //when the activity is destroyed, we need to call cleanup() on ListAdapt
        //so that it can stop listening for changes in the Firebase database
        //@Override



/*
        //pass an instance of Items class to setValue()
        //the client will read the values from anitem and write them into the properties of the new child in the database
        //Firebase rootRef = new Firebase("https://garbagehunters.firebaseio.com/items");
        Date date = new Date();
        Items anitem = new Items("TV 1","Appy",100,3,"AVAILABLE",date);
        rootRef.push().setValue(anitem);

        //we can read a Item straight from a DataSnapshot in our event handlers
        rootRef.limitToLast(5).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    //whenever those change we get objects from DataSnapshot with getValue(Items.class)
                    //The Firebase Android client will then read the properties and map them to the fields of class
                    Items itm = itemSnapshot.getValue(Items.class);
                    Log.i("Item", itm.getItemname() + " posted by " +itm.getPostBy()+" on "+ itm.getPostDate()
                            + " with the price: " + itm.getPostPrice());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("Item", "The read failed: " + firebaseError.getMessage());
            }
        });


        protected void onDestroy(){
            super.onDestroy();
            mAdapter.cleanup();
        }
*/
}


}
