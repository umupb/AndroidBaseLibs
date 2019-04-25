package plugin.channel;

import io.flutter.plugin.common.MethodChannel;
import plugin.model.FlutterChannel;
import plugin.util.ArgumentUtil;

/**
 * 响应对象
 * 作者：wjh on 2019-04-23 16:38
 */
public class ResponseClass {
    public final MethodChannel.Result result;
    public final String uniqueId;

    public ResponseClass(MethodChannel.Result result, String uniqueId) {
        this.result = result;
        this.uniqueId = uniqueId;
    }

    public void success(FlutterChannel flutterChannel) {
        result.success(ArgumentUtil.responseSuccess(uniqueId, flutterChannel));
    }

    public void success() {
        result.success(ArgumentUtil.responseSuccess(uniqueId));
    }

    public void notImplemented() {
        result.success(ArgumentUtil.responseErrorUnImpMethod(uniqueId));
        result.notImplemented();
    }

}
