package umu.plugin.model;

import java.util.HashMap;
import java.util.Map;


/**
 * 参数数据 请求、发送 共有部分
 * 作者：wjh on 2019-04-23 16:22
 */
public class ChannelData<T extends FlutterChannel> implements FlutterChannel {
    public String uniqueId;
    public String url;
    public T data;
    public Map dataMap;

    @Override
    public Map resultMap() {
        Map map = new HashMap<>();
        map.put("uniqueId", uniqueId);
        if (data != null) {
            map.put("data", data.resultMap());
        }
        return map;
    }

    @Override
    public void parsingMap(Map map) {
        IMap iMap = IMap.map(map);
        uniqueId = iMap.optStr("uniqueId");
        dataMap = iMap.optMap("data");

        if (dataMap == null) { // 兼容Flutter端数据传递
            url = iMap.optStr("data");
        }
    }

    public ChannelData data(T data) {
        this.data = data;
        return this;
    }

    public String uniqueId() {
        return uniqueId;
    }
}
