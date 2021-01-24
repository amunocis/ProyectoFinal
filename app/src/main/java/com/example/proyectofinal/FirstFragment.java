package com.example.proyectofinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proyectofinal.databinding.ApartmentListDataBinding;
import com.example.proyectofinal.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements AptAdapter.IPasarElement {
    private FragmentFirstBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AptAdapter adapter = new AptAdapter(ApartmentData.apartmentList(), this);
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void passElement(Apartment item) {
        Bundle mBundle = new Bundle();
        mBundle.putString("clave1", item.getUrlImage());
        mBundle.putString("clave2", item.getNombre());
        mBundle.putString("clave3", item.getTorre());
        mBundle.putString("clave4", item.getDireccion());
        mBundle.putString("clave5", item.getDepto());
    }
}