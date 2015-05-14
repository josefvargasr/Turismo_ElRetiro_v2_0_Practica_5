package com.josevargas.punto2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class Vista_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation ==Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            String s = extras.getString("texto");
            int position = extras.getInt("pos");

            switch (position){
                case 0:
                    principal fragment0 = new principal();
                    fragmentTransaction.replace(android.R.id.content, fragment0).commit();
                    break;
                case 1:
                    hoteles fragment1 = new hoteles();
                    fragmentTransaction.replace(android.R.id.content, fragment1).commit();
                    break;
                case 2:
                    bares fragment2 = new bares();
                    fragmentTransaction.replace(android.R.id.content, fragment2).commit();
                    break;
                case 3:
                    sitios_turisticos fragment3 = new sitios_turisticos();
                    fragmentTransaction.replace(android.R.id.content, fragment3).commit();
                    break;
                case 4:
                    demografia fragment4 = new demografia();
                    fragmentTransaction.replace(android.R.id.content, fragment4).commit();
                    break;
                case 5:
                    new acercade();
                    acercade dialogFragment = acercade.newInstance(getResources().getString(R.string.acercade));
                    dialogFragment.show(getFragmentManager(), "dialog");
                    break;
                default:
                    break;
            }

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
