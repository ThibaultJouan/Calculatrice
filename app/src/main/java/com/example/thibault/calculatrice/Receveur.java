package com.example.thibault.calculatrice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by thibault on 12/01/2017.
 */

public class Receveur extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int resultat = intent.getExtras().getInt("resultat");

        MainActivity.getInstance().onResultDisplay(resultat);

    }
    public interface RetourBackGround {
        void onResultDisplay(int input);
    }
}
