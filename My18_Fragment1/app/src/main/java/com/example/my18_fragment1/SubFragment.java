package com.example.my18_fragment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.my18_fragment1.MainActivity;
import com.example.my18_fragment1.R;

public class SubFragment extends Fragment {

    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_sub,
                container, false);


        rootView.findViewById(R.id.btnSub).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();


                activity.onFragmentChange(2);
            }
        });

        return rootView;
    }
}
