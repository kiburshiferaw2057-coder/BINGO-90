package et.bingo.app;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import java.util.Locale;

/**
 * Java helper and WebView JavascriptInterface for BINGO ET.
 * Handles native Android toasts, Birr (ETB) formatting, and 1-600 card validation.
 */
public class BingoJavaBridge {
    private final Context context;

    public BingoJavaBridge(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void showNativeToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public String formatBirr(double amount) {
        return String.format(Locale.US, "%.2f ETB", amount);
    }

    @JavascriptInterface
    public boolean isValidCardNumber(int number) {
        return number >= 1 && number <= 600;
    }
}
