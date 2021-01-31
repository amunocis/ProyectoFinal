package com.example.proyectofinal.presenter;

import com.example.proyectofinal.model.ModelScore;

public class PresenterScore {

    private IViewScore viewScore;
    private ModelScore modelScore;

    public PresenterScore(IViewScore viewScore) {
        this.viewScore = viewScore;
        this.modelScore = new ModelScore();
    }

    public void showScore(int estado,boolean luces,boolean baño,boolean cocina,boolean dormitorio) {
        viewScore.showScore(modelScore.scoreTotal( estado, luces, baño, cocina, dormitorio));
    }

    public  void  activateButton(int estado,boolean luces,boolean baño,boolean cocina,boolean dormitorio) {
        viewScore.activateButton(modelScore.validarBotonAlerta( estado, luces, baño, cocina, dormitorio));
    }
}
