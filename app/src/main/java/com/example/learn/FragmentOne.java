package com.example.learn;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {
    private  String logTag="FragmentOne";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.i(logTag,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(logTag,"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        Log.i(logTag,"onCreateView");
        return inflater.inflate(R.layout.fragment_one,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Log.i(logTag,"onActivityCreated");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(logTag,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(logTag,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(logTag,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(logTag,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(logTag,"onDestroyView");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(logTag,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(logTag,"onDetach");
    }

}