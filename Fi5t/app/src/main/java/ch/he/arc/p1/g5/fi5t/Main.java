package ch.he.arc.p1.g5.fi5t;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Services{
    private static final String TAG ="Page Accueil" ;


    // Variable utiliser pour les POST-IT

    Button bClosePostIt1, bClosePostIt2, bClosePostIt3, bEtatPorte,bReglages,bIO;
    ImageView iPostIt1, iPostIt2, iPostIt3, Im1;
    TextView tPostItDate1, tPostItDate2, tPostItDate3;
    TextView tPostItFrom1, tPostItFrom2, tPostItFrom3;
    TextView tPostItMessage1, tPostItMessage2, tPostItMessage3;
    TextView tNumberMorePostIts, tStringMorePostIts;

    String message;

    boolean test = true;

    String test2;
    String data;
    String send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      bIO=(Button)findViewById(R.id.bValiderIO);
        tStringMorePostIts = (TextView) findViewById(R.id.lgtMoreMessage);

        bIO=(Button)findViewById(R.id.bValiderIO);


        bIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bIO.setEnabled(false);

                if (test){

                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                  data = "P1";
//                                  for (int i = 0; i < data.length(); i++) {
//                                  send = "" + data.charAt(i);
//                                  Connection.sendMessage(send);
//                                  //SystemClock.sleep(100);
//
//                                  }
                                  Connection.sendMessage(data);
                                }
                            });

                            test = false;

                            SystemClock.sleep(500);


                            runOnUiThread(new Runnable() {
                                public void run() {
                                    //Connection.sendMessage("a");
//                                    send = "";

//                                    for (int i=0;i<20;i++){
//
//                                        if (BlueFetch.ReceivedResponse == "~"){
//                                            Toast.makeText(getApplicationContext(), "BREAK: " + BlueFetch.ReceivedResponse, Toast.LENGTH_SHORT).show();
//                                            break;
//                                        }
//                                        send = send + BlueFetch.ReceivedResponse;
//                                        SystemClock.sleep(50);
//
//                                    }
                                    tStringMorePostIts.setText("ouverte: "+BlueFetch.ReceivedResponse);

                                    //SystemClock.sleep(500);
//                                    tStringMorePostIts.setText("abc: "+send);
                                    //bIO.setEnabled(true);
                                    bIO.setText("Ouverte");
                                }
                            });
                        }
                    }).start();

                //bIO.setText("Sent: abc");
                //test = false;
                //SystemClock.sleep(200);
                //Toast.makeText(getApplicationContext(), "Recieved: " + BlueFetch.ReceivedResponse, Toast.LENGTH_SHORT).show();



                }
                else{
                    new Thread(new Runnable() {
                        public void run() {

                            runOnUiThread(new Runnable() {
                                public void run() {
                                    String data = "P0";
                                    String send;

//                                    for (int i = 0; i < data.length(); i++) {
//                                        send = "" + data.charAt(i);
//                                        Connection.sendMessage(send);
//
//                                        //SystemClock.sleep(100);
//                                    }
                                    Connection.sendMessage(data);
                                }
                            });


                            test = true;

                            SystemClock.sleep(500);
                            //bIO.setEnabled(true);
                            //test2 = BlueFetch.ReceivedResponse;

                            runOnUiThread(new Runnable() {
                                public void run() {
                                    //Connection.sendMessage("a");

                                    //SystemClock.sleep(500);
                                    tStringMorePostIts.setText("fermee: "+BlueFetch.ReceivedResponse);
                                    //bIO.setEnabled(true);
                                    bIO.setText("Fermee");
                                }
                            });
                        }
                    }).start();
                }

                }

        });

        //////// Initializing Blue Values //////

        //Get Door Status
        //Toast.makeText(getApplicationContext(), "Before: " + BlueFetch.ReceivedResponse, Toast.LENGTH_SHORT).show();
        //Connection.sendMessage("1, 22");
        //Connection.sendMessage("$$$");

        //SystemClock.sleep(50);
        //BlueFetch.DoorStatus = BlueFetch.ReceivedResponse;

        new Thread(new Runnable() {
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        data = "22";
                        for (int i = 0; i < data.length(); i++) {
                            send = "" + data.charAt(i);
                            Connection.sendMessage(send);
                        }
                    }
                });

                SystemClock.sleep(500);

                runOnUiThread(new Runnable() {
                    public void run() {
                        BlueFetch.DoorStatus = BlueFetch.ReceivedResponse;
                        if(BlueFetch.DoorStatus=="1")
                        {
                            Im1.setBackgroundResource(R.drawable.opendoor);
                        }else{
                            Im1.setBackgroundResource(R.drawable.closeddoor);
                        }
                    }
                });
            }
        }).start();

        Im1=(ImageView) findViewById(R.id.imageView);

        bReglages=(Button)findViewById(R.id.bReglages);
        bReglages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
               Intent ParametreInstance=new Intent(Main.this,Parametre.class);
                startActivity(ParametreInstance);

            }
        });

        //SystemClock.sleep(50);
        //Toast.makeText(getApplicationContext(), "CMD: " + BlueFetch.DoorStatus, Toast.LENGTH_SHORT).show();

        //SystemClock.sleep(50);
        //Connection.sendMessage("---\r\n");

        //Toast.makeText(getApplicationContext(), "End: " + BlueFetch.ReceivedResponse, Toast.LENGTH_SHORT).show();


