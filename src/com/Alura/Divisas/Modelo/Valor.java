package com.Alura.Divisas.Modelo;

import com.google.gson.annotations.SerializedName;

public class Valor {
    @SerializedName("conversion_rate")
    private double convertida;

    public double getConvertida() {
        return convertida;
    }
}
