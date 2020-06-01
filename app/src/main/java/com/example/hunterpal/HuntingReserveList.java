package com.example.hunterpal;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class HuntingReserveList extends Fragment {

    ListView listView;
    SearchView searchView;
    ArrayAdapter<String> adapter;

    interface Listener{
        void itemClicked(long id);
    }

    private Listener listener;

    public HuntingReserveList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] names = new String[HuntingReserve.reserves.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = HuntingReserve.reserves[i].getReserveName();
        }

        View view = inflater.inflate(R.layout.fragment_hunting_reserve_list,container,false);
        listView = (ListView) view.findViewById(R.id.simpleReserveList);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listener != null){
                    listener.itemClicked(id);

                }
            }
        });

       return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.listener = (Listener) context;
    }
}