//        if(BlueFetch.DoorStatus=="true")
//        {
//            Im1.setBackgroundResource(R.drawable.opendoor);
//        }else{
//            Im1.setBackgroundResource(R.drawable.closeddoor);
//        }

        bEtatPorte=(Button)findViewById(R.id.bEtatPortePrinc);

        bEtatPorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Door Status
                new Thread(new Runnable() {
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                data = "22";
                                for (int i = 0; i < data.length(); i++) {
                                    send = "" + data.charAt(i);
                                    Connection.sendMessage(send);
                                }
                            }
                        });

                        SystemClock.sleep(500);

                        runOnUiThread(new Runnable() {
                            public void run() {
                                BlueFetch.DoorStatus = BlueFetch.ReceivedResponse;
                                if(BlueFetch.DoorStatus=="1")
                                {
                                    Im1.setBackgroundResource(R.drawable.opendoor);
                                }else{
                                    Im1.setBackgroundResource(R.drawable.closeddoor);
                                }
                            }
                        });
                    }
                }).start();

                if(BlueFetch.DoorStatus=="1")
                {
                    //BlueFetch.DoorStatus="false";
                    Im1.setBackgroundResource(R.drawable.closeddoor);
                    bEtatPorte.setTextColor(Color.parseColor("#FFFF0000"));
                    //Close door
                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    data = "21";
                                    for (int i = 0; i < data.length(); i++) {
                                        send = "" + data.charAt(i);
                                        Connection.sendMessage(send);
                                    }
                                }
                            });
                        }
                    }).start();

                }else {
                    Im1.setBackgroundResource(R.drawable.opendoor);
                    //BlueFetch.DoorStatus="true";
                    bEtatPorte.setTextColor(Color.parseColor("#ff7a7a7a"));
                    //open door
                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    data = "20";
                                    for (int i = 0; i < data.length(); i++) {
                                        send = "" + data.charAt(i);
                                        Connection.sendMessage(send);
                                    }
                                }
                            });
                        }
                    }).start();

                }
            }
        });
