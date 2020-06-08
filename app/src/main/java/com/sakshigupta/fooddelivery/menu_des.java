package com.sakshigupta.fooddelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class menu_des extends AppCompatActivity {

    CheckBox ch1,ch2,ch3,ch4,ch5;
    TextView tv1;
    Button btn1,btn2,but;
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_des);
        ch1=(CheckBox)findViewById(R.id.ch1);
        ch2=(CheckBox)findViewById(R.id.ch2);
        ch3=(CheckBox)findViewById(R.id.ch3);
        ch4=(CheckBox)findViewById(R.id.ch4);
        ch5=(CheckBox)findViewById(R.id.ch5);
        tv1=(TextView)findViewById(R.id.tv1);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        //but=(Button)findViewById(R.id.but);

        Intent ab=getIntent();
        final String d1=ab.getStringExtra("bevr");
        final int na=ab.getIntExtra("cost",0);

        //final int d2=ab.getExtras().getInt("cost");

        //String d2=ab.getStringExtra("cost");
        //final int d3=Integer.parseInt(d2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String des ="";
                int cost_des=0;
                if(ch1.isChecked()) {
                    des+="Walnut Brownie";
                    cost_des+=80;
                }
                if(ch2.isChecked()) {
                    des+=" Choco Lava Cake ";
                    cost_des+=90;
                }
                if(ch3.isChecked()) {
                    des+=" Butterscotch Moussecake";
                    cost_des+=70;

                }
                if(ch4.isChecked()) {
                    des+=" Blueberry Cheesecake";
                    cost_des+=120;
                }
                cost_des+=na;
                if(d1!=null)
                c=d1+"\n"+"Desserts: "+des;
                else
                c="Desserts: "+des;
                /*try {
                    FileOutputStream fos=openFileOutput("f4.txt",MODE_PRIVATE);
                    fos.write(c.getBytes());
                    fos.write(cost_des);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                //Toast.makeText(menu_des.this, cost_des, Toast.LENGTH_SHORT).show();
                Intent it=new Intent(menu_des.this,menu_check.class);
                if(c!="")
                it.putExtra("dess",c);
                it.putExtra("cost",cost_des);
                startActivity(it);



            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(menu_des.this,menu_check.class);
                if(d1!="")
                it.putExtra("dess",d1);
                it.putExtra("cost",na);

                startActivity(it);

            }
        });


    }
    }

