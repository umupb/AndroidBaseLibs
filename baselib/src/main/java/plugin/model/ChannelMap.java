package plugin.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单业务数据块
 * 作者：wjh on 2019-04-23 18:01
 */
public class ChannelMap implements FlutterChannel {

    /**
     * 接受数据
     */
    public IMap iMap;
    /**
     * 发送数据
     */
    private Map<String, Object> data = new HashMap<>();

    @Override
    public Map resultMap() {
        return data;
    }

    @Override
    public void parsingMap(Map map) {
        this.iMap = new IMap(map);
    }

    public ChannelMap add(String key, Object values) {
        data.put(key, values);
        return this;
    }

}
