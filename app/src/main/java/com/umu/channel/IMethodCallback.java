package com.umu.channel;

import umu.plugin.model.RequestData;

/**
 * Method通道回调
 * 作者：wjh on 2019/4/17 20:51
 */
public interface IMethodCallback {
    void onMethodCall(RequestData requestData, ResponseClass response);
}
