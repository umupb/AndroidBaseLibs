package plugin.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Event消息数据
 * 作者：wjh on 2019-04-23 18:36
 */
public class EventMsgData implements FlutterChannel {
    public String event;
    public FlutterChannel data;

    public EventMsgData(String event) {
        this.event = event;
    }

    public EventMsgData(String event, FlutterChannel data) {
        this.event = event;
        this.data = data;
    }

    @Override
    public Map resultMap() {
        Map map = new HashMap<>();
        map.put("event", event);
        if (data != null)
            map.put("data", data.resultMap());
        return null;
    }

    @Override
    public void parsingMap(Map map) {
    }

}
