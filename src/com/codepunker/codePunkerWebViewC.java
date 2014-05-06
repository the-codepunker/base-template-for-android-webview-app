package com.codepunker;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.Uri;

public abstract class codePunkerWebViewC extends WebViewClient 
{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) 
    {
        if (Uri.parse(url).getHost().equals("www.codepunker.com")) 
            return false;
        
        launchExternalBrowser(url);            
        return true;
    }
    
    public abstract void launchExternalBrowser(String url);
}