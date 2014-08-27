package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class LecturePostIt extends Services {
    TextView TUtilisateur;
    TextView Date;
    TextView Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_post_it);


        TUtilisateur=(TextView)findViewById(R.id.txVPseudo);
        Date=(TextView)findViewById(R.id.txvDateHeure);
        Message=(TextView)findViewById(R.id.txvMessage);

            Intent intent = getIntent();
            String IDUtilisateur = intent.getStringExtra("RecupID");
            String RecupDate = intent.getStringExtra("RecupDate");
            String RecupMessage = intent.getStringExtra("RecupMessages");


            TUtilisateur.setText(IDUtilisateur);
            Date.setText(RecupDate);
            Message.setText(RecupMessage);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lecture_post_it, menu);
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
