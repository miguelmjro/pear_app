package com.miguelmjro.appstore.pearstroe.Estructuras;

/**
 * Created by miguel on 21/10/16.
 */
public class Precio {
    double aumont;
    String currencyCode;
    String etiqueta;

    public Precio(double aumont, String currencyCode, String etiqueta) {
        this.aumont = aumont;
        this.currencyCode = currencyCode;
        this.etiqueta = etiqueta;
    }

    public double getAumont() {
        return aumont;
    }

    public void setAumont(double aumont) {
        this.aumont = aumont;
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
