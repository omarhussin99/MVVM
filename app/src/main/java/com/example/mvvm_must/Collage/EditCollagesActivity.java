package com.example.mvvm_must.Collage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mvvm_must.R;
import com.example.mvvm_must.Utils.UtilsFunctions;

import java.util.ArrayList;
import java.util.List;

public class EditCollagesActivity extends AppCompatActivity {

    EditText department_ED;
    ImageView save;
    List<Department_item> arrayList;
    item_adapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_collages);
        init();
    }

    void init() {

        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.collagesList);
        department_ED = findViewById(R.id.collageED);
        save = findViewById(R.id.addBTN);


        final List<Department_item> department_items = new ArrayList<>();



        //Todo:get all added collages from the database


        recyclerView.setHasFixedSize(true);
        adapter = new item_adapter(department_items, this);
        recyclerView.setAdapter(adapter);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (department_ED.getText().toString().equals("")) {
                    department_ED.setHint("");
                    department_ED.setCursorVisible(true);
                    UtilsFunctions.showSoftKeyboard(department_ED, EditCollagesActivity.this);

                } else {

                    department_items.add(new Department_item(department_ED.getText().toString(), 123456));
                    SerializableManager.saveListOfObj(EditDepartmentActivity.this, department_items, "department.txt");
                    adapter.notifyDataSetChanged();
                    department_ED.setText("");
                    department_ED.setCursorVisible(false);
                    department_ED.setHint("Insert a department here");
                    UtilsFunctions.hideSoftKeyboard(EditCollagesActivity.this);
                }

            }
        });

        department_ED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (department_ED.getText().toString().length() == 0) {
                    department_ED.setHint("");
                    department_ED.setCursorVisible(true);
                    UtilsFunctions.showSoftKeyboard(department_ED, EditCollagesActivity.this);
                }
            }
        });


    }


}
