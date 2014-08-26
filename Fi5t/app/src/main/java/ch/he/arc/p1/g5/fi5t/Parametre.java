package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Parametre extends Services {

    Button bBluetoothCMD;
    Button bReglageChauffage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,"Paramètre", duration);
        toast.show();
        bReglageChauffage=(Button)findViewById(R.id.bReglagesChauffage);
        bReglageChauffage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bReglageChauffage.setTextColor(Color.parseColor("#FFFFFFFF"));
                Intent Chauffage=new Intent(Parametre.this,Chauffage.class);
                startActivity(Chauffage);
                finish();
            }
        });
        bBluetoothCMD = (Button) findViewById(R.id.bBluetoothCMD);

        bBluetoothCMD.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                bBluetoothCMD.setTextColor(Color.parseColor("#FFFFFFFF"));
                startActivity(new Intent (Parametre.this, BlueTests.class));
                finish();

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parametre, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.Parameter) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
