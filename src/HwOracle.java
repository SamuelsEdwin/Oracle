import hardware.ExtendedRecord;
import hardware.RecordGenerator;
import hardware.Sensor;
import hardware.SensorData;

public class HwOracle {

    Sensor mSensor;

    public HwOracle(String pSensorDir) {
        mSensor = new Sensor(pSensorDir);
    }

    public void init(){
        try {
            mSensor.initializeSignature();



        }catch (Exception i){

            i.printStackTrace();
            System.exit(1);
        }
    }


    public String getJsonRecord() {
        try {

            SensorData data = mSensor.readSensor();
            RecordGenerator generator = new RecordGenerator(mSensor);
            generator.init();
            ExtendedRecord extendedRecord = generator.generateExtendedRecord(data,"user1","user2");


            return extendedRecord.toJSON();
        }catch (Exception i){

            i.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
