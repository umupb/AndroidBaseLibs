package plugin.channel;

import android.text.TextUtils;

import java.util.Map;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import plugin.model.RequestData;
import plugin.util.ArgumentUtil;

/**
 * Method通道回调基类
 * 作者：wjh on 2019/4/17 20:38
 */
public class IMethodCallHandler implements MethodChannel.MethodCallHandler {

    private final IMethodCallback callHandler;

    public IMethodCallHandler(IMethodCallback callHandler) {
        this.callHandler = callHandler;
    }

    @Override
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        RequestData requestObj = new RequestData();
        requestObj.method = call.method;
        if (call.arguments != null && call.arguments instanceof Map) {
            requestObj.parsingMap((Map) call.arguments);
        }

        if (!TextUtils.isEmpty(call.method)) {
            switch (call.method) {
                default:
                    callHandler.onMethodCall(requestObj, new ResponseClass(result, requestObj.uniqueId()));
                    break;
            }
        } else {
            result.success(ArgumentUtil.responseErrorUnImpMethod(requestObj.uniqueId()));
            result.notImplemented();
        }
    }

}