//        bIO=(Button)findViewById(R.id.bValiderIO);
//        bIO.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent IO=new Intent(Main.this,IO.class);
//                startActivity(IO);
//                //finish();
//            }
//        });

        setPostIts();
    }



    public void setPostIts() {

        bClosePostIt1 = (Button) findViewById(R.id.bDelPostIt1);
        bClosePostIt2 = (Button) findViewById(R.id.bDelPostIt2);
        bClosePostIt3 = (Button) findViewById(R.id.bDelPostIt3);
        iPostIt1 = (ImageView) findViewById(R.id.imvpostit1);
        iPostIt2 = (ImageView) findViewById(R.id.imvpostit2);
        iPostIt3 = (ImageView) findViewById(R.id.imvpostit3);
        tPostItDate1 = (TextView) findViewById(R.id.smtDateHeure1);
        tPostItDate2 = (TextView) findViewById(R.id.smtDateHeure2);
        tPostItDate3 = (TextView) findViewById(R.id.smtDateHeure3);
        tPostItMessage1 = (TextView) findViewById(R.id.smtMessage1);
        tPostItMessage2 = (TextView) findViewById(R.id.smtMessage2);
        tPostItMessage3 = (TextView) findViewById(R.id.smtMessage3);
        tPostItFrom1 = (TextView) findViewById(R.id.smtUser3);
        tPostItFrom2 = (TextView) findViewById(R.id.smtUser2);
        tPostItFrom3 = (TextView) findViewById(R.id.smtUser3);




        iPostIt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LecturePostit=new Intent(Main.this,LecturePostIt.class);
                LecturePostit.putExtra("RecupID",tPostItFrom1.getText().toString());
                LecturePostit.putExtra("RecupDate",tPostItDate1.getText().toString());
                LecturePostit.putExtra("RecupMessages",tPostItMessage1.getText().toString());
                startActivity(LecturePostit);

            }
        });
        iPostIt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LecturePostit=new Intent(Main.this,LecturePostIt.class);
                LecturePostit.putExtra("RecupID",tPostItFrom2.getText().toString());
                LecturePostit.putExtra("RecupDate",tPostItDate2.getText().toString());
                LecturePostit.putExtra("RecupMessages",tPostItMessage2.getText().toString());
                startActivity(LecturePostit);

            }
        });
        iPostIt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LecturePostit=new Intent(Main.this,LecturePostIt.class);
                LecturePostit.putExtra("RecupID",tPostItFrom3.getText().toString());
                LecturePostit.putExtra("RecupDate",tPostItDate3.getText().toString());
                LecturePostit.putExtra("RecupMessages",tPostItMessage3.getText().toString());
                startActivity(LecturePostit);

            }
        });
        bClosePostIt1.setVisibility(View.INVISIBLE);
        bClosePostIt2.setVisibility(View.INVISIBLE);
        bClosePostIt3.setVisibility(View.INVISIBLE);

        iPostIt1.setVisibility(View.INVISIBLE);
        iPostIt2.setVisibility(View.INVISIBLE);
        iPostIt3.setVisibility(View.INVISIBLE);


        tPostItDate1.setVisibility(View.INVISIBLE);
        tPostItDate2.setVisibility(View.INVISIBLE);
        tPostItDate3.setVisibility(View.INVISIBLE);




        tPostItMessage1.setVisibility(View.INVISIBLE);
        tPostItMessage2.setVisibility(View.INVISIBLE);
        tPostItMessage3.setVisibility(View.INVISIBLE);


        tPostItFrom1.setVisibility(View.INVISIBLE);
        tPostItFrom2.setVisibility(View.INVISIBLE);
        tPostItFrom3.setVisibility(View.INVISIBLE);

        tNumberMorePostIts = (TextView) findViewById(R.id.lgtNum);
        tStringMorePostIts = (TextView) findViewById(R.id.lgtMoreMessage);
        tNumberMorePostIts.setVisibility(View.INVISIBLE);
        tStringMorePostIts.setVisibility(View.INVISIBLE);


        checkPostIts();


    }

    public void checkPostIts() {

        bClosePostIt1 = (Button) findViewById(R.id.bDelPostIt1);
        tPostItDate1 = (TextView) findViewById(R.id.smtDateHeure1);
        tPostItFrom1 = (TextView) findViewById(R.id.smtUser1);
        tPostItMessage1 = (TextView) findViewById(R.id.smtMessage1);


        switch (BlueFetch.numberMorePostIts) {
            case 0:
                tStringMorePostIts.setText(" ");
                tNumberMorePostIts.setText(" ");
                break;
            case 1:
                tStringMorePostIts.setText("(1) POST-IT attend");
                tNumberMorePostIts.setVisibility(View.VISIBLE);
                tStringMorePostIts.setVisibility(View.VISIBLE);
                break;
            default:
                tStringMorePostIts.setText("Des POST-ITs attendent");
                tNumberMorePostIts.setVisibility(View.VISIBLE);
                tStringMorePostIts.setVisibility(View.VISIBLE);
                break;
        }

        if (BlueFetch.postIt1 == false) {

            iPostIt1.setVisibility(View.INVISIBLE);
            bClosePostIt1.setVisibility(View.INVISIBLE);
            tPostItDate1.setVisibility(View.INVISIBLE);
            tPostItDate1.setText(BlueFetch.postItDate1);
            tPostItFrom1.setVisibility(View.INVISIBLE);
            tPostItFrom1.setText(BlueFetch.postItFrom1);
            tPostItMessage1.setVisibility(View.INVISIBLE);
            tPostItMessage1.setText(BlueFetch.postItMessage1);

        }
        if (BlueFetch.postIt1 == true) {

            iPostIt1.setVisibility(View.VISIBLE);
            bClosePostIt1.setVisibility(View.VISIBLE);
            tPostItDate1.setVisibility(View.VISIBLE);
            tPostItDate1.setText(BlueFetch.postItDate1);
            tPostItFrom1.setVisibility(View.VISIBLE);
            tPostItFrom1.setText(BlueFetch.postItFrom1);
            tPostItMessage1.setVisibility(View.VISIBLE);
            tPostItMessage1.setText(BlueFetch.postItMessage1);

        }

        if (BlueFetch.postIt1 == true && BlueFetch.postIt2 == true) {



            iPostIt2.setVisibility(View.VISIBLE);
            bClosePostIt2.setVisibility(View.VISIBLE);
            tPostItDate2.setVisibility(View.VISIBLE);
            tPostItDate2.setText(BlueFetch.postItDate2);
            tPostItFrom2.setVisibility(View.VISIBLE);
            tPostItFrom2.setText(BlueFetch.postItFrom2);
            tPostItMessage2.setVisibility(View.VISIBLE);
            tPostItMessage2.setText(BlueFetch.postItMessage2);




        }

        if (BlueFetch.postIt1 == true && BlueFetch.postIt2 == true && BlueFetch.postIt3 == true) {

            iPostIt3.setVisibility(View.VISIBLE);
            bClosePostIt3.setVisibility(View.VISIBLE);
            tPostItDate3.setVisibility(View.VISIBLE);
            tPostItDate3.setText(BlueFetch.postItDate3);
            tPostItFrom3.setVisibility(View.VISIBLE);
            tPostItFrom3.setText(BlueFetch.postItFrom3);
            tPostItMessage3.setVisibility(View.VISIBLE);
            tPostItMessage3.setText(BlueFetch.postItMessage3);

        }

        if (BlueFetch.postIt1 == true && BlueFetch.postIt2 == true && BlueFetch.postIt3 == true) {

            iPostIt3.setVisibility(View.VISIBLE);
            bClosePostIt3.setVisibility(View.VISIBLE);
            tPostItDate3.setVisibility(View.VISIBLE);
            tPostItDate3.setText(BlueFetch.postItDate3);
            tPostItFrom3.setVisibility(View.VISIBLE);
            tPostItFrom3.setText(BlueFetch.postItFrom3);
            tPostItMessage3.setVisibility(View.VISIBLE);
            tPostItMessage3.setText(BlueFetch.postItMessage3);

        }

        bClosePostIt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (BlueFetch.postIt2 == false) {

                    if (BlueFetch.postIt3==true){

                    }else {
                        iPostIt1.setVisibility(View.INVISIBLE);
                        bClosePostIt1.setVisibility(View.INVISIBLE);
                        tPostItDate1.setVisibility(View.INVISIBLE);
                        tPostItFrom1.setVisibility(View.INVISIBLE);
                        tPostItMessage1.setVisibility(View.INVISIBLE);
                        BlueFetch.postIt1 = false;
                    }

                } else {
                    tPostItDate1.setText(tPostItDate2.getText());
                    tPostItFrom1.setText(tPostItFrom2.getText());
                    tPostItMessage1.setText(tPostItMessage2.getText());
                    BlueFetch.postIt2 = false;

                    if (BlueFetch.postIt3 == false) {
                        iPostIt2.setVisibility(View.INVISIBLE);
                        bClosePostIt2.setVisibility(View.INVISIBLE);
                        tPostItDate2.setVisibility(View.INVISIBLE);
                        tPostItFrom2.setVisibility(View.INVISIBLE);
                        tPostItMessage2.setVisibility(View.INVISIBLE);
                        BlueFetch.postIt2 = false;
                    } else {
                        tPostItDate2.setText(tPostItDate3.getText());
                        tPostItFrom2.setText(tPostItFrom3.getText());
                        tPostItMessage2.setText(tPostItMessage3.getText());
                        iPostIt3.setVisibility(View.INVISIBLE);
                        bClosePostIt3.setVisibility(View.INVISIBLE);
                        tPostItDate3.setVisibility(View.INVISIBLE);
                        tPostItFrom3.setVisibility(View.INVISIBLE);
                        tPostItMessage3.setVisibility(View.INVISIBLE);
                        BlueFetch.postIt3 = false;

                    }

                }

            }
        });

        bClosePostIt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (BlueFetch.postIt3 == false) {
                    iPostIt2.setVisibility(View.INVISIBLE);
                    bClosePostIt2.setVisibility(View.INVISIBLE);
                    tPostItDate2.setVisibility(View.INVISIBLE);
                    tPostItFrom2.setVisibility(View.INVISIBLE);
                    tPostItMessage2.setVisibility(View.INVISIBLE);
                    BlueFetch.postIt2 = false;
                }else {
                    tPostItDate2.setText(tPostItDate3.getText());
                    tPostItFrom2.setText(tPostItFrom3.getText());
                    tPostItMessage2.setText(tPostItMessage3.getText());
                    iPostIt3.setVisibility(View.INVISIBLE);
                    bClosePostIt3.setVisibility(View.INVISIBLE);
                    tPostItDate3.setVisibility(View.INVISIBLE);
                    tPostItFrom3.setVisibility(View.INVISIBLE);
                    tPostItMessage3.setVisibility(View.INVISIBLE);
                    BlueFetch.postIt3 = false;
                }

            }
        });

        bClosePostIt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iPostIt3.setVisibility(View.INVISIBLE);
                bClosePostIt3.setVisibility(View.INVISIBLE);
                tPostItDate3.setVisibility(View.INVISIBLE);
                tPostItFrom3.setVisibility(View.INVISIBLE);
                tPostItMessage3.setVisibility(View.INVISIBLE);
                BlueFetch.postIt3 = false;

            }
        });


    }

}
