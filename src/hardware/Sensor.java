package hardware;
import javafx.util.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.util.LinkedList;
import java.util.List;

public class Sensor {
    final static Charset ENCODING = StandardCharsets.UTF_8;
    //FIle directory generally the GPIO pin that the sensor is connected to
    private String mSensorDir;
    private String mSensorID;
    private String mSensorPK;
    private Signature mSignature;
    private Signature mVerifySignature;

    KeyPair mKeyPair;
    SecureRandom mSecureRandom;


    private static final String ENCRYPTION_ALGORITHM = "SHA256WithDSA";
    private static final String DSA_ENCRYPTION = "DSA";


    public Sensor(String pSensorDir) {
        mSensorDir = pSensorDir;

    }

    public  void initializeSignature() throws NoSuchAlgorithmException, InvalidKeyException {
        mSignature = Signature.getInstance(ENCRYPTION_ALGORITHM);
        mVerifySignature = Signature.getInstance(ENCRYPTION_ALGORITHM);
        mSecureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(DSA_ENCRYPTION);
        mKeyPair = keyPairGenerator.generateKeyPair();
        mSignature.initSign(mKeyPair.getPrivate(), mSecureRandom);
        mVerifySignature.initVerify(mKeyPair.getPublic());

    }

     public  List<Float> readSensorFloats() throws IOException {
         Path path = Paths.get(mSensorDir);
         List<String> lines = Files.readAllLines(path, ENCODING);

         List<Float> numericalLines  = new LinkedList<Float>();

         for (String line:lines) {
             numericalLines.add(Float.parseFloat(line));
         }
        return numericalLines;
    }


    public SensorData readSensor () throws IOException,SignatureException {
        Path path = Paths.get(mSensorDir);
        List<String> lines = Files.readAllLines(path, ENCODING);
        String sensorData = "";
        for (String line:lines) {
            sensorData += line.trim() + " :";
        }
        sensorData = sensorData.substring(0,sensorData.length()-2).trim();

        //String signature = sign(sensorData);

        return new SensorData(sensorData,sign(sensorData));



    }



    public byte[] sign(String pData) throws SignatureException {


        byte[] data = (pData.trim()).getBytes(ENCODING);

        mSignature.update(data);

        return mSignature.sign();

    }

    public boolean verify(String pData,byte[] pSignature) throws SignatureException {

        byte[] data = (pData.trim()).getBytes(ENCODING);

        mVerifySignature.update(data);
        return mVerifySignature.verify(pSignature);
    }







}