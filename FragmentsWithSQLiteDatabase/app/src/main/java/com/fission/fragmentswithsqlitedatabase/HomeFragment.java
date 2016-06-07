package com.fission.fragmentswithsqlitedatabase;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by anilkumar on 6/6/16.
 */
public class HomeFragment extends Fragment {
   // boolean Is_login;
    Button mBtnHome;
    ImageView imageView;
    //private boolean flag;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      final   View view1=inflater.inflate(R.layout.homefragment,container,false);
        setHasOptionsMenu(true);

        sharedPreferences=getActivity().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putBoolean("is_user_login",true);
        editor.apply();

        mBtnHome=(Button)view1.findViewById(R.id.Home);
        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final GridView gridView=(GridView)view1.findViewById(R.id.gridview);
                imageView=(ImageView)view1.findViewById(R.id.sameimage);
                gridView.setAdapter(new ImageAdapter(getActivity()));
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ImageAdapter imageAdapter=new ImageAdapter(getActivity());
                        imageView.setImageResource(imageAdapter.mImages[position]);
                        imageView.setVisibility(View.VISIBLE);

                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        imageView.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
        return view1;
    }
   @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                final AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Logout");
                alertDialogBuilder.setMessage("Do You Want to Logout");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sharedPreferences=getActivity().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                        editor=sharedPreferences.edit();
                        editor.putBoolean("is_user_login",false);
                        editor.apply();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        LoginFragment loginFragment = new LoginFragment();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.your_placeholder, loginFragment);
                        transaction.commit();//}

                       // dialog.dismiss();
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                Toast.makeText(getActivity(),"you are in Home page",Toast.LENGTH_LONG).show();
                return true;

            default:
            return super.onOptionsItemSelected(item);
        }

    }
}
