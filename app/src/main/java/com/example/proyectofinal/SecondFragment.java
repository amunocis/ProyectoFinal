package com.example.proyectofinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.proyectofinal.databinding.FragmentSecondBinding;

import java.util.zip.Inflater;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding mBinding;
    private String imagen, nombre, torre, direccion, depto ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            imagen = getArguments().getString("clave1");
            nombre = getArguments().getString("clave2");
            torre = getArguments().getString("clave3");
            direccion = getArguments().getString("clave4");
            depto = getArguments().getString("clave5");
        }
    }


    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = FragmentSecondBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.tvNombre2.setText(nombre);
        mBinding.tvTorre2.setText(torre);
        mBinding.tvDireccion2.setText(direccion);
        mBinding.tvDepto2.setText(depto);
        Glide.with(view).load(imagen).apply(new RequestOptions().override(400,400))
                .into(mBinding.ivDepto2);
        mBinding.rgEstTern.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int estado =mBinding.rgEstTern.indexOfChild(mBinding.rgEstTern.findViewById(checkedId));
                String est = estado+"";
                Toast.makeText(getContext(), est, Toast.LENGTH_SHORT).show();

            }
        });
        mBinding.rgEstados.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                boolean eLuces = mBinding.cbLuces.isChecked();
                String sLuces= eLuces+"";
                Toast.makeText(getContext(), sLuces, Toast.LENGTH_SHORT).show();
                boolean eBano = mBinding.cbBano.isChecked();
                String sBano= eBano+"";
                Toast.makeText(getContext(), sBano, Toast.LENGTH_SHORT).show();
                boolean eCocina = mBinding.cbLuces.isChecked();
                String sCocina= eCocina+"";
                Toast.makeText(getContext(), sCocina, Toast.LENGTH_SHORT).show();
                boolean sDormitario = mBinding.cbBano.isChecked();
                String bb= sDormitario+"";
                Toast.makeText(getContext(), bb, Toast.LENGTH_SHORT).show();

            }
        });

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });



    }
}