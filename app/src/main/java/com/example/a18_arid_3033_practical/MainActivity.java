package com.example.a18_arid_3033_practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] Classes;
    Spinner myspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        Spinner myspinner;

        String Name[] = {"Nimra", "Iqra", "Amna"};
        String Reg[] = {"18-Arid-3033", "18-Arid-2000", "18-Arid-9262"};
        Integer Semester[] = {6, 6, 6};
        String Degree[] = {"BSSE", "BSSE", "BSCS"};

        button= (Button) findViewById(R.id.btn);
        myspinner = (Spinner) findViewById(R.id.spineer);

        Database db = new Database();
        db.AddStudents(Name[], Reg[], Semester[], Degree[]);

        Classes = getResources().getStringArray(R.array.Classes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Classes);
        button.setOnClickListener();

        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selected_class = myspinner.getSelectedItemPosition();
                db.display(selected_class);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }






}