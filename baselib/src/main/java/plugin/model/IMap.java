package plugin.model;

import java.util.Map;

/**
 * 作者：wjh on 2019-04-23 17:03
 */
public class IMap {

    private Map map;

    public IMap(Map map) {
        this.map = map;
    }

    public static IMap map(Map map) {
        return new IMap(map);
    }

    public String optStr(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o instanceof String) {
                return (String) o;
            }
        }
        return null;
    }

    public Integer optInt(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o instanceof Integer) {
                return (Integer) o;
            }
        }
        return null;
    }

    public Long optLong(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o instanceof Long) {
                return (Long) o;
            }
        }
        return null;
    }

    public Boolean optBool(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o instanceof Boolean) {
                return (Boolean) o;
            }
        }
        return null;
    }

    public Map optMap(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o instanceof Map) {
                return (Map) o;
            }
        }
        return null;
    }

}
