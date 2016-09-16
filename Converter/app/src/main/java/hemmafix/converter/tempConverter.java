package hemmafix.converter;

import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by axelholm on 2016-09-16.
 */
public class tempConverter {

    public String tempConverterMethod(Scanner sc, TextView info){

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

                        double res = celciusCon(firstDouble);
                        info.setText("Pounds: " + res);

                    }else if(second.equalsIgnoreCase("lb")||second.equalsIgnoreCase("pounds")){

                        double res = farenCon(firstDouble);
                        info.setText("Kg: " + res);

                    }


                }else{

                    double resPound = celciusCon(firstDouble);
                    double resKilo = farenCon(firstDouble);

                    info.setText(+ firstDouble + " Fahrenheit = " + df.format(resKilo) + " Celcius\n" +
                            + firstDouble + "Celcius  = " + df.format(resPound) + " Fahrenheit");



                }

            }

        }catch(NumberFormatException e){
            e.printStackTrace();
        }



        return "";

    }




    public double celciusCon(double d){

        double res = d * 1.8 + 32;


        return res;
    }

    public double farenCon(double d){

        double tmp = d - 32;
        double res = tmp / 1.8;

        return res;
    }


}
