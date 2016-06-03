package com.fission.fragment_2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by anilkumar on 3/6/16.
 */
public class TextFragment extends Fragment {
    TextView mTvAndroidOs,mTvAndroidVersion;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.text_fragment,container,false);
        mTvAndroidOs=(TextView)view.findViewById(R.id.AndroidOs);
        mTvAndroidVersion=(TextView)view.findViewById(R.id.AndroidVersion);
        return view;
    }
    public void change(String txt,String txt1){
        mTvAndroidOs.setText(txt);
        mTvAndroidVersion.setText(txt1);
    }
}
