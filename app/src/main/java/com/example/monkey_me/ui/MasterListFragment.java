package com.example.monkey_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.monkey_me.R;
import com.example.monkey_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {
    MasterListAdapter bodyPartsListAdapter;
    OnImageClickListener mCallback;

    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            mCallback = (OnImageClickListener) context;
        }catch (ClassCastException cce){
            throw new ClassCastException(context.toString() + " must implement OnImageClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        bodyPartsListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        GridView masterGridView = (GridView) rootView.findViewById(R.id.master_grid_view);
        masterGridView.setAdapter(bodyPartsListAdapter);

        masterGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onImageSelected(i);
            }
        });

        return rootView;
    }
}
