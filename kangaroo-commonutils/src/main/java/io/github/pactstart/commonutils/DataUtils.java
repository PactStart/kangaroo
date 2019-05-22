package io.github.pactstart.commonutils;

import java.io.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
public class DataUtils {

    static final Pattern PATTERN = Pattern.compile("^[0-9]*$");

    static final Pattern CHINESE = Pattern.compile("[\\u4e00-\\u9fa5]");

    static final Pattern ALL_CHINESE = Pattern.compile("[\\u4e00-\\u9fa5]+");

    /**
     * 指定随机数种子生成指定范围内的随机数
     *
     * @param seed 随机数种子
     * @param bound 边界
     * @return 随机数
     */
    public static long genRandomWithSeed(long seed, int bound) {
        return new Random(seed).nextInt(bound);
    }

    /**
     * 格式化字符串
     *
     * @param template 字符串模板
     * @param params   参数键值对
     * @return 格式化的字符串
     */
    public static String formatSO(String template, Map<String, Object> params) {
        Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(template);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String param = m.group(); //${xx}
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 格式化字符串
     * @param template 字符串模板
     * @param params 参数键值对
     * @return 格式化的字符串
     */
    public static String formatSS(String template, Map<String, String> params) {
        Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(template);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String param = m.group(); //${xx}
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 指定长度数字生成器
     * @param length 要生成的数字字符串的长度
     * @return 随机字符串
     */
    public static String numRandomGenerator(int length) {
        Long num = (long) ((Math.random() * 9 + 1) * Math.pow(10, length - 1));
        return num.toString();
    }

    /**
     * 指定长度字符串生成器
     *
     * @param length 表示生成字符串的长度
     * @return 随机字符串
     */
    public static String strRandomGenerate(int length) {
        String base = "ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnopqrstuvwxyz23456789";
        return genStr(base, length);
    }

    /**
     * 生成阅读友好的字符串（去除i1oO0等相似的字符）
     * @param length 表示生成字符串的长度
     * @return 随机字符串
     */
    public static String friendlyStrRandomGenerate(int length) {
        String base = "abcefhjkmnrstuvwxyz2345678";
        return genStr(base, length);
    }

    /**
     * 判断指定字符串是否包含数字
     * @param str 字符串
     * @return true包含，false不包含
     */
    public static boolean containsNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if ('0' <= item && item <= '9') {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是否包含字母
     * @param str 字符串
     * @return true包含，false不包含
     */
    public static boolean containsLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if ('a' <= item && item <= 'z' || 'A' <= item && item <= 'Z') {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串的每个字符是否都一样
     *
     * @param str 字符串
     * @return true一样，false不一样
     */
    public static boolean isRepeatStr(String str) {
        if (str.isEmpty()) {
            return true;
        }
        char item = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (item != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否是连续递增数字
     *
     * @param str 字符串
     * @return true是，false否
     */
    public static boolean idOrderNumberic(String str) {
        boolean flag = true;//如果全是连续数字返回true
        boolean isNumeric = true;//如果全是数字返回true
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
                break;
            }
        }
        if (isNumeric) {//如果全是数字则执行是否连续数字判断
            for (int i = 0; i < str.length(); i++) {
                if (i > 0) {//判断如123456
                    int num = Integer.parseInt(str.charAt(i) + "");
                    int num_ = Integer.parseInt(str.charAt(i - 1) + "") + 1;
                    if (num != num_) {
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 是否连续递减数字
     *
     * @param str 字符串
     * @return true是，false否
     */
    public static boolean idOrderNumberic_(String str) {
        boolean flag = true;//如果全是连续数字返回true
        boolean isNumeric = true;//如果全是数字返回true
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
                break;
            }
        }
        if (isNumeric) {//如果全是数字则执行是否连续数字判断
            for (int i = 0; i < str.length(); i++) {
                if (i > 0) {//判断如654321
                    int num = Integer.parseInt(str.charAt(i) + "");
                    int num_ = Integer.parseInt(str.charAt(i - 1) + "") - 1;
                    if (num != num_) {
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 校验身份证号是否合法
     *
     * @param idCard 身份证号
     * @return true合法，false不合法
     */
    @SuppressWarnings("AlibabaUndefineMagicConstant")
    public static boolean checkIDCard(String idCard) {
        // 对身份证号进行长度等简单判断
        //noinspection AlibabaUndefineMagicConstant
        if (idCard == null || idCard.length() != 18 || !idCard.matches("\\d{17}[0-9X]")) {
            return false;
        }
        // 1-17位相乘因子数组
        int[] factor = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 18位随机码数组
        char[] random = "10X98765432".toCharArray();
        // 计算1-17位与相应因子乘积之和
        int total = 0;
        for (int i = 0; i < 17; i++) {
            total += Character.getNumericValue(idCard.charAt(i)) * factor[i];
        }
        // 判断随机码是否相等
        return random[total % 11] == idCard.charAt(17);
    }

    /**
     * 校验银行卡卡号
     * @param bankCard 银行卡号
     * @return true正确，false不正确
     */
    public static boolean checkBankCard(String bankCard) {
        if (bankCard.length() < 15 || bankCard.length() > 19) {
            return false;
        }
        char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return bankCard.charAt(bankCard.length() - 1) == bit;
    }

    private static char getBankCardCheckCode(String nonCheckCodeBankCard) {
        if (nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
                || !nonCheckCodeBankCard.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeBankCard.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    private static String genStr(String base, int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 使用md5算法进行加密
     * @param str 字符串
     * @return md5加密后的字符串
     */
    public static String md5(String str) {
        try {
            StringBuffer buffer = new StringBuffer();
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            byte[] bytes = str.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] targ = md.digest(bytes);
            for (byte b : targ) {
                buffer.append(chars[(b >> 4) & 0x0F]);
                buffer.append(chars[b & 0x0F]);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 深度复制,复制的整个对象图
     * @param src 原对象
     * @return 复制后的对象
     */
    public static Serializable deeplyCopy(Serializable src) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(src);
            oos.close();
            baos.close();
            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Serializable copy = (Serializable) ois.readObject();
            ois.close();
            bais.close();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str 字符串
     * @return true是false否
     */
    public static boolean isNumeric(String str) {
        return PATTERN.matcher(str).matches();
    }

    /**
     *  随机生成在[min, max]区间内的随机整数
     * @param min 最大值
     * @param max 最小值
     * @return 随机数
     */
    public static int randomInt(int min, int max) {
        Random random = new Random();
        int num = random.nextInt(max - min + 1) + min;
        return num;
    }

    /**
     * 获取UUID字符串(不带横杠)
     *
     * @return 字符串
     */
    public static String uuidStr() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&amp;”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, Object> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key).toString();
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }

    /**
     * 功能：生成签名结果
     *
     * @param sArray 要签名的数组
     * @param key    安全校验码
     * @return 签名结果字符串
     */
    public static String buildSign(Map<String, Object> sArray, String key) {
        String prestr = createLinkString(sArray);  //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        prestr = prestr + key;                     //把拼接后的字符串再与安全校验码直接连接起来(key 双方确定好的秘钥)
        String signature = md5(prestr);
        return signature;
    }

    /**
     * 获取当前格式化时间戳,yyyyMMddHHmmssSSS
     *
     * @return 当前时间戳字符串
     */
    public static String getCurrentTimStampStr() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    /**
     * 除首字母外的其他字符用型号替换
     * @param str 原字符串
     * @return 字符串
     */
    public static String getEntryStr(String str) {
        if (str != null && str.trim().length() > 1) {
            StringBuilder temp = new StringBuilder();
            temp.append(str.substring(0, 1));
            int nLen = str.length();
            for (int i = 1; i < nLen; ++i) {
                temp.append("*");
            }
            return temp.toString();
        } else {
            return str;
        }
    }

    /**
     * 将银行卡号中指定位置的字符用星号替换
     *
     * @param bankcard 银行卡号
     * @param begin    开始位置
     * @param end      结束位置
     * @return 星号替换后的银行卡号
     */
    public static String getEntryBankcard(String bankcard, int begin, int end) {
        if (bankcard != null && bankcard.trim().length() > begin + end) {
            StringBuilder temp = new StringBuilder();
            if (begin != 0) {
                temp.append(bankcard.substring(0, begin));
            }
            int nLen = bankcard.length() - begin - end;
            for (int i = begin; i < nLen; ++i) {
                temp.append("*");
            }
            temp.append(bankcard.substring(bankcard.length() - end));
            return temp.toString();
        } else {
            return bankcard;
        }
    }

    /**
     * 是否是中文
     *
     * @param str 字符串
     * @return true是false否
     */
    public static boolean isChinese(String str) {
        return str != null && ALL_CHINESE.matcher(str).matches();
    }

    /**
     * 字符串中是否包含中文
     *
     * @param str 字符串
     * @return true包含false不包含
     */
    public static boolean isContainsChinese(String str) {
        return str != null && CHINESE.matcher(str).find();
    }

    /**
     * 按指定格式格式化日期
     *
     * @param format 格式
     * @param date 日期
     * @return 格式化的日期
     */
    public static String formatDate(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 转换年月日为yyyy-MM-dd格式
     *
     * @param year 年
     * @param month 月
     * @param day 日
     * @return yyyy-MM-dd格式的字符串
     */
    public static String getDateStr(int year, int month, int day) {
        StringBuilder sb = new StringBuilder();
        sb.append(year).append("-");
        if (month < 10) {
            sb.append("0");
        }
        sb.append(month).append("-");
        if (day < 10) {
            sb.append("0");
        }
        sb.append(day);
        return sb.toString();
    }

    /**
     * 将指定集合中的int数据用逗号分隔
     * @param list 集合
     * @return 逗号分隔后的字符串
     */
    public static String separateWithComma(Collection<Integer> list) {
        if (!ValidUtils.isValid(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer item : list) {
            sb.append(item).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 将指定集合中的string用逗号分隔
     * @param list 集合
     * @return 逗号分隔后的字符串
     */
    public static String separateStrWithComma(Collection<String> list) {
        if (!ValidUtils.isValid(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
