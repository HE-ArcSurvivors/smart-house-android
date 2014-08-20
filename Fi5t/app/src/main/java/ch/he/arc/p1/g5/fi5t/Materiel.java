package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class Materiel extends Menu_Activity {

    ListView LvMats;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiel);
        LvMats = (ListView) findViewById(R.id.lvMateriel);
        String[] MyItems = {"Matériel1 est Connectée", "Matériel2", "Matériel3", "Matériel4", "Matériel5", "Matériel6", "Matériel7", "Matériel8", "Matériel9", "Matériel10"};
        LvMats.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MyItems));
        LvMats = (ListView) findViewById(R.id.lvMateriel);
        LvMats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CharSequence Connect =((TextView)view).getText();
                Float Num=((TextView)view).getTextSize();


                String ConnectS=Connect.toString();
                CharSequence searchString = "est Connectée";
                // Test if parentString contains the searchString
                if(ConnectS.contains(searchString)){

                    ConnectS=ConnectS.substring(0,10); // Nom du périphérique doit être fixe.
                    ((TextView)view).setText(ConnectS);
                    ((TextView)view).onSaveInstanceState();
                }
                else{
                    ((TextView)view).setText(Connect+" est Connectée");

                }
            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.materiel, menu);
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
