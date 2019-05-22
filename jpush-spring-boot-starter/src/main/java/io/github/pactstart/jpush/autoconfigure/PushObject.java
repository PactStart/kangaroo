package io.github.pactstart.jpush.autoconfigure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PushObject {

    private boolean allAlias;

    /**
     * 推送用户别名列表
     */
    private List<String> alias;

    /**
     * 通知信息
     */
    private String alert;

    /**
     * 消息内容
     */
    private String msgContent;

    //ios声音
    private String sound = "happy";

    //ios右上角条数
    private int badge = 1;

    Map<String, Object> extras = new HashMap<String, Object>();

    public boolean isAllAlias() {
        return allAlias;
    }

    public void setAllAlias(boolean allAlias) {
        this.allAlias = allAlias;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }


}
