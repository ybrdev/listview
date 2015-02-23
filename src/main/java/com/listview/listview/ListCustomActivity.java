package com.listview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class ListCustomActivity extends Activity implements AdapterView.OnItemClickListener {

    ArrayList<HashMap<String, String>> clubs = new ArrayList<HashMap<String, String>>();
    ListView clubList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_custom);

        clubList = (ListView) findViewById(R.id.listClubs);
        clubList.setOnItemClickListener(this);

        HashMap<String, String> clubMap;
        clubMap = new HashMap<String, String>();
        clubMap.put("name", "Juventus");
        clubMap.put("stadium", "Juventus Stadium");
        clubMap.put("logo", "http://localhost/themes/ace/assets/avatars/avatar.png");
        clubs.add(clubMap);

        clubMap = new HashMap<String, String>();
        clubMap.put("name", "Inter Milan");
        clubMap.put("stadium", "Giuseppe Meazza");
        clubMap.put("logo", "http://localhost/themes/ace/assets/avatars/avatar.png");
        clubs.add(clubMap);

        ListCustomAdapter customAdapter = new ListCustomAdapter(this, clubs);
        clubList.setAdapter(customAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String clubInformation = clubs.get(position).get("name") + ": " +
                clubs.get(position).get("stadium");
        Toast.makeText(this, clubInformation, Toast.LENGTH_SHORT).show();
    }
}
