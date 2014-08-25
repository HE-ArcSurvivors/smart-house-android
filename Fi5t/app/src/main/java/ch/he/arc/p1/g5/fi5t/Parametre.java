package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Parametre extends Services {

    Button bBluetoothCMD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);

        bBluetoothCMD = (Button) findViewById(R.id.bBluetoothCMD);

        bBluetoothCMD.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

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
