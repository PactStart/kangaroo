package io.github.pactstart.weixin.mp.enums;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public enum IndustryCode {

    ONE("1", "IT科技", "互联网|电子商务"),
    TWO("2", "IT科技", "IT软件与服务"),
    THREE("3", "IT科技", "IT硬件与设备"),
    FOUR("4", "IT科技", "电子技术"),
    FIVE("5", "IT科技", "通信与运营商"),
    SIX("6", "IT科技", "网络游戏"),
    SEVEN("7", "金融业", "银行"),
    EIGHT("8", "金融业", "基金|理财|信托"),
    NINE("9", "金融业", "保险"),
    TEN("10", "餐饮", "餐饮"),
    ELEVEN("11", "酒店旅游", "酒店"),
    TWELVE("12", "酒店旅游", "旅游"),
    THIRTEEN("13", "运输与仓储", "快递"),
    FOURTEEN("14", "运输与仓储", "物流"),
    FIFTEEN("15", "运输与仓储", "仓储"),
    SIXTEEN("16", "教育", "培训"),
    SEVENTEEN("17", "教育", "院校"),
    EIGHTEEN("18", "政府与公共事业", "学术科研"),
    NINETEEN("19", "政府与公共事业", "交警"),
    TWENTY("20", "政府与公共事业", "博物馆"),
    TWENTY_ONE("21", "政府与公共事业", "公共事业|非盈利机构"),
    TWENTY_TWO("22", "医药护理", "医药医疗"),
    TWENTY_THREE("23", "医药护理", "护理美容"),
    TWENTY_FOUR("24", "医药护理", "保健与卫生"),
    TWENTY_FIVE("25", "交通工具", "汽车相关"),
    TWENTY_SIX("26", "交通工具", "摩托车相关"),
    TWENTY_SEVEN("27", "交通工具", "火车相关"),
    TWENTY_EIGHT("28", "交通工具", "飞机相关"),
    TWENTY_NINE("29", "房地产", "建筑"),
    THIRTY("30", "房地产", "物业"),
    THIRTY_ONE("31", "消费品", "消费品"),
    THIRTY_TWO("32", "商业服务", "法律"),
    THIRTY_THREE("33", "商业服务", "会展"),
    THIRTY_FOUR("34", "商业服务", "中介服务"),
    THIRTY_FIVE("35", "商业服务", "认证"),
    THIRTY_SIX("36", "商业服务", "审计"),
    THIRTY_SEVEN("37", "文体娱乐", "传媒"),
    THIRTY_EIGHT("38", "文体娱乐", "体育"),
    THIRTY_NINE("39", "文体娱乐", "娱乐休闲"),
    FOURTY("40", "印刷", "印刷"),
    FOURTY_ONE("41", "其它", "其它");;
    private String code;

    private String firstClass;

    private String secondClass;

    IndustryCode(String code, String firstClass, String secondClass) {
        this.code = code;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
    }

    public static IndustryCode valueOf(String firstClass, String secondClass) {
        IndustryCode result = null;
        for (IndustryCode industryCode : values()) {
            if (industryCode.getFirstClass().equals(firstClass) && industryCode.getSecondClass().equals(secondClass)) {
                result = industryCode;
                break;
            }
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }
}
