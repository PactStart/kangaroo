package io.github.pactstart.weixin.mp.message.outbound;

import io.github.pactstart.weixin.mp.message.OutboundMessage;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class OutboundStringMessage implements OutboundMessage {

    private String content;

    public OutboundStringMessage(String content) {
        this.content = content;
    }

    @Override
    public void write(PrintWriter writer) throws IOException {
        writer.println(content);
    }
}
