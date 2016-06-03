package com.fission.fragment_2;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by anilkumar on 3/6/16.
 */
public class MenuFragment extends ListFragment {
    String[] AndroidOs=new String[]{"Cupcake","Donut","Eclair","Froyo","Gingerbread","HoneyComb","Ice Cream SandWich","Jelly Bean","Kit Kat","LaliPOP","MarshMallow"};
    String[] AndroidVersion=new String[]{"1.5","1.6","2.0-2.1","2.2","2.3","3.0-3.2","4.0","4.1-4.3","4.4","5.0","6.0"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_fragment,container,false);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,AndroidOs);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextFragment textFragment=(TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        textFragment.change(AndroidOs[position],"Version:"+AndroidVersion[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}
