package hardware;

public class SensorData {
    public String mData;
    public byte[] mSignature;


    public SensorData (String pData ,byte[] pSignature) {

        mData = pData;
        mSignature = pSignature;

    }

    @Override
    public String toString() {
        return "SensorData{" +
                "mData='" + mData + '\'' +
                ", mSignature='" + mSignature + '\'' +
                '}';
    }
}
