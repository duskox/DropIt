package vorkapic.com.dropit.dataModels;

import android.location.Location;

import java.text.SimpleDateFormat;

/**
 * Created by dvor on 19/07/16.
 */
public class Drop {

    private String title;
    private String message;
    private String attachment;
    private Location location;
    private SimpleDateFormat birth;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation(double latitude, double longitude) {
        this.location = new Location("manual");
        this.location.setLatitude(latitude);
        this.location.setLongitude(longitude);
    }

    public void setBirth(SimpleDateFormat birth) {
        this.birth = birth;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getAttachment() {
        return attachment;
    }

    public Location getLocation() {
        return location;
    }

    public SimpleDateFormat getBirth() {
        return birth;
    }

    public double getLatitude() {
        return location.getLatitude();
    }

    public double getLongitude() {
        return location.getLongitude();
    }
}
