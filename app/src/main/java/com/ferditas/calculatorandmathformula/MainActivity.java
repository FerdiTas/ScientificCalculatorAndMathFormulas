package com.ferditas.calculatorandmathformula;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.google.android.gms.ads.InterstitialAd;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    private Button buttonFormul;
    private EditText display;
    private TextView previousCalculation;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Interstitial Ad

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5023471144141976/6021719305");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        display=findViewById(R.id.displayEditText);
        previousCalculation=findViewById(R.id.previousCalculationView);

        display.setShowSoftInputOnFocus(false);


        buttonFormul=findViewById(R.id.buttonFormul);
        buttonFormul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });


    }

    private void updateText(String strToAdd){
        String oldStr=display.getText().toString();

        int cursorPos=display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPos);
        String rightStr=oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroClick(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneClick(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoClick(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeClick(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourClick(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveClick(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixClick(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenClick(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightClick(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineClick(View view){
        updateText(getResources().getString(R.string.nineText));
    }
    public void multiplyClick(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void divideClick(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void subtractClick(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void addClick(View view){
        updateText(getResources().getString(R.string.addText));
    }
    public void clearClick(View view){
        display.setText("");
        previousCalculation.setText("");
    }
    public void parOpenClick(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parCloseClick(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void decimalClick(View view){
        updateText(getResources().getString(R.string.decimalText));
    }
    public void equalClick(View view){
        String userExp=display.getText().toString();

        previousCalculation.setText(userExp);

        userExp=userExp.replaceAll(getResources().getString(R.string.divideText),"/");
        userExp=userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");

        Expression exp=new Expression(userExp);
        String result=String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void backspaceClick(View view){

        int cursorPos=display.getSelectionStart();
        int textLen=display.getText().length();

        if(cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection=(SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }
    public void trigSinClick(View view){
        updateText("sin(");
    }
    public void trigCosClick(View view){
        updateText("cos(");
    }
    public void trigTanClick(View view){
        updateText("tan(");
    }
    public void trigArcSinClick(View view){
        updateText("arcsin(");
    }
    public void trigArcCosClick(View view){
        updateText("arccos(");
    }
    public void trigArcTanClick(View view){
        updateText("arctan(");
    }
    public void naturalLogClick(View view){
        updateText("ln(");
    }
    public void logClick(View view){
        updateText("log10(");
    }
    public void sqrtClick(View view){
        updateText("sqrt(");
    }
    public void absClick(View view){
        updateText("abs(");
    }
    public void piClick(View view){
        updateText("pi");
    }
    public void eClick(View view){
        updateText("e");
    }
    public void xSquredClick(View view){
        updateText("^(2)");
    }
    public void xPowerYClick(View view){
        updateText("^(");
    }
    public void primeClick(View view){
        updateText("ispr(");
    }

}
