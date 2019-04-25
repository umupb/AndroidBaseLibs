package plugin.channel;

import io.flutter.plugin.common.EventChannel;

/**
 * Event发送器
 * 作者：wjh on 2019/4/17 21:19
 */
public class IEventSender {
    private EventChannel.EventSink events;
    private boolean isCanSend;

    public IEventSender(EventChannel.EventSink events) {
        this.events = events;
        if (events != null) {
            isCanSend = true;
        }
    }

    public void stopSend() {
        isCanSend = false;
    }

    public void send(Object object) {
        if (isCanSend)
            events.success(object);
    }
}
