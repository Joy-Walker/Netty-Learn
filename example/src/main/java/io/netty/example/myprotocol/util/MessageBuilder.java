package io.netty.example.myprotocol.util;

import io.netty.example.myprotocol.vo.Message;
import io.netty.example.myprotocol.vo.MessageHeader;
import io.netty.example.myprotocol.vo.MessageType;

/**
 * @Author panligang3
 * @create 2020/11/29 11:27 上午
 */
public class MessageBuilder {

    /**
     *
     * @param type 消息类型
     * @param content 消息内容
     * @param sessionId id
     * @return
     */
    public static Message buildMessage(MessageType type,String content,int sessionId){
        Message message = new Message();
        message.setContent(content);
        MessageHeader header = new MessageHeader();
        header.setSessionId(sessionId);
        header.setMessageType(type);
        message.setMessageHeader(header);
        return message;
    }

    public static Message buildMessage(MessageType type,String content){
        return buildMessage(type,content,-1);
    }
}
