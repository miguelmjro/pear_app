package com.miguelmjro.appstore.pearstroe.Estructuras;

/**
 * Created by miguel on 21/10/16.
 */
public class Artista {
    String name;
    String pagina;

    public Artista(String name, String pagina) {
        this.name = name;
        this.pagina = pagina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}
