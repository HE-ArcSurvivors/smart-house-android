package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;


public class Main extends Services{
    private static final String TAG ="Page Accueil" ;


    // Variable utiliser pour les POST-IT

    Button bClosePostIt1, bClosePostIt2, bClosePostIt3, bEtatPorte,bReglages;
    ImageView iPostIt1, iPostIt2, iPostIt3, Im1;
    TextView tPostItDate1, tPostItDate2, tPostItDate3;
    TextView tPostItFrom1, tPostItFrom2, tPostItFrom3;
    TextView tPostItMessage1, tPostItMessage2, tPostItMessage3;
    TextView tNumberMorePostIts, tStringMorePostIts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Im1=(ImageView) findViewById(R.id.imageView);

        bReglages=(Button)findViewById(R.id.bReglages);
        bReglages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
               Intent ParametreInstance=new Intent(Main.this,Parametre.class);
                startActivity(ParametreInstance);

            }
        });
        Im1.setBackgroundResource(R.drawable.opendoor);
        bEtatPorte=(Button)findViewById(R.id.bEtatPortePrinc);
        bEtatPorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BlueFetch.DoorStatus==true)
                {
                    BlueFetch.DoorStatus=false;
                    Im1.setBackgroundResource(R.drawable.closeddoor);
                    bEtatPorte.setTextColor(Color.parseColor("#FFFF0000"));



                }
                else {
                    Im1.setBackgroundResource(R.drawable.opendoor);
                    BlueFetch.DoorStatus=true;
                    bEtatPorte.setTextColor(Color.parseColor("#ff7a7a7a"));


                }
            }
        });

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
