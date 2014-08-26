package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
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


    //-----------------ListView------------------------//////
    ListView ListeUtilisateurs ;


    //------------------------Autres---------------------------------------/////
    private List<UserClass> MyUsers =new ArrayList<UserClass>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

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
            HeureTextView.setText(CurrentUsers.getPrenom());

            //-------------Date-------------//
            TextView DateTextView=(TextView)ItemView.findViewById(R.id.item_DateTxt);
            DateTextView.setText(CurrentUsers.getNom());

            //-------------Status-------------//
            TextView StatusTextView=(TextView)ItemView.findViewById(R.id.item_StatutTxt);
            StatusTextView.setText(CurrentUsers.getRole());

            //-------------IDutilisateur------------//

            TextView UtilisateurTextView=(TextView)ItemView.findViewById(R.id.item_IDutilisateurTxt);
            UtilisateurTextView.setText(CurrentUsers.getMDP());


            //-------------IDutilisateur------------//
            TextView MessageTextView=(TextView)ItemView.findViewById(R.id.item_MessageTxt);
            MessageTextView.setText(CurrentUsers.getPseudo());

            return ItemView;
        }

    }

    private void PopulateUserList() {


        UserClass User=new UserClass("Raphaël", "Schaffo", "Admin", "DarkRanger22", "273GJHG", 1);

            MyUsers.add(User);




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
