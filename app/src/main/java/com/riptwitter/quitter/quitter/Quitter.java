package com.riptwitter.quitter.quitter;
//import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Quitter extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_quitter);
        WebView webview= (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new MyBrowser());
        TextView t =(TextView) findViewById(R.id.header2);
        Random random=new Random();

        String[] surpriseText = {"Say no to censorship",
                                "Internet != North Korea",
                                "Free speech is the best",
                                "I say it, even you don't like it",
                                "Support #Gamergate",
                                "Sarkeesian == Censorship"
        };
        int surpriseInt=random.nextInt(7);

        t.setText(surpriseText[surpriseInt]);
        webview.loadUrl("https://quitter.es");
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

       /*


       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String pattern = "(Quitter\\.(is|es)|Quitter\\.no|sealion\\.club|gnutan\\.xyz|freezepeach\\.xyz)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(url);
            if( m.find()) {
                view.loadUrl(url);
                return true;
            }
            else{
                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

                return true;
            }


        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quitter, menu);
        return true;
    }

}