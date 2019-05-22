package io.github.pactstart.weixin.mp.message;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public interface OutboundMessage {

    public void write(PrintWriter writer) throws IOException;
}
