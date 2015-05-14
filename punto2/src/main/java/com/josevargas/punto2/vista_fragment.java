package com.josevargas.punto2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class vista_fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vista, container, false);
    }

    public void establecerTexto(String item) {
        //TextView view = (TextView) getView().findViewById(R.id.tvContenido);
        //view.setText(item);
    }

    public void cambiarFragment(int position){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hoteles fragment1 = new hoteles();
        fragmentTransaction.replace(android.R.id.content, fragment1).commit();
    }


}
