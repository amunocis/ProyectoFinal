package com.example.proyectofinal.model;

public class ModelScore {

    private int scoreElememts(boolean luces, boolean baño, boolean cocina, boolean dormitorio){
        int suma = 0;
        if (luces) {
            suma += 10;
        }
        if (baño) {
            suma += 40;
        }
        if (cocina) {
            suma += 30;
        }
        if (dormitorio) {
            suma += 20;
        }
        return suma;
    }

    public int scoreTotal(int estado,boolean luces,boolean baño,boolean cocina,boolean dormitorio){
        int total = 0;
        total = scoreElememts(luces,baño,cocina,dormitorio)*estado;
        return total;
    }

    public boolean validarBotonAlerta(int estado,boolean luces,boolean baño,boolean cocina,
                                       boolean dormitorio){
        return (scoreTotal(estado, luces, baño, cocina, dormitorio) < 130);
    }
}
