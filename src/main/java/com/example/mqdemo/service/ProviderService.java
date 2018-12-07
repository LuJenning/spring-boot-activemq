package com.example.mqdemo.service;

public interface ProviderService {
    /**
     * 发送消息
     *
     * @param message 消息体
     */
    void sendMsg(String message);

    /**
     * 接收消息
     *
     * @param message 消息体
     */
    void receiveMsg(String message);
}
