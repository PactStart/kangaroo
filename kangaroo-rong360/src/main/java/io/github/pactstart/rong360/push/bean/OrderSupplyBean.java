package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class OrderSupplyBean {


    /**
     * ID_Positive : ["token://FQcsySFrZez1uF29baFCsr1xRYeWqyxhFH0vOjSnFOdhavnGmLy1FzPUmf_AO5FYDzA76HMo51Bpsl_g-lYR2OkedGDlBxBeDsYlB4G2oDzw6gaIdOvi-7dX5iT9gDhb"]
     * ID_Negative : ["token://FQcsySFrZez1uF29baFCsr1xRYeWqyxhFH0vOjSnFOdhavnGmLy1FzPUmf_AO5FYDzA76HMo51Bpsl_g-lYR2OkedGDlBxBeDsYlB4G2oDzw6gaIdOvi-7dX5iT9gDhb"]
     * photo_assay : ["token://FQcsySFrZez1uF29baFCsr1xRYeWqyxhFH0vOjSnFOdhavnGmLy1FzPUmf_AO5FYDzA76HMo51Bpsl_g-lYR2OkedGDlBxBeDsYlB4G2oDzw6gaIdOvi-7dX5iT9gDhb"]
     * addr_detail : 北京市 市辖区 海淀区 东四十条作坊街1号
     * family_phone_number : 15313532667
     * company_name : 融360
     * company_number : 010-45678123-23
     * company_addr_detail : 北京市 市辖区 海淀区 互联网金融中心21层
     * emergency_contact_personA_relationship : 2
     * emergency_contact_personA_name : 金杜
     * emergency_contact_personA_phone : 18899966655
     * emergency_contact_personB_relationship : 3
     * emergency_contact_personB_name : 张守恒
     * emergency_contact_personB_phone : 15530000000
     * contacts : {"id":"5657551","uid":"2988918","device_num":"ac838asdadc5f4cd79f4e21d7a24","device_info":"OPPO R9","platform":"android","installed_apps":"","installed_apps_version":"0","app_location_json":"","update_time":"2016-11-10 17:25:33","create_time":"2016-11-10 17:25:33","delete_time":"2038-01-01 00:00:00","app_location":{"lat":"26.458051","lon":"106.521519","address":"北京市市辖区海淀区东四十条作坊街1号"},"phone_list":[{"uid":"2988918","phone":"15819999999","name":"融小蓝","createtime":""},{"uid":"2988918","phone":"15899992929","name":"融大黑","createtime":""}],"call_log":[{"uid":"2988918","type":"2","date":"1512023845030","duration":"71","phone":"15255555555"},{"uid":"2988918","type":"1","date":"1512023845030","duration":"88","phone":"15588888888"}]}
     * order_no : 247513671028002
     */

    private String addr_detail;
    private String family_phone_number;
    private String company_name;
    private String company_number;
    private String company_addr_detail;
    private String emergency_contact_personA_relationship;
    private String emergency_contact_personA_name;
    private String emergency_contact_personA_phone;
    private String emergency_contact_personB_relationship;
    private String emergency_contact_personB_name;
    private String emergency_contact_personB_phone;
    private ContactsBean contacts;
    private String order_no;
    private String device_info_all;
    private List<String> ID_Positive;
    private List<String> ID_Negative;
    private List<String> photo_assay;

    @NoArgsConstructor
    @Data
    public static class ContactsBean {
        /**
         * id : 5657551
         * uid : 2988918
         * device_num : ac838asdadc5f4cd79f4e21d7a24
         * device_info : OPPO R9
         * platform : android
         * installed_apps :
         * installed_apps_version : 0
         * app_location_json :
         * update_time : 2016-11-10 17:25:33
         * create_time : 2016-11-10 17:25:33
         * delete_time : 2038-01-01 00:00:00
         * app_location : {"lat":"26.458051","lon":"106.521519","address":"北京市市辖区海淀区东四十条作坊街1号"}
         * phone_list : [{"uid":"2988918","phone":"15819999999","name":"融小蓝","createtime":""},{"uid":"2988918","phone":"15899992929","name":"融大黑","createtime":""}]
         * call_log : [{"uid":"2988918","type":"2","date":"1512023845030","duration":"71","phone":"15255555555"},{"uid":"2988918","type":"1","date":"1512023845030","duration":"88","phone":"15588888888"}]
         */

        private String id;
        private String uid;
        private String device_num;
        private String device_info;
        private String platform;
        private String installed_apps;
        private String installed_apps_version;
        private String app_location_json;
        private String update_time;
        private String create_time;
        private String delete_time;
        private AppLocationBean app_location;
        private List<PhoneListBean> phone_list;
        private List<CallLogBean> call_log;

        @NoArgsConstructor
        @Data
        public static class AppLocationBean {
            /**
             * lat : 26.458051
             * lon : 106.521519
             * address : 北京市市辖区海淀区东四十条作坊街1号
             */

            private String lat;
            private String lon;
            private String address;
        }

        @NoArgsConstructor
        @Data
        public static class PhoneListBean {
            /**
             * uid : 2988918
             * phone : 15819999999
             * name : 融小蓝
             * createtime :
             */

            private String uid;
            private String phone;
            private String name;
            private String createtime;
        }

        @NoArgsConstructor
        @Data
        public static class CallLogBean {
            /**
             * uid : 2988918
             * type : 2
             * date : 1512023845030
             * duration : 71
             * phone : 15255555555
             */

            private String uid;
            private String type;
            private String date;
            private String duration;
            private String phone;
        }
    }
}
