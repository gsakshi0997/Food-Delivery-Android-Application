package com.sakshigupta.fooddelivery;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class optionmenu extends AppCompatActivity {

    Button btndes,btnbev,btnpasta,btnpizza;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionmenu);


        btndes=(Button)findViewById(R.id.btndes);
        btnbev=(Button)findViewById(R.id.btnbev);
        btnpasta=(Button)findViewById(R.id.btnpasta);
        btnpizza=(Button)findViewById(R.id.btnpizza);
        tv2=(TextView)findViewById(R.id.tv2);
        Intent i=getIntent();
        String out=i.getStringExtra("ou");
        tv2.setText("Welcome to ABS,"+out);

        btnpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(optionmenu.this,menu_pizza.class);
                startActivity(it);
            }
        });
        btnpasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(optionmenu.this,menu_pasta.class);
                startActivity(it);
            }
        });
        btnbev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(optionmenu.this,menu_bev.class);
                startActivity(it);
            }
        });
        btndes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(optionmenu.this,menu_des.class);
                startActivity(it);
            }
        });

    }

}
