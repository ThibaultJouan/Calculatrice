package com.example.thibault.calculatrice;


import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by thibault on 12/01/2017.
 */

public class CalculService extends IntentService {

    public CalculService(){
        super("CalculService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        int nombre1 = 0;
        int nombre2 = 0;
        int resultat = 0;

        String operateur = "";

        if(null != extras){
            nombre1 = extras.getInt("nombre1");
            nombre2 = extras.getInt("nombre2");

            resultat = nombre1 + nombre2;
        }

        Intent emitBroadcast = new Intent();

        emitBroadcast.setAction("envoie.du.resultat");
        emitBroadcast.putExtra("resultat", resultat);

        sendBroadcast(emitBroadcast);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
