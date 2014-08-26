package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class Chauffage extends Services{
    Button bValiderTemp;
    Button bValiderTextChange;
    TextView txvTemp;
    EditText edtTempMin;
    EditText edtTempMax;
    SeekBar  skTemp;
    Integer Secure=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chauffage);

        bValiderTemp=(Button)findViewById(R.id.bValiderTemp);
        txvTemp=(TextView)findViewById(R.id.txtVTemp);
        edtTempMax=(EditText)findViewById(R.id.edtTempMax);
        edtTempMin=(EditText)findViewById(R.id.edtTempMin);
        skTemp=(SeekBar)findViewById(R.id.seekBar);
        bValiderTextChange=(Button)findViewById(R.id.bTextChange);
        txvTemp.setText(edtTempMin.getText().toString());
        Integer iTempMax= Integer.parseInt(edtTempMax.getText().toString());
        Integer iTempMin=Integer.parseInt(edtTempMin.getText().toString());
        Integer iTemp=iTempMax-iTempMin;
        skTemp.setMax(iTemp);

        skTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(Secure==0)
                {
                    Integer iTempMin=Integer.parseInt(edtTempMin.getText().toString());
                    iTempMin+=skTemp.getProgress();
                    txvTemp.setText(iTempMin.toString());}
                else
                {Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context,"Veuillez valider la saisie", duration);
                    toast.show();}


            }
        });

        bValiderTextChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bValiderTextChange.setTextColor(Color.parseColor("#FFFFFFFF"));
                SystemClock.sleep(1000);
                bValiderTextChange.setTextColor(Color.parseColor("#FF000000"));
                Integer iTempMax = Integer.parseInt(edtTempMax.getText().toString());
                Integer iTempMin = Integer.parseInt(edtTempMin.getText().toString());

                if (iTempMin >= 5 && iTempMin < iTempMax && iTempMax <= 40) {
                    Integer iTemp = iTempMax - iTempMin;
                    skTemp.setMax(iTemp);
                    bValiderTextChange.setVisibility(View.INVISIBLE);
                    Secure = 0;
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Veuillez vérifier la syntaxe de votre saisie (température max=40°)", duration);
                    toast.show();
                }
            }
        });

        edtTempMax.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {

                    bValiderTextChange.setVisibility(View.VISIBLE);
                    Secure++;

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        edtTempMin.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {



                bValiderTextChange.setVisibility(View.VISIBLE);
                Secure++;



            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });





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
