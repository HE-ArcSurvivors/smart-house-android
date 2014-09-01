package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    ListView List;
    String Tamp="";
    String DataInstance="";
    String POPUP;
    Button Newmessage;

    String RecupID;
    String RecupMessage;
    String RecupDate;
    String RecupHeure;
    String RecupStatus;

   


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postit);


        Newmessage=(Button)findViewById(R.id.bNewMessage);
        Newmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Newmessage.setTextColor(Color.parseColor("#FFFFFFFF"));
                Intent NewMessageInstance=new Intent(POSTIT.this,NewMessage.class);
                startActivity(NewMessageInstance);
                finish();
            }
        });

        SearchMessage=(SearchView)findViewById(R.id.searchviewPostit);
        SearchMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearchRequested();
            }
        });


        try
        {

            DataInstance=getIntent().getExtras().getString("valenvoyer");
            POPUP="Message de "+ DataInstance;
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT; Toast toast = Toast.makeText(context,POPUP, duration);
            toast.show();
            Tamp=DataInstance;

        }
        catch(Exception e)
        {   Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT; Toast toast = Toast.makeText(context,"Post-Its", duration);
            toast.show(); }

        final ArrayAdapter<Message> adapter =new MyListAdapter();
        List =(ListView)findViewById(R.id.listViewPostIt);
        List.setAdapter(adapter);
        PopulateMessageList();
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //------------------Modifer Status du Message--------------------/////////



                //------------------Modifer Status du Message--------------------/////////
                Message selItem = (Message) adapter.getItem(position);
                RecupID=selItem.getIDUtilisateur();
                RecupMessage=selItem.getMessages();
                RecupStatus=selItem.getStatus();
                RecupHeure=selItem.getHeure();
                RecupDate=selItem.getDate();

                Intent LecturePostit=new Intent(POSTIT.this,LecturePostIt.class);
                LecturePostit.putExtra("RecupID",RecupID);
                LecturePostit.putExtra("RecupMessages",RecupMessage);
                LecturePostit.putExtra("RecupStatus",RecupStatus);
                LecturePostit.putExtra("RecupDate",RecupHeure+" / " + RecupDate);
                startActivity(LecturePostit);




            }
        });




                SearchMessage.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query!=null)
                {
                    Tamp=query;
                    DataInstance=Tamp;
                    Intent Instance1= new Intent(POSTIT.this,POSTIT.class);
                    Instance1.putExtra("valenvoyer",DataInstance.toString());
                    startActivity(Instance1);
                    finish();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


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

        SharedPreferences MessageProfile = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
        SharedPreferences.Editor editorMessage = MessageProfile.edit();
        editorMessage.putInt(Services.NombrePOSTIT, BlueFetch.BlfNombrePOSTIT);
        editorMessage.putInt(ExternePOSTITID,BlueFetch.POSTITACTUID);
        editorMessage.putString(ExternePOSTITDATE,BlueFetch.POSTITDate);
        editorMessage.putString(ExternePOSTITHEURE,BlueFetch.POSTITHeure);
        editorMessage.putString(ExternePOSTITENVOYERPSEUDO,BlueFetch.POSTITSENDPseudo);
        editorMessage.putString(ExternePOSTITMESSAGE,BlueFetch.POSTITMessage);
        editorMessage.putString(ExternePOSTITSTATUS,BlueFetch.POSTITStatus);
        editorMessage.apply();

        Integer fois = MessageProfile.getInt(Services.NombrePOSTIT,0);
        int i;

        for (i=0; i<fois; i++) {
            ////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////
            ///////////Fonction qui retourne le message et le reste du Postit num 1,2,3,4////////////
            ////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////

            String Recuperation4=MessageProfile.getString(Services.ExternePOSTITDATE,"");
            Integer Recuperation2=MessageProfile.getInt(Services.ExternePOSTITID, 0);
            String Recuperation3=MessageProfile.getString(Services.ExternePOSTITHEURE,"");
            String Recuperation=MessageProfile.getString(Services.ExternePOSTITENVOYERPSEUDO,"");
            String Recuperation5=MessageProfile.getString(Services.ExternePOSTITMESSAGE,"");
            String Recuperation6=MessageProfile.getString(Services.ExternePOSTITSTATUS,"");

            Message MessageNow=new Message(Recuperation4, Recuperation3, Recuperation6, Recuperation5,Recuperation,  Recuperation2);
            if(Tamp.matches("")==true||Tamp.matches(MessageNow.getIDUtilisateur())==true)
            {
                 MyMessages.add(MessageNow);
            }
        }







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
