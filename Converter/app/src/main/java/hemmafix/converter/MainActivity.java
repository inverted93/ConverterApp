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

        try{


            if(sc.hasNext()){

                first = sc.next();
                double firstDouble = Double.parseDouble(first);

                if(sc.hasNext()){

                    second = sc.next();

                    if()





                    double res = pound(firstDouble);

                    info.setText("Kg " + res);

                    radioSet();

                }else{

                }

            }

        }catch(NumberFormatException e){
             e.printStackTrace();
        }







    }



    public double pound(double vikt){

        double res = vikt * 0.45359237;


        return res;


    }


    public void radioSet(){

        RadioButton r1 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton4);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        int selectedId = radioGroup.getCheckedRadioButtonId();

        RadioButton selectedButton = (RadioButton) findViewById(selectedId);

        Toast.makeText(MainActivity.this,selectedButton.getText(), Toast.LENGTH_SHORT).show();




    }




}
