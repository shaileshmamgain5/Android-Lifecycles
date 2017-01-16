package com.androidanalysis.lifecyclesample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentA extends Fragment implements View.OnClickListener{

    private String className = "FragmentA";
    OnNewFragRequested onNewFragRequested;

    public FragmentA() {
        // Required empty public constructor
    }

    public FragmentA(OnNewFragRequested onNewFragRequested) {
        this.onNewFragRequested = onNewFragRequested;
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment FragmentA.
     */
    public static FragmentA newInstance() {
        FragmentA fragment = new FragmentA();
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
        return inflater.inflate(R.layout.fragment_a, container, false);
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

    Button a,b,c;
    @Override
    public void onStart() {
        super.onStart();
        Log.i(className,  " : onStart");
        a = (Button) getView().findViewById(R.id.addFrag);
        b = (Button) getView().findViewById(R.id.replaceFrag);
        c = (Button) getView().findViewById(R.id.addFragStack);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        int  x = v.getId();
        switch (x)
        {
            case R.id.addFrag:
                onNewFragRequested.onFragmentRequested(false, false);
                break;
            case R.id.addFragStack:
                onNewFragRequested.onFragmentRequested(true, false);
                break;
            case R.id.replaceFrag:
                onNewFragRequested.onFragmentRequested(false,  false);
                break;
        }
    }

    /**
     * Interface to interact with the activity
     */
    public interface OnNewFragRequested {

        void onFragmentRequested(boolean addToBackStack, boolean replaceFragment);
    }
}
