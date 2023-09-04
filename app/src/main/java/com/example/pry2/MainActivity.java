package com.example.pry2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Credenciales de usuario estático
    private static final String USUARIO_CORRECTO = "andres";
    private static final String CONTRASENA_CORRECTA = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextUsername = findViewById(R.id.editTextText);
        final EditText editTextPassword = findViewById(R.id.editTextTextPassword);
        Button buttonLogin = findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el usuario y la contraseña ingresados por el usuario
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Comprobar si las credenciales son correctas
                if (username.equals(USUARIO_CORRECTO) && password.equals(CONTRASENA_CORRECTA)) {
                    mostrarAlerta("Inicio de sesión exitoso", "¡Bienvenido, " + username + "!");
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    mostrarAlerta("Error de inicio de sesión", "Usuario o contraseña incorrectos");
                }
            }
        });
    }

    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}