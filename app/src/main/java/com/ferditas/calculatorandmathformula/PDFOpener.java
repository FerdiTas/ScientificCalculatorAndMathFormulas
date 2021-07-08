package com.ferditas.calculatorandmathformula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener extends AppCompatActivity {

    PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_opener);

        myPDFViewer=(PDFView) findViewById(R.id.pdfViewer);

        String getItem=getIntent().getStringExtra("pdfFileName");

        if(getItem.equals("Matematik Formülleri Temel")){
            myPDFViewer.fromAsset("matematik_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Geometri Formülleri")){
            myPDFViewer.fromAsset("geometri_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Mutlak Değer Formülleri")){
            myPDFViewer.fromAsset("mutlakDeger_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Üslü Sayılar Formülleri")){
            myPDFViewer.fromAsset("usluSayilar_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Köklü Sayılar Formülleri")){
            myPDFViewer.fromAsset("kokluSayilar_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Trigonometri Formülleri")){
            myPDFViewer.fromAsset("trigonometri_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Logaritma Formülleri")){
            myPDFViewer.fromAsset("logaritma_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Limit Formülleri")){
            myPDFViewer.fromAsset("limit_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Türev Formülleri")){
            myPDFViewer.fromAsset("turev_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("İntegral Formülleri")){
            myPDFViewer.fromAsset("integral_formulleri.pdf.pdf").load();
        }
        if(getItem.equals("Yeni Nesil Matematik Soruları")){
            myPDFViewer.fromAsset("yeniMatSoruları.pdf").load();
        }
        if(getItem.equals("Yeni Nesil Problemler")){
            myPDFViewer.fromAsset("yeniNesilProblemler.pdf").load();
        }

    }
}