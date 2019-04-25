package plugin.plugin;


import android.text.TextUtils;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import plugin.channel.IEventSender;
import plugin.channel.IMethodCallHandler;
import plugin.channel.IMethodCallback;
import plugin.channel.ResponseClass;
import plugin.model.RequestData;

/**
 * 插件基类
 * 作者：wjh on 2019/4/18 12:37
 */
public abstract class NativePlugin {

    /**
     * Method通道
     */
    protected MethodChannel methodChannel;
    /**
     * Event发送器
     */
    protected IEventSender eventSender;

    public NativePlugin(BinaryMessenger binaryMessenger) {
        if (binaryMessenger != null) {
            if (!TextUtils.isEmpty(getMethodChannelName())) {
                methodChannel = new MethodChannel(binaryMessenger, getMethodChannelName());
                methodChannel.setMethodCallHandler(new IMethodCallHandler(new IMethodCallback() {
                    @Override
                    public void onMethodCall(RequestData requestData, ResponseClass response) {
                        onLocalMethodCall(requestData, response);
                    }
                }));
            }

            if (!TextUtils.isEmpty(getEventChannelName())) {
                new EventChannel(binaryMessenger, getEventChannelName()).setStreamHandler(
                        new EventChannel.StreamHandler() {
                            @Override
                            public void onListen(Object arguments, EventChannel.EventSink events) {
                                eventSender = new IEventSender(events);
                            }

                            @Override
                            public void onCancel(Object arguments) {
                                eventSender.stopSend();
                            }
                        }
                );
            }
        }
    }

    protected abstract String getMethodChannelName();

    protected abstract String getEventChannelName();

    protected abstract void onLocalMethodCall(RequestData requestData, ResponseClass response);

    /**
     * 发送消息 Method
     *
     * @param method
     * @param arguments
     * @param callback
     */
    public void sendMethodMsg(String method, Object arguments, MethodChannel.Result callback) {
        if (methodChannel != null) {
            methodChannel.invokeMethod(method, arguments, callback);
        }
    }

    /**
     * 发送消息 Event
     *
     * @param arguments
     */
    public void sendEventMsg(Object arguments) {
        if (eventSender != null) {
            eventSender.send(arguments);
        }
    }

}
