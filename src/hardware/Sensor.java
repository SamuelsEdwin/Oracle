package hardware;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Sensor {
    final static Charset ENCODING = StandardCharsets.UTF_8;
    //FIle directory generally the GPIO pin that the sensor is connected to
    private String mSensorDir;

    public Sensor(String pSensorDir) {
        mSensorDir = pSensorDir;
    }

     public  List<Float> readSensor() throws IOException {
         Path path = Paths.get(mSensorDir);
         List<String> lines = Files.readAllLines(path, ENCODING);

         List<Float> numericalLines  = new LinkedList<Float>();

         for (String line:lines) {
             numericalLines.add(Float.parseFloat(line));
         }
        return numericalLines;
    }




}