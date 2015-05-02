package app.srmaakash.bloodapp;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class BankFragment extends Fragment {

    public BankFragment() {
    }

    private WebView mWebView2;

    View rootview;
    ProgressDialog mProgress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_bank, container, false);

        mWebView2 = (WebView) rootview.findViewById(R.id.bankView);

        WebSettings webSettings = mWebView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        mProgress = ProgressDialog.show(getActivity(), "Loading", "Please wait ...");
        mWebView2.setWebViewClient(new WebViewClient() {
            // load url
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            // when finish loading page
            public void onPageFinished(WebView view, String url) {
                if (mProgress.isShowing()) {
                    mProgress.dismiss();
                }
            }
        });
        mWebView2.getSettings().setSupportZoom(true);
        mWebView2.getSettings().setBuiltInZoomControls(true);
        mWebView2.loadUrl("http://www.srmcse.co.in/blood/bloodbank.php");


        return rootview;
    }


}
