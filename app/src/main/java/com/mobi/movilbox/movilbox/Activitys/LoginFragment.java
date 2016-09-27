package com.mobi.movilbox.movilbox.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mobi.movilbox.movilbox.Models.User;
import com.mobi.movilbox.movilbox.Networking.HttpService;
import com.mobi.movilbox.movilbox.Networking.Service;
import com.mobi.movilbox.movilbox.R;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Interfaz de login
 */
public class LoginFragment extends Fragment {
    View view;
    EditText user;
    EditText password;
    SweetAlertDialog dialog;

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
                dialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                dialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                dialog.setTitleText("Loading");
                dialog.setCancelable(false);
                dialog.show();
                login();
            }
        });
    }

    /**
     * Se encarga de realizar login contra el servidor
     */
    public void login() {
        if(validateFields()){
            final Service restService = new Service();
            final HttpService httpService =
                    restService.createService(HttpService.class, "token");

            Call<Void> call = httpService.login(
                    new User(user.getText().toString(),
                             password.getText().toString())
            );

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Log.e("login", "test" );
                        if (dialog!=null)
                            dialog.dismissWithAnimation();
                        startActivity(new Intent(getActivity(), MainActivity.class));
                    }
                    else{
                        dialog.dismissWithAnimation();
                        new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Error...")
                                .setContentText("Algo pasa  con los datos suministrados...")
                                .show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("login", "" +t);
                }
            });
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
