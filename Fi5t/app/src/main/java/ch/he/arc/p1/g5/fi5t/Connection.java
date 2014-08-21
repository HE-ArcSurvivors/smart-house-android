package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Connection extends Activity {
    Button bConnecter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        bConnecter=(Button)findViewById(R.id.bConnecter);
        bConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iConnectMain =new Intent(Connection.this,Main.class);
                startActivity(iConnectMain);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.connection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.PageAccueil) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
