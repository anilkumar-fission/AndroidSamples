package com.fission.galleryexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by anilkumar on 25/5/16.
 */
public class GalleryImageAdapter extends BaseAdapter {
    private Context mContext;
    public Integer[] mImages={
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.ten
    };
    public GalleryImageAdapter(Context context){
        mContext=context;
    }
    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(mContext);
        imageView.setImageResource(mImages[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(200,200));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}
