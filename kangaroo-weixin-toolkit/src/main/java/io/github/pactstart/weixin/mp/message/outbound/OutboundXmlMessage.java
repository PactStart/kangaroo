package io.github.pactstart.weixin.mp.message.outbound;

import io.github.pactstart.weixin.mp.message.OutboundMessage;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public abstract class OutboundXmlMessage implements OutboundMessage {

    @Override
    public void write(PrintWriter writer) throws IOException {
        Document document = DocumentFactory.getInstance().createDocument();
        Element root = document.addElement("xml");
        this.write(root);
        writer.println(root.asXML());
        writer.flush();
    }

    protected abstract void write(Element root);
}
