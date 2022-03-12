package com.example.monkey_me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.monkey_me.ui.MasterListFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private int mouthIndex;
    private int eyesIndex;
    private int clothesIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onImageSelected(int position){
        int bodyPartNumber = position/4;
        int listIndex = position - (bodyPartNumber*4);

        switch (bodyPartNumber){
            case 0: mouthIndex = listIndex; break;
            case 1: eyesIndex = listIndex; break;
            case 2: clothesIndex = listIndex; break;
            default: break;
        }

        Bundle bodyPartsBundle = new Bundle();
        bodyPartsBundle.putInt("mouthIndex", mouthIndex);
        bodyPartsBundle.putInt("eyesIndex", eyesIndex);
        bodyPartsBundle.putInt("clothesIndex", clothesIndex);

        final Intent intent = new Intent(this, MonkeyMeActivity.class);
        intent.putExtras(bodyPartsBundle);

        //ToDo: Button logic should NOT be defined here! It can generate a bug where the NEXT button does nothing if no body part has ben touched first
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
