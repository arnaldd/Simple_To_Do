package sg.edu.rp.c346.id20039583.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etAddItem;
    Button btnAdd, btnClear, btnDelete;
    ListView lvTask;
    Spinner spnAddDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAddItem = findViewById(R.id.etAddItem);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        btnDelete = findViewById(R.id.btnDelete);
        lvTask = findViewById(R.id.lvTask);
        spnAddDelete = findViewById(R.id.spinner);

        spnAddDelete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:

                        btnDelete.setEnabled(false);
                        btnClear.setEnabled(false);
                        btnAdd.setEnabled(true);
                        etAddItem.setHint("Type in a new task here");

                        break;

                    case 1:

                        btnDelete.setEnabled(true);
                        btnClear.setEnabled(true);
                        btnAdd.setEnabled(false);
                        etAddItem.setHint("Type in a task to remove or press clear to remove all");

                        break;
                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayList<String> task;   //two originally stored value in list
        task = new ArrayList<String>();

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                task);
        lvTask.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTasks = etAddItem.getText().toString();
                task.add(newTasks);
                adapter.notifyDataSetChanged();


            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTasks = etAddItem.getText().toString();
                task.remove(newTasks);
                adapter.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                task.clear();
                adapter.notifyDataSetChanged();
            }
        });

        lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                Toast.makeText(MainActivity.this, task.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
}