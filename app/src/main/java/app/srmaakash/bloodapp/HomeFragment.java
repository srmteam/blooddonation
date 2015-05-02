package app.srmaakash.bloodapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}




	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        WebView mWebView;
        mWebView = (WebView) rootView.findViewById(R.id.webView2);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("file:///android_asset/index.html");









          Button reg = (Button)rootView.findViewById(R.id.button2);
          Button hosp_button = (Button) rootView.findViewById(R.id.button);
        //Button login_button = (Button) rootView.findViewById(R.id.button);
        Button donorbutton = (Button)rootView.findViewById(R.id.donor_botton);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDetail();
            }
        });



        donorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createdonor();
            }
        });

        hosp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospitalDetails();
            }
        });
         
        return rootView;
    }

    public void registerDetail(){
        Intent log3 = new Intent(getActivity(),Registration.class);
        startActivity(log3);
    }


    public void createdonor(){
        Intent log = new Intent(getActivity(), Donors_list.class);
        startActivity(log);
    }

    public void hospitalDetails(){
        Intent log4 = new Intent(getActivity(),Hospitals.class);
        startActivity(log4);
    }
}
