import hardware.Sensor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Sensor test = new Sensor("Unversioned/input_1.txt");

    try {
        System.out.println(test.readSensor());
    }catch (IOException i){

        i.printStackTrace();

    }



    }
}

