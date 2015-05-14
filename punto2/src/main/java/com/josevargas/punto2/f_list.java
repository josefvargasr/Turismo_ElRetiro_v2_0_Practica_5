package com.josevargas.punto2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class f_list extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] listItems = new String[] { getResources().getString(R.string.principal),getResources().getString(R.string.hoteles),
                getResources().getString(R.string.bares),getResources().getString(R.string.sitios_turisticos),
                getResources().getString(R.string.demografia),getResources().getString(R.string.acercade) };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String registro = (String) getListAdapter().getItem(position);
        int pos = position;
        //vista_fragment fragment = (vista_fragment) getFragmentManager().findFragmentById(R.id.vista);
        vista_fragment fragment = (vista_fragment) getFragmentManager().findFragmentById(R.id.vista);

        if (fragment != null && fragment.isInLayout()) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (position){
                case 0:
                    principal fragment0 = new principal();
                    fragmentTransaction.replace(R.id.container, fragment0).commit();
                    break;
                case 1:
                    hoteles fragment1 = new hoteles();
                    fragmentTransaction.replace(R.id.container, fragment1).commit();
                    break;
                case 2:
                    bares fragment2 = new bares();
                    fragmentTransaction.replace(R.id.container, fragment2).commit();
                    break;
                case 3:
                    sitios_turisticos fragment3 = new sitios_turisticos();
                    fragmentTransaction.replace(R.id.container, fragment3).commit();
                    break;
                case 4:
                    demografia fragment4 = new demografia();
                    fragmentTransaction.replace(R.id.container, fragment4).commit();
                    break;
                case 5:
                    new acercade();
                    acercade dialogFragment = acercade.newInstance(getResources().getString(R.string.acercade));
                    dialogFragment.show(getFragmentManager(), "dialog");
                    break;
                default:
                    break;
            }
            //fragment.establecerTexto(registro);
            //fragment.cambiarFragment(pos);
        }else {
            if(pos==5) {
                new acercade();
                acercade dialogFragment = acercade.newInstance(getResources().getString(R.string.acercade));
                dialogFragment.show(getFragmentManager(), "dialog");
            }else {
                Intent intent = new Intent(getActivity().getApplicationContext(), Vista_activity.class);
                intent.putExtra("texto", registro);
                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        }
    }
}
