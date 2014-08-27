package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Users extends Services {


    //----------------------Button--------------------//////
    Button bModifier;
    Button bNouveau;
    Button bSupprimer;
    Integer iNombreUtilisateur;


    //-----------------ListView------------------------//////
    ListView ListeUtilisateurs ;


    //------------------------Autres---------------------------------------/////
    private List<UserClass> MyUsers =new ArrayList<UserClass>();


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
        ListeUtilisateurs= (ListView)findViewById(R.id.ltvUtilisateur);

        final ArrayAdapter<UserClass> adapter =new MyListAdapter();
        ListeUtilisateurs.setAdapter(adapter);
        PopulateUserList();


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



            //----------Heure --------//
            TextView HeureTextView=(TextView)ItemView.findViewById(R.id.item_HeureTxt);
            HeureTextView.setText("");

            //-------------Date-------------//
            TextView DateTextView=(TextView)ItemView.findViewById(R.id.item_DateTxt);
            DateTextView.setText("");

            //-------------Status-------------//
            TextView StatusTextView=(TextView)ItemView.findViewById(R.id.item_StatutTxt);
            StatusTextView.setText("");

            //-------------IDutilisateur------------//

            TextView UtilisateurTextView=(TextView)ItemView.findViewById(R.id.item_IDutilisateurTxt);
            UtilisateurTextView.setText("");


            //-------------IDutilisateur------------//
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
        String nom = "Rémininator";
        Integer nombre = 2;
        //------------------------------ On va recevoir le nombre d'utilisateur de la base de données-------------------///
        editor.putInt(Services.NombreUtilisateurs, nombre);
        editor.putString(ExterneUserName, nom);

        //Pour sauver les informations
        editor.apply();

        //Pour recuperer les informations depuis le service
        Integer fois = UserProfile.getInt(Services.NombreUtilisateurs,0);
        int i;
        for (i=0; i<fois; i++) {
            String Recuperation=UserProfile.getString(Services.ExterneUserName,"");
            UserClass User=new UserClass("", "", "", "",Recuperation,  1);
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
    int MessageEnvoyer;




    public UserClass(String sNom,String sPrenom,String sRole,String sMDP,String sPseudo,Integer iMessageEnvoyer) {
        super();
        Nom=sNom;
        Prenom=sPrenom;
        Role=sRole;
        MDP=sMDP;
        Pseudo=sPseudo;
        MessageEnvoyer=iMessageEnvoyer;

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
    public Integer getImessage()
    {
        return MessageEnvoyer;
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
