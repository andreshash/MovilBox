package com.mobi.movilbox.movilbox.Helpers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import android.support.design.widget.Snackbar;
import android.view.View;


/**
 * Clase de utilidades
 */
public class Helpers {

    /**
     * Genera un SnackBar sencillo y lo muestra al usuario.
     *
     * @param viewCoordinator : Vista donde se muestra el snackbar
     * @param message         : Mensaje principal
     * @param time            : Duración del snackbar
     */
    @Deprecated
    public static void generateSnackBarSimple(final View viewCoordinator,
                                              String message,
                                              int time
    ) {

        Snackbar snackbar = Snackbar
                .make(viewCoordinator, message, time);
        snackbar.show();
    }

    /**
     * Reemplaza un fragment en una vista específica
     *
     * @param source   Fragment de origen
     * @param viewId   Vista en donde se ubicará el fragment
     * @param fragment Fragmento a asignar a la vista
     */
    public static void replaceFragment(android.support.v4.app.Fragment source,
                                       int viewId,
                                       android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentTransaction transaction = source
                .getFragmentManager()
                .beginTransaction();
        transaction.replace(viewId, fragment);
        transaction.commit();
    }
}