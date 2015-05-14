package com.josevargas.turismoelretiro20;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        principal fragment = new principal();
        fragmentTransaction.replace(android.R.id.content, fragment).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_principal) {
            principal fragment = new principal();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
            return true;
        }
        if (id == R.id.menu_hoteles) {
            hoteles fragment = new hoteles();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
            return true;
        }
        if (id == R.id.menu_bares) {
            bares fragment = new bares();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
            return true;
        }
        if (id == R.id.menu_demografia) {
            demografia fragment = new demografia();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
            return true;
        }
        if (id == R.id.menu_sitios_turisticos) {
            sitios_turisticos fragment = new sitios_turisticos();
            fragmentTransaction.replace(android.R.id.content, fragment).commit();
            return true;
        }
        if (id == R.id.menu_acercade) {
            new acercade();
            acercade dialogFragment = acercade.newInstance(getResources().getString(R.string.acercade));
            dialogFragment.show(getFragmentManager(), "dialog");

            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
