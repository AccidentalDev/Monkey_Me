package com.example.monkey_me.data;

import com.example.monkey_me.R;

import java.util.ArrayList;
import java.util.List;

public class AndroidImageAssets {

    private static final List<Integer> mouths = new ArrayList<Integer>(){{
        add(R.drawable.boca1);
        add(R.drawable.boca2);
        add(R.drawable.boca3);
        add(R.drawable.boca4);
    }};

    private static final List<Integer> eyes = new ArrayList<Integer>(){{
        add(R.drawable.ojos1);
        add(R.drawable.ojos2);
        add(R.drawable.ojos3);
        add(R.drawable.ojos4);
    }};

    private static final List<Integer> clothes = new ArrayList<Integer>(){{
        add(R.drawable.ropa1);
        add(R.drawable.ropa2);
        add(R.drawable.ropa3);
        add(R.drawable.ropa4);
    }};

    private static final List<Integer> all = new ArrayList<Integer>() {{
        addAll(mouths);
        addAll(eyes);
        addAll(clothes);
    }};

    public static List<Integer> getMouths() {
        return mouths;
    }

    public static List<Integer> getEyes() {
        return eyes;
    }

    public static List<Integer> getClothes() {
        return clothes;
    }

    public static List<Integer> getAll() {
        return all;
    }
}
