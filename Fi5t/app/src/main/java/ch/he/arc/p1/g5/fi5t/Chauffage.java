package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
    TextView txvTemp, tvTempExterne, tvTempInterne;
    EditText edtTempMin;
    EditText edtTempMax;
    SeekBar  skTemp;
    Integer Secure=0;
    String data,send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chauffage);


        //------------------------Déclaration de variable------------------------------//

        txvTemp=(TextView)findViewById(R.id.txtVTemp);
        edtTempMax=(EditText)findViewById(R.id.edtTempMax);
        edtTempMin=(EditText)findViewById(R.id.edtTempMin);

        tvTempExterne=(TextView)findViewById(R.id.tvTempExterne);
        tvTempInterne=(TextView)findViewById(R.id.tvTempInterne);

        //------------------------Déclaration de variable------------------------------//



        new Thread(new Runnable() {
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        data = "31";
                        for (int i = 0; i < data.length(); i++) {
                            send = "" + data.charAt(i);
                            Connection.sendMessage(send);
                        }
                    }
                });

                SystemClock.sleep(500);

                runOnUiThread(new Runnable() {
                    public void run() {

                        tvTempInterne.setText(BlueFetch.ReceivedResponse);

                    }
                });

                SystemClock.sleep(1000);

                runOnUiThread(new Runnable() {
                    public void run() {
                        data = "32";
                        for (int i = 0; i < data.length(); i++) {
                            send = "" + data.charAt(i);
                            Connection.sendMessage(send);
                        }
                    }
                });

                SystemClock.sleep(500);

                runOnUiThread(new Runnable() {
                    public void run() {

                        tvTempExterne.setText(BlueFetch.ReceivedResponse);
                    }
                });


            }
        }).start();

       SharedPreferences UserChauffage = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
       SharedPreferences.Editor editorChauffage = UserChauffage.edit();

        editorChauffage.putInt(Services.TemperatureChauffage,BlueFetch.TemperatureActuelle);
        editorChauffage.putInt(Services.TemperatureChauffageMax,BlueFetch.TemperatureMaximum);
        editorChauffage.putInt(Services.TemperatureChauffageMin,BlueFetch.TemperatureMinimum);
        editorChauffage.apply();

        Integer TempActuRecu=UserChauffage.getInt(Services.TemperatureChauffage,0);
        Integer TempMaxRecu=UserChauffage.getInt(Services.TemperatureChauffageMax,0);
        Integer TempMinRecu=UserChauffage.getInt(Services.TemperatureChauffageMin,0);
        edtTempMax.setText(TempMaxRecu.toString());
        edtTempMin.setText(TempMinRecu.toString());
        txvTemp.setText(TempActuRecu.toString());
        skTemp=(SeekBar)findViewById(R.id.seekBar);
        bValiderTextChange=(Button)findViewById(R.id.bTextChange);

        Integer iTempMax= Integer.parseInt(edtTempMax.getText().toString());
        final Integer iTempMin=Integer.parseInt(edtTempMin.getText().toString());
        Integer iTemp=iTempMax-iTempMin;
        skTemp.setMax(iTemp);







        //-------------------------------Validation---------------------------------//
        bValiderTemp=(Button)findViewById(R.id.bValiderTemp);
        bValiderTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences UserProfile = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
                SharedPreferences.Editor editor = UserProfile.edit();
                editor.putInt(Services.TemperatureChauffage, iTempMin);
                editor.apply();

                BlueFetch.TemperatureActuelle = iTempMin;

                new Thread(new Runnable() {
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                data = "30";
                                for (int i = 0; i < data.length(); i++) {
                                    send = "" + data.charAt(i);
                                    Connection.sendMessage(send);
                                }
                            }
                        });

                        SystemClock.sleep(500);

                        runOnUiThread(new Runnable() {
                            public void run() {

                                data = iTempMin.toString();
                                for (int i = 0; i < data.length(); i++) {
                                    send = "" + data.charAt(i);
                                    Connection.sendMessage(send);
                                }


                            }
                        });

                    }
                }).start();



            }
        });
        //-------------------------------Validation---------------------------------//

        //------------------Changement seekbar-------------------------------------//

        skTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
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

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        });
        //------------------Changement seekbar-------------------------------------//


        //-----------------------Validation d'éditage----------------------------//
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
        //-----------------------Validation d'éditage----------------------------//

        //-------------------------Editage---------------------------------------//
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
        //-------------------------Editage---------------------------------------//





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
