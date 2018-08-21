import hardware.Sensor;
import hardware.SensorData;

import javax.sound.midi.Soundbank;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Sensor test = new Sensor("Unversioned/input_1.txt");

    try {
        test.initializeSignature();
        SensorData data = test.readSensor();
        System.out.println(test.verify(data.mData,data.mSignature));


    }catch (Exception i){

        i.printStackTrace();

    }



    }
}

