package com.example.learn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentContainer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContainer extends Fragment {
    private int fragmentIndex;
    private String logTag;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentContainer() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public FragmentContainer(int index){
        this.fragmentIndex=index;
        this.logTag="FragmentContainer"+index;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentContainer.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContainer newInstance(String param1, String param2) {
        FragmentContainer fragment = new FragmentContainer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(logTag,"onCreate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_container,null);
        TextView tvContent = (TextView)rootView.findViewById(R.id.textView);
        switch(fragmentIndex){
            case(1):
                tvContent.setText("1!我将以红色形态出击");
                tvContent.setBackgroundResource(android.R.color.holo_red_light);
                break;
            case(2):
                tvContent.setText("2!我将以橙色色形态出击");
                tvContent.setBackgroundResource(android.R.color.holo_orange_light);
                break;
            case(3):
                tvContent.setText("3!我将以蓝色形态出击");
                tvContent.setBackgroundResource(android.R.color.holo_blue_light);
                break;
        }
        Log.i(logTag,"onCreateView");
        return rootView;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.i(logTag,"onAttach");
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