package et.bingo.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

/**
 * Main Kotlin entry Activity for BINGO ET Android App.
 * Hosts the offline-ready BINGO ET engine and connects to Java game helpers.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.bingoWebView)
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.allowFileAccess = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true

        // Attach Java bridge for Birr (ETB) formatting and 1-600 round utilities
        webView.addJavascriptInterface(BingoJavaBridge(this), "BingoAndroid")
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        webView.loadUrl("file:///android_asset/public/index.html")
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
