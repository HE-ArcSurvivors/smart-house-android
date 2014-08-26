package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class NewMessage extends Services {

    String Destinataire;
    String Message;
    EditText eMessage;
    EditText eDestinataire;
    Button bEnvoyer;
    Integer Compteur=0;
    CheckBox chkTous;
    Calendar c = Calendar.getInstance();

    //---------------------------Valeur d'envoie pour l'Intent Post-its-------------------------------//
    String DateEnvoie;
    String HeureEnvoie;
    String MessageEnvoie;
    String DestinataireEnvoie;
    String UtilisateurActuelleEnvoie="Moi";

    //---------------------------Valeur d'envoie pour l'Intent Post-its-------------------------------//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        //-------Instanciation---------//
        eMessage=(EditText)findViewById(R.id.extMessage);
        eDestinataire=(EditText)findViewById(R.id.extDestinataire);
        bEnvoyer=(Button)findViewById(R.id.bEnvoyer);
        chkTous=(CheckBox)findViewById(R.id.chkTous);




        //------------------------------------------------------tous les utilisateurs sont destinataires ?-------------------------//
        chkTous.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkTous.isChecked()==true) {
                    eDestinataire.setText("Tous");
                    eDestinataire.setEnabled(false);
                }
                else {
                    eDestinataire.setText("");
                    eDestinataire.setEnabled(true);
                }
            }
        });
        //------------------------------------------------------tous les utilisateurs sont destinataires ?-------------------------//

        //------------------------------------------Ajout des destinataires existant--------------------------------------------------//
        final List<String> list = new ArrayList<String>();
        list.add("Seb");
        list.add("Jordane");
        list.add("SuperMama");
        //------------------------------------------Ajout des destinataires existant--------------------------------------------------//

        bEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] f= (String[]) list.toArray(new String[0]);
                for( int i = 0 ; i < f.length;i++)
                {
                    if(f[i].matches(eDestinataire.getText().toString())==true||chkTous.isChecked()==true)
                    {
                        Compteur++;
                    }
                }
                if(Compteur >=1) {
                    if(eMessage.getText().toString()!="") {

                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, "Message Envoyé", duration);
                        toast.show();
                        Compteur = 0;
                        //Integer Num = c.get(Calendar.DATE);
                        //String eDate =Num.toString();
                       // String eHeure = c.getTime().toString();

                        //Intent IntentSend= new Intent(NewMessage.this,POSTIT.class);
                        //Bundle extras = new Bundle();
                        //extras.putString("ValDestinataire",eDestinataire.getText().toString());
                        //extras.putString("ValMessage",eMessage.getText().toString());
                        //extras.putString("ValDate",eDate);
                        //extras.putString("ValMessage", eHeure);
                        //extras.putString("ValUserAct", UtilisateurActuelleEnvoie);
                        //IntentSend.putExtras(extras);

                        //startActivity(IntentSend);
                       // finish();

                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
