package com.josevargas.turismoelretiro20;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;


public class acercade extends DialogFragment {

    static acercade newInstance(String title){
        acercade fragment = new acercade();
        Bundle Args = new Bundle();
        Args.putString("title",title);
        fragment.setArguments(Args);
        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        String title = getArguments().getString("title");
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(title)
                .setMessage(getResources().getString(R.string.acerdade_intro1) + "\n" + getResources().getString(R.string.acerdade_intro2)
                        + "\n" + getResources().getString(R.string.acerdade_intro3) + "\n" + getResources().getString(R.string.acerdade_intro4)
                        + "\n" + getResources().getString(R.string.acerdade_intro5)).create();
    }

}

