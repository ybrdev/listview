package com.listview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ListBasicActivity extends Activity implements AdapterView.OnItemClickListener {

    ArrayList<String> clubs = new ArrayList<String>();
    ListView listClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_basic);

        listClubs = (ListView) findViewById(R.id.listClubs);
        listClubs.setOnItemClickListener(this);

        clubs.add("Juventus");
        clubs.add("AC Milan");
        clubs.add("Inter Milan");
        clubs.add("AS Roma");
        clubs.add("SS Lazio");
        clubs.add("Napoli");
        clubs.add("Fiorentina");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clubs);

        listClubs.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String clubName = clubs.get(position);
        Toast.makeText(this, clubName, Toast.LENGTH_SHORT).show();
    }
}
