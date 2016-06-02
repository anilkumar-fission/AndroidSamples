package com.fission.gridviewactivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by anilkumar on 23/5/16.
 */
public class ImageAdapterActivity extends BaseAdapter {
    private Context mContext;
    public ImageAdapterActivity(Context c){
        mContext=c;
    }
    @Override
    public int getCount() {
        return mImages.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView==null){
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(70,70));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else{
            imageView=(ImageView)convertView;
        }
        imageView.setImageResource(mImages[position]);
        return imageView;
    }
    public Integer[] mImages={
        R.drawable.one,
        R.drawable.two ,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.ten,

    };
}
