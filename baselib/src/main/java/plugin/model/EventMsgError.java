package plugin.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误块
 * 作者：wjh on 2019-04-23 18:01
 */
public class EventMsgError implements FlutterChannel {

    public int errorCode;

    public EventMsgError(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public Map resultMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", errorCode);
        return map;
    }

    @Override
    public void parsingMap(Map map) {
    }

}
