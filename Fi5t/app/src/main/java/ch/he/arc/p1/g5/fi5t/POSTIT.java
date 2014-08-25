package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class POSTIT extends Services {
    private List<Message> MyMessages =new ArrayList<Message>();
    SearchView SearchMessage;
    String Tamp="";
    EditText message;
   


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postit);
        SearchMessage=(SearchView)findViewById(R.id.searchviewPostit);

        message = (EditText) findViewById(R.id.extractEditText);
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        message.addTextChangedListener(new TextWatcher() {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                prefs.edit().putString("autoSave", s.toString()).commit();
                Toast toast = Toast.makeText(context,s.toString(), duration);
                toast.show();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });



        SearchMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearchRequested();
            }
        });
        SearchMessage.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(query!=null)
                {

                    Tamp=query;
                    message.setText(Tamp);
                    Intent intent = new Intent(getApplicationContext(), POSTIT.class);
                    startActivity(intent);
                    finish();

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;

            }
        });
        PopulateMessageList();
        PopulateListView();

    }


    private void PopulateListView() {
        ArrayAdapter<Message> adapter =new MyListAdapter();
        ListView List =(ListView)findViewById(R.id.listViewPostIt);
        List.setAdapter(adapter);
    }
    private class MyListAdapter extends ArrayAdapter<Message>
    {
        public MyListAdapter(){super(POSTIT.this,R.layout.item_view,MyMessages);}
        @Override
        public View getView(int position,View convertView, ViewGroup parent)
        {
            View ItemView =convertView;
            if(ItemView==null){
                ItemView= getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }


            //------------------------------Fill the view------------------------------//
            Message CurrentMessage=MyMessages.get(position);



            //----------Heure --------//
            TextView HeureTextView=(TextView)ItemView.findViewById(R.id.item_HeureTxt);
            HeureTextView.setText(CurrentMessage.getHeure());

            //-------------Date-------------//
            TextView DateTextView=(TextView)ItemView.findViewById(R.id.item_DateTxt);
            DateTextView.setText(CurrentMessage.getDate());

            //-------------Status-------------//
            TextView StatusTextView=(TextView)ItemView.findViewById(R.id.item_StatutTxt);
            StatusTextView.setText(CurrentMessage.getStatus());

            //-------------IDutilisateur------------//

            TextView UtilisateurTextView=(TextView)ItemView.findViewById(R.id.item_IDutilisateurTxt);
            UtilisateurTextView.setText(CurrentMessage.getIDUtilisateur());


            //-------------IDutilisateur------------//
            TextView MessageTextView=(TextView)ItemView.findViewById(R.id.item_MessageTxt);
            MessageTextView.setText(CurrentMessage.getMessages());

            return ItemView;
        }

    }

    private void PopulateMessageList() {

            if(message.getText().toString()=="Seb")
            {
                Tamp=message.getText().toString();
            }
            Message Message1 =new Message("12.08.2014", "12:00", "NonLu", "Maman est à la maison", "SuperMama", 6);
            if(Tamp==""||Tamp==Message1.getIDUtilisateur())
            {
                MyMessages.add(Message1);
            }
            Message Message2=new Message("12.08.2014", "11:49", "NonLu", "Je t'aime mon Fils", "SuperMama", 5);
            if(Tamp==""||Tamp==Message2.getIDUtilisateur())
            {
                MyMessages.add(Message2);
            }
            Message Message3=new Message("12.08.2014", "11:41", "NonLu", "bonne journée", "Seb", 4);
            if(Tamp==""||Tamp==Message3.getIDUtilisateur())
            {
                MyMessages.add(Message3);
            }
            Message Message4=new Message("12.08.2014", "11:39", "NonLu", "Vivement les vacances", "Seb", 3);
            if(Tamp==""||Tamp==Message4.getIDUtilisateur())
            {
                MyMessages.add(Message4);
            }
            Message Message5=new Message("12.08.2014", "11:33", "NonLu", "Faudra recouvrir mes livres bisous", "Jordane", 2);
            if(Tamp==""||Tamp==Message5.getIDUtilisateur())
            {
                MyMessages.add(Message5);
            }
            Message Message6=new Message("12.08.2014", "11:33", "NonLu", "Le début des cours :D", "Jordane", 1);
            if(Tamp==""||Tamp==Message6.getIDUtilisateur())
            {
                MyMessages.add(Message6);
            }

            // for (int 0 au nombre élément dans la base de donnée -1, create Element
            // Si élément.getID=tamp add sinon pas ajouter.

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.postit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.PostIt) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
