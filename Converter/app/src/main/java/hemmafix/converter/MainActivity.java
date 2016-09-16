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

        radioSet();


        tempConverter t1 = new tempConverter();

        t1.tempConverterMethod();


        weightConverter w1 = new weightConverter();

        w1.weightConverter(sc, info);






    }





   /* public String tempConverter(Scanner sc){



        return "";

    }*/





    public void radioSet(){ // Används inte just nu..

        RadioButton r1 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton4);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        int selectedId = radioGroup.getCheckedRadioButtonId();

        RadioButton selectedButton = (RadioButton) findViewById(selectedId);

        Toast.makeText(MainActivity.this,selectedButton.getText(), Toast.LENGTH_SHORT).show();

        





    }




}
