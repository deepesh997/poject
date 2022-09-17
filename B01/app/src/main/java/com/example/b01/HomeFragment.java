package com.example.b01;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {

    public ImageView ravi, kharib, jayat;
    @Override

        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_home, container, false);

        ravi=view.findViewById(R.id.ravi);
        ravi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ravi.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "loading", Toast.LENGTH_SHORT).show();
            }
        });
        kharib=view.findViewById(R.id.kharif);
        kharib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), kharib.class);
                startActivity(intent);
                Toast.makeText(getContext(), "loading", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}