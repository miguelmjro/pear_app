package com.miguelmjro.appstore.pearstroe.Estructuras;

/**
 * Created by miguel on 21/10/16.
 */
public class Categoria {
    String term;
    String label;
    String scheme;
    int id;

    public Categoria(String term, String label, String scheme, int id) {
        this.term = term;
        this.label = label;
        this.scheme = scheme;
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
