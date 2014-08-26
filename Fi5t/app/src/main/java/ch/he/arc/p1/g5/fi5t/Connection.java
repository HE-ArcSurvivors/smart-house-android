package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;


public class Connection extends Activity {

    Button bBlueTests, bLogin;
    TextView dStatus;
    ProgressBar mProgress;
    CheckBox cbRemember;
    EditText dUsername, dPassword;
    SharedPreferences savedUser;
    String sUsername;
    String sPassword;
    Boolean blnChecked;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        //Intent myIntent = new Intent (Connection.this, MonProfil.class);
        //startActivity(myIntent);
        //finish();

        Context context = getApplicationContext();
        SharedPreferences sharedProfile = getSharedPreferences(Services.MyProfile,MODE_PRIVATE);
        String string = sharedProfile.getString(Services.LastName,"");
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, string, duration).show();

        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        dUsername = (EditText) findViewById(R.id.dUsername);
        bLogin = (Button) findViewById(R.id.bLogin);

        savedUser = getSharedPreferences(Services.MyProfile, Context.MODE_PRIVATE);

        bBlueTests = (Button) findViewById(R.id.bBluetests);
        dStatus = (TextView) findViewById(R.id.dStatus);
        dPassword = (EditText) findViewById(R.id.dPassword);
        mProgress = (ProgressBar) findViewById(R.id.progressBarLogin);


        boolean checkBoxValue = savedUser.getBoolean(Services.RememberMeCheckbox, false);
        if (checkBoxValue) {
            cbRemember.setChecked(true);
            if (savedUser.contains(Services.UserName)){
                dUsername.setText(savedUser.getString(Services.UserName, ""));
            }
            if (savedUser.contains(Services.Password)){
                dPassword.setText(savedUser.getString(Services.Password, ""));
            }
        }



        mProgress.setVisibility(View.INVISIBLE);

        bBlueTests.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                startActivity(new Intent (Connection.this, BlueTests.class));


            }

        });
        

        bLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                //SystemClock.sleep(2000);

                dStatus.setText("Connection in Progress");

                mProgress.setVisibility(View.VISIBLE);

                bLogin.setEnabled(false);



                sPassword = dPassword.getText().toString();
                sUsername = dUsername.getText().toString();
                blnChecked = cbRemember.isChecked();

                if (sPassword.matches(BlueFetch.AuthorizedPassword) && sUsername.matches(BlueFetch.AuthorizedUsername)) {

                    Editor editor = savedUser.edit();
                    editor.putBoolean(Services.RememberMeCheckbox, blnChecked);
                    editor.putString(Services.UserName, sUsername);
                    editor.putString(Services.Password, sPassword);
                    editor.apply();


                    // Create Inner Thread Class
                    new Thread(new Runnable() {
                        public void run() {

                            SystemClock.sleep(1000);

                            mProgress.post(new Runnable() {
                                public void run() {
                                    mProgress.setVisibility(View.INVISIBLE);
                                }
                            });

                            dStatus.post(new Runnable() {
                                public void run() {
                                    dStatus.setText("Connected!");
                                }
                            });

                            SystemClock.sleep(500);

                            runOnUiThread(new Runnable() {
                                public void run() {
                                    // some code that needs to be ran in UI thread
                                    Intent myIntent = new Intent(Connection.this, Main.class);

                                    startActivity(myIntent);

                                    finish();


                                }
                            });


                        }
                    }).start();
                }else{

                    new Thread(new Runnable() {
                        public void run() {

                            SystemClock.sleep(1000);

                            mProgress.post(new Runnable() {
                                public void run() {
                                    mProgress.setVisibility(View.INVISIBLE);
                                }
                            });

                            dStatus.post(new Runnable() {
                                public void run() {
                                    dStatus.setText("Mauvais \n Username ou Password!");
                                }
                            });



                        }
                    }).start();
                    bLogin.setEnabled(true);

                }




/*
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Connection...");
                alertDialog.setMessage("You are are now connected");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });
                alertDialog.show();

*/
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
