package plugin.util;

/**
 * 常量数据
 * 作者：wjh on 2019/3/11 17:42
 */
public class FlutterConstant {

    /**
     * 全局
     */
    public static final String PLATFORM_METHOD = "umu.flutter.module/method.channel";
    public static final String PLATFORM_EVENT = "umu.flutter.module/event.channel";
    /**
     * 录音
     */
    public static final String PLATFORM_METHOD_AUDIO_RECORDER = "umu.audioRecorder.module/method.channel";
    public static final String PLATFORM_EVENT_AUDIO_RECORDER = "umu.audioRecorder.moudle/event.channel";
    /**
     * 播放器
     */
    public static final String PLATFORM_METHOD_AUDIO_PLAYER = "umu.audioPlayer.module/method.channel";
    public static final String PLATFORM_EVENT_AUDIO_PLAYER = "umu.audioPlayer.module/event.channel";

    /**
     * 通道消息指令
     */
    public static final class MethodCommand {
        public static final String FUNCTION_LOG = "log";
        public static final String FUNCTION_BACK = "back";
        public static final String FUNCTION_ENV = "getEnv";
        public static final String FUNCTION_NAVIGATE = "navigateTo";

        public static final String AUDIO_RECORDER_PERMISSION = "permission"; // 是否开启录音权限
        public static final String AUDIO_RECORDER_NEW = "new"; // 初始化录音机
        public static final String AUDIO_RECORDER_FREE = "free"; // 录音机析构释放
        public static final String AUDIO_RECORDER_START = "start"; // 开始录音
        public static final String AUDIO_RECORDER_PAUSE = "pause"; // 暂停录音
        public static final String AUDIO_RECORDER_RESUME = "resume"; // 继续录音
        public static final String AUDIO_RECORDER_STOP = "stop"; // 结束录音
        public static final String AUDIO_RECORDER_DELETE = "delete"; // //删除一段录音

        public static final String AUDIO_PLAYER_NEW = "new"; // 音频播放器初始化
        public static final String AUDIO_PLAYER_FREE = "free"; // 音频播放器析构释放
        public static final String AUDIO_PLAYER_SET_URL = "setUrl"; // 设置当前播放的Url
        public static final String AUDIO_PLAYER_GET_URL = "getUrl"; // 获取当前播放的Url
        public static final String AUDIO_PLAYER_PLAY = "play"; // 开始播放
        public static final String AUDIO_PLAYER_PAUSE = "pause"; // 暂停播放
        public static final String AUDIO_PLAYER_RESUME = "resume"; // 恢复播放
        public static final String AUDIO_PLAYER_STOP = "stop"; // 停止播放
        public static final String AUDIO_PLAYER_SEEK = "seek"; // 指定某一时间点开始播放

    }

    public static final class EventCommand {
        public static final String AUDIO_RECORDER_ON_ERROR = "onError"; // 录音器发生错误
        public static final String AUDIO_PLAYER_ON_ERROR = "onError"; // 播放器发生错误
        public static final String AUDIO_PLAYER_ON_PLAYING = "onPlaying"; // 音频开始播放
        public static final String AUDIO_PLAYER_ON_BUFFERING = "onBuffering"; // 音频数据正在缓存
        public static final String AUDIO_PLAYER_ON_COMPLETED = "onCompleted"; // 音频播放完毕
        public static final String AUDIO_PLAYER_TIME_UPDATE = "onTimeUpdate"; // 播放时长，按timer固定间隔
        public static final String AUDIO_RECORDER_TIME_UPDATE = "onTimeUpdate"; // 录制时长，按timer固定间隔
        public static final String AUDIO_RECORDER_TIME_MAX = "onMaxTime"; // 录音已达到最大时长。(业务上做暂停处理)
    }

    public static final class ErrorCode {
        public static final int SUCCESS = 0; // 表示成功
        public static final int METHOD_100001 = 100001; // 调用方法未实现
        public static final int METHOD_100002 = 100002; // 参数错误
        public static final int METHOD_110001 = 110001; // 录音机发生内部错误
        public static final int METHOD_120001 = 120001; // 播放器内部发生错误
        public static final int METHOD_120002 = 120002; // 播放音频文件错误
        public static final int METHOD_120003 = 120003; // 播放器网络错误

    }
}
