package com.sakshigupta.fooddelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    Button Btnmenu,Btnlogin;
    String[] location ={"Select Nearest Outlet","Bhayander","Churchgate","Santacruz","Bandra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btnmenu=(Button)findViewById(R.id.Btnmenu);
        Btnlogin=(Button)findViewById(R.id.Btnlogin);

        spn = (Spinner) findViewById(R.id.spn);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,location);

        spn.setAdapter(a);

        Btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=spn.getSelectedItemPosition();
                String s=location[i];
                Intent it=new Intent(MainActivity.this,optionmenu.class);
                it.putExtra("ou",s);
                startActivity(it);

            }
        });

    }
    public void onBackPressed()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
