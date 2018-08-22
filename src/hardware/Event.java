package hardware;

public class Event {
    public String mEventString;
    public String mEventID;

    public Event(String pEventID,String pEventString) {
        mEventID = pEventID;
        mEventString = pEventString;
    }

    @Override
    public String toString() {
        return "Event{" +
                "mEventString='" + mEventString + '\'' +
                ", mEventID='" + mEventID + '\'' +
                '}';
    }
}
