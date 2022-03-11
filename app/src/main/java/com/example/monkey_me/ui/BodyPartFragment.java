package com.example.monkey_me.ui;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.monkey_me.R;
import com.example.monkey_me.data.AndroidImageAssets;

import java.util.List;
import java.util.zip.Inflater;

public class BodyPartFragment extends Fragment {
    private static final String TAG = "BodyPartFragment";
    private List<Integer> mImageIDs;
    private int mImageIndex;


    public BodyPartFragment(){
        //Empty for now
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if(mImageIDs != null){
            imageView.setImageResource(mImageIDs.get(mImageIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mImageIndex < mImageIDs.size()-1){
                        mImageIndex++;
                    }else{
                        mImageIndex = 0;
                    }
                    imageView.setImageResource(mImageIDs.get(mImageIndex));
                }
            });
        }else{
            Log.v(TAG, "WARNING, body part image was not defined! Using default values!");
            imageView.setImageResource(AndroidImageAssets.getMouths().get(0));
        }

        return rootView;
    }

    public void setmImageIDs(List<Integer> mImageIDs) {
        this.mImageIDs = mImageIDs;
    }

    public void setmImageIndex(int mImageIndex) {
        this.mImageIndex = mImageIndex;
    }
}
