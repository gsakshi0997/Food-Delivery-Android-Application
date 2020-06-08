package com.sakshigupta.fooddelivery;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.sakshigupta.fooddelivery.R.id.tv2;

public class menu_check extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_check);

        tv1=(TextView)findViewById(R.id.tv1);
        //tv2=(TextView)findViewById(R.id.tv2);
        //tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        Button bt1=(Button)findViewById(R.id.bt1);
        Intent ab=getIntent();
        final String c1=ab.getStringExtra("dess");
        final int na=ab.getIntExtra("cost",0);

        //int c2=ab.getExtras().getInt("cost");

        //String c2=ab.getStringExtra("cost");
        //int d3=Integer.parseInt(c2);
        if(c1==null)
            tv1.setText("No item selected");
        else

        tv1.setText("Order Details:\n"+c1);
        tv4.setText("Total Bill: "+na);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Order Details"+c1+"with total billing amount of Rs"+na);
                Intent c = Intent.createChooser(i, "Open with");
                startActivity(c);
            }
        });
        /*
        String line;
        StringBuffer sb=new StringBuffer();
        try {
            FileInputStream fis=openFileInput("f1.txt");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            while((line=br.readLine())!=null)
            {
                sb.append(line+"\n");
            }
            tv1.setText(sb.toString());
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line1;
        StringBuffer sb1=new StringBuffer();
        try {
            FileInputStream fis1=openFileInput("f2.txt");
            InputStreamReader isr1=new InputStreamReader(fis1);
            BufferedReader br1=new BufferedReader(isr1);
            while((line1=br1.readLine())!=null)
            {
                sb1.append(line1+"\n");
            }
            tv2.setText(sb1.toString());
            br1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line2;
        StringBuffer sb2=new StringBuffer();
        try {
            FileInputStream fis2=openFileInput("f3.txt");
            InputStreamReader isr2=new InputStreamReader(fis2);
            BufferedReader br2=new BufferedReader(isr2);
            while((line2=br2.readLine())!=null)
            {
                sb2.append(line2+"\n");
            }
            tv3.setText(sb2.toString());
            br2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line3;
        StringBuffer sb3=new StringBuffer();
        try {
            FileInputStream fis3=openFileInput("f4.txt");
            InputStreamReader isr3=new InputStreamReader(fis3);
            BufferedReader br3=new BufferedReader(isr3);
            while((line3=br3.readLine())!=null)
            {
                sb3.append(line3+"\n");
            }
            tv4.setText(sb3.toString());
            br3.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to return to the home screen?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //finish();
                        //menu_check.this.onSuperBackPressed();
                        Intent it=new Intent(menu_check.this,MainActivity.class);
                        startActivity(it);
                        //super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    /*
    if (handleCancel()){
        super.onBackPressed();
    }
    */
    }

}
