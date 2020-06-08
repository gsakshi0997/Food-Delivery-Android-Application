package com.sakshigupta.fooddelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class menu_bev extends AppCompatActivity {

    CheckBox ch1,ch2,ch3,ch4,ch5;
    TextView tv1;
    Button btn1,btn2;
    String e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bev);

        ch1=(CheckBox)findViewById(R.id.ch1);
        ch2=(CheckBox)findViewById(R.id.ch2);
        ch3=(CheckBox)findViewById(R.id.ch3);
        ch4=(CheckBox)findViewById(R.id.ch4);
        ch5=(CheckBox)findViewById(R.id.ch5);
        tv1=(TextView)findViewById(R.id.tv1);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

        Intent ab=getIntent();
        final String b1=ab.getStringExtra("pasta");
        final int na=ab.getIntExtra("cost",0);

        //final int b3=ab.getExtras().getInt("cost");

        //final int b3=Integer.parseInt(b2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bev ="";
                int cost_bev=0;
                if(ch1.isChecked()) {
                    bev+="Iced Tea";
                    cost_bev+=100;
                }
                if(ch2.isChecked()) {
                    bev+=" Pepsi";
                    cost_bev+=60;
                }
                if(ch3.isChecked()) {
                    bev+=" Fanta";
                    cost_bev+=60;

                }
                if(ch4.isChecked()) {
                    bev+=" Vanilla Milkshake";
                    cost_bev+=120;
                }
                if(ch5.isChecked()) {
                    bev+=" Chocolate Milkshake";
                    cost_bev+=120;
                }
                cost_bev+=na;
                if(b1!="")
                e1=b1+"\n"+"Beverages: "+bev;
                else
                e1="Beverages: "+bev;
                /*try {
                    FileOutputStream fos=openFileOutput("f3.txt",MODE_PRIVATE);
                    fos.write(e1.getBytes());
                    fos.write(cost_bev);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

                Intent it=new Intent(menu_bev.this,menu_des.class);
                if(e1!="")
                it.putExtra("bevr",e1);
                it.putExtra("cost",cost_bev);
                startActivity(it);



            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(menu_bev.this,menu_des.class);
                if(b1!="")
                it.putExtra("bevr",b1);
                it.putExtra("cost",na);

                startActivity(it);

            }
        });


    }
}
