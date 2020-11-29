package io.netty.example.myprotocol.vo;

/**
 * @author Mark老师   享学课堂 https://enjoy.ke.qq.com
 * 类说明：消息的类型定义
 */
public enum MessageType {

    SERVICE_((byte) 1),/*业务消息*/
    LOGIN((byte) 3), /*登录消息*/
    HEARTBEAT((byte) 5);/*心跳消息*/

    private byte value;

    private MessageType(byte value) {
	this.value = value;
    }

    public byte value() {
	return this.value;
    }
}
