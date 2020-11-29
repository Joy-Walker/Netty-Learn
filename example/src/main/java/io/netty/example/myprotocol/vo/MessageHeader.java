package io.netty.example.myprotocol.vo;

/**
 * @Author panligang3
 * @create 2020/11/29 11:11 上午
 */
public class MessageHeader {

    /**
     * sessionId
     */
    private Integer sessionId;

    /**
     * 消息类型
     */
    private  MessageType messageType;


    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageHeader{" +
                "sessionId=" + sessionId +
                ", messageType=" + messageType +
                '}';
    }
}
