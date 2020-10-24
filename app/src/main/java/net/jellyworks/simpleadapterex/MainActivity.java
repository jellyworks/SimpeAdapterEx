package net.jellyworks.simpleadapterex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String[] nations = {"Australia", "Canada", "China", "France", "German", "India", "Indonesia",
            "Iran", "Italy", "Japan", "Korea", "Mongol", "Russia", "Spain", "UK", "USA"};
    String[] locations = {"Australia", "North America", "Asia", "Europe", "Europe", "Asia", "Asia",
            "Middle East", "Europe", "Asia", "Asia", "Asia", "Eurasia", "Europe", "Europe", "North America"};
    int[] flags = {R.drawable.australia, R.drawable.canada, R.drawable.china,
            R.drawable.france, R.drawable.german, R.drawable.india, R.drawable.indonesia,
            R.drawable.iran, R.drawable.italy, R.drawable.japan, R.drawable.korea,
            R.drawable.mongol, R.drawable.russia, R.drawable.spain, R.drawable.uk, R.drawable.usa};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, nations[i], Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<HashMap<String, Object>> items = new ArrayList<>();
        for (int i=0;i<nations.length;i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("nation", nations[i]);
            map.put("location", locations[i]);
            map.put("flag", flags[i]);
            items.add(map);
        }
        String[] from = {"nation", "location", "flag"};
        int[] to = {R.id.textView_name_item, R.id.textView_location_item, R.id.imageView_flag_item};

        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.flag_item, from, to);
        listView.setAdapter(adapter);
    }
}