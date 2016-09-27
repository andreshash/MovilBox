package com.mobi.movilbox.movilbox.Activitys;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobi.movilbox.movilbox.Helpers.Helpers;
import com.mobi.movilbox.movilbox.R;

/**
 * Activity principal
 */
public class MainActivity extends AppCompatActivity {
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateInitialization(savedInstanceState);
    }


    /**
     * Función que contiene los componentes iniciales de la actividad
     *
     * @param savedInstanceState
     */
    public void onCreateInitialization(Bundle savedInstanceState) {
        context = initContext();
        LoginFragment login = new LoginFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, login);
        if (!isFinishing()) {
            fragmentTransaction.commit();
        }
    }

    /**
     * Inicializa el contexto
     *
     * @return el contexto de la actividad
     */
    public Activity initContext() {
        return this;
    }


}
