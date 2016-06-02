package com.fission.galleryexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;


public class MainActivity extends Activity {
    ImageView mSelectedImage;
    Gallery mGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGallery=(Gallery)findViewById(R.id.gallery);
        mSelectedImage=(ImageView)findViewById(R.id.image);
        final GalleryImageAdapter galleryImageAdapter=new GalleryImageAdapter(this);
        mGallery.setAdapter(galleryImageAdapter);
        mGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectedImage.setImageResource(galleryImageAdapter.mImages[position]);
            }
        });
    }

}
