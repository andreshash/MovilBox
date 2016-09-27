package com.mobi.movilbox.movilbox.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mobi.movilbox.movilbox.R;

/**
 * Interfaz de login
 */
public class LoginFragment extends Fragment {
    public static final String TAG = LoginFragment.class.getSimpleName();
    View view;
    EditText user;
    EditText password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        onCreateInitilization();
        return view;
    }

    /**
     * Inicialización del fragment
     */
    public void onCreateInitilization() {
        user = (EditText) view.findViewById(R.id.user);
        password = (EditText) view.findViewById(R.id.password);
        Button login = (Button) view.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    /**
     * Se encarga de realizar login contra el servidor
     */
    public void login() {
        if(validateFields()){
            //TODO crear una conexión
        }
    }

    /**
     * Verifica que todos los campos tengan información
     *
     * @return: True:  Si tiene todos los datos diligenciados.
     * False: Si alguno falta por diligenciar.
     */
    public boolean validateFields() {
        if (user.getText().toString().isEmpty()) {
            user.setError("Se requiere que digite el usuario");
            return false;
        } else if (password.getText().toString().isEmpty()) {
            password.setError("Se requiere que digite la contraseña");
            return false;
        }
        return  true;
    }
}
