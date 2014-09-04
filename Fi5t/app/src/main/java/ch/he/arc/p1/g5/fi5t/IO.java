package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;


public class IO extends Activity {

    Switch switchPorte;
    Button ValiderIO;

    String message,data,send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);
        switchPorte = (Switch)findViewById(R.id.switchPorte);

        new Thread(new Runnable() {
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        message = "22" + "\0";
                        int lengthOfMessage = message.length();
                        //Toast.makeText(getApplicationContext(), "before: " + lengthOfMessage, Toast.LENGTH_SHORT).show();
                        for (int i=lengthOfMessage;i<140;i++) {
                            message = message + " ";
                        }
                        Connection.sendMessage(message);
                    }
                });

                SystemClock.sleep(500);

                runOnUiThread(new Runnable() {
                    public void run() {
                        BlueFetch.DoorStatus = BlueFetch.ReceivedResponse;
                        if(BlueFetch.DoorStatus.matches("1"))
                        {
                            switchPorte.setChecked(true);
                        }else{
                            switchPorte.setChecked(false);
                        }
                    }
                });
            }
        }).start();

        switchPorte.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    BlueFetch.DoorStatus="1";
                    //open door
                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    message = "20" + "\0";
                                    int lengthOfMessage = message.length();
                                    //Toast.makeText(getApplicationContext(), "before: " + lengthOfMessage, Toast.LENGTH_SHORT).show();
                                    for (int i=lengthOfMessage;i<140;i++) {
                                        message = message + " ";
                                    }
                                    Connection.sendMessage(message);
                                }
                            });
                        }
                    }).start();
                } else {
                    BlueFetch.DoorStatus="0";
                    //Close door
                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    message = "21" + "\0";
                                    int lengthOfMessage = message.length();
                                    //Toast.makeText(getApplicationContext(), "before: " + lengthOfMessage, Toast.LENGTH_SHORT).show();
                                    for (int i=lengthOfMessage;i<140;i++) {
                                        message = message + " ";
                                    }
                                    Connection.sendMessage(message);
                                }
                            });
                        }
                    }).start();

                }
            }
        });


        ValiderIO=(Button)findViewById(R.id.bValiderIO);
        ValiderIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Main=new Intent(IO.this,Main.class);
                startActivity(Main);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.io, menu);
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
