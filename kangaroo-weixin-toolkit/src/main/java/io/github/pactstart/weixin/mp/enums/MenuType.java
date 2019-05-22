package io.github.pactstart.weixin.mp.enums;

/**
 * 公众号菜单类型
 * Created by Di.Lei on 2017/7/27.
 */
public enum MenuType {
    /**
     * 点击事件
     */
    click,
    /**
     * 视图页面
     */
    view,
    /**
     * 扫码推事件
     */
    scancode_push,
    /**
     * 扫码带提示
     */
    scancode_waitmsg,
    /**
     * 系统拍照发图
     */
    pic_sysphoto,
    /**
     * 拍照或者相册发图
     */
    pic_photo_or_album,
    /**
     * 微信相册发图
     */
    pic_weixin,
    /**
     * 发送位置
     */
    location_select,
    /**
     * 图片
     */
    media_id,
    /**
     * 图文消息
     */
    view_limited,

    /**
     * 小程序
     */
    miniprogram;
}
