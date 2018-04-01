package com.apps.rdjsmartapps.androidcrudapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemListAdapter adapter;
    public List<Item> mItemList;
    ListView listView1;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listView1);

        mItemList = new ArrayList<>();

        mItemList.add(new Item(1,R.drawable.avatar, "Avatar",4));
        mItemList.add(new Item(2,R.drawable.mi, "MI 6",2));
        mItemList.add(new Item(3,R.drawable.ironman, "Iron Man 3",5));
        mItemList.add(new Item(4,R.drawable.avengers, "Avengers-Infinity War",3));
        mItemList.add(new Item(5,R.drawable.captainamerica, "Captain America",4));
        mItemList.add(new Item(6,R.drawable.hulk, "Incredible Hulk",3));



       adapter = new ItemListAdapter(this, mItemList);
       listView1.setAdapter(adapter);

       // set on item click listener

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Clicked on Item: " + view.getTag(),Toast.LENGTH_LONG ).show();

                String id = view.getTag().toString();
                int itemId = Integer.valueOf(id);
                itemId = itemId - 1;
                Intent movieInfo = new Intent(MainActivity.this, MovieInfoActivity.class);
                movieInfo.putExtra("id", mItemList.get(itemId).getId());
                movieInfo.putExtra("imageId", mItemList.get(itemId).getImageId());
                movieInfo.putExtra("movie_name", mItemList.get(itemId).getMovieName());
                movieInfo.putExtra("rating", mItemList.get(itemId).getRating());
                startActivity(movieInfo);
            }
        });


        // ADD fab action button on click listener
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(addIntent);
            }
        });

    }
}
