package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderBean {

    private int is_reloan;


    /**
     * orderInfo : {"order_No":"258617943106534","order_no":"258617943106534","user_id":30000421,"id":75530253,"user_name":"张三","register_time":1492582991,"status":80,"order_time":1551707677,"city":"北京","bank":"深圳市华民投资发展有限公司","product":"华融易贷","product_id":10429491,"user_group_id":212,"user_mobile":"13420504517"}
     * applyDetail : {"user_id":"412723199608124653","user_education":"2","bureau_user_name":"张三","gps_location":"116.307315,39.977859","max_monthly_repayment":10000,"phone_number_house":"13420504517","credit_status":"1","user_income_by_card":1,"asset_house_type":"1","user_social_security":"2","work_period":"1","if_provident_fund":"2","is_op_type":"4","asset_auto_type":"1","GPS_Address":"北京市朝阳区华贸商业街"}
     * addInfo : {"zhima":{"ali_trust_score":{"score":"726"},"ali_trust_watchlist":{"success":true,"biz_no":"Z5400431928953","is_matched":false}},"mobile":{"user":{"user_source":"CHINAMOBILE_CHONGQING","id_card":"","addr":"北京海淀测试地址","real_name":"**牛","phone":"18866688866","phone_remain":"12.42","reg_time":"2014-05-26","update_time":"2017-12-17 19:54:21","score":"2476","contact_phone":"18866688866","star_level":"4","authentication":"1","phone_status":"1","package_name":"4G自选流量套餐280元包11G|4G自"},"userdata":{"user_source":"CHINAMOBILE_CHONGQING","id_card":"","addr":"北京海淀测试地址","real_name":"**牛","phone":"18866688866","phone_remain":"12.42","reg_time":"2014-05-26","update_time":"2017-12-17 19:54:21","score":"2476","contact_phone":"18866688866","star_level":"4","authentication":"1","phone_status":"1","package_name":"4G自选流量套餐280元包11G|4G自"},"tel":[{"teldata":[{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:52:47","call_type":"1","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"53","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:59:43","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"51","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 16:07:22","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"17","trade_type":"1","receive_phone":"075584312345"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 12:15:45","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"11","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 14:41:56","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"68","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-13 13:04:51","call_type":"1","fee":"0.19","special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"16","trade_type":"1","receive_phone":"18866688866"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_TELDATA_201707_1509071984456485"},{"teldata":[{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-20 16:39:18","call_type":"1","fee":"0.19","special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"6","trade_type":"1","receive_phone":"4001812345"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-20 16:40:26","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"440","trade_type":"1","receive_phone":"18866688866"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_TELDATA_201707_1509071984280129"}],"msg":[{"msgdata":[{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:42:05","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:49:38","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:04:33","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 08:12:16","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"95559"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:31:14","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"1069079812345"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_MSGDATA_201707_1509071982253595"},{"msgdata":[{"business_name":"SMS","fee":"0.1","send_time":"2017-08-02 19:04:49","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":"0.1","send_time":"2017-08-02 19:04:50","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":0,"send_time":"2017-08-04 11:14:05","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"447537412345"},{"business_name":"SMS","fee":0,"send_time":"2017-08-18 14:43:28","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"447537412345"},{"business_name":"SMS","fee":0,"send_time":"2017-08-18 17:02:12","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10658112"},{"business_name":"SMS","fee":"0.1","send_time":"2017-08-24 12:56:20","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10690934312345"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_MSGDATA_201708_1509071982107192"}],"bill":[{"month":"201712","call_pay":"380.56","package_fee":"331","msg_fee":"1.7","tel_fee":"44.82","net_fee":0,"addtional_fee":"3.04","preferential_fee":"","generation_fee":0,"other_fee":0,"score":"2476","otherspaid_fee":"","pay_fee":""},{"month":"201711","call_pay":"384.36","package_fee":"331","msg_fee":"2.1","tel_fee":"45.26","net_fee":0,"addtional_fee":"6","preferential_fee":"0.00","generation_fee":0,"other_fee":0,"score":"","otherspaid_fee":0,"pay_fee":""}],"net":[{"netdata_key":"hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_NETDATA_201708_1509072024435556","netdata":[{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":"手机上网10元夜间套餐（15年版）","start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"24366","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":null,"start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"774","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(2G/4G)","preferential_fee":"团购国内流量1G","start_time":"2017-08-01 17:46:01","total_time":"94971","total_traffic":"167669","trade_addr":"北京海淀测试地址"}]}],"recharge":[{"fee":"0.4","recharge_time":"2017-04-27 10:00:49","recharge_way":"现金交费"}]},"icredit":[{"card":[{"bank":8882,"name":"融平波","payment_due_date":"2017-12-24","credit_card":"6259656210812345","type":"credit","login_account":"500237199307112345","card_no":"6259656210812345"}],"bill_flow":[{"bill":{"new_balance":131770,"min_payment":126742,"statement_start_date":"2017-11-05","month":"2017-12","statement_end_date":"2017-12-04","payment_cur_date":"2017-12-04","payment_due_date":"2017-12-24","credit_limit":1000000,"cash_advance_limit":500000,"last_balance":140087,"last_payment":-386000,"new_charges":0,"interest":0,"cur_adjust_amount":0,"last_points":0,"repayment":0,"currency":""},"flow":[{"trans_date":"2017-09-28","post_date":"2017-09-28","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-186000,"rmb_org_amount":-186000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"手机银行现金转出8338","rmb_amount":50000,"rmb_org_amount":50000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-200000,"rmb_org_amount":-200000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"现金分期*金额","rmb_amount":130000,"rmb_org_amount":130000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"信用卡现金转出手续费","rmb_amount":500,"rmb_org_amount":500,"currency":"CNY","cardNo_last4_digits":"0015"}]},{"bill":{"new_balance":147455,"min_payment":139511,"statement_start_date":"2017-08-05","month":"2017-09","statement_end_date":"2017-09-04","payment_cur_date":"2017-09-04","payment_due_date":"2017-09-24","credit_limit":1000000,"cash_advance_limit":500000,"last_balance":132279,"last_payment":-500000,"new_charges":0,"interest":0,"cur_adjust_amount":0,"last_points":0,"repayment":0,"currency":""},"flow":[{"trans_date":"2017-09-04","post_date":"2017-09-04","description":"现金分期每月手续费","rmb_amount":2120,"rmb_org_amount":2120,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"信用卡现金转出手续费","rmb_amount":768,"rmb_org_amount":768,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"手机银行现金转出8338","rmb_amount":76800,"rmb_org_amount":76800,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-200000,"rmb_org_amount":-200000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"现金分期*金额","rmb_amount":110000,"rmb_org_amount":110000,"currency":"CNY","cardNo_last4_digits":"0015"}]},{"bill":{"new_balance":132279,"min_payment":130512,"statement_start_date":"2017-07-05","month":"2017-08","statement_end_date":"2017-08-04","payment_cur_date":"2017-08-04","payment_due_date":"2017-08-24","credit_limit":1000000,"cash_advance_limit":500000,"last_balance":127963,"last_payment":-500000,"new_charges":0,"interest":0,"cur_adjust_amount":0,"last_points":0,"repayment":0,"currency":""},"flow":[{"trans_date":"2017-08-04","post_date":"2017-08-04","description":"现金分期单期金额:分期9/12","rmb_amount":6667,"rmb_org_amount":6667,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-22","post_date":"2017-05-22","description":"手机银行现金转出8338","rmb_amount":500000,"rmb_org_amount":500000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-22","post_date":"2017-05-22","description":"网银跨行还款62268901195****3","rmb_amount":-500000,"rmb_org_amount":-500000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-05","post_date":"2017-05-05","description":"手机银行一键转账还款8338","rmb_amount":-76222,"rmb_org_amount":-76222,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-05","post_date":"2017-05-05","description":"深圳市财付通科技有限公司","rmb_amount":70000,"rmb_org_amount":70000,"currency":"CNY","cardNo_last4_digits":"0015"}]}]}],"alipay":[{"alipay_info":[{"login_name":"18866688866","real_name":"**牛","id_card":"5****************2","email":"未添加邮箱账户名","phone":"159******30","taobao_name":"南宫靖雨悠","identify_time":"","register_date":"1401206412345","is_real_name":"已认证","is_protected":"账户已受全面保障","is_phone":"已绑定","secret_level":"","balance":"300.00","income":"3.17","is_idcard":"是","amount":"0.00","total_amount":"8000.00","available_amount":"0.00","need_to_pay_next_month":"0.00"}],"alipay_list":[{"trade_no":"2017012500003001150024812345","pay_time":"1485321112345","trade_type":"1月-固话/宽带费-*林清-我家","trade_no_type":"1月-固话/宽带费-*林清-我家","receiver_name":"重庆电信公司","amount":"-94","status":"交易成功","source":"","trade_classification":"缴费","alipay_name":"18866688866"},{"trade_no":"2017120921001004155260712345","pay_time":"1512815812345","trade_type":"滴滴快车-周瑜师傅","trade_no_type":"滴滴快车-周瑜师傅","receiver_name":"","amount":"-5","status":"交易成功","source":"","trade_classification":"转账","alipay_name":"18866688866"}],"bankcard":[{"card_last_num":"9687","open_status":"已开通","apply_time":"0","bank_name":"交通银行","card_type":"信用卡","mobile":"159****5930","active_date":"2017-03-09","show_user_name":"融七牛","alipay_name":"18866688866"},{"card_last_num":"6314","open_status":"已开通","apply_time":"0","bank_name":"浦发银行","card_type":"信用卡","mobile":"159****5930","active_date":"2016-12-11","show_user_name":"融七牛","alipay_name":"18866688866"}],"alipay_charge_account":[{"account_id":"a20170113000700120000150701012345","charge_item":"水费","area":"重庆","charge_unit":"长寿自来水","charge_account":"*才路公租房1幢3-4","charge_number":"1234512345","charge_reminder":"未设置","login_name":"18866688866"},{"account_id":"a20170114000700120000150701012345","charge_item":"电费","area":"重庆","charge_unit":"国网重庆市电力公司","charge_account":"重庆市*********","charge_number":"1577812345","charge_reminder":"未设置","login_name":"18866688866"}],"crawl_time":"2017-12-18 00:07:45"}],"ibank":{"bank_name":"中国银行","user_name":"融七牛","data":[{"page":"0","detail":[{"no":"","trade_time":"2017-07-17 00:00:00","payment":"30.00","deposit":"","abstract":"转账支出","balance":"495.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1054.00","deposit":"","abstract":"转账支出","balance":"525.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"1425.00","abstract":"POS转账","balance":"1579.56","trade_type":"","trade_country":"","trade_place":"POS机 POS机","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1300.00","deposit":"","abstract":"代收费","balance":"154.56","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"0274******9999","other_account_name":"银众投资","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"205.79","abstract":"代收付","balance":"1454.56","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"100.00","abstract":"代付","balance":"1248.77","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"116.00","deposit":"","abstract":"转账支出","balance":"1148.77","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""}],"img_url":"https://is.rong360.com/image/hbase?key=","html_url":"https://is.rong360.com/image/hbase?key=hbase2://cfile173/ibank/html/fc6baf234fc4c46e5cc35cd5f6a5cf4a_0_1500364233340290"},{"page":"1","detail":[{"no":"","trade_time":"2017-07-16 00:00:00","payment":"71.00","deposit":"","abstract":"网上快捷支付","balance":"1264.77","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"17.90","abstract":"代收付","balance":"1335.77","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"100.00","deposit":"","abstract":"网上快捷支付","balance":"1317.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"5.00","abstract":"代付","balance":"1417.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"50.00","abstract":"代付","balance":"1412.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"799.20","abstract":"代收付","balance":"1362.87","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"399.60","abstract":"代收付","balance":"563.67","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"1135.00","deposit":"","abstract":"网上快捷支付","balance":"164.07","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"849.15","abstract":"代收付","balance":"1299.07","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"443.98","abstract":"代收付","balance":"449.92","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""}],"img_url":"https://is.rong360.com/image/hbase?key=","html_url":"https://is.rong360.com/image/hbase?key=hbase2://cfile173/ibank/html/fc6baf234fc4c46e5cc35cd5f6a5cf4a_0_1500364235737852"}]},"ec":[{"mail":"chen123123123testrong@qq.com","bank_name":"民生","card_no":"9888","name":"融七牛","sex":"2","last_balance":"159063","last_payment":"85600","statement_start_date":"1476312345","statement_end_date":"1479012345","payment_cur_date":"1479012345","payment_due_date":"1480712345","credit_limit":"0","total_points":"11548","new_balance":"200979","min_payment":"65202","new_charges":"125358","adjustment":"0","interest":"2158","last_points":"10774","earned_points":"774","sender_email":"master12313@creditcard.cmbc.com.cn","adjusted_points":"0","available_balance_usd":"0","available_balance":"0","cash_advance_limit_usd":"0","credit_limit_usd":"0","cash_advance_limit":"0","min_payment_usd":"0","new_balance_usd":"0","redeemed_points":"0","rewarded_points":"0","time":"2017-02-21 14:11:29","create_time":"2017-02-21 14:11:29","trans_detail":[{"trans_date":"1479012345","post_date":"1479012345","description":"利息交易","rmb_amount":"2158","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 手续费第3期共12期","rmb_amount":"425","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 每月摊消第3期共12期","rmb_amount":"5290","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 手续费第3期共24期","rmb_amount":"6076","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 每月摊消第3期共24期","rmb_amount":"36167","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-60600","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-20000","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"杭州欣美药房有限公司","rmb_amount":"77400","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-5000","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"}],"is_simple":0,"url":"https://is.rong360.com/image/f?token=V8yTJB_tn33ypP3nMAuaJT2pnf9-8r6gbarmJWWmi9YUv7h7CRwuJE0KwVIiVRNh49hVY1YqXF5wwCZwKQqIU32vQqk-qdVcIhnZiTLFGh1gX3X6odh5q8_608Rp96ym3kWFZQhyWAS1hNZfM6DraQ,,"}],"jd":{"login_name":"18866688866","auth_info":{"login_name":"18866688866","name":"融妍","id_card":"3****************1","auth_time":"2016-05-04","binding_phone":"159****2060","auth_channel":"京东金融实名认证","financial_service":"白条"},"bt_info":{"login_name":"18866688866","bt_credit_point":72.1,"bt_overdraft":5242.31,"bt_quota":5261},"user_info":{"login_name":"18866688866","username":"jd_5123123123","set_login_name":"jd_123123123","nickname":"jd_123123213","sex":"保密","birthday":"0000-00-00","hobbies":"","email":"52*****82@qq.com","real_name":"","marriage":"","income":"","id_card":"","education":"","industry":"","is_qq_bound":"已绑定","is_wechat_bound":"已绑定","account_grade":"银牌会员","account_type":"个人用户"},"shipping_addrs":[{"login_name":"18866688866","addr_id":"138397500","receiver":"融七牛","region":"浙江杭州市上城区","address":"北京海淀测试地址","mobile_phone":"159****2060","fixed_phone":"","email_addr":""}],"bankcards":[{"login_name":"18866688866","card_id":"cfe4bbcf685fb9cf507778072d029f65","bank_name":"citic","tail_number":"1132","card_type":"信用卡","owner_name":"*妍","phone":"135****8281"}],"order_list":[{"order_id":"18866688866","receiver":"融七牛","money":"65.0000","buy_way":"在线支付","buy_time":"1480312345","order_status":"完成","order_source":"JD","login_name":"18866688866","receiver_addr":"北京海淀测试地址","receiver_post":"","receiver_fix_phone":"","receiver_telephone":"135****8281","receiver_email":"","product_names":"盒装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光;","invoice_type":"普通发票","invoice_header":"个人","invoice_content":"明细","products":[{"price":65,"product_id":"18866688866","name":"融装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光"}],"url":"https://is.rong360.com/image/hbase?key="}]},"insure":{"user":{"real_name":"**牛","id_card":"440184198810112345","sex":"男","birthday":"1988-10-16","work_start_day":"","acc_prop":"本地非农业户口(本地城镇)","acc_addr":"","degree":"","cellphone":"","phone":"","email":"社保登记","insure_code":"1049112345","insure_city":"广州社保","insure_status":"","insure_month_money":"","com_name":"","com_code":"","nation":"汉族","live_addr":"北京海淀测试地址","live_postcode":"510600","marital_status":"","worker_nation":"","start_insure_day":"","format_acc_prop":"非农","format_degree":"","format_insure_status":"","format_marital_status":"","format_worker_nation":""},"flow":[{"id_card":"440184198810112345","pay_date":"","start_date":"2017-07","end_date":"2017-11","base_rmb":"2075.00","com_rmb":"66.40","per_rmb":"13.28","balance_rmb":"","month_rmb":"79.68","com_name":"华润万家生活超市（广州）有限公司从化店","pay_type":"正常缴费","flow_type":"2"}]},"taobao":[{"tb_user":{"login_name":"15012345678","vip_level":"","buyer_credit":64,"rate_summary":"100.0","score":625,"vip_count":0,"star_level":0,"sum_amount":"0.00","count_orders":0,"count_days_bought":0,"count_days_from_regi":0,"account_name":"许伟伟先生","email":"","binding_phone":"15012345678","authentication":"已完成","binding_weibo_account":"","binding_weibo_nickname":"","name":"许伟伟","division_code":"","address":"","tianmao_account":"许伟伟先生","tianmao_grade":815,"tianmao_vip_level":"","tianmao_credit_level":""},"tb_orders":[{"order_id":"165227275474186756","status":"成功","actual_fee":"19.00","phone_order":1,"transaction_time":"2018-06-2023:03:26","payment_time":"2018-06-2023:03:29","confirmation_time":"2018-06-2023:03:37","receiver_name":"","receiver_telephone":"","receiver_address":"","products":[{"product_name":"爱奇艺VIP黄金会员一个月卡爱奇艺会员1个月填手机号","product_price":"19.00","product_quantity":1}]},{"order_id":"162855483476186756","status":"成功","actual_fee":"27.65","phone_order":1,"transaction_time":"2018-06-1709:32:09","payment_time":"2018-06-1709:32:12","confirmation_time":"2018-06-1709:32:41","receiver_name":"","receiver_telephone":"","receiver_address":"","products":[{"product_name":"腾讯地下城与勇士30元点券/DNF点卡/dnf点卷/DNF3000点券★自动充","product_price":"27.65","product_quantity":1}]}],"tb_deliver_addrs":[{"tb_user_id":3836225,"receiver_name":"崔文文","area":"北京市","address":"北京市海淀区丹棱街","zip_code":"100000","phone":"13012345678","is_default_address":""},{"tb_user_id":3836225,"receiver_name":"许姐姐","area":"北京市","address":"北京市海淀区丹棱街","zip_code":"100000","phone":"13012345678","is_default_address":""}],"tb_zhifubao_binding":{"tb_user_id":3836225,"balance":"2044.77","total_profit":"22.51","total_quotient":"3.88","huabei_credit_amount":"370.15","huabei_total_credit_amount":"4500.00","zhifubao_account":"150******40","binding_phone":"15012345678","account_type":"个人账户","verified_name":"许伟伟","verified_id_card":"41272***********53"}}],"tjy_model":{"decision_score":649},"fund":{"cid":21,"location":"西安公积金","cityName":"西安市","orderId":"05071a78a0725404a119de096511a15a","create_date":"2018-06-27 21:16:50","data":{"gjj_data":[{"gjj_brief":{"ID":"610103198605112345","name":"融浩","card":"","customer_id":"1489872","deposit_amount":"1600.00","fb_deposit_amount":"","balance":"28225.98","fb_balance":"","once_balance":"","status":"正常","record_date":"2018-05","company":"西安凯美置业有限公司","deposit_base":"16000.00","person_rate":"5.00","company_rate":"5.00","init_date":"2013-02-05","start_date":"2013-07","sex":"男","email":"","phone":"","marriage":"","address":"","birthday":"1986-05-14","company_id":"0019186","person_deposit_amount":"","company_deposit_amount":"","deposit_rate":""},"gjj_detail":[{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-06-20","op_type":"汇缴201805公积金","record_month":"2018-05","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-05-10","op_type":"汇缴201804公积金","record_month":"2018-04","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-04-02","op_type":"汇缴201803公积金","record_month":"2018-03","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-03-20","op_type":"汇缴201802公积金","record_month":"2018-02","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2017-01-16","op_type":"购买、建造、翻建、大修自住住房等","record_month":"2017-01","amount":"-29489.93","balance":"","remark":"","comments":"","deposit_type":"支取-购房贷款支取","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2016-01-08","op_type":"汇缴201601公积金","record_month":"2016-01","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-12-08","op_type":"汇缴201512公积金","record_month":"2015-12","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-11-16","op_type":"汇缴201511公积金","record_month":"2015-11","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-04-02","op_type":"租房","record_month":"2015-04","amount":"-4080.00","balance":"","remark":"","comments":"","deposit_type":"其他","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201503公积金","record_month":"2015-03","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201502公积金","record_month":"2015-02","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-01-26","op_type":"汇缴201501公积金","record_month":"2015-01","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-31","op_type":"汇缴201412公积金","record_month":"2014-12","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-30","op_type":"汇缴201411公积金","record_month":"2014-11","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201410公积金","record_month":"2014-10","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201409公积金","record_month":"2014-09","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-08-27","op_type":"汇缴201408公积金","record_month":"2014-08","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2013-07-12","op_type":"汇缴201307公积金","record_month":"2013-07","amount":"900.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1}],"gjj_account_analyzed_data":{"newest_account":1,"cont_last_times":59,"back_cont_last_times":-1,"cont_max_times":-1,"back_cont_max_times":-1,"sum_times":59,"back_sum_times":59}}],"loan_data":[{"loan_brief":[],"loan_detail":[]}],"general_analyzed_data":{"every_company_data":[],"last_6months_pay_off":"-1","last_6months_back_pay_off":"-1","last_24months_sum_times":"-1","last_24months_back_sum_times":"-1","last_24months_company_quantity":"-1","last_12months_has_extract":"-1","last_12months_average":"-1","last_24months_average":"-1","start_date":"2013-07-12","end_date":"2018-06-20","overdueClassify":[],"loanClassify":[],"blacklist":[]}}},"contacts":{"id":"25170825","uid":"25856023","device_num":"69DC83FF-C53A-482B-BB99-F22","device_info":"iPhone 7","platform":"ios","installed_apps":"","installed_apps_version":1,"app_location_json":"","update_time":"2017-07-18 16:02:31","create_time":"2017-07-18 16:02:31","delete_time":"2038-01-01 00:00:00","phone_list":[{"uid":"25856023","phone_dirty":"18866688866","phone":"18866688866","name":"融雯琼","createtime":"1454612345"},{"uid":"25856023","phone_dirty":"139-681234773","phone":"18866688866","name":"融剑","createtime":"1454612345"},{"uid":"25856023","phone_dirty":"135-881234654","phone":"18866688866","name":"融文","createtime":"1454612345"}],"call_log":[],"app_location":{"lat":"30.222225512345","lon":"120.17200112345","address":"北京海淀测试地址"}}}
     */

    private OrderInfoBean orderInfo;
    private ApplyDetailBean applyDetail;
    private AddInfoBean addInfo;

    @NoArgsConstructor
    @Data
    public static class OrderInfoBean {
        /**
         * order_No : 258617943106534
         * user_id : 30000421
         * id : 75530253
         * user_name : 张三
         * register_time : 1492582991
         * status : 80
         * order_time : 1551707677
         * city : 北京
         * bank : 深圳市华民投资发展有限公司
         * product : 华融易贷
         * product_id : 10429491
         * user_group_id : 212
         * user_mobile : 13420504517
         */

        private String order_No;
        private int user_id;
        private int id;
        private String user_name;
        private int register_time;
        private int status;
        private int order_time;
        private String city;
        private String bank;
        private String product;
        private int product_id;
        private int user_group_id;
        private String user_mobile;
    }

    @NoArgsConstructor
    @Data
    public static class ApplyDetailBean {
        /**
         * user_id : 412723199608124653
         * user_education : 2
         * bureau_user_name : 张三
         * gps_location : 116.307315,39.977859
         * max_monthly_repayment : 10000
         * phone_number_house : 13420504517
         * credit_status : 1
         * user_income_by_card : 1
         * asset_house_type : 1
         * user_social_security : 2
         * work_period : 1
         * if_provident_fund : 2
         * is_op_type : 4
         * asset_auto_type : 1
         * GPS_Address : 北京市朝阳区华贸商业街
         */

        private String user_id;
        private String user_education;
        private String bureau_user_name;
        private String gps_location;
        private int max_monthly_repayment;
        private String phone_number_house;
        private String credit_status;
        private int user_income_by_card;
        private String asset_house_type;
        private String user_social_security;
        private String work_period;
        private String if_provident_fund;
        private String is_op_type;
        private String asset_auto_type;
        private String GPS_Address;
    }

    @NoArgsConstructor
    @Data
    public static class AddInfoBean {
        /**
         * zhima : {"ali_trust_score":{"score":"726"},"ali_trust_watchlist":{"success":true,"biz_no":"Z5400431928953","is_matched":false}}
         * mobile : {"user":{"user_source":"CHINAMOBILE_CHONGQING","id_card":"","addr":"北京海淀测试地址","real_name":"**牛","phone":"18866688866","phone_remain":"12.42","reg_time":"2014-05-26","update_time":"2017-12-17 19:54:21","score":"2476","contact_phone":"18866688866","star_level":"4","authentication":"1","phone_status":"1","package_name":"4G自选流量套餐280元包11G|4G自"},"userdata":{"user_source":"CHINAMOBILE_CHONGQING","id_card":"","addr":"北京海淀测试地址","real_name":"**牛","phone":"18866688866","phone_remain":"12.42","reg_time":"2014-05-26","update_time":"2017-12-17 19:54:21","score":"2476","contact_phone":"18866688866","star_level":"4","authentication":"1","phone_status":"1","package_name":"4G自选流量套餐280元包11G|4G自"},"tel":[{"teldata":[{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:52:47","call_type":"1","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"53","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:59:43","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"51","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 16:07:22","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"17","trade_type":"1","receive_phone":"075584312345"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 12:15:45","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"11","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 14:41:56","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"68","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-13 13:04:51","call_type":"1","fee":"0.19","special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"16","trade_type":"1","receive_phone":"18866688866"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_TELDATA_201707_1509071984456485"},{"teldata":[{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-20 16:39:18","call_type":"1","fee":"0.19","special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"6","trade_type":"1","receive_phone":"4001812345"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-20 16:40:26","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"440","trade_type":"1","receive_phone":"18866688866"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_TELDATA_201707_1509071984280129"}],"msg":[{"msgdata":[{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:42:05","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:49:38","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:04:33","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 08:12:16","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"95559"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:31:14","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"1069079812345"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_MSGDATA_201707_1509071982253595"},{"msgdata":[{"business_name":"SMS","fee":"0.1","send_time":"2017-08-02 19:04:49","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":"0.1","send_time":"2017-08-02 19:04:50","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":0,"send_time":"2017-08-04 11:14:05","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"447537412345"},{"business_name":"SMS","fee":0,"send_time":"2017-08-18 14:43:28","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"447537412345"},{"business_name":"SMS","fee":0,"send_time":"2017-08-18 17:02:12","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10658112"},{"business_name":"SMS","fee":"0.1","send_time":"2017-08-24 12:56:20","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10690934312345"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_MSGDATA_201708_1509071982107192"}],"bill":[{"month":"201712","call_pay":"380.56","package_fee":"331","msg_fee":"1.7","tel_fee":"44.82","net_fee":0,"addtional_fee":"3.04","preferential_fee":"","generation_fee":0,"other_fee":0,"score":"2476","otherspaid_fee":"","pay_fee":""},{"month":"201711","call_pay":"384.36","package_fee":"331","msg_fee":"2.1","tel_fee":"45.26","net_fee":0,"addtional_fee":"6","preferential_fee":"0.00","generation_fee":0,"other_fee":0,"score":"","otherspaid_fee":0,"pay_fee":""}],"net":[{"netdata_key":"hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_NETDATA_201708_1509072024435556","netdata":[{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":"手机上网10元夜间套餐（15年版）","start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"24366","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":null,"start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"774","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(2G/4G)","preferential_fee":"团购国内流量1G","start_time":"2017-08-01 17:46:01","total_time":"94971","total_traffic":"167669","trade_addr":"北京海淀测试地址"}]}],"recharge":[{"fee":"0.4","recharge_time":"2017-04-27 10:00:49","recharge_way":"现金交费"}]}
         * icredit : [{"card":[{"bank":8882,"name":"融平波","payment_due_date":"2017-12-24","credit_card":"6259656210812345","type":"credit","login_account":"500237199307112345","card_no":"6259656210812345"}],"bill_flow":[{"bill":{"new_balance":131770,"min_payment":126742,"statement_start_date":"2017-11-05","month":"2017-12","statement_end_date":"2017-12-04","payment_cur_date":"2017-12-04","payment_due_date":"2017-12-24","credit_limit":1000000,"cash_advance_limit":500000,"last_balance":140087,"last_payment":-386000,"new_charges":0,"interest":0,"cur_adjust_amount":0,"last_points":0,"repayment":0,"currency":""},"flow":[{"trans_date":"2017-09-28","post_date":"2017-09-28","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-186000,"rmb_org_amount":-186000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"手机银行现金转出8338","rmb_amount":50000,"rmb_org_amount":50000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-200000,"rmb_org_amount":-200000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"现金分期*金额","rmb_amount":130000,"rmb_org_amount":130000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"信用卡现金转出手续费","rmb_amount":500,"rmb_org_amount":500,"currency":"CNY","cardNo_last4_digits":"0015"}]},{"bill":{"new_balance":147455,"min_payment":139511,"statement_start_date":"2017-08-05","month":"2017-09","statement_end_date":"2017-09-04","payment_cur_date":"2017-09-04","payment_due_date":"2017-09-24","credit_limit":1000000,"cash_advance_limit":500000,"last_balance":132279,"last_payment":-500000,"new_charges":0,"interest":0,"cur_adjust_amount":0,"last_points":0,"repayment":0,"currency":""},"flow":[{"trans_date":"2017-09-04","post_date":"2017-09-04","description":"现金分期每月手续费","rmb_amount":2120,"rmb_org_amount":2120,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"信用卡现金转出手续费","rmb_amount":768,"rmb_org_amount":768,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"手机银行现金转出8338","rmb_amount":76800,"rmb_org_amount":76800,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-200000,"rmb_org_amount":-200000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-08-07","post_date":"2017-08-08","description":"现金分期*金额","rmb_amount":110000,"rmb_org_amount":110000,"currency":"CNY","cardNo_last4_digits":"0015"}]},{"bill":{"new_balance":132279,"min_payment":130512,"statement_start_date":"2017-07-05","month":"2017-08","statement_end_date":"2017-08-04","payment_cur_date":"2017-08-04","payment_due_date":"2017-08-24","credit_limit":1000000,"cash_advance_limit":500000,"last_balance":127963,"last_payment":-500000,"new_charges":0,"interest":0,"cur_adjust_amount":0,"last_points":0,"repayment":0,"currency":""},"flow":[{"trans_date":"2017-08-04","post_date":"2017-08-04","description":"现金分期单期金额:分期9/12","rmb_amount":6667,"rmb_org_amount":6667,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-22","post_date":"2017-05-22","description":"手机银行现金转出8338","rmb_amount":500000,"rmb_org_amount":500000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-22","post_date":"2017-05-22","description":"网银跨行还款62268901195****3","rmb_amount":-500000,"rmb_org_amount":-500000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-05","post_date":"2017-05-05","description":"手机银行一键转账还款8338","rmb_amount":-76222,"rmb_org_amount":-76222,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-05-05","post_date":"2017-05-05","description":"深圳市财付通科技有限公司","rmb_amount":70000,"rmb_org_amount":70000,"currency":"CNY","cardNo_last4_digits":"0015"}]}]}]
         * alipay : [{"alipay_info":[{"login_name":"18866688866","real_name":"**牛","id_card":"5****************2","email":"未添加邮箱账户名","phone":"159******30","taobao_name":"南宫靖雨悠","identify_time":"","register_date":"1401206412345","is_real_name":"已认证","is_protected":"账户已受全面保障","is_phone":"已绑定","secret_level":"","balance":"300.00","income":"3.17","is_idcard":"是","amount":"0.00","total_amount":"8000.00","available_amount":"0.00","need_to_pay_next_month":"0.00"}],"alipay_list":[{"trade_no":"2017012500003001150024812345","pay_time":"1485321112345","trade_type":"1月-固话/宽带费-*林清-我家","trade_no_type":"1月-固话/宽带费-*林清-我家","receiver_name":"重庆电信公司","amount":"-94","status":"交易成功","source":"","trade_classification":"缴费","alipay_name":"18866688866"},{"trade_no":"2017120921001004155260712345","pay_time":"1512815812345","trade_type":"滴滴快车-周瑜师傅","trade_no_type":"滴滴快车-周瑜师傅","receiver_name":"","amount":"-5","status":"交易成功","source":"","trade_classification":"转账","alipay_name":"18866688866"}],"bankcard":[{"card_last_num":"9687","open_status":"已开通","apply_time":"0","bank_name":"交通银行","card_type":"信用卡","mobile":"159****5930","active_date":"2017-03-09","show_user_name":"融七牛","alipay_name":"18866688866"},{"card_last_num":"6314","open_status":"已开通","apply_time":"0","bank_name":"浦发银行","card_type":"信用卡","mobile":"159****5930","active_date":"2016-12-11","show_user_name":"融七牛","alipay_name":"18866688866"}],"alipay_charge_account":[{"account_id":"a20170113000700120000150701012345","charge_item":"水费","area":"重庆","charge_unit":"长寿自来水","charge_account":"*才路公租房1幢3-4","charge_number":"1234512345","charge_reminder":"未设置","login_name":"18866688866"},{"account_id":"a20170114000700120000150701012345","charge_item":"电费","area":"重庆","charge_unit":"国网重庆市电力公司","charge_account":"重庆市*********","charge_number":"1577812345","charge_reminder":"未设置","login_name":"18866688866"}],"crawl_time":"2017-12-18 00:07:45"}]
         * ibank : {"bank_name":"中国银行","user_name":"融七牛","data":[{"page":"0","detail":[{"no":"","trade_time":"2017-07-17 00:00:00","payment":"30.00","deposit":"","abstract":"转账支出","balance":"495.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1054.00","deposit":"","abstract":"转账支出","balance":"525.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"1425.00","abstract":"POS转账","balance":"1579.56","trade_type":"","trade_country":"","trade_place":"POS机 POS机","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1300.00","deposit":"","abstract":"代收费","balance":"154.56","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"0274******9999","other_account_name":"银众投资","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"205.79","abstract":"代收付","balance":"1454.56","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"100.00","abstract":"代付","balance":"1248.77","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"116.00","deposit":"","abstract":"转账支出","balance":"1148.77","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""}],"img_url":"https://is.rong360.com/image/hbase?key=","html_url":"https://is.rong360.com/image/hbase?key=hbase2://cfile173/ibank/html/fc6baf234fc4c46e5cc35cd5f6a5cf4a_0_1500364233340290"},{"page":"1","detail":[{"no":"","trade_time":"2017-07-16 00:00:00","payment":"71.00","deposit":"","abstract":"网上快捷支付","balance":"1264.77","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"17.90","abstract":"代收付","balance":"1335.77","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"100.00","deposit":"","abstract":"网上快捷支付","balance":"1317.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"5.00","abstract":"代付","balance":"1417.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"50.00","abstract":"代付","balance":"1412.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"799.20","abstract":"代收付","balance":"1362.87","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"399.60","abstract":"代收付","balance":"563.67","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"1135.00","deposit":"","abstract":"网上快捷支付","balance":"164.07","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"849.15","abstract":"代收付","balance":"1299.07","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"443.98","abstract":"代收付","balance":"449.92","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""}],"img_url":"https://is.rong360.com/image/hbase?key=","html_url":"https://is.rong360.com/image/hbase?key=hbase2://cfile173/ibank/html/fc6baf234fc4c46e5cc35cd5f6a5cf4a_0_1500364235737852"}]}
         * ec : [{"mail":"chen123123123testrong@qq.com","bank_name":"民生","card_no":"9888","name":"融七牛","sex":"2","last_balance":"159063","last_payment":"85600","statement_start_date":"1476312345","statement_end_date":"1479012345","payment_cur_date":"1479012345","payment_due_date":"1480712345","credit_limit":"0","total_points":"11548","new_balance":"200979","min_payment":"65202","new_charges":"125358","adjustment":"0","interest":"2158","last_points":"10774","earned_points":"774","sender_email":"master12313@creditcard.cmbc.com.cn","adjusted_points":"0","available_balance_usd":"0","available_balance":"0","cash_advance_limit_usd":"0","credit_limit_usd":"0","cash_advance_limit":"0","min_payment_usd":"0","new_balance_usd":"0","redeemed_points":"0","rewarded_points":"0","time":"2017-02-21 14:11:29","create_time":"2017-02-21 14:11:29","trans_detail":[{"trans_date":"1479012345","post_date":"1479012345","description":"利息交易","rmb_amount":"2158","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 手续费第3期共12期","rmb_amount":"425","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 每月摊消第3期共12期","rmb_amount":"5290","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 手续费第3期共24期","rmb_amount":"6076","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 每月摊消第3期共24期","rmb_amount":"36167","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-60600","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-20000","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"杭州欣美药房有限公司","rmb_amount":"77400","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-5000","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"}],"is_simple":0,"url":"https://is.rong360.com/image/f?token=V8yTJB_tn33ypP3nMAuaJT2pnf9-8r6gbarmJWWmi9YUv7h7CRwuJE0KwVIiVRNh49hVY1YqXF5wwCZwKQqIU32vQqk-qdVcIhnZiTLFGh1gX3X6odh5q8_608Rp96ym3kWFZQhyWAS1hNZfM6DraQ,,"}]
         * jd : {"login_name":"18866688866","auth_info":{"login_name":"18866688866","name":"融妍","id_card":"3****************1","auth_time":"2016-05-04","binding_phone":"159****2060","auth_channel":"京东金融实名认证","financial_service":"白条"},"bt_info":{"login_name":"18866688866","bt_credit_point":72.1,"bt_overdraft":5242.31,"bt_quota":5261},"user_info":{"login_name":"18866688866","username":"jd_5123123123","set_login_name":"jd_123123123","nickname":"jd_123123213","sex":"保密","birthday":"0000-00-00","hobbies":"","email":"52*****82@qq.com","real_name":"","marriage":"","income":"","id_card":"","education":"","industry":"","is_qq_bound":"已绑定","is_wechat_bound":"已绑定","account_grade":"银牌会员","account_type":"个人用户"},"shipping_addrs":[{"login_name":"18866688866","addr_id":"138397500","receiver":"融七牛","region":"浙江杭州市上城区","address":"北京海淀测试地址","mobile_phone":"159****2060","fixed_phone":"","email_addr":""}],"bankcards":[{"login_name":"18866688866","card_id":"cfe4bbcf685fb9cf507778072d029f65","bank_name":"citic","tail_number":"1132","card_type":"信用卡","owner_name":"*妍","phone":"135****8281"}],"order_list":[{"order_id":"18866688866","receiver":"融七牛","money":"65.0000","buy_way":"在线支付","buy_time":"1480312345","order_status":"完成","order_source":"JD","login_name":"18866688866","receiver_addr":"北京海淀测试地址","receiver_post":"","receiver_fix_phone":"","receiver_telephone":"135****8281","receiver_email":"","product_names":"盒装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光;","invoice_type":"普通发票","invoice_header":"个人","invoice_content":"明细","products":[{"price":65,"product_id":"18866688866","name":"融装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光"}],"url":"https://is.rong360.com/image/hbase?key="}]}
         * insure : {"user":{"real_name":"**牛","id_card":"440184198810112345","sex":"男","birthday":"1988-10-16","work_start_day":"","acc_prop":"本地非农业户口(本地城镇)","acc_addr":"","degree":"","cellphone":"","phone":"","email":"社保登记","insure_code":"1049112345","insure_city":"广州社保","insure_status":"","insure_month_money":"","com_name":"","com_code":"","nation":"汉族","live_addr":"北京海淀测试地址","live_postcode":"510600","marital_status":"","worker_nation":"","start_insure_day":"","format_acc_prop":"非农","format_degree":"","format_insure_status":"","format_marital_status":"","format_worker_nation":""},"flow":[{"id_card":"440184198810112345","pay_date":"","start_date":"2017-07","end_date":"2017-11","base_rmb":"2075.00","com_rmb":"66.40","per_rmb":"13.28","balance_rmb":"","month_rmb":"79.68","com_name":"华润万家生活超市（广州）有限公司从化店","pay_type":"正常缴费","flow_type":"2"}]}
         * taobao : [{"tb_user":{"login_name":"15012345678","vip_level":"","buyer_credit":64,"rate_summary":"100.0","score":625,"vip_count":0,"star_level":0,"sum_amount":"0.00","count_orders":0,"count_days_bought":0,"count_days_from_regi":0,"account_name":"许伟伟先生","email":"","binding_phone":"15012345678","authentication":"已完成","binding_weibo_account":"","binding_weibo_nickname":"","name":"许伟伟","division_code":"","address":"","tianmao_account":"许伟伟先生","tianmao_grade":815,"tianmao_vip_level":"","tianmao_credit_level":""},"tb_orders":[{"order_id":"165227275474186756","status":"成功","actual_fee":"19.00","phone_order":1,"transaction_time":"2018-06-2023:03:26","payment_time":"2018-06-2023:03:29","confirmation_time":"2018-06-2023:03:37","receiver_name":"","receiver_telephone":"","receiver_address":"","products":[{"product_name":"爱奇艺VIP黄金会员一个月卡爱奇艺会员1个月填手机号","product_price":"19.00","product_quantity":1}]},{"order_id":"162855483476186756","status":"成功","actual_fee":"27.65","phone_order":1,"transaction_time":"2018-06-1709:32:09","payment_time":"2018-06-1709:32:12","confirmation_time":"2018-06-1709:32:41","receiver_name":"","receiver_telephone":"","receiver_address":"","products":[{"product_name":"腾讯地下城与勇士30元点券/DNF点卡/dnf点卷/DNF3000点券★自动充","product_price":"27.65","product_quantity":1}]}],"tb_deliver_addrs":[{"tb_user_id":3836225,"receiver_name":"崔文文","area":"北京市","address":"北京市海淀区丹棱街","zip_code":"100000","phone":"13012345678","is_default_address":""},{"tb_user_id":3836225,"receiver_name":"许姐姐","area":"北京市","address":"北京市海淀区丹棱街","zip_code":"100000","phone":"13012345678","is_default_address":""}],"tb_zhifubao_binding":{"tb_user_id":3836225,"balance":"2044.77","total_profit":"22.51","total_quotient":"3.88","huabei_credit_amount":"370.15","huabei_total_credit_amount":"4500.00","zhifubao_account":"150******40","binding_phone":"15012345678","account_type":"个人账户","verified_name":"许伟伟","verified_id_card":"41272***********53"}}]
         * tjy_model : {"decision_score":649}
         * fund : {"cid":21,"location":"西安公积金","cityName":"西安市","orderId":"05071a78a0725404a119de096511a15a","create_date":"2018-06-27 21:16:50","data":{"gjj_data":[{"gjj_brief":{"ID":"610103198605112345","name":"融浩","card":"","customer_id":"1489872","deposit_amount":"1600.00","fb_deposit_amount":"","balance":"28225.98","fb_balance":"","once_balance":"","status":"正常","record_date":"2018-05","company":"西安凯美置业有限公司","deposit_base":"16000.00","person_rate":"5.00","company_rate":"5.00","init_date":"2013-02-05","start_date":"2013-07","sex":"男","email":"","phone":"","marriage":"","address":"","birthday":"1986-05-14","company_id":"0019186","person_deposit_amount":"","company_deposit_amount":"","deposit_rate":""},"gjj_detail":[{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-06-20","op_type":"汇缴201805公积金","record_month":"2018-05","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-05-10","op_type":"汇缴201804公积金","record_month":"2018-04","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-04-02","op_type":"汇缴201803公积金","record_month":"2018-03","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-03-20","op_type":"汇缴201802公积金","record_month":"2018-02","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2017-01-16","op_type":"购买、建造、翻建、大修自住住房等","record_month":"2017-01","amount":"-29489.93","balance":"","remark":"","comments":"","deposit_type":"支取-购房贷款支取","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2016-01-08","op_type":"汇缴201601公积金","record_month":"2016-01","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-12-08","op_type":"汇缴201512公积金","record_month":"2015-12","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-11-16","op_type":"汇缴201511公积金","record_month":"2015-11","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-04-02","op_type":"租房","record_month":"2015-04","amount":"-4080.00","balance":"","remark":"","comments":"","deposit_type":"其他","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201503公积金","record_month":"2015-03","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201502公积金","record_month":"2015-02","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-01-26","op_type":"汇缴201501公积金","record_month":"2015-01","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-31","op_type":"汇缴201412公积金","record_month":"2014-12","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-30","op_type":"汇缴201411公积金","record_month":"2014-11","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201410公积金","record_month":"2014-10","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201409公积金","record_month":"2014-09","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-08-27","op_type":"汇缴201408公积金","record_month":"2014-08","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2013-07-12","op_type":"汇缴201307公积金","record_month":"2013-07","amount":"900.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1}],"gjj_account_analyzed_data":{"newest_account":1,"cont_last_times":59,"back_cont_last_times":-1,"cont_max_times":-1,"back_cont_max_times":-1,"sum_times":59,"back_sum_times":59}}],"loan_data":[{"loan_brief":[],"loan_detail":[]}],"general_analyzed_data":{"every_company_data":[],"last_6months_pay_off":"-1","last_6months_back_pay_off":"-1","last_24months_sum_times":"-1","last_24months_back_sum_times":"-1","last_24months_company_quantity":"-1","last_12months_has_extract":"-1","last_12months_average":"-1","last_24months_average":"-1","start_date":"2013-07-12","end_date":"2018-06-20","overdueClassify":[],"loanClassify":[],"blacklist":[]}}}
         * contacts : {"id":"25170825","uid":"25856023","device_num":"69DC83FF-C53A-482B-BB99-F22","device_info":"iPhone 7","platform":"ios","installed_apps":"","installed_apps_version":1,"app_location_json":"","update_time":"2017-07-18 16:02:31","create_time":"2017-07-18 16:02:31","delete_time":"2038-01-01 00:00:00","phone_list":[{"uid":"25856023","phone_dirty":"18866688866","phone":"18866688866","name":"融雯琼","createtime":"1454612345"},{"uid":"25856023","phone_dirty":"139-681234773","phone":"18866688866","name":"融剑","createtime":"1454612345"},{"uid":"25856023","phone_dirty":"135-881234654","phone":"18866688866","name":"融文","createtime":"1454612345"}],"call_log":[],"app_location":{"lat":"30.222225512345","lon":"120.17200112345","address":"北京海淀测试地址"}}
         */

        private ZhimaBean zhima;
        private MobileBean mobile;
        private IbankBean ibank;
        private JdBean jd;
        private InsureBean insure;
        private TjyModelBean tjy_model;
        private FundBean fund;
        private ContactsBean contacts;
        private List<IcreditBean> icredit;
        private List<AlipayBean> alipay;
        private List<EcBean> ec;
        private List<TaobaoBean> taobao;

        @NoArgsConstructor
        @Data
        public static class ZhimaBean {
            /**
             * ali_trust_score : {"score":"726"}
             * ali_trust_watchlist : {"success":true,"biz_no":"Z5400431928953","is_matched":false}
             */

            private AliTrustScoreBean ali_trust_score;
            private AliTrustWatchlistBean ali_trust_watchlist;

            @NoArgsConstructor
            @Data
            public static class AliTrustScoreBean {
                /**
                 * score : 726
                 */

                private String score;
            }

            @NoArgsConstructor
            @Data
            public static class AliTrustWatchlistBean {
                /**
                 * success : true
                 * biz_no : Z5400431928953
                 * is_matched : false
                 */

                private boolean success;
                private String biz_no;
                private boolean is_matched;
            }
        }

        @NoArgsConstructor
        @Data
        public static class MobileBean {
            /**
             * user : {"user_source":"CHINAMOBILE_CHONGQING","id_card":"","addr":"北京海淀测试地址","real_name":"**牛","phone":"18866688866","phone_remain":"12.42","reg_time":"2014-05-26","update_time":"2017-12-17 19:54:21","score":"2476","contact_phone":"18866688866","star_level":"4","authentication":"1","phone_status":"1","package_name":"4G自选流量套餐280元包11G|4G自"}
             * userdata : {"user_source":"CHINAMOBILE_CHONGQING","id_card":"","addr":"北京海淀测试地址","real_name":"**牛","phone":"18866688866","phone_remain":"12.42","reg_time":"2014-05-26","update_time":"2017-12-17 19:54:21","score":"2476","contact_phone":"18866688866","star_level":"4","authentication":"1","phone_status":"1","package_name":"4G自选流量套餐280元包11G|4G自"}
             * tel : [{"teldata":[{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:52:47","call_type":"1","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"53","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:59:43","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"51","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 16:07:22","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"17","trade_type":"1","receive_phone":"075584312345"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 12:15:45","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"11","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 14:41:56","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"68","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-13 13:04:51","call_type":"1","fee":"0.19","special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"16","trade_type":"1","receive_phone":"18866688866"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_TELDATA_201707_1509071984456485"},{"teldata":[{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-20 16:39:18","call_type":"1","fee":"0.19","special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"6","trade_type":"1","receive_phone":"4001812345"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-20 16:40:26","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"440","trade_type":"1","receive_phone":"18866688866"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_TELDATA_201707_1509071984280129"}]
             * msg : [{"msgdata":[{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:42:05","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:49:38","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:04:33","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 08:12:16","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"95559"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:31:14","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"1069079812345"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_MSGDATA_201707_1509071982253595"},{"msgdata":[{"business_name":"SMS","fee":"0.1","send_time":"2017-08-02 19:04:49","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":"0.1","send_time":"2017-08-02 19:04:50","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":0,"send_time":"2017-08-04 11:14:05","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"447537412345"},{"business_name":"SMS","fee":0,"send_time":"2017-08-18 14:43:28","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"447537412345"},{"business_name":"SMS","fee":0,"send_time":"2017-08-18 17:02:12","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10658112"},{"business_name":"SMS","fee":"0.1","send_time":"2017-08-24 12:56:20","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10690934312345"}],"url":"https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_MSGDATA_201708_1509071982107192"}]
             * bill : [{"month":"201712","call_pay":"380.56","package_fee":"331","msg_fee":"1.7","tel_fee":"44.82","net_fee":0,"addtional_fee":"3.04","preferential_fee":"","generation_fee":0,"other_fee":0,"score":"2476","otherspaid_fee":"","pay_fee":""},{"month":"201711","call_pay":"384.36","package_fee":"331","msg_fee":"2.1","tel_fee":"45.26","net_fee":0,"addtional_fee":"6","preferential_fee":"0.00","generation_fee":0,"other_fee":0,"score":"","otherspaid_fee":0,"pay_fee":""}]
             * net : [{"netdata_key":"hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_NETDATA_201708_1509072024435556","netdata":[{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":"手机上网10元夜间套餐（15年版）","start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"24366","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":null,"start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"774","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(2G/4G)","preferential_fee":"团购国内流量1G","start_time":"2017-08-01 17:46:01","total_time":"94971","total_traffic":"167669","trade_addr":"北京海淀测试地址"}]}]
             * recharge : [{"fee":"0.4","recharge_time":"2017-04-27 10:00:49","recharge_way":"现金交费"}]
             */

            private UserBean user;
            private UserdataBean userdata;
            private List<TelBean> tel;
            private List<MsgBean> msg;
            private List<BillBean> bill;
            private List<NetBean> net;
            private List<RechargeBean> recharge;

            @NoArgsConstructor
            @Data
            public static class UserBean {
                /**
                 * user_source : CHINAMOBILE_CHONGQING
                 * id_card :
                 * addr : 北京海淀测试地址
                 * real_name : **牛
                 * phone : 18866688866
                 * phone_remain : 12.42
                 * reg_time : 2014-05-26
                 * update_time : 2017-12-17 19:54:21
                 * score : 2476
                 * contact_phone : 18866688866
                 * star_level : 4
                 * authentication : 1
                 * phone_status : 1
                 * package_name : 4G自选流量套餐280元包11G|4G自
                 */

                private String user_source;
                private String id_card;
                private String addr;
                private String real_name;
                private String phone;
                private String phone_remain;
                private String reg_time;
                private String update_time;
                private String score;
                private String contact_phone;
                private String star_level;
                private String authentication;
                private String phone_status;
                private String package_name;
            }

            @NoArgsConstructor
            @Data
            public static class UserdataBean {
                /**
                 * user_source : CHINAMOBILE_CHONGQING
                 * id_card :
                 * addr : 北京海淀测试地址
                 * real_name : **牛
                 * phone : 18866688866
                 * phone_remain : 12.42
                 * reg_time : 2014-05-26
                 * update_time : 2017-12-17 19:54:21
                 * score : 2476
                 * contact_phone : 18866688866
                 * star_level : 4
                 * authentication : 1
                 * phone_status : 1
                 * package_name : 4G自选流量套餐280元包11G|4G自
                 */

                private String user_source;
                private String id_card;
                private String addr;
                private String real_name;
                private String phone;
                private String phone_remain;
                private String reg_time;
                private String update_time;
                private String score;
                private String contact_phone;
                private String star_level;
                private String authentication;
                private String phone_status;
                private String package_name;
            }

            @NoArgsConstructor
            @Data
            public static class TelBean {
                /**
                 * teldata : [{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:52:47","call_type":"1","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"53","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 11:59:43","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"51","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-01 16:07:22","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"17","trade_type":"1","receive_phone":"075584312345"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 12:15:45","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"11","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-05 14:41:56","call_type":"2","fee":0,"special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"68","trade_type":"1","receive_phone":"18866688866"},{"business_name":"4G自选套餐语音18元档","call_time":"2017-07-13 13:04:51","call_type":"1","fee":"0.19","special_offer":"","trade_addr":"北京海淀测试地址","trade_time":"16","trade_type":"1","receive_phone":"18866688866"}]
                 * url : https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_TELDATA_201707_1509071984456485
                 */

                private String url;
                private List<TeldataBean> teldata;

                @NoArgsConstructor
                @Data
                public static class TeldataBean {
                    /**
                     * business_name : 4G自选套餐语音18元档
                     * call_time : 2017-07-01 11:52:47
                     * call_type : 1
                     * fee : 0
                     * special_offer :
                     * trade_addr : 北京海淀测试地址
                     * trade_time : 53
                     * trade_type : 1
                     * receive_phone : 18866688866
                     */

                    private String business_name;
                    private String call_time;
                    private String call_type;
                    private String fee;
                    private String special_offer;
                    private String trade_addr;
                    private String trade_time;
                    private String trade_type;
                    private String receive_phone;
                }
            }

            @NoArgsConstructor
            @Data
            public static class MsgBean {
                /**
                 * msgdata : [{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:42:05","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":0,"send_time":"2017-07-12 00:49:38","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"10086"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:04:33","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"18866688866"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 08:12:16","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"95559"},{"business_name":"SMS","fee":"0.1","send_time":"2017-07-31 19:31:14","trade_addr":"北京海淀测试地址","trade_type":"1","trade_way":1,"receiver_phone":"1069079812345"}]
                 * url : https://is.rong360.com/image/hbase?key=hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_MSGDATA_201707_1509071982253595
                 */

                private String url;
                private List<MsgdataBean> msgdata;

                @NoArgsConstructor
                @Data
                public static class MsgdataBean {
                    /**
                     * business_name : SMS
                     * fee : 0
                     * send_time : 2017-07-12 00:42:05
                     * trade_addr : 北京海淀测试地址
                     * trade_type : 1
                     * trade_way : 1
                     * receiver_phone : 10086
                     */

                    private String business_name;
                    private String fee;
                    private String send_time;
                    private String trade_addr;
                    private String trade_type;
                    private int trade_way;
                    private String receiver_phone;
                }
            }

            @NoArgsConstructor
            @Data
            public static class BillBean {
                /**
                 * month : 201712
                 * call_pay : 380.56
                 * package_fee : 331
                 * msg_fee : 1.7
                 * tel_fee : 44.82
                 * net_fee : 0
                 * addtional_fee : 3.04
                 * preferential_fee :
                 * generation_fee : 0
                 * other_fee : 0
                 * score : 2476
                 * otherspaid_fee :
                 * pay_fee :
                 */

                private String month;
                private String call_pay;
                private String package_fee;
                private String msg_fee;
                private String tel_fee;
                private String net_fee;
                private String addtional_fee;
                private String preferential_fee;
                private String generation_fee;
                private String other_fee;
                private String score;
                private String otherspaid_fee;
                private String pay_fee;
            }

            @NoArgsConstructor
            @Data
            public static class NetBean {
                /**
                 * netdata_key : hbase://cfile174/MobilePhone/html/dec0dac5b177b4afac8ce7adf3969348_NETDATA_201708_1509072024435556
                 * netdata : [{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":"手机上网10元夜间套餐（15年版）","start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"24366","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(4G)","preferential_fee":null,"start_time":"2017-08-01 00:12:43","total_time":"58973","total_traffic":"774","trade_addr":"北京海淀测试地址"},{"fee":0,"net_type":"GPRS","net_way":"CMNET(2G/4G)","preferential_fee":"团购国内流量1G","start_time":"2017-08-01 17:46:01","total_time":"94971","total_traffic":"167669","trade_addr":"北京海淀测试地址"}]
                 */

                private String netdata_key;
                private List<NetdataBean> netdata;

                @NoArgsConstructor
                @Data
                public static class NetdataBean {
                    /**
                     * fee : 0
                     * net_type : GPRS
                     * net_way : CMNET(4G)
                     * preferential_fee : 手机上网10元夜间套餐（15年版）
                     * start_time : 2017-08-01 00:12:43
                     * total_time : 58973
                     * total_traffic : 24366
                     * trade_addr : 北京海淀测试地址
                     */

                    private String fee;
                    private String net_type;
                    private String net_way;
                    private String preferential_fee;
                    private String start_time;
                    private String total_time;
                    private String total_traffic;
                    private String trade_addr;
                }
            }

            @NoArgsConstructor
            @Data
            public static class RechargeBean {
                /**
                 * fee : 0.4
                 * recharge_time : 2017-04-27 10:00:49
                 * recharge_way : 现金交费
                 */

                private String fee;
                private String recharge_time;
                private String recharge_way;
            }
        }

        @NoArgsConstructor
        @Data
        public static class IbankBean {
            /**
             * bank_name : 中国银行
             * user_name : 融七牛
             * data : [{"page":"0","detail":[{"no":"","trade_time":"2017-07-17 00:00:00","payment":"30.00","deposit":"","abstract":"转账支出","balance":"495.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1054.00","deposit":"","abstract":"转账支出","balance":"525.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"1425.00","abstract":"POS转账","balance":"1579.56","trade_type":"","trade_country":"","trade_place":"POS机 POS机","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1300.00","deposit":"","abstract":"代收费","balance":"154.56","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"0274******9999","other_account_name":"银众投资","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"205.79","abstract":"代收付","balance":"1454.56","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"100.00","abstract":"代付","balance":"1248.77","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"116.00","deposit":"","abstract":"转账支出","balance":"1148.77","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""}],"img_url":"https://is.rong360.com/image/hbase?key=","html_url":"https://is.rong360.com/image/hbase?key=hbase2://cfile173/ibank/html/fc6baf234fc4c46e5cc35cd5f6a5cf4a_0_1500364233340290"},{"page":"1","detail":[{"no":"","trade_time":"2017-07-16 00:00:00","payment":"71.00","deposit":"","abstract":"网上快捷支付","balance":"1264.77","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"17.90","abstract":"代收付","balance":"1335.77","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"100.00","deposit":"","abstract":"网上快捷支付","balance":"1317.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"5.00","abstract":"代付","balance":"1417.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"50.00","abstract":"代付","balance":"1412.87","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"799.20","abstract":"代收付","balance":"1362.87","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"399.60","abstract":"代收付","balance":"563.67","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"1135.00","deposit":"","abstract":"网上快捷支付","balance":"164.07","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"849.15","abstract":"代收付","balance":"1299.07","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"","deposit":"443.98","abstract":"代收付","balance":"449.92","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""}],"img_url":"https://is.rong360.com/image/hbase?key=","html_url":"https://is.rong360.com/image/hbase?key=hbase2://cfile173/ibank/html/fc6baf234fc4c46e5cc35cd5f6a5cf4a_0_1500364235737852"}]
             */

            private String bank_name;
            private String user_name;
            private List<DataBean> data;

            @NoArgsConstructor
            @Data
            public static class DataBean {
                /**
                 * page : 0
                 * detail : [{"no":"","trade_time":"2017-07-17 00:00:00","payment":"30.00","deposit":"","abstract":"转账支出","balance":"495.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1054.00","deposit":"","abstract":"转账支出","balance":"525.56","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"1425.00","abstract":"POS转账","balance":"1579.56","trade_type":"","trade_country":"","trade_place":"POS机 POS机","other_account":"","other_account_name":"","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"1300.00","deposit":"","abstract":"代收费","balance":"154.56","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"0274******9999","other_account_name":"银众投资","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"205.79","abstract":"代收付","balance":"1454.56","trade_type":"","trade_country":"","trade_place":"","other_account":"0000******2916","other_account_name":"支付宝（中国）网络技术有限公司客户备付金","other_account_bank":""},{"no":"","trade_time":"2017-07-17 00:00:00","payment":"","deposit":"100.00","abstract":"代付","balance":"1248.77","trade_type":"","trade_country":"","trade_place":"银企对接 银企对接","other_account":"7458******0219","other_account_name":"深圳市财付通科技有限公司","other_account_bank":""},{"no":"","trade_time":"2017-07-16 00:00:00","payment":"116.00","deposit":"","abstract":"转账支出","balance":"1148.77","trade_type":"","trade_country":"","trade_place":"","other_account":"","other_account_name":"","other_account_bank":""}]
                 * img_url : https://is.rong360.com/image/hbase?key=
                 * html_url : https://is.rong360.com/image/hbase?key=hbase2://cfile173/ibank/html/fc6baf234fc4c46e5cc35cd5f6a5cf4a_0_1500364233340290
                 */

                private String page;
                private String img_url;
                private String html_url;
                private List<DetailBean> detail;

                @NoArgsConstructor
                @Data
                public static class DetailBean {
                    /**
                     * no :
                     * trade_time : 2017-07-17 00:00:00
                     * payment : 30.00
                     * deposit :
                     * abstract : 转账支出
                     * balance : 495.56
                     * trade_type :
                     * trade_country :
                     * trade_place :
                     * other_account :
                     * other_account_name :
                     * other_account_bank :
                     */

                    private String no;
                    private String trade_time;
                    private String payment;
                    private String deposit;
                    private String abstractX;
                    private String balance;
                    private String trade_type;
                    private String trade_country;
                    private String trade_place;
                    private String other_account;
                    private String other_account_name;
                    private String other_account_bank;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class JdBean {
            /**
             * login_name : 18866688866
             * auth_info : {"login_name":"18866688866","name":"融妍","id_card":"3****************1","auth_time":"2016-05-04","binding_phone":"159****2060","auth_channel":"京东金融实名认证","financial_service":"白条"}
             * bt_info : {"login_name":"18866688866","bt_credit_point":72.1,"bt_overdraft":5242.31,"bt_quota":5261}
             * user_info : {"login_name":"18866688866","username":"jd_5123123123","set_login_name":"jd_123123123","nickname":"jd_123123213","sex":"保密","birthday":"0000-00-00","hobbies":"","email":"52*****82@qq.com","real_name":"","marriage":"","income":"","id_card":"","education":"","industry":"","is_qq_bound":"已绑定","is_wechat_bound":"已绑定","account_grade":"银牌会员","account_type":"个人用户"}
             * shipping_addrs : [{"login_name":"18866688866","addr_id":"138397500","receiver":"融七牛","region":"浙江杭州市上城区","address":"北京海淀测试地址","mobile_phone":"159****2060","fixed_phone":"","email_addr":""}]
             * bankcards : [{"login_name":"18866688866","card_id":"cfe4bbcf685fb9cf507778072d029f65","bank_name":"citic","tail_number":"1132","card_type":"信用卡","owner_name":"*妍","phone":"135****8281"}]
             * order_list : [{"order_id":"18866688866","receiver":"融七牛","money":"65.0000","buy_way":"在线支付","buy_time":"1480312345","order_status":"完成","order_source":"JD","login_name":"18866688866","receiver_addr":"北京海淀测试地址","receiver_post":"","receiver_fix_phone":"","receiver_telephone":"135****8281","receiver_email":"","product_names":"盒装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光;","invoice_type":"普通发票","invoice_header":"个人","invoice_content":"明细","products":[{"price":65,"product_id":"18866688866","name":"融装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光"}],"url":"https://is.rong360.com/image/hbase?key="}]
             */

            private String login_name;
            private AuthInfoBean auth_info;
            private BtInfoBean bt_info;
            private UserInfoBean user_info;
            private List<ShippingAddrsBean> shipping_addrs;
            private List<BankcardsBean> bankcards;
            private List<OrderListBean> order_list;

            @NoArgsConstructor
            @Data
            public static class AuthInfoBean {
                /**
                 * login_name : 18866688866
                 * name : 融妍
                 * id_card : 3****************1
                 * auth_time : 2016-05-04
                 * binding_phone : 159****2060
                 * auth_channel : 京东金融实名认证
                 * financial_service : 白条
                 */

                private String login_name;
                private String name;
                private String id_card;
                private String auth_time;
                private String binding_phone;
                private String auth_channel;
                private String financial_service;
            }

            @NoArgsConstructor
            @Data
            public static class BtInfoBean {
                /**
                 * login_name : 18866688866
                 * bt_credit_point : 72.1
                 * bt_overdraft : 5242.31
                 * bt_quota : 5261
                 */

                private String login_name;
                private double bt_credit_point;
                private double bt_overdraft;
                private int bt_quota;
            }

            @NoArgsConstructor
            @Data
            public static class UserInfoBean {
                /**
                 * login_name : 18866688866
                 * username : jd_5123123123
                 * set_login_name : jd_123123123
                 * nickname : jd_123123213
                 * sex : 保密
                 * birthday : 0000-00-00
                 * hobbies :
                 * email : 52*****82@qq.com
                 * real_name :
                 * marriage :
                 * income :
                 * id_card :
                 * education :
                 * industry :
                 * is_qq_bound : 已绑定
                 * is_wechat_bound : 已绑定
                 * account_grade : 银牌会员
                 * account_type : 个人用户
                 */

                private String login_name;
                private String username;
                private String set_login_name;
                private String nickname;
                private String sex;
                private String birthday;
                private String hobbies;
                private String email;
                private String real_name;
                private String marriage;
                private String income;
                private String id_card;
                private String education;
                private String industry;
                private String is_qq_bound;
                private String is_wechat_bound;
                private String account_grade;
                private String account_type;
            }

            @NoArgsConstructor
            @Data
            public static class ShippingAddrsBean {
                /**
                 * login_name : 18866688866
                 * addr_id : 138397500
                 * receiver : 融七牛
                 * region : 浙江杭州市上城区
                 * address : 北京海淀测试地址
                 * mobile_phone : 159****2060
                 * fixed_phone :
                 * email_addr :
                 */

                private String login_name;
                private String addr_id;
                private String receiver;
                private String region;
                private String address;
                private String mobile_phone;
                private String fixed_phone;
                private String email_addr;
            }

            @NoArgsConstructor
            @Data
            public static class BankcardsBean {
                /**
                 * login_name : 18866688866
                 * card_id : cfe4bbcf685fb9cf507778072d029f65
                 * bank_name : citic
                 * tail_number : 1132
                 * card_type : 信用卡
                 * owner_name : *妍
                 * phone : 135****8281
                 */

                private String login_name;
                private String card_id;
                private String bank_name;
                private String tail_number;
                private String card_type;
                private String owner_name;
                private String phone;
            }

            @NoArgsConstructor
            @Data
            public static class OrderListBean {
                /**
                 * order_id : 18866688866
                 * receiver : 融七牛
                 * money : 65.0000
                 * buy_way : 在线支付
                 * buy_time : 1480312345
                 * order_status : 完成
                 * order_source : JD
                 * login_name : 18866688866
                 * receiver_addr : 北京海淀测试地址
                 * receiver_post :
                 * receiver_fix_phone :
                 * receiver_telephone : 135****8281
                 * receiver_email :
                 * product_names : 盒装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光;
                 * invoice_type : 普通发票
                 * invoice_header : 个人
                 * invoice_content : 明细
                 * products : [{"price":65,"product_id":"18866688866","name":"融装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光"}]
                 * url : https://is.rong360.com/image/hbase?key=
                 */

                private String order_id;
                private String receiver;
                private String money;
                private String buy_way;
                private String buy_time;
                private String order_status;
                private String order_source;
                private String login_name;
                private String receiver_addr;
                private String receiver_post;
                private String receiver_fix_phone;
                private String receiver_telephone;
                private String receiver_email;
                private String product_names;
                private String invoice_type;
                private String invoice_header;
                private String invoice_content;
                private String url;
                private List<ProductsBean> products;

                @NoArgsConstructor
                @Data
                public static class ProductsBean {
                    /**
                     * price : 65
                     * product_id : 18866688866
                     * name : 融装插页式相册620张5寸相册本6寸过塑7寸插袋大容量家庭影集宝宝成长相册簿 620款美好时光
                     */

                    private int price;
                    private String product_id;
                    private String name;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class InsureBean {
            /**
             * user : {"real_name":"**牛","id_card":"440184198810112345","sex":"男","birthday":"1988-10-16","work_start_day":"","acc_prop":"本地非农业户口(本地城镇)","acc_addr":"","degree":"","cellphone":"","phone":"","email":"社保登记","insure_code":"1049112345","insure_city":"广州社保","insure_status":"","insure_month_money":"","com_name":"","com_code":"","nation":"汉族","live_addr":"北京海淀测试地址","live_postcode":"510600","marital_status":"","worker_nation":"","start_insure_day":"","format_acc_prop":"非农","format_degree":"","format_insure_status":"","format_marital_status":"","format_worker_nation":""}
             * flow : [{"id_card":"440184198810112345","pay_date":"","start_date":"2017-07","end_date":"2017-11","base_rmb":"2075.00","com_rmb":"66.40","per_rmb":"13.28","balance_rmb":"","month_rmb":"79.68","com_name":"华润万家生活超市（广州）有限公司从化店","pay_type":"正常缴费","flow_type":"2"}]
             */

            private UserBeanX user;
            private List<FlowBean> flow;

            @NoArgsConstructor
            @Data
            public static class UserBeanX {
                /**
                 * real_name : **牛
                 * id_card : 440184198810112345
                 * sex : 男
                 * birthday : 1988-10-16
                 * work_start_day :
                 * acc_prop : 本地非农业户口(本地城镇)
                 * acc_addr :
                 * degree :
                 * cellphone :
                 * phone :
                 * email : 社保登记
                 * insure_code : 1049112345
                 * insure_city : 广州社保
                 * insure_status :
                 * insure_month_money :
                 * com_name :
                 * com_code :
                 * nation : 汉族
                 * live_addr : 北京海淀测试地址
                 * live_postcode : 510600
                 * marital_status :
                 * worker_nation :
                 * start_insure_day :
                 * format_acc_prop : 非农
                 * format_degree :
                 * format_insure_status :
                 * format_marital_status :
                 * format_worker_nation :
                 */

                private String real_name;
                private String id_card;
                private String sex;
                private String birthday;
                private String work_start_day;
                private String acc_prop;
                private String acc_addr;
                private String degree;
                private String cellphone;
                private String phone;
                private String email;
                private String insure_code;
                private String insure_city;
                private String insure_status;
                private String insure_month_money;
                private String com_name;
                private String com_code;
                private String nation;
                private String live_addr;
                private String live_postcode;
                private String marital_status;
                private String worker_nation;
                private String start_insure_day;
                private String format_acc_prop;
                private String format_degree;
                private String format_insure_status;
                private String format_marital_status;
                private String format_worker_nation;
            }

            @NoArgsConstructor
            @Data
            public static class FlowBean {
                /**
                 * id_card : 440184198810112345
                 * pay_date :
                 * start_date : 2017-07
                 * end_date : 2017-11
                 * base_rmb : 2075.00
                 * com_rmb : 66.40
                 * per_rmb : 13.28
                 * balance_rmb :
                 * month_rmb : 79.68
                 * com_name : 华润万家生活超市（广州）有限公司从化店
                 * pay_type : 正常缴费
                 * flow_type : 2
                 */

                private String id_card;
                private String pay_date;
                private String start_date;
                private String end_date;
                private String base_rmb;
                private String com_rmb;
                private String per_rmb;
                private String balance_rmb;
                private String month_rmb;
                private String com_name;
                private String pay_type;
                private String flow_type;
            }
        }

        @NoArgsConstructor
        @Data
        public static class TjyModelBean {
            /**
             * decision_score : 649
             */

            private int decision_score;
        }

        @NoArgsConstructor
        @Data
        public static class FundBean {
            /**
             * cid : 21
             * location : 西安公积金
             * cityName : 西安市
             * orderId : 05071a78a0725404a119de096511a15a
             * create_date : 2018-06-27 21:16:50
             * data : {"gjj_data":[{"gjj_brief":{"ID":"610103198605112345","name":"融浩","card":"","customer_id":"1489872","deposit_amount":"1600.00","fb_deposit_amount":"","balance":"28225.98","fb_balance":"","once_balance":"","status":"正常","record_date":"2018-05","company":"西安凯美置业有限公司","deposit_base":"16000.00","person_rate":"5.00","company_rate":"5.00","init_date":"2013-02-05","start_date":"2013-07","sex":"男","email":"","phone":"","marriage":"","address":"","birthday":"1986-05-14","company_id":"0019186","person_deposit_amount":"","company_deposit_amount":"","deposit_rate":""},"gjj_detail":[{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-06-20","op_type":"汇缴201805公积金","record_month":"2018-05","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-05-10","op_type":"汇缴201804公积金","record_month":"2018-04","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-04-02","op_type":"汇缴201803公积金","record_month":"2018-03","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-03-20","op_type":"汇缴201802公积金","record_month":"2018-02","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2017-01-16","op_type":"购买、建造、翻建、大修自住住房等","record_month":"2017-01","amount":"-29489.93","balance":"","remark":"","comments":"","deposit_type":"支取-购房贷款支取","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2016-01-08","op_type":"汇缴201601公积金","record_month":"2016-01","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-12-08","op_type":"汇缴201512公积金","record_month":"2015-12","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-11-16","op_type":"汇缴201511公积金","record_month":"2015-11","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-04-02","op_type":"租房","record_month":"2015-04","amount":"-4080.00","balance":"","remark":"","comments":"","deposit_type":"其他","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201503公积金","record_month":"2015-03","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201502公积金","record_month":"2015-02","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-01-26","op_type":"汇缴201501公积金","record_month":"2015-01","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-31","op_type":"汇缴201412公积金","record_month":"2014-12","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-30","op_type":"汇缴201411公积金","record_month":"2014-11","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201410公积金","record_month":"2014-10","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201409公积金","record_month":"2014-09","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-08-27","op_type":"汇缴201408公积金","record_month":"2014-08","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2013-07-12","op_type":"汇缴201307公积金","record_month":"2013-07","amount":"900.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1}],"gjj_account_analyzed_data":{"newest_account":1,"cont_last_times":59,"back_cont_last_times":-1,"cont_max_times":-1,"back_cont_max_times":-1,"sum_times":59,"back_sum_times":59}}],"loan_data":[{"loan_brief":[],"loan_detail":[]}],"general_analyzed_data":{"every_company_data":[],"last_6months_pay_off":"-1","last_6months_back_pay_off":"-1","last_24months_sum_times":"-1","last_24months_back_sum_times":"-1","last_24months_company_quantity":"-1","last_12months_has_extract":"-1","last_12months_average":"-1","last_24months_average":"-1","start_date":"2013-07-12","end_date":"2018-06-20","overdueClassify":[],"loanClassify":[],"blacklist":[]}}
             */

            private int cid;
            private String location;
            private String cityName;
            private String orderId;
            private String create_date;
            private DataBeanX data;

            @NoArgsConstructor
            @Data
            public static class DataBeanX {
                /**
                 * gjj_data : [{"gjj_brief":{"ID":"610103198605112345","name":"融浩","card":"","customer_id":"1489872","deposit_amount":"1600.00","fb_deposit_amount":"","balance":"28225.98","fb_balance":"","once_balance":"","status":"正常","record_date":"2018-05","company":"西安凯美置业有限公司","deposit_base":"16000.00","person_rate":"5.00","company_rate":"5.00","init_date":"2013-02-05","start_date":"2013-07","sex":"男","email":"","phone":"","marriage":"","address":"","birthday":"1986-05-14","company_id":"0019186","person_deposit_amount":"","company_deposit_amount":"","deposit_rate":""},"gjj_detail":[{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-06-20","op_type":"汇缴201805公积金","record_month":"2018-05","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-05-10","op_type":"汇缴201804公积金","record_month":"2018-04","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-04-02","op_type":"汇缴201803公积金","record_month":"2018-03","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-03-20","op_type":"汇缴201802公积金","record_month":"2018-02","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2017-01-16","op_type":"购买、建造、翻建、大修自住住房等","record_month":"2017-01","amount":"-29489.93","balance":"","remark":"","comments":"","deposit_type":"支取-购房贷款支取","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2016-01-08","op_type":"汇缴201601公积金","record_month":"2016-01","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-12-08","op_type":"汇缴201512公积金","record_month":"2015-12","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-11-16","op_type":"汇缴201511公积金","record_month":"2015-11","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-04-02","op_type":"租房","record_month":"2015-04","amount":"-4080.00","balance":"","remark":"","comments":"","deposit_type":"其他","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201503公积金","record_month":"2015-03","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201502公积金","record_month":"2015-02","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-01-26","op_type":"汇缴201501公积金","record_month":"2015-01","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-31","op_type":"汇缴201412公积金","record_month":"2014-12","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-30","op_type":"汇缴201411公积金","record_month":"2014-11","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201410公积金","record_month":"2014-10","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201409公积金","record_month":"2014-09","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-08-27","op_type":"汇缴201408公积金","record_month":"2014-08","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2013-07-12","op_type":"汇缴201307公积金","record_month":"2013-07","amount":"900.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1}],"gjj_account_analyzed_data":{"newest_account":1,"cont_last_times":59,"back_cont_last_times":-1,"cont_max_times":-1,"back_cont_max_times":-1,"sum_times":59,"back_sum_times":59}}]
                 * loan_data : [{"loan_brief":[],"loan_detail":[]}]
                 * general_analyzed_data : {"every_company_data":[],"last_6months_pay_off":"-1","last_6months_back_pay_off":"-1","last_24months_sum_times":"-1","last_24months_back_sum_times":"-1","last_24months_company_quantity":"-1","last_12months_has_extract":"-1","last_12months_average":"-1","last_24months_average":"-1","start_date":"2013-07-12","end_date":"2018-06-20","overdueClassify":[],"loanClassify":[],"blacklist":[]}
                 */

                private GeneralAnalyzedDataBean general_analyzed_data;
                private List<GjjDataBean> gjj_data;
                private List<LoanDataBean> loan_data;

                @NoArgsConstructor
                @Data
                public static class GeneralAnalyzedDataBean {
                    /**
                     * every_company_data : []
                     * last_6months_pay_off : -1
                     * last_6months_back_pay_off : -1
                     * last_24months_sum_times : -1
                     * last_24months_back_sum_times : -1
                     * last_24months_company_quantity : -1
                     * last_12months_has_extract : -1
                     * last_12months_average : -1
                     * last_24months_average : -1
                     * start_date : 2013-07-12
                     * end_date : 2018-06-20
                     * overdueClassify : []
                     * loanClassify : []
                     * blacklist : []
                     */

                    private String last_6months_pay_off;
                    private String last_6months_back_pay_off;
                    private String last_24months_sum_times;
                    private String last_24months_back_sum_times;
                    private String last_24months_company_quantity;
                    private String last_12months_has_extract;
                    private String last_12months_average;
                    private String last_24months_average;
                    private String start_date;
                    private String end_date;
                    private List<?> every_company_data;
                    private List<?> overdueClassify;
                    private List<?> loanClassify;
                    private List<?> blacklist;
                }

                @NoArgsConstructor
                @Data
                public static class GjjDataBean {
                    /**
                     * gjj_brief : {"ID":"610103198605112345","name":"融浩","card":"","customer_id":"1489872","deposit_amount":"1600.00","fb_deposit_amount":"","balance":"28225.98","fb_balance":"","once_balance":"","status":"正常","record_date":"2018-05","company":"西安凯美置业有限公司","deposit_base":"16000.00","person_rate":"5.00","company_rate":"5.00","init_date":"2013-02-05","start_date":"2013-07","sex":"男","email":"","phone":"","marriage":"","address":"","birthday":"1986-05-14","company_id":"0019186","person_deposit_amount":"","company_deposit_amount":"","deposit_rate":""}
                     * gjj_detail : [{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-06-20","op_type":"汇缴201805公积金","record_month":"2018-05","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-05-10","op_type":"汇缴201804公积金","record_month":"2018-04","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-04-02","op_type":"汇缴201803公积金","record_month":"2018-03","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2018-03-20","op_type":"汇缴201802公积金","record_month":"2018-02","amount":"1600.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2017-01-16","op_type":"购买、建造、翻建、大修自住住房等","record_month":"2017-01","amount":"-29489.93","balance":"","remark":"","comments":"","deposit_type":"支取-购房贷款支取","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2016-01-08","op_type":"汇缴201601公积金","record_month":"2016-01","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-12-08","op_type":"汇缴201512公积金","record_month":"2015-12","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-11-16","op_type":"汇缴201511公积金","record_month":"2015-11","amount":"1326.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-04-02","op_type":"租房","record_month":"2015-04","amount":"-4080.00","balance":"","remark":"","comments":"","deposit_type":"其他","cont_flag":0,"back_cont_flag":0},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201503公积金","record_month":"2015-03","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-03-20","op_type":"汇缴201502公积金","record_month":"2015-02","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2015-01-26","op_type":"汇缴201501公积金","record_month":"2015-01","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-31","op_type":"汇缴201412公积金","record_month":"2014-12","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-12-30","op_type":"汇缴201411公积金","record_month":"2014-11","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201410公积金","record_month":"2014-10","amount":"1020.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-10-30","op_type":"汇缴201409公积金","record_month":"2014-09","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2014-08-27","op_type":"汇缴201408公积金","record_month":"2014-08","amount":"799.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1},{"id":"05071a78a0725404a119de096511a15a","gjj_type":"0","company":"","order_id":"","record_date":"2013-07-12","op_type":"汇缴201307公积金","record_month":"2013-07","amount":"900.00","balance":"","remark":"","comments":"","deposit_type":"正常汇缴","cont_flag":1,"back_cont_flag":1}]
                     * gjj_account_analyzed_data : {"newest_account":1,"cont_last_times":59,"back_cont_last_times":-1,"cont_max_times":-1,"back_cont_max_times":-1,"sum_times":59,"back_sum_times":59}
                     */

                    private GjjBriefBean gjj_brief;
                    private GjjAccountAnalyzedDataBean gjj_account_analyzed_data;
                    private List<GjjDetailBean> gjj_detail;

                    @NoArgsConstructor
                    @Data
                    public static class GjjBriefBean {
                        /**
                         * ID : 610103198605112345
                         * name : 融浩
                         * card :
                         * customer_id : 1489872
                         * deposit_amount : 1600.00
                         * fb_deposit_amount :
                         * balance : 28225.98
                         * fb_balance :
                         * once_balance :
                         * status : 正常
                         * record_date : 2018-05
                         * company : 西安凯美置业有限公司
                         * deposit_base : 16000.00
                         * person_rate : 5.00
                         * company_rate : 5.00
                         * init_date : 2013-02-05
                         * start_date : 2013-07
                         * sex : 男
                         * email :
                         * phone :
                         * marriage :
                         * address :
                         * birthday : 1986-05-14
                         * company_id : 0019186
                         * person_deposit_amount :
                         * company_deposit_amount :
                         * deposit_rate :
                         */

                        private String ID;
                        private String name;
                        private String card;
                        private String customer_id;
                        private String deposit_amount;
                        private String fb_deposit_amount;
                        private String balance;
                        private String fb_balance;
                        private String once_balance;
                        private String status;
                        private String record_date;
                        private String company;
                        private String deposit_base;
                        private String person_rate;
                        private String company_rate;
                        private String init_date;
                        private String start_date;
                        private String sex;
                        private String email;
                        private String phone;
                        private String marriage;
                        private String address;
                        private String birthday;
                        private String company_id;
                        private String person_deposit_amount;
                        private String company_deposit_amount;
                        private String deposit_rate;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class GjjAccountAnalyzedDataBean {
                        /**
                         * newest_account : 1
                         * cont_last_times : 59
                         * back_cont_last_times : -1
                         * cont_max_times : -1
                         * back_cont_max_times : -1
                         * sum_times : 59
                         * back_sum_times : 59
                         */

                        private int newest_account;
                        private int cont_last_times;
                        private int back_cont_last_times;
                        private int cont_max_times;
                        private int back_cont_max_times;
                        private int sum_times;
                        private int back_sum_times;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class GjjDetailBean {
                        /**
                         * id : 05071a78a0725404a119de096511a15a
                         * gjj_type : 0
                         * company :
                         * order_id :
                         * record_date : 2018-06-20
                         * op_type : 汇缴201805公积金
                         * record_month : 2018-05
                         * amount : 1600.00
                         * balance :
                         * remark :
                         * comments :
                         * deposit_type : 正常汇缴
                         * cont_flag : 1
                         * back_cont_flag : 1
                         */

                        private String id;
                        private String gjj_type;
                        private String company;
                        private String order_id;
                        private String record_date;
                        private String op_type;
                        private String record_month;
                        private String amount;
                        private String balance;
                        private String remark;
                        private String comments;
                        private String deposit_type;
                        private int cont_flag;
                        private int back_cont_flag;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class LoanDataBean {
                    private List<?> loan_brief;
                    private List<?> loan_detail;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class ContactsBean {
            /**
             * id : 25170825
             * uid : 25856023
             * device_num : 69DC83FF-C53A-482B-BB99-F22
             * device_info : iPhone 7
             * platform : ios
             * installed_apps :
             * installed_apps_version : 1
             * app_location_json :
             * update_time : 2017-07-18 16:02:31
             * create_time : 2017-07-18 16:02:31
             * delete_time : 2038-01-01 00:00:00
             * phone_list : [{"uid":"25856023","phone_dirty":"18866688866","phone":"18866688866","name":"融雯琼","createtime":"1454612345"},{"uid":"25856023","phone_dirty":"139-681234773","phone":"18866688866","name":"融剑","createtime":"1454612345"},{"uid":"25856023","phone_dirty":"135-881234654","phone":"18866688866","name":"融文","createtime":"1454612345"}]
             * call_log : []
             * app_location : {"lat":"30.222225512345","lon":"120.17200112345","address":"北京海淀测试地址"}
             */

            private String id;
            private String uid;
            private String device_num;
            private String device_info;
            private String platform;
            private String installed_apps;
            private int installed_apps_version;
            private String app_location_json;
            private String update_time;
            private String create_time;
            private String delete_time;
            private AppLocationBean app_location;
            private List<PhoneListBean> phone_list;
            private List<?> call_log;

            @NoArgsConstructor
            @Data
            public static class AppLocationBean {
                /**
                 * lat : 30.222225512345
                 * lon : 120.17200112345
                 * address : 北京海淀测试地址
                 */

                private String lat;
                private String lon;
                private String address;
            }

            @NoArgsConstructor
            @Data
            public static class PhoneListBean {
                /**
                 * uid : 25856023
                 * phone_dirty : 18866688866
                 * phone : 18866688866
                 * name : 融雯琼
                 * createtime : 1454612345
                 */

                private String uid;
                private String phone_dirty;
                private String phone;
                private String name;
                private String createtime;
            }
        }

        @NoArgsConstructor
        @Data
        public static class IcreditBean {
            private List<CardBean> card;
            private List<BillFlowBean> bill_flow;

            @NoArgsConstructor
            @Data
            public static class CardBean {
                /**
                 * bank : 8882
                 * name : 融平波
                 * payment_due_date : 2017-12-24
                 * credit_card : 6259656210812345
                 * type : credit
                 * login_account : 500237199307112345
                 * card_no : 6259656210812345
                 */

                private int bank;
                private String name;
                private String payment_due_date;
                private String credit_card;
                private String type;
                private String login_account;
                private String card_no;
            }

            @NoArgsConstructor
            @Data
            public static class BillFlowBean {
                /**
                 * bill : {"new_balance":131770,"min_payment":126742,"statement_start_date":"2017-11-05","month":"2017-12","statement_end_date":"2017-12-04","payment_cur_date":"2017-12-04","payment_due_date":"2017-12-24","credit_limit":1000000,"cash_advance_limit":500000,"last_balance":140087,"last_payment":-386000,"new_charges":0,"interest":0,"cur_adjust_amount":0,"last_points":0,"repayment":0,"currency":""}
                 * flow : [{"trans_date":"2017-09-28","post_date":"2017-09-28","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-186000,"rmb_org_amount":-186000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"手机银行现金转出8338","rmb_amount":50000,"rmb_org_amount":50000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"上海跨行代付上海富友支付服务有限","rmb_amount":-200000,"rmb_org_amount":-200000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"现金分期*金额","rmb_amount":130000,"rmb_org_amount":130000,"currency":"CNY","cardNo_last4_digits":"0015"},{"trans_date":"2017-09-15","post_date":"2017-09-15","description":"信用卡现金转出手续费","rmb_amount":500,"rmb_org_amount":500,"currency":"CNY","cardNo_last4_digits":"0015"}]
                 */

                private BillBeanX bill;
                private List<FlowBeanX> flow;

                @NoArgsConstructor
                @Data
                public static class BillBeanX {
                    /**
                     * new_balance : 131770
                     * min_payment : 126742
                     * statement_start_date : 2017-11-05
                     * month : 2017-12
                     * statement_end_date : 2017-12-04
                     * payment_cur_date : 2017-12-04
                     * payment_due_date : 2017-12-24
                     * credit_limit : 1000000
                     * cash_advance_limit : 500000
                     * last_balance : 140087
                     * last_payment : -386000
                     * new_charges : 0
                     * interest : 0
                     * cur_adjust_amount : 0
                     * last_points : 0
                     * repayment : 0
                     * currency :
                     */

                    private int new_balance;
                    private int min_payment;
                    private String statement_start_date;
                    private String month;
                    private String statement_end_date;
                    private String payment_cur_date;
                    private String payment_due_date;
                    private int credit_limit;
                    private int cash_advance_limit;
                    private int last_balance;
                    private int last_payment;
                    private int new_charges;
                    private int interest;
                    private int cur_adjust_amount;
                    private int last_points;
                    private int repayment;
                    private String currency;
                }

                @NoArgsConstructor
                @Data
                public static class FlowBeanX {
                    /**
                     * trans_date : 2017-09-28
                     * post_date : 2017-09-28
                     * description : 上海跨行代付上海富友支付服务有限
                     * rmb_amount : -186000
                     * rmb_org_amount : -186000
                     * currency : CNY
                     * cardNo_last4_digits : 0015
                     */

                    private String trans_date;
                    private String post_date;
                    private String description;
                    private int rmb_amount;
                    private int rmb_org_amount;
                    private String currency;
                    private String cardNo_last4_digits;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class AlipayBean {
            /**
             * alipay_info : [{"login_name":"18866688866","real_name":"**牛","id_card":"5****************2","email":"未添加邮箱账户名","phone":"159******30","taobao_name":"南宫靖雨悠","identify_time":"","register_date":"1401206412345","is_real_name":"已认证","is_protected":"账户已受全面保障","is_phone":"已绑定","secret_level":"","balance":"300.00","income":"3.17","is_idcard":"是","amount":"0.00","total_amount":"8000.00","available_amount":"0.00","need_to_pay_next_month":"0.00"}]
             * alipay_list : [{"trade_no":"2017012500003001150024812345","pay_time":"1485321112345","trade_type":"1月-固话/宽带费-*林清-我家","trade_no_type":"1月-固话/宽带费-*林清-我家","receiver_name":"重庆电信公司","amount":"-94","status":"交易成功","source":"","trade_classification":"缴费","alipay_name":"18866688866"},{"trade_no":"2017120921001004155260712345","pay_time":"1512815812345","trade_type":"滴滴快车-周瑜师傅","trade_no_type":"滴滴快车-周瑜师傅","receiver_name":"","amount":"-5","status":"交易成功","source":"","trade_classification":"转账","alipay_name":"18866688866"}]
             * bankcard : [{"card_last_num":"9687","open_status":"已开通","apply_time":"0","bank_name":"交通银行","card_type":"信用卡","mobile":"159****5930","active_date":"2017-03-09","show_user_name":"融七牛","alipay_name":"18866688866"},{"card_last_num":"6314","open_status":"已开通","apply_time":"0","bank_name":"浦发银行","card_type":"信用卡","mobile":"159****5930","active_date":"2016-12-11","show_user_name":"融七牛","alipay_name":"18866688866"}]
             * alipay_charge_account : [{"account_id":"a20170113000700120000150701012345","charge_item":"水费","area":"重庆","charge_unit":"长寿自来水","charge_account":"*才路公租房1幢3-4","charge_number":"1234512345","charge_reminder":"未设置","login_name":"18866688866"},{"account_id":"a20170114000700120000150701012345","charge_item":"电费","area":"重庆","charge_unit":"国网重庆市电力公司","charge_account":"重庆市*********","charge_number":"1577812345","charge_reminder":"未设置","login_name":"18866688866"}]
             * crawl_time : 2017-12-18 00:07:45
             */

            private String crawl_time;
            private List<AlipayInfoBean> alipay_info;
            private List<AlipayListBean> alipay_list;
            private List<BankcardBean> bankcard;
            private List<AlipayChargeAccountBean> alipay_charge_account;

            @NoArgsConstructor
            @Data
            public static class AlipayInfoBean {
                /**
                 * login_name : 18866688866
                 * real_name : **牛
                 * id_card : 5****************2
                 * email : 未添加邮箱账户名
                 * phone : 159******30
                 * taobao_name : 南宫靖雨悠
                 * identify_time :
                 * register_date : 1401206412345
                 * is_real_name : 已认证
                 * is_protected : 账户已受全面保障
                 * is_phone : 已绑定
                 * secret_level :
                 * balance : 300.00
                 * income : 3.17
                 * is_idcard : 是
                 * amount : 0.00
                 * total_amount : 8000.00
                 * available_amount : 0.00
                 * need_to_pay_next_month : 0.00
                 */

                private String login_name;
                private String real_name;
                private String id_card;
                private String email;
                private String phone;
                private String taobao_name;
                private String identify_time;
                private String register_date;
                private String is_real_name;
                private String is_protected;
                private String is_phone;
                private String secret_level;
                private String balance;
                private String income;
                private String is_idcard;
                private String amount;
                private String total_amount;
                private String available_amount;
                private String need_to_pay_next_month;
            }

            @NoArgsConstructor
            @Data
            public static class AlipayListBean {
                /**
                 * trade_no : 2017012500003001150024812345
                 * pay_time : 1485321112345
                 * trade_type : 1月-固话/宽带费-*林清-我家
                 * trade_no_type : 1月-固话/宽带费-*林清-我家
                 * receiver_name : 重庆电信公司
                 * amount : -94
                 * status : 交易成功
                 * source :
                 * trade_classification : 缴费
                 * alipay_name : 18866688866
                 */

                private String trade_no;
                private String pay_time;
                private String trade_type;
                private String trade_no_type;
                private String receiver_name;
                private String amount;
                private String status;
                private String source;
                private String trade_classification;
                private String alipay_name;
            }

            @NoArgsConstructor
            @Data
            public static class BankcardBean {
                /**
                 * card_last_num : 9687
                 * open_status : 已开通
                 * apply_time : 0
                 * bank_name : 交通银行
                 * card_type : 信用卡
                 * mobile : 159****5930
                 * active_date : 2017-03-09
                 * show_user_name : 融七牛
                 * alipay_name : 18866688866
                 */

                private String card_last_num;
                private String open_status;
                private String apply_time;
                private String bank_name;
                private String card_type;
                private String mobile;
                private String active_date;
                private String show_user_name;
                private String alipay_name;
            }

            @NoArgsConstructor
            @Data
            public static class AlipayChargeAccountBean {
                /**
                 * account_id : a20170113000700120000150701012345
                 * charge_item : 水费
                 * area : 重庆
                 * charge_unit : 长寿自来水
                 * charge_account : *才路公租房1幢3-4
                 * charge_number : 1234512345
                 * charge_reminder : 未设置
                 * login_name : 18866688866
                 */

                private String account_id;
                private String charge_item;
                private String area;
                private String charge_unit;
                private String charge_account;
                private String charge_number;
                private String charge_reminder;
                private String login_name;
            }
        }

        @NoArgsConstructor
        @Data
        public static class EcBean {
            /**
             * mail : chen123123123testrong@qq.com
             * bank_name : 民生
             * card_no : 9888
             * name : 融七牛
             * sex : 2
             * last_balance : 159063
             * last_payment : 85600
             * statement_start_date : 1476312345
             * statement_end_date : 1479012345
             * payment_cur_date : 1479012345
             * payment_due_date : 1480712345
             * credit_limit : 0
             * total_points : 11548
             * new_balance : 200979
             * min_payment : 65202
             * new_charges : 125358
             * adjustment : 0
             * interest : 2158
             * last_points : 10774
             * earned_points : 774
             * sender_email : master12313@creditcard.cmbc.com.cn
             * adjusted_points : 0
             * available_balance_usd : 0
             * available_balance : 0
             * cash_advance_limit_usd : 0
             * credit_limit_usd : 0
             * cash_advance_limit : 0
             * min_payment_usd : 0
             * new_balance_usd : 0
             * redeemed_points : 0
             * rewarded_points : 0
             * time : 2017-02-21 14:11:29
             * create_time : 2017-02-21 14:11:29
             * trans_detail : [{"trans_date":"1479012345","post_date":"1479012345","description":"利息交易","rmb_amount":"2158","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 手续费第3期共12期","rmb_amount":"425","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 每月摊消第3期共12期","rmb_amount":"5290","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 手续费第3期共24期","rmb_amount":"6076","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1479012345","post_date":"1479012345","description":"灵活分期 每月摊消第3期共24期","rmb_amount":"36167","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-60600","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-20000","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"杭州欣美药房有限公司","rmb_amount":"77400","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"},{"trans_date":"1476812345","post_date":"1476812345","description":"支付宝转入","rmb_amount":"-5000","rmb_org_amount":"0","currency":"1","trans_area":"","create_time":"2017-02-21 14:11:29","update_time":"2017-02-21 14:11:29"}]
             * is_simple : 0
             * url : https://is.rong360.com/image/f?token=V8yTJB_tn33ypP3nMAuaJT2pnf9-8r6gbarmJWWmi9YUv7h7CRwuJE0KwVIiVRNh49hVY1YqXF5wwCZwKQqIU32vQqk-qdVcIhnZiTLFGh1gX3X6odh5q8_608Rp96ym3kWFZQhyWAS1hNZfM6DraQ,,
             */

            private String mail;
            private String bank_name;
            private String card_no;
            private String name;
            private String sex;
            private String last_balance;
            private String last_payment;
            private String statement_start_date;
            private String statement_end_date;
            private String payment_cur_date;
            private String payment_due_date;
            private String credit_limit;
            private String total_points;
            private String new_balance;
            private String min_payment;
            private String new_charges;
            private String adjustment;
            private String interest;
            private String last_points;
            private String earned_points;
            private String sender_email;
            private String adjusted_points;
            private String available_balance_usd;
            private String available_balance;
            private String cash_advance_limit_usd;
            private String credit_limit_usd;
            private String cash_advance_limit;
            private String min_payment_usd;
            private String new_balance_usd;
            private String redeemed_points;
            private String rewarded_points;
            private String time;
            private String create_time;
            private int is_simple;
            private String url;
            private List<TransDetailBean> trans_detail;

            @NoArgsConstructor
            @Data
            public static class TransDetailBean {
                /**
                 * trans_date : 1479012345
                 * post_date : 1479012345
                 * description : 利息交易
                 * rmb_amount : 2158
                 * rmb_org_amount : 0
                 * currency : 1
                 * trans_area :
                 * create_time : 2017-02-21 14:11:29
                 * update_time : 2017-02-21 14:11:29
                 */

                private String trans_date;
                private String post_date;
                private String description;
                private String rmb_amount;
                private String rmb_org_amount;
                private String currency;
                private String trans_area;
                private String create_time;
                private String update_time;
            }
        }

        @NoArgsConstructor
        @Data
        public static class TaobaoBean {
            /**
             * tb_user : {"login_name":"15012345678","vip_level":"","buyer_credit":64,"rate_summary":"100.0","score":625,"vip_count":0,"star_level":0,"sum_amount":"0.00","count_orders":0,"count_days_bought":0,"count_days_from_regi":0,"account_name":"许伟伟先生","email":"","binding_phone":"15012345678","authentication":"已完成","binding_weibo_account":"","binding_weibo_nickname":"","name":"许伟伟","division_code":"","address":"","tianmao_account":"许伟伟先生","tianmao_grade":815,"tianmao_vip_level":"","tianmao_credit_level":""}
             * tb_orders : [{"order_id":"165227275474186756","status":"成功","actual_fee":"19.00","phone_order":1,"transaction_time":"2018-06-2023:03:26","payment_time":"2018-06-2023:03:29","confirmation_time":"2018-06-2023:03:37","receiver_name":"","receiver_telephone":"","receiver_address":"","products":[{"product_name":"爱奇艺VIP黄金会员一个月卡爱奇艺会员1个月填手机号","product_price":"19.00","product_quantity":1}]},{"order_id":"162855483476186756","status":"成功","actual_fee":"27.65","phone_order":1,"transaction_time":"2018-06-1709:32:09","payment_time":"2018-06-1709:32:12","confirmation_time":"2018-06-1709:32:41","receiver_name":"","receiver_telephone":"","receiver_address":"","products":[{"product_name":"腾讯地下城与勇士30元点券/DNF点卡/dnf点卷/DNF3000点券★自动充","product_price":"27.65","product_quantity":1}]}]
             * tb_deliver_addrs : [{"tb_user_id":3836225,"receiver_name":"崔文文","area":"北京市","address":"北京市海淀区丹棱街","zip_code":"100000","phone":"13012345678","is_default_address":""},{"tb_user_id":3836225,"receiver_name":"许姐姐","area":"北京市","address":"北京市海淀区丹棱街","zip_code":"100000","phone":"13012345678","is_default_address":""}]
             * tb_zhifubao_binding : {"tb_user_id":3836225,"balance":"2044.77","total_profit":"22.51","total_quotient":"3.88","huabei_credit_amount":"370.15","huabei_total_credit_amount":"4500.00","zhifubao_account":"150******40","binding_phone":"15012345678","account_type":"个人账户","verified_name":"许伟伟","verified_id_card":"41272***********53"}
             */

            private TbUserBean tb_user;
            private TbZhifubaoBindingBean tb_zhifubao_binding;
            private List<TbOrdersBean> tb_orders;
            private List<TbDeliverAddrsBean> tb_deliver_addrs;

            @NoArgsConstructor
            @Data
            public static class TbUserBean {
                /**
                 * login_name : 15012345678
                 * vip_level :
                 * buyer_credit : 64
                 * rate_summary : 100.0
                 * score : 625
                 * vip_count : 0
                 * star_level : 0
                 * sum_amount : 0.00
                 * count_orders : 0
                 * count_days_bought : 0
                 * count_days_from_regi : 0
                 * account_name : 许伟伟先生
                 * email :
                 * binding_phone : 15012345678
                 * authentication : 已完成
                 * binding_weibo_account :
                 * binding_weibo_nickname :
                 * name : 许伟伟
                 * division_code :
                 * address :
                 * tianmao_account : 许伟伟先生
                 * tianmao_grade : 815
                 * tianmao_vip_level :
                 * tianmao_credit_level :
                 */

                private String login_name;
                private String vip_level;
                private int buyer_credit;
                private String rate_summary;
                private int score;
                private int vip_count;
                private int star_level;
                private String sum_amount;
                private int count_orders;
                private int count_days_bought;
                private int count_days_from_regi;
                private String account_name;
                private String email;
                private String binding_phone;
                private String authentication;
                private String binding_weibo_account;
                private String binding_weibo_nickname;
                private String name;
                private String division_code;
                private String address;
                private String tianmao_account;
                private int tianmao_grade;
                private String tianmao_vip_level;
                private String tianmao_credit_level;
            }

            @NoArgsConstructor
            @Data
            public static class TbZhifubaoBindingBean {
                /**
                 * tb_user_id : 3836225
                 * balance : 2044.77
                 * total_profit : 22.51
                 * total_quotient : 3.88
                 * huabei_credit_amount : 370.15
                 * huabei_total_credit_amount : 4500.00
                 * zhifubao_account : 150******40
                 * binding_phone : 15012345678
                 * account_type : 个人账户
                 * verified_name : 许伟伟
                 * verified_id_card : 41272***********53
                 */

                private int tb_user_id;
                private String balance;
                private String total_profit;
                private String total_quotient;
                private String huabei_credit_amount;
                private String huabei_total_credit_amount;
                private String zhifubao_account;
                private String binding_phone;
                private String account_type;
                private String verified_name;
                private String verified_id_card;
            }

            @NoArgsConstructor
            @Data
            public static class TbOrdersBean {
                /**
                 * order_id : 165227275474186756
                 * status : 成功
                 * actual_fee : 19.00
                 * phone_order : 1
                 * transaction_time : 2018-06-2023:03:26
                 * payment_time : 2018-06-2023:03:29
                 * confirmation_time : 2018-06-2023:03:37
                 * receiver_name :
                 * receiver_telephone :
                 * receiver_address :
                 * products : [{"product_name":"爱奇艺VIP黄金会员一个月卡爱奇艺会员1个月填手机号","product_price":"19.00","product_quantity":1}]
                 */

                private String order_id;
                private String status;
                private String actual_fee;
                private int phone_order;
                private String transaction_time;
                private String payment_time;
                private String confirmation_time;
                private String receiver_name;
                private String receiver_telephone;
                private String receiver_address;
                private List<ProductsBeanX> products;

                @NoArgsConstructor
                @Data
                public static class ProductsBeanX {
                    /**
                     * product_name : 爱奇艺VIP黄金会员一个月卡爱奇艺会员1个月填手机号
                     * product_price : 19.00
                     * product_quantity : 1
                     */

                    private String product_name;
                    private String product_price;
                    private int product_quantity;
                }
            }

            @NoArgsConstructor
            @Data
            public static class TbDeliverAddrsBean {
                /**
                 * tb_user_id : 3836225
                 * receiver_name : 崔文文
                 * area : 北京市
                 * address : 北京市海淀区丹棱街
                 * zip_code : 100000
                 * phone : 13012345678
                 * is_default_address :
                 */

                private int tb_user_id;
                private String receiver_name;
                private String area;
                private String address;
                private String zip_code;
                private String phone;
                private String is_default_address;
            }
        }
    }
}
