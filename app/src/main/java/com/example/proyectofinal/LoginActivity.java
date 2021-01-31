package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.proyectofinal.databinding.ActivityLoginBinding;
import com.example.proyectofinal.presenter.IViewLogin;
import com.example.proyectofinal.presenter.PresenterLogin;

public class LoginActivity extends AppCompatActivity implements IViewLogin {
    private ActivityLoginBinding mBinding;
    private PresenterLogin presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        presenter = new PresenterLogin(this);

        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.checkPassword(mBinding.etPassword.getText().toString());
            }
        });
    }

    @Override
    public void toSecondActivity() {
        Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void showPassMsg() {
        Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkButton() {
        Toast.makeText(this, "Asopao", Toast.LENGTH_SHORT).show();
        mBinding.button.setEnabled(false);
    }
}