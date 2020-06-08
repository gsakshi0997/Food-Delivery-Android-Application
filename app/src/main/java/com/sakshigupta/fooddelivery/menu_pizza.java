package com.sakshigupta.fooddelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class menu_pizza extends AppCompatActivity {

    Spinner spnsize;
    Button button,btn2;
    CheckBox cbCorn,cbOnion,cbTomato,cbcottage,cbMush,cbcap;
    String s1,s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pizza);


        spnsize=(Spinner)findViewById(R.id.spnsize);
        cbCorn=(CheckBox)findViewById(R.id.cbCorn);
        cbOnion=(CheckBox)findViewById(R.id.cbOnion);
        cbTomato=(CheckBox)findViewById(R.id.cbTomato);
        cbcap=(CheckBox)findViewById(R.id.cbcap);
        cbcottage=(CheckBox)findViewById(R.id.cbcottage);
        cbMush=(CheckBox)findViewById(R.id.cbMush);
        button=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.btn2);
        final String size[]={"Select size","Small(Rs 120)","Medium(Rs 300)","Large(Rs 450)"};

        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,size);

        spnsize.setAdapter(a);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=spnsize.getSelectedItemPosition();
                if(i!=-1 || i!=0)
                 s=size[i];
                String t="";
                int cost_pizza=0;
                if(s.equals("Small(Rs 120)"))
                    cost_pizza=120;
                else if(s.equals("Medium(Rs 300)"))
                    cost_pizza=240;
                else if(s.equals("Large(Rs 450)"))
                    cost_pizza=450;
                if(cbCorn.isChecked()) {
                    t+="Corn\t";

                }
                    if(cbOnion.isChecked()) {
                        t+=" Onion\t";

                    }
                if(cbTomato.isChecked()) {
                    t+=" Tomato\t";


                }
                if(cbcap.isChecked()) {
                    t+=" Capsicum\t";

                }
                    if(cbMush.isChecked()) {
                        t+=" Mushroom\t";

                    }
                if(cbcottage.isChecked())
                {
                    t+=" Cottage Cheese\t";
                }
                if(s!="" && t!="")
                s1="Size: "+s+" Toppings: "+t;
                else s1="";
               /* try {
                    FileOutputStream fos=openFileOutput("f1.txt",MODE_PRIVATE);
                    fos.write(s1.getBytes());
                    fos.write(cost_pizza);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                Toast.makeText(menu_pizza.this, s1, Toast.LENGTH_SHORT).show();
               Intent it=new Intent(menu_pizza.this,menu_pasta.class);

                    if (s1 != "null")
                        it.putExtra("pizza", s1);
                    //it.putExtra("top",t);
                    it.putExtra("cost",cost_pizza);
                    startActivity(it);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(menu_pizza.this,menu_pasta.class);

                startActivity(it);

            }
        });

    }
}
