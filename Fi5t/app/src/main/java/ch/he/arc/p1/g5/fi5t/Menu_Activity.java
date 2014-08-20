package ch.he.arc.p1.g5.fi5t;

//Import
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


// Classe Menu_Activity

public class Menu_Activity extends Activity{

    // Déclaration TAG
    private static final String TAG ="Menu" ;
    String Role="Admin";
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if(Role!="Admin")
        {
            MenuItem item3  = menu.findItem(R.id.Users);
            item3.setVisible(false);}
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    // int id = item.getItemId();
    //if (id == R.id.Users) {
    // return true;
    //}
    // return super.onOptionsItemSelected(item);
    // }
    @Override
    public boolean onOptionsItemSelected(MenuItem Item)
        {
        Intent intent = null;
        switch (Item.getItemId())
        {
            case R.id.Users:
                intent = new Intent(getApplicationContext(),Users.class);
                startActivity(intent);
                return true;

            case R.id.action_settings:
                intent = new Intent(getApplicationContext(),Main.class);
                startActivity(intent);
                return true;
            case R.id.PostIt:
                intent = new Intent(getApplicationContext(),POSTIT.class);
                startActivity(intent);
                return true;
            case R.id.Material:
                intent = new Intent(getApplicationContext(),Materiel.class);
                startActivity(intent);
                return true;
            case R.id.Parameter:
                intent = new Intent(getApplicationContext(),Parametre.class);
                startActivity(intent);
                return true;
            case R.id.MonProfil:
                intent = new Intent(getApplicationContext(),MonProfil.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(Item);

        }
    }

}
