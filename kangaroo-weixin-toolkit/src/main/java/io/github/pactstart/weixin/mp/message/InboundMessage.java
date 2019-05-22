package io.github.pactstart.weixin.mp.message;

import java.io.InputStream;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public interface InboundMessage {

    void read(InputStream in);
}
