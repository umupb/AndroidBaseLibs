package plugin.model;

import java.util.Map;

/**
 * 请求数据块
 * 作者：wjh on 2019-04-23 16:18
 */
public class RequestData extends ChannelData {

    public String method;
    public IMap iMapData;

    @Override
    public Map resultMap() {
        return super.resultMap();
    }

    @Override
    public void parsingMap(Map map) {
        super.parsingMap(map);
        iMapData = new IMap(dataMap);
    }

    /**
     * 是否有数据
     *
     * @return
     */
    public boolean hasData() {
        return iMapData != null;
    }

}
