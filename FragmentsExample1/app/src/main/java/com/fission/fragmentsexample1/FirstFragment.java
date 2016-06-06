package com.fission.fragmentsexample1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by anilkumar on 5/6/16.
 */
public class FirstFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfragment, container, false);
        Button nextButton = (Button) view.findViewById(R.id.button_first);
        nextButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
