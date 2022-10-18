package com.crizacio.fastvehiclegpsadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    public static String PREF_NAME = "com.crizacio.fastvehiclegpsadmin.configuracion";
    public static String NUMERO = "com.crizacio.fastvehiclegpsadmin.configuracion.numero";
    public static String CODIGO = "com.crizacio.fastvehiclegpsadmin.configuracion.codigo";

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    EditText edt_Numero, edt_Codigo;

    String phoneNo;
    String gpsPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = MainActivity.this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        loadConfig();
    }
    @Override
    protected void onPause() {
        super.onPause();
        editor.putString(NUMERO, edt_Numero.getText().toString());
        editor.putString(CODIGO, edt_Codigo.getText().toString());
        editor.apply();
        Toast.makeText(this, "Se ha guardado la configuracion", Toast.LENGTH_SHORT).show();
        loadConfig();
    }

    public void loadConfig() {
        phoneNo = sharedPref.getString(NUMERO, "");
        gpsPassword = sharedPref.getString(CODIGO, "123456");

        edt_Numero = (EditText)findViewById(R.id.edtNumero);
        edt_Codigo = (EditText)findViewById(R.id.edtCodigo);

        edt_Numero.setText(phoneNo);
        edt_Codigo.setText(gpsPassword);
    }

    public boolean sendSMSMessage(String message) {
        if (phoneNo != "") {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(this, "Comando " + message + " enviado!", Toast.LENGTH_LONG).show();
            return true;
        } else {
            Toast.makeText(this, "Debe ingresar un numero", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public void metVerDesarrollador (View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://crizacio.com/"));
        startActivity(browserIntent);
    }

    public void metEscucharOnBoard (View view) {
        sendSMSMessage("listen"+gpsPassword);
    }
    public void metCortacorrienteRapido (View view) {
        sendSMSMessage("quickstop"+gpsPassword);
    }
    public void metCortacorrienteSeguro (View view) {
        sendSMSMessage("noquickstop"+gpsPassword);
    }
    public void metObtenerUbicacion (View view) {
        sendSMSMessage("position"+gpsPassword);
    }
    boolean isActivo = false;
    public void metAdminInmovilizar (View view) {
        if (!isActivo) {
            if (sendSMSMessage("stop"+gpsPassword)) {isActivo = !isActivo;}
        } else {
            if (sendSMSMessage("resume"+gpsPassword)) {isActivo = !isActivo;}
        }
    }
}