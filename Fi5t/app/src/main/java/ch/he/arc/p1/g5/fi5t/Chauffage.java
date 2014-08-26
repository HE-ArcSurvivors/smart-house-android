package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class Chauffage extends Services{
    Button bValiderTemp;
    TextView txvTemp;
    EditText edtTempMin;
    EditText edtTempMax;
    SeekBar  skTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chauffage);
        bValiderTemp=(Button)findViewById(R.id.bValiderTemp);
        txvTemp=(TextView)findViewById(R.id.txtVTemp);
        edtTempMax=(EditText)findViewById(R.id.edtTempMax);
        edtTempMin=(EditText)findViewById(R.id.edtTempMin);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chauffage, menu);
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
