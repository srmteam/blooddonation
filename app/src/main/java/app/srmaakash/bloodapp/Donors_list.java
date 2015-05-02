package app.srmaakash.bloodapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

/**
 * Created by Lenovo on 2/1/2015.
 */
public class Donors_list extends Activity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donar_list);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton A_positive = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton A_negative = (ImageButton) findViewById(R.id.imageButton);
        ImageButton B_positive = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton B_negative = (ImageButton) findViewById(R.id.imageButton8);
        ImageButton O_positive = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton O_negative = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton AB_positive = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton AB_negative = (ImageButton) findViewById(R.id.imageButton5);




        A_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Donors_list.this, Apos.class);
                startActivity(a);
            }

        });

        A_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(Donors_list.this, Aneg.class);
                startActivity(b);
            }

        });

        O_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Donors_list.this, Opos.class);
                startActivity(c);

            }

        });
        B_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(Donors_list.this, Bneg.class);
                startActivity(d);
            }
        });
        B_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(Donors_list.this, Bpos.class);
                startActivity(e);
            }
        });

        O_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(Donors_list.this, Oneg.class);
                startActivity(f);

            }

        });
        AB_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(Donors_list.this, ABneg.class);
                startActivity(g);

            }

        });
        AB_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(Donors_list.this, ABpos.class);
                startActivity(h);

            }

        });

    }




    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}















