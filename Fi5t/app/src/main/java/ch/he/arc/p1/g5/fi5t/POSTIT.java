package ch.he.arc.p1.g5.fi5t;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class POSTIT extends Menu_Activity {
    private List<Message> MyMessages =new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postit);
        PopulateMessageList();

    }

    private void PopulateMessageList() {
        MyMessages.add(new Message("12.08.2014","12:00","NonLu","Maman est à la maison","SuperMama",1));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.postit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.PostIt) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
