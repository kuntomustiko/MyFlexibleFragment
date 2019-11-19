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
public class CategoryFragment extends Fragment implements View.OnClickListener {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    // todo 6
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_detail_category){
            // todo 10
            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();

            // menggunakan obyek bundle untuk mengirimkan data antar fragment
            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            // kirimkan obyek bundle tersebut
            mDetailCategoryFragment.setArguments(mBundle);

            // menggunakan setter and getter untuk mengirimkan data ke fragment lainnya
            String description = "kategori ini akan berisi produk-produk lifestyle";
            mDetailCategoryFragment.setDescription(description);

            FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager != null){
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}
