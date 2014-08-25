package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MonProfil extends Services {

    TextView tvNom, tvPrenom, tvID, tvRole;
    boolean error=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);

        tvNom = (TextView) findViewById(R.id.tvNom);
        tvPrenom = (TextView) findViewById(R.id.tvPrenom);
        tvID = (TextView) findViewById(R.id.tvID);
        tvRole = (TextView) findViewById(R.id.tvRole);


        SharedPreferences sharedProfile = getSharedPreferences(MyProfile, Context.MODE_PRIVATE);
        if (sharedProfile.contains(FirstName)){
            tvNom.setText(sharedProfile.getString(FirstName, ""));
        }else{
            error = true;
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mon_profil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.MonProfil) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
