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


    public Event generateEvent(String address1, String address2) throws IOException,SignatureException {


        int randomValue = mRandom.nextInt();
        String date = mFormat.format(mDate);
        String eventID;

        //Record record;
        String pointer = String.format("%s:%s:%s:%s",address1,address2,randomValue,date);
        eventID = hash(pointer);

        return new Event(eventID,pointer);
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
