package hemmafix.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void pressButton(View view){

        EditText txtField = (EditText) findViewById(R.id.editText);
        TextView info = (TextView) findViewById(R.id.textView);

        String text = txtField.getText().toString();

        Scanner sc = new Scanner(text);

        String first="";
        String second="";

        DecimalFormat df = new DecimalFormat("#.###");

        try{


            if(sc.hasNext()){

                first = sc.next();//Hämtar det första talet

                double firstDouble = Double.parseDouble(first); // Parsar till double


                if(sc.hasNext()){ // Kollar om det finns ett till "ord"

                    second = sc.next(); //Hämtar nästa ord

                    if(second.equalsIgnoreCase("kg")||second.equalsIgnoreCase("kilo")){

                        double res = poundCon(firstDouble);

                        info.setText("Pounds: " + res);

                    }else if(second.equalsIgnoreCase("lb")||second.equalsIgnoreCase("pounds")){

                        double res = kiloCon(firstDouble);

                        info.setText("Kg: " + res);

                    }


                }else{

                    double resPound = poundCon(firstDouble);
                    double resKilo = kiloCon(firstDouble);

                    info.setText(+ firstDouble + " Kg = " + df.format(resKilo) + " Pounds\n" +
                             + firstDouble + " Pounds = " + df.format(resPound) + " Kg");



                }

            }

        }catch(NumberFormatException e){
             e.printStackTrace();
        }







    }

    public double kiloCon(double vikt){

        double res = vikt * 2.20462262;


        return res;


    }


    public double poundCon(double vikt){

        double res = vikt * 0.45359237;


        return res;


    }


    public void radioSet(){ // Används inte just nu..

        RadioButton r1 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton4);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        int selectedId = radioGroup.getCheckedRadioButtonId();

        RadioButton selectedButton = (RadioButton) findViewById(selectedId);

        Toast.makeText(MainActivity.this,selectedButton.getText(), Toast.LENGTH_SHORT).show();




    }




}
