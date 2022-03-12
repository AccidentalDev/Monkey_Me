package com.example.monkey_me;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.monkey_me.data.AndroidImageAssets;
import com.example.monkey_me.ui.BodyPartFragment;

public class MonkeyMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monkey_me);

        if(savedInstanceState == null) {
            int mouthIndex = 0;
            int eyesIndex = 0;
            int clothesIndex = 0;

            Bundle extrasBundle = getIntent().getExtras();
            if (extrasBundle != null){
                Log.v("MonkeyMeActivity", "Activity was sent an extras bundle!");
                mouthIndex = extrasBundle.getInt("mouthIndex", 0);
                eyesIndex = extrasBundle.getInt("eyesIndex", 0);
                clothesIndex = extrasBundle.getInt("clothesIndex", 0);
            }

            BodyPartFragment mouthFragment = new BodyPartFragment();
            mouthFragment.setmImageIDs(AndroidImageAssets.getMouths());
            mouthFragment.setmImageIndex(mouthIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.mouth_container, mouthFragment).commit();

            BodyPartFragment eyesFragment = new BodyPartFragment();
            eyesFragment.setmImageIDs(AndroidImageAssets.getEyes());
            eyesFragment.setmImageIndex(eyesIndex);

            fragmentManager.beginTransaction().add(R.id.eyes_container, eyesFragment).commit();

            BodyPartFragment clothesFragment = new BodyPartFragment();
            clothesFragment.setmImageIDs(AndroidImageAssets.getClothes());
            clothesFragment.setmImageIndex(clothesIndex);

            fragmentManager.beginTransaction().add(R.id.clothes_container, clothesFragment).commit();
        }
    }
}