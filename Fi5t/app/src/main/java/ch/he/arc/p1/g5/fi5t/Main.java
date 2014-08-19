package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Main extends Activity {


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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        tPostItFrom1 = (TextView) findViewById(R.id.smtUser1);
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


        final String postItMessage1 = "Message from Post It 1";
        final String postItMessage2 = "Message from Post It 2";
        final String postItMessage3 = "Message from Post It 3";

        final String postItDate1 = "Day 1";
        final String postItDate2 = "Day 2";
        final String postItDate3 = "Day 3";

        final String postItTime1 = "01:00";
        final String postItTime2 = "02:00";
        final String postItTime3 = "03:00";

        final String postItFrom1 = "User 1";
        final String postItFrom2 = "User 2";
        final String postItFrom3 = "User 3";

        int numberMorePostIts = 3;

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
                tStringMorePostIts.setText("Post-It is waiting");
                break;
            default:
                tStringMorePostIts.setText("Post-Its are waiting");
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
