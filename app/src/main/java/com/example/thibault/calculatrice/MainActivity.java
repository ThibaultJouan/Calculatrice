package com.example.thibault.calculatrice;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Receveur.RetourBackGround {

    private static MainActivity ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS}, 1);


        ins = this;

        IntentFilter filter = new IntentFilter("envoie.du.resultat");
        this.registerReceiver(new Receveur(), filter);

        final int nombre1 = 7;
        final int nombre2 = 18;

        Button boutonValider = (Button)findViewById(R.id.button);
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendCalcul(nombre1, nombre2);
                //SmsManager sms = SmsManager.getDefault();
                //sms.sendTextMessage("0650497547", null, "coucou", null, null);
            }
        });
    }

    public void SendCalcul(int nombre1, int nombre2){
        Intent intent = new Intent(MainActivity.this, CalculService.class);

        intent.putExtra("nombre1", nombre1);
        intent.putExtra("nombre2", nombre2);
        startService(intent);
    }

    @Override
    public void onResultDisplay(int input) {
        TextView texte = (TextView)findViewById(R.id.textViewResult);
        texte.setText(String.valueOf(input));
    }

    public static MainActivity getInstance()
    {
        return ins;
    }
}
