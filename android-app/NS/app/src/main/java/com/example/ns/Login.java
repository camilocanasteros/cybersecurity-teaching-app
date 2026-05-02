package com.example.ns;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText email, password;

    // URL local (ajusta si cambia tu IP)
    String url = "http://192.168.1.9/netshield/validate.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.user); // puedes dejar el id así si ya existe
        password = findViewById(R.id.password);
    }

    public void validar(View v) {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Por favor espera");

        if(email.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingresar correo electronico", Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingresar contraseña", Toast.LENGTH_SHORT).show();
        }
        else{

            pd.show();

            StringRequest request = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            pd.dismiss();

                            response = response.trim(); // 🔥 MUY IMPORTANTE

                            if(response.startsWith("Bienvenido")){

                                String[] parts = response.split("\\|");

                                if(parts.length >= 2){
                                    String nombre = parts[1];

                                    Intent intent = new Intent(Login.this, Bienvenido.class);
                                    intent.putExtra("nombre", nombre);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(Login.this, "Error al obtener nombre", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(Login.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            pd.dismiss();
                            Toast.makeText(Login.this, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<>();

                    // IMPORTANTE: ahora es "email", no "user"
                    params.put("email", email.getText().toString().trim());
                    params.put("password", password.getText().toString().trim());

                    return params;
                }
            };

            RequestQueue rq = Volley.newRequestQueue(this);
            rq.add(request);
        }
    }
}