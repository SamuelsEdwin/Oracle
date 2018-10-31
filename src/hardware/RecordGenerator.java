package hardware;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public class RecordGenerator {

    private static String HASHING_ALGORITHM = "SHA-256";
    final static Charset ENCODING = StandardCharsets.UTF_8;

    private Sensor mSensor;
    private Random mRandom;
    private Date mDate;
    private SimpleDateFormat mFormat;
    private MessageDigest mDigest;
    public RecordGenerator (Sensor sensor) {

        mSensor = sensor;
        mRandom = new Random();
        mDate = new Date();
        mFormat = new SimpleDateFormat("dd:MM:yyyy 'at' HH:mm");


    }
    public void init() throws NoSuchAlgorithmException {
        mDigest = MessageDigest.getInstance(HASHING_ALGORITHM);

    }
    public Event generateEvent(String pID1, String pID2) throws SignatureException {


        int randomValue = mRandom.nextInt();
        String date = mFormat.format(mDate);
        String eventID;

        //Record record;
        String pointer = String.format("%s:%s:%s:%s",pID1,pID2,randomValue,date);
        eventID = hash(pointer);

        return new Event(eventID,pointer);
    }


    public Record generateRecord(Record pData, String pID1,String pID2) throws SignatureException {

        Event event = generateEvent(pID1,pID2);


        return new Record(pData.mData,pData.mSignature,event.mEventID);


    }



    public ExtendedRecord generateExtendedRecord(SensorData pData, String pID1,String pID2) throws SignatureException {

        Event event = generateEvent(pID1,pID2);
        return new ExtendedRecord(
                new Record(pData.mData,pData.mSignature,event.mEventID),
                event.mEventString);
    }



    private String hash( String pInput) {

        byte[] hash = mDigest.digest(
                pInput.getBytes(ENCODING));

        return  bytesToHex(hash);

    }

    public static String bytesToHex(byte[] pHash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < pHash.length; i++) {
            String hex = Integer.toHexString(0xff &pHash[i]);
            if(hex.length() == 1) {hexString.append('0');}
            hexString.append(hex);
        }
        return hexString.toString();
    }



}
