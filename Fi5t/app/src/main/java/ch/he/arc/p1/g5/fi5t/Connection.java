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


public class Connection extends Activity {

    Button bBlueTests, bLogin;
    TextView dStatus;
    ProgressBar mProgress;
    CheckBox cbRemember;
    EditText dUsername, dPassword;
    SharedPreferences savedUser;
    String sUsername;
    String sPassword;

    public static final String UserPassword = "UserPasswordKey" ;
    public static final String Username = "UsernameKey" ;
    public static final String Password = "PasswordKey" ;
    public static final String Checkbox = "CheckboxKey" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        dUsername = (EditText) findViewById(R.id.dUsername);
        bLogin = (Button) findViewById(R.id.bLogin);

        savedUser = getSharedPreferences(UserPassword, Context.MODE_PRIVATE);

        Intent myIntent = new Intent (Connection.this, MonProfil.class);
        //Bundle bundle = new Bundle();
        //bundle.putInt("VAL", 1);
        //myIntent.putExtras(bundle);
        //myIntent.putExtra("firstKeyName","FirstKeyValue");
        //startActivity(myIntent);
        //finish();
<<<<<<< HEAD

=======
>>>>>>> f597e1154a63c6db0303b3e5d36d76b96120febc

        bBlueTests = (Button) findViewById(R.id.bBluetests);
        dStatus = (TextView) findViewById(R.id.dStatus);
        dPassword = (EditText) findViewById(R.id.dPassword);
        mProgress = (ProgressBar) findViewById(R.id.progressBarLogin);


        boolean checkBoxValue = savedUser.getBoolean(Checkbox, false);
        if (checkBoxValue) {
            cbRemember.setChecked(true);
            if (savedUser.contains(Username)){
                dUsername.setText(savedUser.getString(Username, ""));
            }
            if (savedUser.contains(Password)){
                dPassword.setText(savedUser.getString(Password, ""));
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

                String password  = dPassword.getText().toString();;
                String username  = dUsername.getText().toString();
                Boolean checked  = cbRemember.isChecked();
                Editor editor = savedUser.edit();
                editor.putBoolean(Checkbox, checked);
                editor.putString(Username, username);
                editor.putString(Password, password);
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
                                Intent myIntent = new Intent (Connection.this, Main.class);
                                //Bundle bundle = new Bundle();
                                //bundle.putInt("VAL", 1);
                                //myIntent.putExtras(bundle);

                                //myIntent.putExtra("firstKeyName","FirstKeyValue");

                                startActivity(myIntent);

                                finish();


                            }
                        });


                    }
                }).start();




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
