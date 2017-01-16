package com.androidanalysis.lifecyclesample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentB extends Fragment {

    private String className = "FragmentB";

    public FragmentB() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment FragmentA.
     */
    public static FragmentB newInstance() {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(className,  " : onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i(className,  " : onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i(className,  " : onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(className,  " : onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(className,  " : onDestroy");
    }
}
