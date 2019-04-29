package umu.plugin.model;

import java.util.Map;

import umu.plugin.util.NumberUtil;

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
            if (o != null) {
                return String.valueOf(o);
            }
        }
        return null;
    }

    public int optInt(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null) {
                return NumberUtil.parseInt(o);
            }
        }
        return 0;
    }

    public float optFloat(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null) {
                return NumberUtil.parseFloat(o);
            }
        }
        return 0f;
    }

    public double optDouble(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null) {
                return NumberUtil.parseDouble(o);
            }
        }
        return 0;
    }

    public long optLong(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null) {
                return NumberUtil.parseLong(o);
            }
        }
        return 0;
    }

    public boolean optBool(String key) {
        if (map != null) {
            Object o = map.get(key);
            if (o != null) {
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
