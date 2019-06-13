package umu.plugin.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import umu.plugin.model.FlutterChannel;

/**
 * 数据格式转换工具包
 * 作者：wjh on 2019-04-28 14:07
 */
public class IDataUtil {
    private static final String TAG = "IMapUtil";

    /**
     * 数组解析 List<T>
     * * <p>
     * 1.T若为有参构造方法 一定要再定义一个无惨构造方法，要不然实例化有问题
     * 2.T若为嵌套类一定要定义成"静态"类，嵌套类实际上并不需要引用一个封闭的实例。
     * </p>
     *
     * @param list
     * @param c
     * @param <T>
     * @return
     */
    public static <T extends FlutterChannel> List<T> flutterToArr(List list, Class<T> c) {
        if (list != null) {
            List<T> ts = new ArrayList<>();
            boolean typeState = false; // 增加一个状态可减少遍历时的类型转换
            for (Object lo : list) {
                if (!typeState && lo instanceof Map) {
                    typeState = true;
                }
                if (!typeState) {
                    break;
                }
                ts.add(flutterToObj((Map) lo, c));
            }
            return ts;
        }

        return null;
    }

    /**
     * 对象解析 T
     * <p>
     * 1.T若为有参构造方法 一定要再定义一个无惨构造方法，要不然实例化有问题
     * 2.T若为嵌套类一定要定义成"静态"类，嵌套类实际上并不需要引用一个封闭的实例。
     * </p>
     *
     * @param map
     * @param c
     * @param <T>
     * @return
     */
    public static <T extends FlutterChannel> T flutterToObj(Map map, Class<T> c) {
        if (map != null) {
            try {
                T t = (T) Class.forName(c.getName()).newInstance();
                t.parsingMap(map);
                return t;
            } catch (InstantiationException e) {
                Log.e(TAG, "FLUTTER:    " + e.getMessage());
            } catch (IllegalAccessException e) {
                Log.e(TAG, "FLUTTER:    " + e.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "FLUTTER:    " + e.getMessage());
            }
        }
        return null;
    }

    /**
     * list<T> To list<Map>
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends FlutterChannel> List<Map> toListMap(List<T> list) {
        List<Map> mapList = null;
        if (list != null && !list.isEmpty()) {
            mapList = new ArrayList<>();
            for (T t : list) {
                Map channelMap = t.resultMap();
                if (channelMap == null) {
                    continue;
                }

                mapList.add(channelMap);
            }
        }
        return mapList;
    }

    /**
     * list<Map> To list<T>
     *
     * @param mapList
     * @param c
     * @param <T>
     * @return
     */
    public static <T extends FlutterChannel> List<T> toListMap(List<Map> mapList, Class<T> c) {
        List<T> list = null;
        if (mapList != null && !mapList.isEmpty()) {
            list = new ArrayList<>();
            for (Map m : mapList) {
                T t = flutterToObj(m, c);
                if (t != null)
                    list.add(t);
            }
        }
        return list;
    }
}
