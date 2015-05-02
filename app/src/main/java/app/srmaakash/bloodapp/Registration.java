package app.srmaakash.bloodapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2/26/2015.
 */
public class Registration extends Activity {

    private EditText name,passwordField,contactField,cityField,regnoField,blood,confirm_pass,altcontact,add;
    private TextView status,role;
    private Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        name = (EditText)findViewById(R.id.editText);
        //passwordField = (EditText)findViewById(R.id.editText2);
        status = (TextView)findViewById(R.id.textView17);
        role = (TextView)findViewById(R.id.textView19);

        //blood = (EditText)findViewById(R.id.editText4);
        contactField =  (EditText)findViewById(R.id.editText5);
        //cityField= (EditText)findViewById(R.id.editText6);
        regnoField = (EditText)findViewById(R.id.editText7);
        //confirm_pass = (EditText)findViewById(R.id.editText3);
        altcontact = (EditText)findViewById(R.id.editText2);
        add = (EditText)findViewById(R.id.editText6);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        addItemsOnSpinner2();
        addItemsOnSpinner1();
        //addListenerOnButton();
        //addListenerOnSpinnerItemSelection();



    }
    public void addItemsOnSpinner1(){

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("O+");
        list.add("O-");
        list.add("A+");

        list.add("A-");
        list.add("B+");
        list.add("B-");
        list.add("AB+");
        list.add("AB-");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);

    }

    public void addItemsOnSpinner2(){

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Assam");
        list.add("Andra Pradesh");
        list.add("Arunachal Pradesh");
        list.add("Bihar");
        list.add("Chattisgarh");
        list.add("Delhi");
        list.add("Goa");
        list.add("Gujarat");
        list.add("Haryana");
        list.add("Himachal Pradesh");
        list.add("Jammu Kashmir");
        list.add("Gujarat");
        list.add("Jharkhand");
        list.add("Tamil Nadu");
        list.add("Karnataka");

        list.add("Kerala");
        list.add("Madhya Pradesh");

        list.add("Maharashtra");
        list.add("Manipur");
        list.add("Meghalaya");
        list.add("Mizoram");
        list.add("Nagaland");
        list.add("Orissa");
        list.add("Punjab");
        list.add("Rajasthan");
        list.add("Sikkim");
        list.add("Tamil Nadu");
        list.add("Tripura");

        list.add("Uttar Pradesh");
        list.add("Uttarakhand");
        list.add("West Bengal");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);

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


    public void loginPost (View view){




        /*AlertDialog alertDialog = new AlertDialog.Builder(Registration.this).create(); //Read Update
        alertDialog.setTitle("RESULT");
        alertDialog.setMessage(" Thank You for registering ");

        alertDialog.setButton("Back", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // here you can add functions
            }
        });
        alertDialog.show();*/


        String username = name.getText().toString();
        //String password = passwordField.getText().toString();
        String contact = contactField.getText().toString();
        //String city = cityField.getText().toString();
        String registration = regnoField.getText().toString();
        String bloodgrp = spinner1.getSelectedItem().toString();
        //String bloodgrp = blood.getText().toString();
        //String cpassword = confirm_pass.getText().toString();
        String alternate = altcontact.getText().toString();
        String address = add.getText().toString();
        String state = spinner2.getSelectedItem().toString();


        new SigninActivity(this,status,role,1).execute(username,contact,registration,bloodgrp,alternate,address,state);

    }
}
