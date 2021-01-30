package com.example.proyectofinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.proyectofinal.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding mBinding;
    private String imagen, nombre, direccion, torre, depto ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            imagen = getArguments().getString("clave1");
            nombre = getArguments().getString("clave2");
            torre = getArguments().getString("clave3");
            direccion = getArguments().getString("clave4");
            depto = getArguments().getString("clave5");

        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mBinding = FragmentSecondBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.tvNombre2.setText(nombre);
       // mBinding.tvTorre2.setText(torre);
        //mBinding.tvDireccion2.setText(direccion);
        mBinding.tvDepto2.setText(depto);
        Glide.with(view).load(imagen).into(mBinding.ivDepto2);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}