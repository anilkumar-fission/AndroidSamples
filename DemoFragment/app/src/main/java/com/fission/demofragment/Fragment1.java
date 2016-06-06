package com.fission.demofragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by anilkumar on 4/6/16.
 */
public class Fragment1 extends Fragment {
    Button add;
    Fragment2 fragment_two;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1, container,false);
        add=(Button) view.findViewById(R.id.button);
        fragment_two =new Fragment2();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction t=getActivity().getFragmentManager().beginTransaction();
                t.remove( new Fragment1());

                t.replace(R.id.Fragment1, fragment_two);
                t.addToBackStack(null);
                t.commit();
            }
        });
        return view;
    }
}
