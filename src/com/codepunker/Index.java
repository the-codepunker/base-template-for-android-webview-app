package com.codepunker;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.codepunker.codePunkerWebViewC;
import android.net.Uri;
import android.graphics.Bitmap;
import android.widget.ProgressBar;

public class Index extends Activity 
{
  private WebView codePunkerWebView;
  private ProgressBar progressBar;

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event)
  {
      if ((keyCode == KeyEvent.KEYCODE_BACK) && codePunkerWebView.canGoBack()) 
      {
    	codePunkerWebView.goBack();
        return true;
      }
      return super.onKeyDown(keyCode, event);
  }

  @SuppressLint("SetJavaScriptEnabled") //remove the stupid warning
  @Override
  protected void onCreate(Bundle savedInstanceState) 
  {
	super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_index);

    codePunkerWebView = (WebView) findViewById(R.id.webview);
    progressBar = (ProgressBar) findViewById(R.id.progressBar1);

    WebViewClient client = new codePunkerWebViewC() 
    {
        @Override
        public void launchExternalBrowser(String url) 
        {
          Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
          startActivity(intent);
        }
      
        @Override
        public void onPageStarted(WebView codePunkerWebView, String url, Bitmap favicon)
        {
          super.onPageStarted(codePunkerWebView, url, favicon);
        }

        @Override
        public void onPageFinished(WebView codePunkerWebView, String url)
        {
          super.onPageFinished(codePunkerWebView, url);
          progressBar.setVisibility(View.GONE);
        }
    };
    
    codePunkerWebView.setWebViewClient(client);
    codePunkerWebView.getSettings().setJavaScriptEnabled(true);
    codePunkerWebView.getSettings().setUserAgentString("Codepunker.com/0.1 (http://codepunker.com/CodePunker/; info@codepunker.com)");
    codePunkerWebView.loadUrl("http://www.codepunker.com");
  }
}