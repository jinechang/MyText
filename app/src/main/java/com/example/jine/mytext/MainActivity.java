package com.example.jine.mytext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void postdata(View view){
        Intent intent = new Intent(MainActivity.this, PostItemActivity.class);
        startActivity(intent);
        finish();
    }

    public void showdata(View view){
        Intent intent = new Intent(MainActivity.this, ListDatabaseActivity.class);
        startActivity(intent);
        finish();
    }


}
