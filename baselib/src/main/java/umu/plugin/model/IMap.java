package umu.plugin.model;

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
            if (o != null && o instanceof String) {
                return (String) o;
            }
        }
        return null;
    }

    public int optInt(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null && o instanceof Integer) {
                return (Integer) o;
            }
        }
        return 0;
    }

    public float optFloat(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null && o instanceof Float) {
                return (Float) o;
            }
        }
        return 0f;
    }

    public double optDouble(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null && o instanceof Double) {
                return (Double) o;
            }
        }
        return 0;
    }

    public long optLong(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null && o instanceof Long) {
                return (Long) o;
            }
        }
        return 0;
    }

    public boolean optBool(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null && o instanceof Boolean) {
                return (Boolean) o;
            }
        }
        return false;
    }

    public Object optObj(String key) {
        if (map != null) {
            Object o = map.get(key);
            return o;
        }
        return null;
    }

    public Map optMap(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null && o instanceof Map) {
                return (Map) o;
            }
        }
        return null;
    }
}
