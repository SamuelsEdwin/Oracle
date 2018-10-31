package hardware;

import java.util.Arrays;

public class Record {
    public String mData;
    public byte[] mSignature;//sensors signature
    public String mEventID;// Hash of officers ID:PersonID:Time:Random string Hash

    public Record(String pData, byte[] pSignature, String pEventID) {
        this.mData = pData;
        this.mSignature = pSignature;
        this.mEventID = pEventID;
    }

    @Override
    public String toString() {
        return "Record{" +
                "mData='" + mData + '\'' +
                ", mSignature=" + Arrays.toString(mSignature) +
                ", mEventID='" + mEventID + '\'' +
                '}';
    }
}


