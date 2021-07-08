package com.ferditas.calculatorandmathformula;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    ListView pdfListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Toast.makeText(this, "Sayısal Formül İçeriklerine Hoşgeldiniz...", Toast.LENGTH_SHORT).show();

        pdfListView=(ListView) findViewById(R.id.myPDFList);

        String[] pdfFiles={"Matematik Formülleri Temel","Geometri Formülleri","Mutlak Değer Formülleri","Üslü Sayılar Formülleri"
        ,"Köklü Sayılar Formülleri","Trigonometri Formülleri","Logaritma Formülleri","Limit Formülleri","Türev Formülleri"
        ,"İntegral Formülleri","Yeni Nesil Matematik Soruları","Yeni Nesil Problemler"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pdfFiles){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view=super.getView(position, convertView, parent);
                TextView myText=(TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        pdfListView.setAdapter(adapter);
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item=pdfListView.getItemAtPosition(position).toString();

                Intent start=new Intent(getApplicationContext(),PDFOpener.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });
    }
}