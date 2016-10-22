package com.miguelmjro.appstore.pearstroe.Estructuras;

/**
 * Created by miguel on 21/10/16.
 */
public class Aplicacion {
    String name;
    String summary;
    String title;
    Imagen[] imagen;
    Categoria categoria;
    Artista artista;
    Precio precio;

    public Aplicacion(String name, String summary, String title, Imagen[] imagen, Categoria categoria, Artista artista, Precio precio) {
        this.name = name;
        this.summary = summary;
        this.title = title;
        this.imagen = imagen;
        this.categoria = categoria;
        this.artista = artista;
        this.precio = precio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Imagen[] getImagen() {
        return imagen;
    }

    public void setImagen(Imagen[] imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }
}
