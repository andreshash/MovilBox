package com.mobi.movilbox.movilbox.Activitys;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobi.movilbox.movilbox.R;

/**
 * Interfaz de login
 */
public class LoginFragment extends Fragment {
    public static final String TAG = LoginFragment.class.getSimpleName();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        return  view;
    }
}
