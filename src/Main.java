

import hardware.ExtendedRecord;
import hardware.RecordGenerator;
import hardware.Sensor;
import hardware.SensorData;




public class Main {

    public static void main(String[] args) {
	// write your code here
    HwOracle test = new HwOracle("Unversioned/input_1.txt");
    try {

        test.init();
        System.out.println(test.getJsonRecord());


        }catch (Exception i){

        i.printStackTrace();

        }
    }

}

