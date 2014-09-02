package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AjouterModifer extends Services {
    Button BtnOk;
    Button BtnAjouter;
    EditText edtNom;
    EditText edtPrenom;
    EditText edtPseudo;
    EditText edtMDP;
    EditText edtRole;

    String SedtNom;
    String SedtPrenom;
    String SedtPseudo;
    String SedtMDP;
    String SedtRole;
    String SedtID;


    String ModifySedtNom;
    String ModifySedtPrenom;
    String ModifySedtPseudo;
    String ModifySedtMDP;
    String ModifySedtRole;

    String NewedtNom;
    String NewedtPrenom;
    String NewedtPseudo;
    String NewedtMDP;
    String NewedtRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_modifer);


        BtnOk=(Button)findViewById(R.id.bOK);
        BtnAjouter=(Button)findViewById(R.id.btnAjouter);
        edtNom=(EditText)findViewById(R.id.edtNom);
        edtPrenom=(EditText)findViewById(R.id.edtPrenom);
        edtPseudo=(EditText)findViewById(R.id.edtPseudo);
        edtMDP=(EditText)findViewById(R.id.edtMDP);
        edtRole=(EditText)findViewById(R.id.edtRole);

        Intent intent = getIntent();
        SedtNom=intent.getStringExtra("ModifyNom");
        SedtPrenom=intent.getStringExtra("ModifyPrenom");
        SedtPseudo=intent.getStringExtra("ModifyPseudo");
        SedtMDP=intent.getStringExtra("ModifyMDP");
        SedtRole=intent.getStringExtra("ModifyRole");
        SedtID=intent.getStringExtra("ModifyID");

        //Connection.sendMessage("---\r\n");

        edtNom.setText(SedtNom);
        edtPrenom.setText(SedtPrenom);
        edtPseudo.setText(SedtPseudo);
        edtMDP.setText(SedtMDP);
        edtRole.setText(SedtRole);

        if(edtNom.getText().toString().matches(""))
        {
            BtnOk.setVisibility(View.INVISIBLE);
            BtnAjouter.setVisibility(View.VISIBLE);

        }
        else
        {
            BtnOk.setVisibility(View.VISIBLE);
            BtnAjouter.setVisibility(View.INVISIBLE);

        }

        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModifySedtNom=edtNom.getText().toString();
                ModifySedtPrenom=edtPrenom.getText().toString();
                ModifySedtPseudo=edtPseudo.getText().toString();
                ModifySedtMDP=edtMDP.getText().toString();
                ModifySedtRole=edtRole.getText().toString();

                SharedPreferences UserModify = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
                SharedPreferences.Editor editorModify  = UserModify.edit();
                editorModify.putString(Services.ModifyUserName,ModifySedtNom);
                editorModify.putString(Services.ModifyUserFirstName,ModifySedtPrenom);
                editorModify.putString(Services.ModifyUserPseudo,ModifySedtPseudo);
                editorModify.putString(Services.ModifyUserMDP,ModifySedtMDP);
                editorModify.putString(Services.ModifyUserRole,ModifySedtRole);
                editorModify.putString(Services.ModifyUserID,SedtID);
                editorModify.apply();
                //////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////
                /////////////////Méthode qui écrit de Services dans bluefetch/////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////

                Intent BackUser=new Intent(AjouterModifer.this,Users.class);
                startActivity(BackUser);
                finish();
            }
        });
        BtnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewedtNom=edtNom.getText().toString();
                NewedtPrenom=edtPrenom.getText().toString();
                NewedtPseudo=edtPseudo.getText().toString();
                NewedtMDP=edtMDP.getText().toString();
                NewedtRole=edtRole.getText().toString();

                SharedPreferences UserNew = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
                SharedPreferences.Editor editorNew  = UserNew.edit();
                editorNew.putString(Services.NEWUserName,NewedtNom);
                editorNew.putString(Services.NEWUserFirstName,NewedtPrenom);
                editorNew.putString(Services.NEWUserPseudo,NewedtPseudo);
                editorNew.putString(Services.NEWUserMDP,NewedtMDP);
                editorNew.putString(Services.NEWUserRole,NewedtRole);
                editorNew.apply();

                //////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////
                /////////////////Méthode qui écrit de Services dans bluefetch/////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////

                Intent BackUser=new Intent(AjouterModifer.this,Users.class);
                startActivity(BackUser);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ajouter_modifer, menu);
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
