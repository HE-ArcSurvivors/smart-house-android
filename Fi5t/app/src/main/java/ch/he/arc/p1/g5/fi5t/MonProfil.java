package ch.he.arc.p1.g5.fi5t;

import ch.he.arc.p1.g5.fi5t.Services;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MonProfil extends Services {

    EditText tvNom, tvPrenom, tvUsername, tvRole;
    Button bConfirm;
    String whatAmI="nothing";
    boolean loop = true;

    SharedPreferences sharedProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);

        tvNom = (EditText) findViewById(R.id.tvNom);
        tvPrenom = (EditText) findViewById(R.id.tvPrenom);
        tvUsername = (EditText) findViewById(R.id.tvUsername);
        tvRole = (EditText) findViewById(R.id.tvRole);
        bConfirm = (Button) findViewById(R.id.bConfirm);


        sharedProfile = getSharedPreferences(MyProfile, Context.MODE_PRIVATE);


        if (sharedProfile.contains(LastName)){
            tvNom.setText(sharedProfile.getString(LastName, ""));
        }
        if (sharedProfile.contains(FirstName)){
            tvPrenom.setText(sharedProfile.getString(FirstName, ""));
        }
        if (sharedProfile.contains(UserName)){
            tvUsername.setText(sharedProfile.getString(UserName, ""));
        }
        if (sharedProfile.contains(UserRole)){
            tvRole.setText(sharedProfile.getString(UserRole, ""));
        }


        tvNom.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {

                if (loop == true){
                    bConfirm.setVisibility(View.VISIBLE);
                    //loop = false;
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        tvPrenom.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {

                if (loop == true){
                    bConfirm.setVisibility(View.VISIBLE);
                    //loop = false;
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        tvUsername.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {

                if (loop == true){
                    bConfirm.setVisibility(View.VISIBLE);
                    //loop = false;
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


    }

    public void save(View view){
        String nom  = tvNom.getText().toString();
        String prenom  = tvPrenom.getText().toString();
        String username  = tvUsername.getText().toString();
        Editor editor = sharedProfile.edit();
        editor.putString(LastName, nom);
        editor.putString(FirstName, prenom);
        editor.putString(UserName, username);
        editor.apply();
        bConfirm.setVisibility(View.INVISIBLE);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mon_profil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.MonProfil) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
