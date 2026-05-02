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

public class SignUp extends AppCompatActivity {

    EditText email, name, password, age, gender;

    // Para emulador
    String url = "http://192.168.1.9/netshield/register.php";

    // Para celular real (descomenta y ajusta la IP)
    // String url = "http://192.168.1.5/netsshield/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        name = findViewById(R.id.user);
        password = findViewById(R.id.password);
        age = findViewById(R.id.edad);
        gender = findViewById(R.id.genero);
    }

    public void insertar(View v){

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Por favor espera");

        if(email.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingresar correo electronico", Toast.LENGTH_SHORT).show();
        }
        else if(name.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingresar nombre de usuario", Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingresar contraseña", Toast.LENGTH_SHORT).show();
        }
        else if(age.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingresar edad", Toast.LENGTH_SHORT).show();
        }
        else if(gender.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingresar genero", Toast.LENGTH_SHORT).show();
        }
        else{

            pd.show();

            StringRequest request = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            pd.dismiss();

                            email.setText("");
                            name.setText("");
                            password.setText("");
                            age.setText("");
                            gender.setText("");

                            Toast.makeText(SignUp.this, response, Toast.LENGTH_LONG).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            pd.dismiss();
                            Toast.makeText(SignUp.this, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<>();

                    params.put("email", email.getText().toString().trim());
                    params.put("name", name.getText().toString().trim());
                    params.put("password", password.getText().toString().trim());
                    params.put("age", age.getText().toString().trim());
                    params.put("gender", gender.getText().toString().trim());

                    return params;
                }
            };

            RequestQueue rq = Volley.newRequestQueue(this);
            rq.add(request);
        }
    }

    public void goToLogin(View v){
        Intent intent = new Intent(v.getContext(), Login.class);
        startActivity(intent);
    }
}