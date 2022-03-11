package com.example.monkey_me;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.monkey_me.data.AndroidImageAssets;
import com.example.monkey_me.ui.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BodyPartFragment mouthFragment = new BodyPartFragment();
        mouthFragment.setmImageIDs(AndroidImageAssets.getMouths());
        mouthFragment.setmImageIndex(0);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mouth_container, mouthFragment).commit();

        BodyPartFragment eyesFragment = new BodyPartFragment();
        eyesFragment.setmImageIDs(AndroidImageAssets.getEyes());
        eyesFragment.setmImageIndex(0);

        fragmentManager.beginTransaction().add(R.id.eyes_container, eyesFragment).commit();

        BodyPartFragment clothesFragment = new BodyPartFragment();
        clothesFragment.setmImageIDs(AndroidImageAssets.getClothes());
        clothesFragment.setmImageIndex(0);

        fragmentManager.beginTransaction().add(R.id.clothes_container, clothesFragment).commit();
    }
}