package com.mustiko.belajar.myflexiblefragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment implements View.OnClickListener {


    // todo 9
    TextView tvCategoryName;
    TextView tvCategoryDescription;
    Button btnProfile;
    Button btnShowDialog;

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public DetailCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // mengambil data yang dikirimkan melalui obyek bundle
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);

        // mengambil data yang di kirimkan melalui setter and getter
        tvCategoryDescription.setText(getDescription());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_profile:
                // todo 16
                // getActivity() Hal ini karena kita menggunakan Fragment, sedangkan fungsi this hanya bisa dipanggil melalui Activity
                Intent mIntent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_show_dialog:

                // todo 13
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();

                // getChildFragmentManager() merupakan pilihan yang tepat untuk kondisi saat ini,
                // yakni sebuah nested fragment / fragment bersarang. Karena OptionDialogFragment
                // dipanggil di dalam sebuah obyek fragment yang telah ada sebelumnya yaitu DetailCategoryFragment,
                // maka demi performa lebih baik gunakanlah getChildFragmentManager() sebagai pilihan yang lebih tepat.

                // Baris di atas digunakan untuk menampilkan obyek OptionDialogFragment ke layar.
                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager,OptionDialogFragment.class.getSimpleName());

                break;
        }
    }

    // todo 14
    // menampilkan sebuah dialog ke pengguna untuk memilih sebuah opsi yang tersedia

    // mengimplemntasikan interface
    OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChoosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}
