package com.mustiko.belajar.myflexiblefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // todo 4
        // melakukan penemplean atau pemasangan obyek HomeFragment sehingga dapat
        // di tampilkan ke layar

        // FragmentManager merupakan antarmuka untuk mengorganisir obyek fragment yang terdapat didalam sebuah activity
        FragmentManager mFragmentManager = getSupportFragmentManager();
        HomeFragment mHomeFragment = new HomeFragment();
        Fragment fragment = mFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)){
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment.class.getSimpleName());
            // proses penambhana fragment ke dalam activity terjadi
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, mHomeFragment, HomeFragment.class.getSimpleName())
                    .commit();
        }
    }
}
