package com.example.faustocheca.webviewasynctaskw;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    String journalSelected;
    String urlElPais = "http://elpais.com";
    String urlElMundo = "http://elmundo.com";
    String urlElConfidencial = "http://elconfidencial.com";
    String urlElConfidencialDigital = "http://elconfidencialdigital.com";
    String urlABC = "http://abc.es";
    String urlLaVanguardia = "http://laVanguardia.com";
    String urlOKDiario = "http://okdiario.com";
    String urlElEspañol = "http://elespanol.com";
    String urlLibertadDigital = "http://www.libertaddigital.com";
    String myUrl = null;
    Button buttonWeb;
    WebView webView;






    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adapt Spinner

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.Journals,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        journalSelected = spinner.getSelectedItem().toString();
        myUrl = traerURL(journalSelected);
        Log.i(">>TAG", myUrl);

        // si clikas el botón, se carga el Webview y la página Web seleccionada

        buttonWeb = (Button) findViewById(R.id.btn_load_web);

        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadMyWebPage ();

            }
        });






    }



    private void loadMyWebPage() {

        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(myUrl);



    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            Log.i(">>TAG", "yesCan");
            webView.goBack();
        } else {
            Log.i(">>TAG", "noCannot");
            super.onBackPressed();
        }
    }





    private String traerURL(String journal) {

        switch (journal) {
            case "El Pais":
                myUrl = urlElPais;
                break;
            case "El Mundo":
                myUrl = urlElMundo;
                break;
            case "El Confidencial":
                myUrl = urlElConfidencial;
                break;
            case "ABC":
                myUrl = urlABC;
                break;
            case "La Vanguardia":
                myUrl = urlLaVanguardia;
                break;
            case "OK Diario":
                myUrl = urlOKDiario;
                break;
            case "Libertad Digital":
                myUrl = urlLibertadDigital;
                break;
            case "El Español":
                myUrl = urlElEspañol;
                break;
            case "El Confidencial Digital":
                myUrl = urlElConfidencialDigital;
                break;
            default:
                myUrl="";

        }
        return myUrl;
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

