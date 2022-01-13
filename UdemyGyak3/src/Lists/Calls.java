package Lists;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calls {
    private Date timeStamp;
    private Contacts calledContact;

    public Calls(Contacts calledContact) {
        this.calledContact = calledContact;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        timeStamp = new Date(System.currentTimeMillis());

    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public Contacts getCalledContact() {
        return calledContact;
    }
}
