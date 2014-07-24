package events;

import org.json.JSONObject;

/**
 * Created by bnegron on 7/24/14.
 */
public class DownloadEvent extends BaseEvent {
    String result;
    public DownloadEvent(String result) {
        this.result = result;
    }
    public String getResult(){return result;}
}
