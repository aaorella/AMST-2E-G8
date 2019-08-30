package com.grupo2.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    Volley a = new Volley();
    String token = "2471155859574120";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buscarHeroe(View v){

        EditText heroe = (EditText)findViewById(R.id.editText);
        String nombreHeroe = heroe.getText().toString();
        String url = "https://www.superheroapi.com/api.php/" + token + "/search/" + nombreHeroe;
        Intent i = new Intent(getApplicationContext(), ResultadoActivity.class);
        i.putExtra("url",url );
        startActivity(i);



    }
}






