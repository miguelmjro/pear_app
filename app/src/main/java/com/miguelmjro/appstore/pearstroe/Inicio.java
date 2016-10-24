package com.miguelmjro.appstore.pearstroe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelmjro.appstore.pearstroe.Estructuras.Aplicacion;
import com.miguelmjro.appstore.pearstroe.Fragmentos.AplicacionesFragment;
import com.miguelmjro.appstore.pearstroe.dbo.DAOBase;
import com.miguelmjro.appstore.pearstroe.json.Json;
import com.miguelmjro.appstore.pearstroe.tareas.Descargas;

import java.util.List;

public class Inicio extends FragmentActivity
       /* implements NavigationView.OnNavigationItemSelectedListener */ {
    String json = null;
    List<Aplicacion> apps;
    AplicacionesFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        Intent intent = getIntent();
        String json = intent.getExtras().getString("json");
        if (json != null) {
            this.json = json;
        }
        Json oJson = new Json(this.json);
        apps = oJson.getAplicaciones();
        DAOBase daoBase=new DAOBase(this);
        daoBase.actualizaAplicaciones(apps);
        daoBase.cuentaCategoria();
        frag=(AplicacionesFragment)getSupportFragmentManager().findFragmentById(R.id.list_fragment);
//        TextView tv_json=(TextView)findViewById(R.id.respuesta);
//        tv_json.setText(apps.get(1).getTitle()+"\n\n"+apps.get(1).getSummary());

        //navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        frag.setAplicaciones(apps);
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.inicio, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
