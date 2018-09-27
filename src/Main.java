/*

import hardware.RecordGenerator;
import hardware.Sensor;
import hardware.SensorData;

*/


public class Main {

    public static void main(String[] args) {
	// write your code here
/*    Sensor test = new Sensor("Unversioned/input_1.txt");

    try {
        test.initializeSignature();
        SensorData data = test.readSensor();
        System.out.println(test.verify(data.mData ,data.mSignature));
        RecordGenerator generator = new RecordGenerator(test);
        generator.init();
       // System.out.println(generator.generateSignature("adde1","add2"));
        deployment.generateWallet();


        }catch (Exception i){

        i.printStackTrace();

        }


        System.out.println("words");
        */


        try {
            Deploy deployment = new Deploy();
            deployment.generateWallet();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}

