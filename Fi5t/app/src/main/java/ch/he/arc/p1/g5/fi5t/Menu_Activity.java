package ch.he.arc.p1.g5.fi5t;

//Import
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;




// Classe Menu_Activity

public class Menu_Activity extends Activity{

    // Déclaration TAG
    private static final String TAG ="Menu" ;



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
        switch (Item.getItemId())
        {
            case R.id.Users:
                Log.i(TAG, "Users item was clicked");
                return true;

            case R.id.action_settings:
                Log.i(TAG,"FI5T item was clicked");
                return true;
            case R.id.PostIt:
                Log.i(TAG,"PostIt item was clicked");
                return true;
            case R.id.Material:
                Log.i(TAG,"Material item was clicked");
                return true;
            case R.id.Parameter:
                Log.i(TAG,"Parameter item was clicked");
                return true;

            default:
                return super.onOptionsItemSelected(Item);

        }
    }

}
