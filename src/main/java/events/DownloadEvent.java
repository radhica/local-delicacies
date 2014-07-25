package events;

import android.util.Log;
import com.example.LocalDelicacies.LocationList;
import org.json.JSONObject;

/**
 * Created by bnegron on 7/24/14.
 */
public class DownloadEvent extends BaseEvent {
    LocationList result;
    public DownloadEvent(LocationList result) {
        this.result = result;
    }
    public LocationList getResult(){return result;}
}
