package plugin.model;

import java.util.Map;

import plugin.util.FlutterConstant;

/**
 * 响应数据块
 * 作者：wjh on 2019-04-23 16:14
 */
public class ResponseData extends ChannelData {

    public boolean status;
    public int errorCode;

    public ResponseData(String uniqueId) {
        this.uniqueId = uniqueId;
        this.status = true;
        this.errorCode = FlutterConstant.ErrorCode.SUCCESS;
    }

    public ResponseData(String uniqueId, int errorCode) {
        this.uniqueId = uniqueId;
        this.status = false;
        this.errorCode = errorCode;
    }

    @Override
    public Map resultMap() {
        Map map = super.resultMap();
        map.put("status", status);
        map.put("errorCode", errorCode);
        return map;
    }

    @Override
    public void parsingMap(Map map) {
        super.parsingMap(map);
        IMap iMap = IMap.map(map);
        status = iMap.optBool("status");
        errorCode = iMap.optInt("errorCode");
    }
}
