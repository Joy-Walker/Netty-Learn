package io.netty.example.myprotocol.vo;

/**
 * @Author panligang3
 * @create 2020/11/29 11:10 上午
 */
public class Message {

    /**
     * 消息内容
     */
    private String content;

    private MessageHeader messageHeader;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", messageHeader=" + messageHeader +
                '}';
    }
}
