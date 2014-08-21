package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Menu_Activity{
    private static final String TAG ="Page Accueil" ;


    // Variable utiliser pour les POST-IT

    Button bClosePostIt1, bClosePostIt2, bClosePostIt3;
    ImageView iPostIt1, iPostIt2, iPostIt3;
    TextView tPostItDate1, tPostItDate2, tPostItDate3;
    TextView tPostItFrom1, tPostItFrom2, tPostItFrom3;
    TextView tPostItMessage1, tPostItMessage2, tPostItMessage3;
    TextView tNumberMorePostIts, tStringMorePostIts;

    boolean postIt1 = true;
    boolean postIt2 = true;
    boolean postIt3 = true;
    Button bEtatPorte;
    String EtatPorte="Ouverte"; //--------------------------Etat de la porte-----------------------------//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bEtatPorte=(Button)findViewById(R.id.bEtatPortePrinc);
        bEtatPorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                if(EtatPorte=="Ouverte")
                {
                    Toast toast = Toast.makeText(context,"Fermé", duration);
                    toast.show();
                    EtatPorte="Fermé";
                }
                else {
                    Toast toast = Toast.makeText(context, "Ouverte", duration);
                    toast.show();
                    EtatPorte="Ouverte";

                }
            }
        });


        Bundle bundle = getIntent().getExtras();

        //Boolean yourBool = getIntent().getExtras().getBoolean("postIt1");

        /*
        if(bundle.getBoolean("postIt1")== false)
        {
            Toast.makeText(Home.this,
                    "YOUR ARE AT HOME!", Toast.LENGTH_SHORT).show();
        }
        */

        setPostIts();
    }










    public void setPostIts() {

        bClosePostIt1 = (Button) findViewById(R.id.bDelPostIt1);
        bClosePostIt2 = (Button) findViewById(R.id.bDelPostIt2);
        bClosePostIt3 = (Button) findViewById(R.id.bDelPostIt3);
        bClosePostIt1.setVisibility(View.INVISIBLE);
        bClosePostIt2.setVisibility(View.INVISIBLE);
        bClosePostIt3.setVisibility(View.INVISIBLE);

        iPostIt1 = (ImageView) findViewById(R.id.imvpostit1);
        iPostIt2 = (ImageView) findViewById(R.id.imvpostit2);
        iPostIt3 = (ImageView) findViewById(R.id.imvpostit3);
        iPostIt1.setVisibility(View.INVISIBLE);
        iPostIt2.setVisibility(View.INVISIBLE);
        iPostIt3.setVisibility(View.INVISIBLE);

        tPostItDate1 = (TextView) findViewById(R.id.smtDateHeure1);
        tPostItDate2 = (TextView) findViewById(R.id.smtDateHeure2);
        tPostItDate3 = (TextView) findViewById(R.id.smtDateHeure3);
        tPostItDate1.setVisibility(View.INVISIBLE);
        tPostItDate2.setVisibility(View.INVISIBLE);
        tPostItDate3.setVisibility(View.INVISIBLE);



        tPostItMessage1 = (TextView) findViewById(R.id.smtMessage1);
        tPostItMessage2 = (TextView) findViewById(R.id.smtMessage2);
        tPostItMessage3 = (TextView) findViewById(R.id.smtMessage3);
        tPostItMessage1.setVisibility(View.INVISIBLE);
        tPostItMessage2.setVisibility(View.INVISIBLE);
        tPostItMessage3.setVisibility(View.INVISIBLE);

        tPostItFrom1 = (TextView) findViewById(R.id.smtUser3);
        tPostItFrom2 = (TextView) findViewById(R.id.smtUser2);
        tPostItFrom3 = (TextView) findViewById(R.id.smtUser3);
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


        final String postItMessage1 = "Je suis de sortie ce soir !";
        final String postItMessage2 = "Je rentre à la maison à 18h00";
        final String postItMessage3 = "Je fini un peu plus tôt l'école que prévu";

        final String postItDate1 = "13:00/25.08.2014";
        final String postItDate2 = "11:21/25.08.2014";
        final String postItDate3 = "10:58/25.08.2014";


        final String postItFrom1 = "Franck";
        final String postItFrom2 = "Maman";
        final String postItFrom3 = "Franck";

        int numberMorePostIts = 1;

        bClosePostIt1 = (Button) findViewById(R.id.bDelPostIt1);
        tPostItDate1 = (TextView) findViewById(R.id.smtDateHeure1);
        tPostItFrom1 = (TextView) findViewById(R.id.smtUser1);
        tPostItMessage1 = (TextView) findViewById(R.id.smtMessage1);


        switch (numberMorePostIts) {
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


        if (postIt1 == true) {

            iPostIt1.setVisibility(View.VISIBLE);
            bClosePostIt1.setVisibility(View.VISIBLE);
            tPostItDate1.setVisibility(View.VISIBLE);
            tPostItDate1.setText(postItDate1);
            tPostItFrom1.setVisibility(View.VISIBLE);
            tPostItFrom1.setText(postItFrom1);
            tPostItMessage1.setVisibility(View.VISIBLE);
            tPostItMessage1.setText(postItMessage1);

        }

        if (postIt1 == true && postIt2 == true) {



            iPostIt2.setVisibility(View.VISIBLE);
            bClosePostIt2.setVisibility(View.VISIBLE);
            tPostItDate2.setVisibility(View.VISIBLE);
            tPostItDate2.setText(postItDate2);
            tPostItFrom2.setVisibility(View.VISIBLE);
            tPostItFrom2.setText(postItFrom2);
            tPostItMessage2.setVisibility(View.VISIBLE);
            tPostItMessage2.setText(postItMessage2);




        }

        if (postIt1 == true && postIt2 == true && postIt3 == true) {

            iPostIt3.setVisibility(View.VISIBLE);
            bClosePostIt3.setVisibility(View.VISIBLE);
            tPostItDate3.setVisibility(View.VISIBLE);
            tPostItDate3.setText(postItDate3);
            tPostItFrom3.setVisibility(View.VISIBLE);
            tPostItFrom3.setText(postItFrom3);
            tPostItMessage3.setVisibility(View.VISIBLE);
            tPostItMessage3.setText(postItMessage3);

        }

        if (postIt1 == true && postIt2 == true && postIt3 == true) {

            iPostIt3.setVisibility(View.VISIBLE);
            bClosePostIt3.setVisibility(View.VISIBLE);
            tPostItDate3.setVisibility(View.VISIBLE);
            tPostItDate3.setText(postItDate3);
            tPostItFrom3.setVisibility(View.VISIBLE);
            tPostItFrom3.setText(postItFrom3);
            tPostItMessage3.setVisibility(View.VISIBLE);
            tPostItMessage3.setText(postItMessage3);

        }

        bClosePostIt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (postIt2 == false) {

                    if (postIt3==true){

                    }else {
                        iPostIt1.setVisibility(View.INVISIBLE);
                        bClosePostIt1.setVisibility(View.INVISIBLE);
                        tPostItDate1.setVisibility(View.INVISIBLE);
                        tPostItFrom1.setVisibility(View.INVISIBLE);
                        tPostItMessage1.setVisibility(View.INVISIBLE);
                        postIt1 = false;
                    }

                } else {
                    tPostItDate1.setText(tPostItDate2.getText());
                    tPostItFrom1.setText(tPostItFrom2.getText());
                    tPostItMessage1.setText(tPostItMessage2.getText());
                    postIt2 = false;

                    if (postIt3 == false) {
                        iPostIt2.setVisibility(View.INVISIBLE);
                        bClosePostIt2.setVisibility(View.INVISIBLE);
                        tPostItDate2.setVisibility(View.INVISIBLE);
                        tPostItFrom2.setVisibility(View.INVISIBLE);
                        tPostItMessage2.setVisibility(View.INVISIBLE);
                        postIt2 = false;
                    } else {
                        tPostItDate2.setText(tPostItDate3.getText());
                        tPostItFrom2.setText(tPostItFrom3.getText());
                        tPostItMessage2.setText(tPostItMessage3.getText());
                        iPostIt3.setVisibility(View.INVISIBLE);
                        bClosePostIt3.setVisibility(View.INVISIBLE);
                        tPostItDate3.setVisibility(View.INVISIBLE);
                        tPostItFrom3.setVisibility(View.INVISIBLE);
                        tPostItMessage3.setVisibility(View.INVISIBLE);
                        postIt3 = false;

                    }

                }

            }
        });

        bClosePostIt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (postIt3 == false) {
                    iPostIt2.setVisibility(View.INVISIBLE);
                    bClosePostIt2.setVisibility(View.INVISIBLE);
                    tPostItDate2.setVisibility(View.INVISIBLE);
                    tPostItFrom2.setVisibility(View.INVISIBLE);
                    tPostItMessage2.setVisibility(View.INVISIBLE);
                    postIt2 = false;
                }else {
                    tPostItDate2.setText(tPostItDate3.getText());
                    tPostItFrom2.setText(tPostItFrom3.getText());
                    tPostItMessage2.setText(tPostItMessage3.getText());
                    iPostIt3.setVisibility(View.INVISIBLE);
                    bClosePostIt3.setVisibility(View.INVISIBLE);
                    tPostItDate3.setVisibility(View.INVISIBLE);
                    tPostItFrom3.setVisibility(View.INVISIBLE);
                    tPostItMessage3.setVisibility(View.INVISIBLE);
                    postIt3 = false;
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
                postIt3 = false;

                /*
                    Intent i = new Intent(Home.this, Home.class);
                    i.putExtra("postIt1", true);
                    i.putExtra("postIt2", true);
                    i.putExtra("postIt3", false);
                //startIn();

*/
            }
        });


    }

}
