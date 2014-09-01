package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Users extends Services {


    //----------------------Button--------------------//////
    Button bModifier;
    Button bNouveau;
    Button bSupprimer;


    //-----------------ListView------------------------//////
    ListView ListeUtilisateurs ;


    //------------------------Autres---------------------------------------/////
    private List<UserClass> MyUsers =new ArrayList<UserClass>();

    // String utiliser pour récupérer l'élément selectionnée//
    String IDUtilisateurDel;
    String PseudoUtilisateurDel;


    String IDUtilisateurModif;
    String NomUtilisateurModif;
    String PrenomUtilisateurModif;
    String MDPUtilisateurModif;
    String RoleUtilisateurModif;
    String PseudoUtilisateurModif;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        //Initialisation de l'utilisation de la memoire interne
        //SharedPreferences UserProfile = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);

        //Pour recuperer les informations depuis le service
        //String UserName = UserProfile.getString(Services.UserName,"");

        //Initialisation de l'ecriture
        //Editor editor = UserProfile.edit();

        //Pour ecrire les informations dans le service
        //String test = "banana";
        //editor.putString(Services.UserName, test);

        //Pour sauver les informations
        //editor.apply();

        bModifier=(Button)findViewById(R.id.bModifier);
        bNouveau=(Button)findViewById(R.id.bNouveau);
        bSupprimer=(Button)findViewById(R.id.bSupprimer);
        bModifier.setVisibility(View.INVISIBLE);
        bSupprimer.setVisibility(View.INVISIBLE);
        bNouveau.setVisibility(View.INVISIBLE);

        ListeUtilisateurs= (ListView)findViewById(R.id.ltvUtilisateur);
        final ArrayAdapter<UserClass> adapter =new MyListAdapter();
        ListeUtilisateurs.setAdapter(adapter);
        PopulateUserList();

        ListeUtilisateurs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListeUtilisateurs.setSelector(R.drawable.button);
                bModifier.setVisibility(View.VISIBLE);
                bSupprimer.setVisibility(View.VISIBLE);
                bNouveau.setVisibility(View.VISIBLE);

                UserClass sellUser=(UserClass) adapter.getItem(position);

                // ----------------Delete-------------//
                IDUtilisateurDel=sellUser.getID().toString();
                PseudoUtilisateurDel=sellUser.getPseudo().toString();


               //---------------Modifer---------------//
                IDUtilisateurModif=sellUser.getID().toString();
                PseudoUtilisateurModif=sellUser.getPseudo().toString();
                NomUtilisateurModif=sellUser.getNom();
                PrenomUtilisateurModif=sellUser.getPrenom();
                MDPUtilisateurModif=sellUser.getMDP();
                RoleUtilisateurModif=sellUser.getRole();



            }
        });
        bSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences UserDel = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
                SharedPreferences.Editor editorDel = UserDel.edit();
                editorDel .putString(Services.DeleteUserID,IDUtilisateurDel);
                editorDel .apply();
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////////Fonction qui écris le nouveau Service.ID dans bluefetch del ID///////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT; Toast toast = Toast.makeText(context,PseudoUtilisateurDel+" à été supprimé", duration);
                toast.show();
                Intent ApresDel=new Intent(Users.this,Users.class);
                startActivity(ApresDel);
                finish();
            }
        });

        bNouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewUser=new Intent(Users.this,AjouterModifer.class);
                startActivity(NewUser);
                finish();
            }
        });
        bModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ModifyUser=new Intent(Users.this,AjouterModifer.class);
                ModifyUser.putExtra("ModifyPseudo",PseudoUtilisateurModif);
                ModifyUser.putExtra("ModifyNom",NomUtilisateurModif);
                ModifyUser.putExtra("ModifyPrenom",PrenomUtilisateurModif);
                ModifyUser.putExtra("ModifyMDP",MDPUtilisateurModif);
                ModifyUser.putExtra("ModifyRole",RoleUtilisateurModif);
                ModifyUser.putExtra("ModifyID",IDUtilisateurModif);
                startActivity(ModifyUser);
                finish();
            }
        });

   }
    private class MyListAdapter extends ArrayAdapter<UserClass>
    {
        public MyListAdapter(){super(Users.this,R.layout.item_view,MyUsers);}
        @Override
        public View getView(int position,View convertView, ViewGroup parent)
        {
            View ItemView =convertView;
            if(ItemView==null){
                ItemView= getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }


            //------------------------------Fill the view------------------------------//
            UserClass CurrentUsers=MyUsers.get(position);



            //----------VIDE --------//
            TextView HeureTextView=(TextView)ItemView.findViewById(R.id.item_HeureTxt);
            HeureTextView.setText("");

            //-------------VIDE------------//
            TextView DateTextView=(TextView)ItemView.findViewById(R.id.item_DateTxt);
            DateTextView.setText("");

            //-------------VIDE-------------//
            TextView StatusTextView=(TextView)ItemView.findViewById(R.id.item_StatutTxt);
            StatusTextView.setText("");

            //-------------VIDE------------//

            TextView UtilisateurTextView=(TextView)ItemView.findViewById(R.id.item_IDutilisateurTxt);
            UtilisateurTextView.setText("");


            //-------------PSEUDO-----------//
            TextView MessageTextView=(TextView)ItemView.findViewById(R.id.item_MessageTxt);
            MessageTextView.setText(CurrentUsers.getPseudo());

            return ItemView;
        }

    }

    private void PopulateUserList() {



        //Initialisation de l'utilisation de la memoire interne
        SharedPreferences UserProfile = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
        Editor editor = UserProfile.edit();

       //------------------------------ On va recevoir le nombre d'utilisateur de la base de données-------------------///
        editor.putInt(Services.NombreUtilisateurs, BlueFetch.BlfNombreUtilisateur);


        editor.putInt(ExterneUserID,BlueFetch.IDExternUser);
        editor.putString(ExterneUserName,BlueFetch.ExternPseudoName.toString());
        editor.putString(ExterneFirstName,BlueFetch.ExternUserFirstName);
        editor.putString(ExterneLastName,BlueFetch.ExternUserName);
        editor.putString(ExternePassword,BlueFetch.ExterneMotDePasse);
        editor.putString(ExterneUserRole,BlueFetch.ExternUserRoles);


       //Pour sauver les informations
        editor.apply();

        //Pour recuperer les informations depuis le service
        Integer fois = UserProfile.getInt(Services.NombreUtilisateurs,0);
        int i;

        for (i=0; i<fois; i++) {
            ////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////
            ///////////Fonction qui retourne le nom et le reste de l'utilisateur num 1,2,3,4////////////
            ////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////

            String Recuperation=UserProfile.getString(Services.ExterneUserName,"");
            Integer Recuperation2=UserProfile.getInt(Services.ExterneUserID, 0);
            String Recuperation3=UserProfile.getString(Services.ExterneFirstName,"");
            String Recuperation4=UserProfile.getString(Services.ExterneLastName,"");
            String Recuperation5=UserProfile.getString(Services.ExternePassword,"");
            String Recuperation6=UserProfile.getString(Services.ExterneUserRole,"");

            UserClass User=new UserClass(Recuperation4, Recuperation3, Recuperation6, Recuperation5,Recuperation,  Recuperation2);
            MyUsers.add(User);
        }





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.Users) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

class UserClass {

    String Nom;
    String Prenom;
    String Role;
    String MDP;
    String Pseudo;
    int IDUser;




    public UserClass(String sNom,String sPrenom,String sRole,String sMDP,String sPseudo,Integer iMessageEnvoyer) {
        super();
        Nom=sNom;
        Prenom=sPrenom;
        Role=sRole;
        MDP=sMDP;
        Pseudo=sPseudo;
        IDUser=iMessageEnvoyer;

    }

    public String getNom()
    {
        return Nom;
    }
    public String getPrenom()
    {
        return Prenom;
    }
    public String getRole()
    {
        return Role;
    }
    public String getMDP()
    {
        return MDP;
    }
    public String getPseudo()
    {
        return Pseudo;
    }
    public Integer getID()
    {
        return IDUser;
    }
    public void setNom(String NNom)
    {
        Nom=NNom;
    }
    public void setPrenom(String NPrenom)
    {
        Prenom=NPrenom;
    }
    public void setRole(String NRole)
    {
        Role=NRole;
    }
    public void setMDP(String NMDP)
    {
        MDP=NMDP;
    }
    public void setPseudo(String NPseudo)
    {
        Pseudo=NPseudo;
    }



}
