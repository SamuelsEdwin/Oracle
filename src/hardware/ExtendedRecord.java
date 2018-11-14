package hardware;

public class ExtendedRecord {
    public Record mRecord;
    public String mSignaturePointer;

    public ExtendedRecord(Record pRecord, String pSignaturePointer) {

        mRecord = pRecord;
        mSignaturePointer = pSignaturePointer;

    }

    @Override
    public String toString() {
        return "ExtendedRecord{" +
                "mRecord=" + mRecord +
                ", mSignaturePointer='" + mSignaturePointer + '\'' +
                '}';
    }


    public String toJSON() {

        return  "{"+
                "\"payload\":"+"\"" +mRecord.mData+" "+ RecordGenerator.bytesToHex(mRecord.mSignature) +"\""+"," +
                "\"EventID\":"+"\""+mRecord.mEventID+"\""+","
                +"\"EventIDString\":"+"\""+mSignaturePointer+"\""+"}";

    }
}
