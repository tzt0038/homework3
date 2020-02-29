package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

/* import */
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText noteContent;
    ListView listView;
    ArrayList<String> noteList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    boolean exist = false;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        noteContent = findViewById(R.id.noteContent);
        listView = findViewById(R.id.noteList);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_single_choice, noteList);
        listView.setAdapter(adapter);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = noteContent.getText().toString();
                if (exist == false) {
                    noteList.add(content);
                    adapter.notifyDataSetChanged();
                    noteContent.setText("");
                } else {
                    noteList.set(index, content);
                    adapter.notifyDataSetChanged();
                    noteContent.setText("");
                    exist = false;
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                noteContent.setText(noteList.get(position));
                index = position;
                exist = true;
            }
        });

    }

}
