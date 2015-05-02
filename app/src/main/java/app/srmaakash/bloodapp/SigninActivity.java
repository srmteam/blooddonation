package app.srmaakash.bloodapp;

/**
 * Created by Lenovo on 2/26/2015.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SigninActivity  extends AsyncTask<String,Void,String>{

    private TextView statusField,roleField;
    private Context context;
    private int byGetOrPost = 1;
    //flag 0 means get and 1 means post.(By default it is get.)
    public SigninActivity(Context context,TextView statusField,
                          TextView roleField,int flag) {
        this.context = context;
        this.statusField = statusField;
        this.roleField = roleField;
        byGetOrPost = flag;
    }

    protected void onPreExecute(){

    }
    @Override
    protected String doInBackground(String... arg0) {
        if(byGetOrPost == 1){ //means by Get Method
            try{


                String username = (String)arg0[0];

                String contact  = (String)arg0[1];
                //String city     = (String)arg0[3];
                String registration = (String)arg0[2];
                String bloodgrp = (String)arg0[3];
                String alternate = (String)arg0[4];
                String address = (String)arg0[5];
                String state = (String)arg0[6];
                String link="http://technorexx.in/register1.php";
                String data  = URLEncoder.encode("username", "UTF-8")
                        + "=" + URLEncoder.encode(username, "UTF-8");

                data += "&" + URLEncoder.encode("contact", "UTF-8")
                        + "=" + URLEncoder.encode(contact, "UTF-8");

                data += "&" + URLEncoder.encode("registration", "UTF-8")
                        + "=" + URLEncoder.encode(registration, "UTF-8");
                data += "&" + URLEncoder.encode("bloodgrp", "UTF-8")
                        + "=" + URLEncoder.encode(bloodgrp, "UTF-8");
                data += "&" + URLEncoder.encode("alternate", "UTF-8")
                        + "=" + URLEncoder.encode(alternate, "UTF-8");
                data += "&" + URLEncoder.encode("address", "UTF-8")
                        + "=" + URLEncoder.encode(address, "UTF-8");
                data += "&" + URLEncoder.encode("state", "UTF-8")
                        + "=" + URLEncoder.encode(state, "UTF-8");
                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter
                        (conn.getOutputStream());
                wr.write( data );
                wr.flush();
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;
                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result){
        this.statusField.setText("");
        this.roleField.setText(result);

        /*if(result.equals("y")){


            Toast toast = Toast.makeText(context, "You Have Successfully Registered", Toast.LENGTH_LONG);
            toast.show();

        }*/

        /*else if(result.equals("m"))
        {
            Toast toast = Toast.makeText(context, "Invalid Mobile Number", Toast.LENGTH_LONG);
            toast.show();
        }

        else if(result.equals("a"))
        {
            Toast toast = Toast.makeText(context, "Given userame has Already been Registered", Toast.LENGTH_LONG);
            toast.show();
        }*/

       /* else if(result.equals("n"))
        {
            Toast toast = Toast.makeText(context, "Give Details Correctly", Toast.LENGTH_LONG);
            toast.show();
        }*/





    }
}
