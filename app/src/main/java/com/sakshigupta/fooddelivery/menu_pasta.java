package com.sakshigupta.fooddelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class menu_pasta extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv5;
    RadioGroup rg1,rg2;
    //RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    Button bt1,bt2;
    String abb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pasta);

        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        rg1=(RadioGroup)findViewById(R.id.rg1);
        rg2=(RadioGroup)findViewById(R.id.rg2);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        //tv5=(TextView)findViewById(R.id.tv5);

        Intent ab=getIntent();
        final String n=ab.getStringExtra("pizza");

        final int na=ab.getIntExtra("cost",0);
        //final int na1=Integer.parseInt(na);
        final int cost_pasta=na+200;

        //tv5.setText(n+" "+na);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String pas="";
                String pas1="";
                        int a=rg1.getCheckedRadioButtonId();
                if(a!=-1) {
                    RadioButton rb = (RadioButton) findViewById(a);
                    pas = rb.getText().toString();
                }
                        int b=rg2.getCheckedRadioButtonId();
                if(b!=-1){
                        RadioButton rb12=(RadioButton)findViewById(b);
                        pas1=rb12.getText().toString();}
                if(n!=null)
                abb=n+"\n"+"Pasta: "+pas+" Sauce: "+pas1;
                else if(!(a<0) && !(b<0))
                    abb="Pasta: "+pas+" Sauce: "+pas1;
                else
                abb=" ";

                /*try {
                    FileOutputStream fos=openFileOutput("f2.txt",MODE_PRIVATE);
                    fos.write(abb.getBytes());
                    fos.write(cost_pasta);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                //Toast.makeText(menu_pasta.this, abb, Toast.LENGTH_SHORT).show();
                Intent it=new Intent(menu_pasta.this,menu_bev.class);
                if(abb!="null")
                it.putExtra("pasta",abb);
                it.putExtra("cost",cost_pasta);
                startActivity(it);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(menu_pasta.this,menu_bev.class);
                if(n!=null)
                it.putExtra("pasta",n);
                it.putExtra("cost",na);

                startActivity(it);

            }
        });


    }
}
