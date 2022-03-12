package com.example.monkey_me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.monkey_me.data.AndroidImageAssets;
import com.example.monkey_me.ui.BodyPartFragment;
import com.example.monkey_me.ui.MasterListFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private int mouthIndex;
    private int eyesIndex;
    private int clothesIndex;

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.monkey_me_linear_layout) != null){
            mTwoPane = true;

            Button nextButton = findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);

            GridView gridView = findViewById(R.id.master_grid_view);
            //gridView.setNumColumns(1);

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

    public void onImageSelected(int position){
        int bodyPartNumber = position/4;
        int listIndex = position - (bodyPartNumber*4);

        if(mTwoPane){
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setmImageIndex(listIndex);
            switch (bodyPartNumber){
                case 0:
                    bodyPartFragment.setmImageIDs(AndroidImageAssets.getMouths());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.mouth_container, bodyPartFragment).commit();
                    break;
                case 1:
                    bodyPartFragment.setmImageIDs(AndroidImageAssets.getEyes());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.eyes_container, bodyPartFragment).commit();
                    break;
                case 2:
                    bodyPartFragment.setmImageIDs(AndroidImageAssets.getClothes());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.clothes_container, bodyPartFragment).commit();
                    break;
                default:
                    Log.v("MainActivity", "Error getting body part index");
            }


        }else {
            switch (bodyPartNumber) {
                case 0:
                    mouthIndex = listIndex;
                    break;
                case 1:
                    eyesIndex = listIndex;
                    break;
                case 2:
                    clothesIndex = listIndex;
                    break;
                default:
                    break;
            }

            Bundle bodyPartsBundle = new Bundle();
            bodyPartsBundle.putInt("mouthIndex", mouthIndex);
            bodyPartsBundle.putInt("eyesIndex", eyesIndex);
            bodyPartsBundle.putInt("clothesIndex", clothesIndex);

            final Intent intent = new Intent(this, MonkeyMeActivity.class);
            intent.putExtras(bodyPartsBundle);

            //ToDo: Button logic should NOT be defined here! It can generate a bug where the NEXT button does nothing if no body part has ben touched first
            Button nextButton = findViewById(R.id.next_button);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }
    }
}
