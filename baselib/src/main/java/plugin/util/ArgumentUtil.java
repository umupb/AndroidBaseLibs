package plugin.util;

import java.util.Map;
import java.util.UUID;

import plugin.model.FlutterChannel;
import plugin.model.ResponseData;


/**
 * 参数转换类
 * 作者：wjh on 2019/3/15 10:46
 */
public class ArgumentUtil {

    /**
     * Flutter方法回调结果 Success
     *
     * @return
     */
    public static final Map responseSuccess(String uniqueId) {
        return new ResponseData(uniqueId).resultMap();
    }

    /**
     * Flutter方法回调结果 Success带参数
     *
     * @param uniqueId
     * @param flutterChannel
     * @return
     */
    public static final Map responseSuccess(String uniqueId, FlutterChannel flutterChannel) {
        return new ResponseData(uniqueId).data(flutterChannel).resultMap();
    }

    /**
     * Flutter方法回调结果 Error
     *
     * @param errorCode
     * @return
     */
    public static final Map responseError(String uniqueId, int errorCode) {
        return new ResponseData(uniqueId, errorCode).resultMap();
    }

    /**
     * Flutter方法回调结果 方法未实现
     *
     * @return
     */
    public static final Map responseErrorUnImpMethod(String uniqueId) {
        return responseError(uniqueId, FlutterConstant.ErrorCode.METHOD_100001);
    }

    /**
     * 获取一个唯一的uniqueId
     *
     * @return
     */
    public static String getUniqueId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
