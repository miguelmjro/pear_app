package com.miguelmjro.appstore.pearstroe.Estructuras;

/**
 * Created by miguel on 21/10/16.
 */
public class Precio {
    double amount;
    String currencyCode;
    String etiqueta;

    public Precio(double amount, String currencyCode, String etiqueta) {
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.etiqueta = etiqueta;
    }

    public double getAumont() {
        return amount;
    }

    public void setAumont(double aumont) {
        this.amount = aumont;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}
