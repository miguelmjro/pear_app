package com.miguelmjro.appstore.pearstroe.Fragmentos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelmjro.appstore.pearstroe.Estructuras.Aplicacion;
import com.miguelmjro.appstore.pearstroe.Estructuras.Imagen;
import com.miguelmjro.appstore.pearstroe.Fragmentos.dummy.DummyContent.DummyItem;
import com.miguelmjro.appstore.pearstroe.R;
import com.miguelmjro.appstore.pearstroe.tareas.Descargas;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class AdaptadorAplicaciones extends BaseAdapter {

    Context context;
    List<Aplicacion> rowItem;
    private int codigohash;
    public AdaptadorAplicaciones(Context context, List<Aplicacion> rowItem) {
        this.context = context;
        this.rowItem = rowItem;
        codigohash=0;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.fragment_aplicaciones, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.iconoApp);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.nombre);

        Aplicacion row_pos = rowItem.get(position);
        // setting the image resource and title

        Imagen imagen=row_pos.getImagen()[2];
        txtTitle.setText(row_pos.getName());
        imgIcon.setImageBitmap(imagen.getImagen());
        if(imagen.getImagen()==null&&imgIcon.hashCode()!=codigohash){
            codigohash=imgIcon.hashCode();
            Descargas des= new Descargas();
            des.setImagen(imgIcon);
            des.execute(imagen);
        }


        return convertView;

    }
}