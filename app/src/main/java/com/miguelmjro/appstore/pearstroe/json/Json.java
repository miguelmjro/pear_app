package com.miguelmjro.appstore.pearstroe.json;

import com.miguelmjro.appstore.pearstroe.Estructuras.Aplicacion;
import com.miguelmjro.appstore.pearstroe.Estructuras.Artista;
import com.miguelmjro.appstore.pearstroe.Estructuras.Categoria;
import com.miguelmjro.appstore.pearstroe.Estructuras.Imagen;
import com.miguelmjro.appstore.pearstroe.Estructuras.Precio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by miguel on 21/10/16.
 */
public class Json {
    JSONObject jsObject;
    JSONObject raiz;
    JSONArray aplicaciones;
    public Json(String st_json){
        try {
            jsObject = new JSONObject(st_json);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public Aplicacion[] getAplicaciones(){
        Aplicacion[] apps=null;
        try {
            Vector<Aplicacion> vec=new Vector<Aplicacion>();
            raiz =jsObject.getJSONObject("feed");
            aplicaciones = raiz.getJSONArray("entry");
            for (int i=0; i < aplicaciones.length(); i++)
            {
                JSONObject app = aplicaciones.getJSONObject(i);
                // Pulling items from the array
                String name = app.getString("im:name");
                JSONObject js_summary= app.getJSONObject("summary");
                String summary=js_summary.getString("label");
                JSONObject js_title=app.getJSONObject("title");
                String title=js_title.getString("label");

                JSONObject js_price= app.getJSONObject("price");
                String pri_eti=js_price.getString("label");
                JSONObject js_atributos=js_price.getJSONObject("attributes");
                double amount=js_atributos.getDouble("amount");
                String currencyCode=js_atributos.getString("currency");
                Precio precio = new Precio(amount,currencyCode,pri_eti);

                JSONObject js_artist= app.getJSONObject("category");
                String art_nombre=js_artist.getString("label");
                js_atributos=js_artist.getJSONObject("attributes");
                String art_url=js_atributos.getString("href");
                Artista artista= new Artista(art_nombre, art_url);

                JSONObject js_category= app.getJSONObject("category");
                js_atributos=js_category.getJSONObject("attributes");
                int id_cat=js_atributos.getInt("im:id");
                String cat_term=js_atributos.getString("term");
                String label=js_atributos.getString("label");
                String scheme=js_atributos.getString("scheme");
                Categoria categoria=new Categoria(cat_term, label, scheme, id_cat);

                JSONArray jsa_imagen= app.getJSONArray("im:image");
                Imagen[] imagen=new Imagen[jsa_imagen.length()];
                for (int j=0;j<jsa_imagen.length();j++){
                    JSONObject js_imagen=jsa_imagen.getJSONObject(j);
                    String im_url=js_imagen.getString("label");
                    int altura=js_imagen.getInt("height");
                    imagen[j]=new Imagen(im_url,altura);
                }
                vec.add(new Aplicacion( name, summary, title, imagen, categoria, artista,  precio));
            }
            apps=new Aplicacion[vec.size()];
            for (int i=0;i<vec.size();i++){
                apps[i]=vec.get(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            apps=null;
        }
        return apps;
    }
}
