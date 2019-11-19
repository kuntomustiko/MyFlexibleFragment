package com.mustiko.belajar.myflexiblefragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }



    // ayout interface didefinisikan dan ditransformasikan dari layout
    // berupa file xml ke dalam obyek view dengan menggunakan metode inflate()
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout yang ingin diubah, root dari layout activity,
        // Apakah kita akan menempelkan layout kita ke dalam root dari parent layout yang ada.
        // Jika ya, maka akan ditempelkan ke dalam parent layout yang ada.
        // Jika tidak, maka hanya akan menghasilkan nilai balik dalam bentuk obyek view saja.
        // Kita memilih false pada attachToRoot karena pada kode ini kita ingin menambahkan event onClick pada button-nya.
        // Maka kita membutuhkan nilai balik berupa view.
        // Secara default, attachToRoot bernilai false. Jadi kita hanya inginkan mengubah layout xml kedalam bentuk obyek view
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // todo 3
    // Di sini kita bisa gunakan untuk inisialisasi view,
    // dan juga mengatur action-nya (set listener)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnCategory = view.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // todo 7
        // Fragment manager untuk mengatur atau mengoordinasi semua obyek fragment yang ada di dalam sebuah activity
        if (view.getId() == R.id.btn_category){
            CategoryFragment mCategoryFragment = new CategoryFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager != null){
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, mCategoryFragment, CategoryFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}
