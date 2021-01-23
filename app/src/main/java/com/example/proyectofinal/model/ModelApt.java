package com.example.proyectofinal.model;

public class ModelApt {
    private int check = 0;

    public boolean checkPassword(String pass) {
        return pass.equals("123Pass");
    }

    public boolean checkAs() {
        check =+1;
        return (check < 3);
    }


}
