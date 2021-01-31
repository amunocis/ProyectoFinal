package com.example.proyectofinal;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
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
import com.example.proyectofinal.presenter.IViewScore;
import com.example.proyectofinal.presenter.PresenterScore;

public class SecondFragment extends Fragment implements IViewScore {


    private FragmentSecondBinding mBinding;
    private PresenterScore presenterScore;
    private String imagen, nombre, torre, direccion, depto, totalSt ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            imagen = getArguments().getString("clave1");
            nombre = getArguments().getString("clave2");
            depto = getArguments().getString("clave5");
        }

        presenterScore = new PresenterScore( this);
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
        mBinding.tvDepto2.setText(depto);
        Glide.with(view).load(imagen).apply(new RequestOptions().override(400,400))
                .into(mBinding.ivDepto2);
        mBinding.rgEstTern.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int estado =mBinding.rgEstTern.indexOfChild(mBinding.rgEstTern.findViewById(checkedId));
                boolean eLuces = mBinding.cbLuces.isChecked();
                boolean eBano = mBinding.cbBano.isChecked();
                boolean eCocina = mBinding.cbCocina.isChecked();
                boolean sDormitorio = mBinding.cbDormitorio.isChecked();
                presenterScore.showScore(estado, eLuces, eBano, eCocina, sDormitorio);
                presenterScore.activateButton(estado, eLuces, eBano, eCocina, sDormitorio);
            }

        });

        mBinding.btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] emails = {"carol.llanca@gmail.com"};
                Intent mIntent = new Intent(Intent.ACTION_SENDTO);
                mIntent.setData(Uri.parse("mailto:"));
                mIntent.putExtra(Intent.EXTRA_EMAIL, emails);
                mIntent.putExtra(Intent.EXTRA_SUBJECT, "ALERTA!!: INSPECCIÓN DE DEPTO");
                mIntent.putExtra(Intent.EXTRA_TEXT, "Revisión de departamento " + nombre + " " + depto);
                if (mIntent.resolveActivity(getActivity().getPackageManager()) !=null) {
                    startActivity(mIntent);
                } else {
                    Toast.makeText(getContext(), "Debes instalar una app de correo",
                            Toast.LENGTH_SHORT).show();
                }

            }
            
        });
        mBinding.btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Puntaje obtenido " + totalSt, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void showScore(int total) {
        totalSt = total + "";
        String puntaje = getString(R.string.score, totalSt);
        mBinding.tvResult.setTextColor(Color.parseColor("#000000"));
        mBinding.tvResult.setText(puntaje);


    }

    @Override
    public void activateButton(boolean check) {
        mBinding.btAlert.setEnabled(check);

    }
}