package com.fission.gridview;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewMainActivity extends Activity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_main);
        final GridView gridView=(GridView)findViewById(R.id.gridview);
        imageView=(ImageView)findViewById(R.id.sameimage);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent i= new Intent(getApplicationContext(),FullImageActivity.class);
                i.putExtra("id",position);
                startActivity(i);*/

                ImageAdapter imageAdapter=new ImageAdapter(getApplicationContext());
                imageView.setImageResource(imageAdapter.mImages[position]);
                imageView.setVisibility(View.VISIBLE);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setVisibility(View.GONE);
            }
        });


    }
}
