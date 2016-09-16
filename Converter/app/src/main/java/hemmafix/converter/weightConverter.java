package hemmafix.converter;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by axelholm on 2016-09-16.
 */
public class weightConverter {


    public String weightConverter(Scanner sc, TextView info){


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


        return "";

    }





    public double kiloCon(double vikt){

        double res = vikt * 2.20462262;


        return res;


    }


    public double poundCon(double vikt){

        double res = vikt * 0.45359237;


        return res;


    }




}
