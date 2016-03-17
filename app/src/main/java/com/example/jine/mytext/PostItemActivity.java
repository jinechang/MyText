package com.example.jine.mytext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.firebase.client.Firebase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jine on 16-03-16.
 */
public class PostItemActivity extends ActionBarActivity {

    EditText inputcategory;
    EditText inputsubcategory;
    EditText inputitemname;
    EditText inputseller;
    EditText inputyears;
    EditText inputpostprice;
    EditText inputstatus;
    EditText showmessage;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_post_item);
        final Firebase rootRef = new Firebase("https://garbagehunters.firebaseio.com/items");

        initPost();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_post_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //    if (id == R.id.action_settings) {
        //        return true;
        //    }

        return super.onOptionsItemSelected(item);
    }

    public void initPost(){
        inputcategory = (EditText) findViewById(R.id.categoryEditText);
        inputsubcategory = (EditText) findViewById(R.id.subcategoryEditText);
        inputitemname = (EditText) findViewById(R.id.postitemEditText);
        inputseller = (EditText) findViewById(R.id.sellerEditText);
        inputyears = (EditText) findViewById(R.id.yearsEditText);
        inputpostprice = (EditText) findViewById(R.id.postpriceEditText);
        inputstatus = (EditText) findViewById(R.id.statusEditText);
        showmessage = (EditText) findViewById(R.id.note);
        date = new Date();

        RadioGroup group = (RadioGroup)findViewById(R.id.group_cate);
        final RadioButton cRadio_appliance = (RadioButton)findViewById(R.id.cate_appliance);
        final RadioButton cRadio_book = (RadioButton)findViewById(R.id.cate_book);
        final RadioButton cRadio_furniture = (RadioButton)findViewById(R.id.cate_furniture);
        final RadioButton cRadio_kitchenware = (RadioButton)findViewById(R.id.cate_kitchenware);
        final RadioButton cRadio_sports = (RadioButton)findViewById(R.id.cate_sports);

        RadioGroup subgroup = (RadioGroup)findViewById(R.id.group_subcate);
        final RadioButton subRadio1 =(RadioButton)findViewById(R.id.subcate1);
        final RadioButton subRadio2 =(RadioButton)findViewById(R.id.subcate2);
        final RadioButton subRadio3 =(RadioButton)findViewById(R.id.subcate3);
        final RadioButton subRadio4 =(RadioButton)findViewById(R.id.subcate4);
        final RadioButton subRadio5 =(RadioButton)findViewById(R.id.subcate5);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId==cRadio_appliance.getId()){
                    inputcategory.setText(cRadio_appliance.getText());
                    subRadio1.setText("TV");
                    subRadio2.setText("Washer");
                    subRadio3.setText("Cleaner");
                    subRadio4.setText("Hair drier");
                    subRadio5.setText("Computer");
                    inputsubcategory.setText("TV");
                }
                else if (checkedId==cRadio_book.getId()){
                    inputcategory.setText(cRadio_book.getText());
                    subRadio1.setText("Technical Book");
                    subRadio2.setText("Novel");
                    subRadio3.setText("Fairy tale book");
                    subRadio4.setText("Textbook");
                    subRadio5.setText("Cook Book");
                    inputsubcategory.setText("Technical Book");
                }else if (checkedId==cRadio_furniture.getId()){
                    inputcategory.setText(cRadio_furniture.getText());
                    subRadio1.setText("Table");
                    subRadio2.setText("Sofa");
                    subRadio3.setText("Bed");
                    subRadio4.setText("Chair");
                    subRadio5.setText("Drawer");
                    inputsubcategory.setText("Table");

                }else if (checkedId==cRadio_kitchenware.getId()){
                    inputcategory.setText(cRadio_kitchenware.getText());
                    subRadio1.setText("Cookerware");
                    subRadio2.setText("Knife and fork");
                    subRadio3.setText("Dishware");
                    subRadio4.setText("Ovenware");
                    subRadio5.setText("Tableware");
                    inputsubcategory.setText("Cookerware");
                }else if (checkedId==cRadio_sports.getId()){
                    inputcategory.setText(cRadio_sports.getText());
                    subRadio1.setText("Bike");
                    subRadio2.setText("Skates");
                    subRadio3.setText("Safety helmet");
                    subRadio4.setText("Racket");
                    subRadio5.setText("Balls");
                    inputsubcategory.setText("Bike");
                }

            }
        });

        subgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup subgroup, int checkedId) {

                if (checkedId==subRadio1.getId()){
                    inputsubcategory.setText(subRadio1.getText());
                }
                else if (checkedId==subRadio2.getId()){
                    inputsubcategory.setText(subRadio2.getText());
                }else if (checkedId==subRadio3.getId()){
                    inputsubcategory.setText(subRadio3.getText());
                }else if (checkedId==subRadio4.getId()){
                    inputsubcategory.setText(subRadio4.getText());
                }else if (checkedId==subRadio5.getId()){
                    inputsubcategory.setText(subRadio5.getText());
                }

            }
        });
    }

    public void addItem(View view) {
        final Firebase rootRef = new Firebase("https://garbagehunters.firebaseio.com/items");
        ItemListViewAdapter itemListViewAdapter = new ItemListViewAdapter(this, Items.class, android.R.layout.two_line_list_item, rootRef);

        String category;
        String subcategory;
        String itemname;
        String seller;
        int years;
        int postprice;
        String status;
        Date postdate;

        category = inputcategory.getText().toString().trim();
        subcategory = inputsubcategory.getText().toString().trim();
        itemname = inputitemname.getText().toString().trim();
        seller = inputseller.getText().toString().trim();
        years = Integer.valueOf(inputyears.getText().toString().trim());
        postprice = Integer.valueOf(inputpostprice.getText().toString());
        status = "AVAILABLE";
        postdate = date;
        itemname = itemname+" posted by " + seller;

        if (!category.isEmpty() && !subcategory.isEmpty() && !itemname.isEmpty() && !seller.isEmpty()) {

            Map<String, Object> item = new HashMap<String, Object>();
            HashMap<String, String> itemMap = new HashMap<String, String>();

            itemMap.put("PosyBy", seller);
            itemMap.put("PostDate", postdate.toString());
            itemMap.put("PostPrice", String.valueOf(postprice));
            itemMap.put("Status", status);
            itemMap.put("YearsOfUse", String.valueOf(years));
            item.put(itemname, itemMap);


            rootRef.child(category).child(subcategory).updateChildren(item);
        }
        inputitemname.setText("");
        inputseller.setText("");
        inputpostprice.setText("");
        inputyears.setText("");
        showmessage.setText("This item is posted successfully.");

    }

    public void returnmain(View view){
        //Intent intent = new Intent(MainActivity.this, ListDatabaseActivity.class);
        Intent intent = new Intent(PostItemActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
