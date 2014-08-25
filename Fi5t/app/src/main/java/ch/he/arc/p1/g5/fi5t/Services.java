package ch.he.arc.p1.g5.fi5t;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileOutputStream;


public class Services extends Activity {



    // Déclaration TAG
    private static final String TAG ="Menu" ;
    String Role="Admin"; //---------------------------------------------Rôle------------------------------------------//
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {

        if(Role!="Admin")
        {
            MenuItem item3  = menu.findItem(R.id.Users);
            item3.setVisible(false);}

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item)
    {
        Intent intent = null;
        switch (Item.getItemId())
        {
            case R.id.Users:
                // Récupération du nom;
                Class Nom=this.getClass();

                //Context context = getApplicationContext();
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context,this.getLocalClassName().toString(), duration);
                //toast.show();
                if(Nom!=Users.class)
                {intent = new Intent(getApplicationContext(),Users.class);
                    startActivity(intent);}
                if(Nom!=Main.class&&Nom!=Users.class)
                {finish();
                }

                return true;

            case R.id.PageAccueil:
                Class Nom1=this.getClass();
                if(Nom1!=Main.class)
                {
                    intent = new Intent(getApplicationContext(),Main.class);
                    startActivity(intent);
                    finish();
                }
                return true;
            case R.id.PostIt:
                Class Nom2=this.getClass();
                if(Nom2!=POSTIT.class)
                {intent = new Intent(getApplicationContext(),POSTIT.class);
                    startActivity(intent);}
                if(Nom2!=Main.class&&Nom2!=POSTIT.class)
                {finish();
                }
                return true;
            case R.id.Material:
                Class Nom3=this.getClass();
                if(Nom3!=Materiel.class)
                {intent = new Intent(getApplicationContext(),Materiel.class);
                    startActivity(intent);}
                if(Nom3!=Main.class&&Nom3!=Materiel.class)
                {finish();
                }


                return true;
            case R.id.Parameter:
                Class Nom4=this.getClass();
                if(Nom4!=Parametre.class)
                {intent = new Intent(getApplicationContext(),Parametre.class);
                    startActivity(intent);}
                if(Nom4!=Main.class&&Nom4!=Parametre.class)
                {finish();
                }

                return true;
            case R.id.MonProfil:
                Class Nom5=this.getClass();
                if(Nom5!=MonProfil.class)
                {intent = new Intent(getApplicationContext(),MonProfil.class);
                    startActivity(intent);}
                if(Nom5!=Main.class&&Nom5!=MonProfil.class)
                {finish();
                }

                return true;

            default:
                return super.onOptionsItemSelected(Item);

        }
    }

}
