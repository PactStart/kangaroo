package io.github.pactstart.weixin.mp.message.inbound;

import io.github.pactstart.weixin.common.exception.WeixinApiException;
import io.github.pactstart.weixin.mp.message.inbound.event.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public abstract class InboundXmlMessage {

    private static Logger logger = LoggerFactory.getLogger(InboundXmlMessage.class);

    public static AbstractReceivedMessage read(InputStream in) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(in);
        } catch (DocumentException e) {
            throw new WeixinApiException("解析xml流数据失败", e);
        }
        Element root = document.getRootElement();
        String msgType = root.elementText("MsgType");
        boolean isEvent = "event".equals(msgType);
        AbstractReceivedMessage xmlMessage = null;
        if (isEvent) {
            String event = root.elementText("Event");
            if ("subscribe".equals(event) || "unsubscribe".equals(event)) {
                xmlMessage = new SubscribeEvent();
            } else if ("SCAN".equals(event)) {
                xmlMessage = new ScanSceneQrCodeEvent();
            } else if ("LOCATION".equals(event)) {
                xmlMessage = new LocationReportEvent();
            } else if ("CLICK".equals(event)) {
                xmlMessage = new ClickMenuEvent();
            } else if ("VIEW".equals(event)) {
                xmlMessage = new ViewMenuEvent();
            } else if ("TEMPLATESENDJOBFINISH".equals(event)) {
                xmlMessage = new TemplateSendJobFinishEvent();
            } else if ("qrcode".equals(event)) {
                xmlMessage = new ScancodeMenuEvent();
            } else if ("scancode_waitmsg".equals(event)) {
                //扫码推事件且弹出“消息接收中”提示框的事件推送
            } else if ("location_select".equals(event)) {
                xmlMessage = new LocationSelectMenuEvent();
            } else if ("pic_weixin".equals(event)) {
                //弹出微信相册发图器的事件推送
                xmlMessage = new PicEvent();
            } else if ("pic_sysphoto".equals(event)) {
                //弹出系统拍照发图的事件推送
                xmlMessage = new PicEvent();
            } else if ("pic_photo_or_album".equals(event)) {
                //弹出拍照或者相册发图的事件推送
                xmlMessage = new PicEvent();
            } else if ("scancode_push".equals(event)) {
                //扫码推事件的事件推送
            } else if ("qualification_verify_success".equals(event) || "qualification_verify_fail".equals(event)) {
                xmlMessage = new QualificationVerifyEvent();
            } else if ("naming_verify_success".equals(event) || "naming_verify_fail".equals(event)) {
                xmlMessage = new NamingVerifyEvent();
            } else if ("annual_renew".equals(event)) {
                xmlMessage = new AnnualRenewEvent();
            }
        } else {
            if ("text".equals(msgType)) {
                xmlMessage = new TextMessage();
            } else if ("image".equals(msgType)) {
                xmlMessage = new ImageMessage();
            } else if ("voice".equals(msgType)) {
                xmlMessage = new VoiceMessage();
            } else if ("video".equals(msgType)) {
                xmlMessage = new VoiceMessage();
            } else if ("location".equals(msgType)) {
                xmlMessage = new LocationMessage();
            } else if ("link".equals(msgType)) {
                xmlMessage = new LinkMessage();
            }
        }
        if (xmlMessage != null) {
            xmlMessage.read(root);
        }
        return xmlMessage;
    }

    public abstract void read(Element element);

}
