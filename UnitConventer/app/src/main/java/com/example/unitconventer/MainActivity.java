package com.example.unitconventer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView  textView,textView2,textView4,ValueOfEuro;
     Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView4=findViewById(R.id.textView4);
        ValueOfEuro=findViewById(R.id.ValueOfEuro);
        editText= findViewById(R.id.editTextNumber);
        button=findViewById(R.id.button);
        Spinner spinner= findViewById(R.id.spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this, R.array.currency,android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] currencyarray=getResources().getStringArray(R.array.currency);
                if (parent.getSelectedItem().toString().equals(currencyarray[0])) {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ConvertFromLirastoUSD();
                        }
                    });
                }
                else if (parent.getSelectedItem().toString().equals(currencyarray[1])){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ConvertFromLirastoEuro();
                        }
                    });
                }
                else if (parent.getSelectedItem().toString().equals(currencyarray[2])){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ConvertFromLirastoALL();
                        }
                    });
                }

                textView4.setText(currencyarray[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConvertFromLirastoEuro();
            }
        });

    }

    private void ConvertFromLirastoEuro() {
        String valueEnteredinLiras =editText.getText().toString();
        double Liras= Double.parseDouble(valueEnteredinLiras);
        double euro=Liras/ 7.67;
        ValueOfEuro.setText(""+euro);

    }
    private void ConvertFromLirastoUSD() {
        String valueEnteredinLiras =editText.getText().toString();
        double Liras= Double.parseDouble(valueEnteredinLiras);
        double dolar=Liras/ 6.86;
        ValueOfEuro.setText(""+dolar);
    }
    private void ConvertFromLirastoALL() {
        String valueEnteredinLiras =editText.getText().toString();
        double Liras= Double.parseDouble(valueEnteredinLiras);
        double leke=Liras * 16.10;
        ValueOfEuro.setText(""+leke);
    }
}