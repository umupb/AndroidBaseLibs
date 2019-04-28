package umu.plugin.model;

import java.util.ArrayList;
import java.util.List;
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
            if (o instanceof Map) {
                return (Map) o;
            }
        }
        return null;
    }

    public void optList(String key, ClassT ClassT) {
        if (map != null) {
            Object o = map.get(key);
            if (o instanceof List) {
                ClassT.toList((List) o);
                return;
            }
        }

        ClassT.list(null);
    }

    public static abstract class ClassT<T extends FlutterChannel> {
        public void toList(List list) {
            if (list != null) {
                List<T> ts = new ArrayList<>();
                boolean typeState = false; // 增加一个状态可减少遍历时的类型转换
                for (Object lo : list) {
                    if (!typeState && lo instanceof FlutterChannel) {
                        typeState = true;
                    }
                    if (!typeState) {
                        break;
                    }

                    ts.add((T) lo);
                }

                list(ts);
            }
        }

        public abstract void list(List<T> ts);
    }

}
