package plugin.model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;


/**
 * 参数数据 请求、发送 共有部分
 * 作者：wjh on 2019-04-23 16:22
 */
public class ChannelData<T extends FlutterChannel> implements FlutterChannel {
    private static final String TAG = "ChannelData";

    public String uniqueId;
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
    }

    /**
     * 类型扩展使用
     *
     * @param c
     * @param <T>
     * @return
     */
    public <T extends FlutterChannel> T mapToObj(Class<T> c) {
        if (dataMap != null) {
            try {
                T t = (T) Class.forName(c.getName()).newInstance();
                t.parsingMap(dataMap);
                return t;
            } catch (InstantiationException e) {
                Log.e(TAG, "JSON:    " + e.getMessage());
            } catch (IllegalAccessException e) {
                Log.e(TAG, "JSON:    " + e.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "JSON:    " + e.getMessage());
            }
        }
        return null;
    }

    public ChannelData data(T data) {
        this.data = data;
        return this;
    }

    public String uniqueId() {
        return uniqueId;
    }
}
