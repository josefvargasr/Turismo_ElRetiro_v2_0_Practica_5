package com.josevargas.punto2;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class DetallesActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        setContentView(R.layout.fragment_vista);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String s = extras.getString("texto");
            //TextView view = (TextView) findViewById(R.id.tvContenido);
            //view.setText(s);
        }
    }
}
