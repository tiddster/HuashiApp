package com.muxistudio.appcommon.data;

import java.util.List;

public class CardAccount {

    /**
     * code : 0
     * message : OK
     * data : {"count":100,"list":[{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/中式套餐","transMoney":6.5,"dealDate":"2020-01-17 13:36:09","outMoney":26.96},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":8,"dealDate":"2020-01-16 13:15:52","outMoney":33.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":6,"dealDate":"2020-01-15 18:15:55","outMoney":41.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":8,"dealDate":"2020-01-15 12:51:14","outMoney":47.46},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":20,"dealDate":"2020-01-14 13:25:45","outMoney":55.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/港台风","transMoney":7,"dealDate":"2020-01-14 13:24:48","outMoney":35.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":12,"dealDate":"2020-01-13 12:57:00","outMoney":42.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":3,"dealDate":"2020-01-12 12:21:55","outMoney":54.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-12 12:13:56","outMoney":57.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.4,"dealDate":"2020-01-12 08:43:32","outMoney":66.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-12 08:43:00","outMoney":68.86},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/港台风","transMoney":8,"dealDate":"2020-01-11 12:46:39","outMoney":70.86},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.4,"dealDate":"2020-01-11 08:47:46","outMoney":78.86},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2020-01-11 08:46:49","outMoney":81.26},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":80,"dealDate":"2020-01-10 16:46:41","outMoney":83.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-10 16:20:04","outMoney":3.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-10 16:19:16","outMoney":6.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-10 16:18:18","outMoney":9.26},{"dealName":"消费","orgName":"华中师范大学/校内经营商户/九丘文化传媒公司倍阅华师店","transMoney":9,"dealDate":"2020-01-10 13:00:28","outMoney":18.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-10 10:15:53","outMoney":27.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-10 10:09:09","outMoney":30.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-09 18:06:24","outMoney":39.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/酸奶屋","transMoney":12,"dealDate":"2020-01-09 18:03:03","outMoney":42.26},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":50,"dealDate":"2020-01-09 17:59:59","outMoney":54.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":4,"dealDate":"2020-01-09 07:35:50","outMoney":4.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2020-01-09 07:33:46","outMoney":8.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":42.4,"dealDate":"2020-01-08 19:37:46","outMoney":10.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-08 19:07:53","outMoney":52.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-08 19:02:56","outMoney":55.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-08 19:01:59","outMoney":64.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-08 12:14:49","outMoney":67.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-08 11:49:47","outMoney":70.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":6.5,"dealDate":"2020-01-08 07:23:21","outMoney":79.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-07 17:09:49","outMoney":86.16},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.43,"dealDate":"2020-01-07 17:09:14","outMoney":88.16},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":6,"dealDate":"2020-01-07 13:59:11","outMoney":90.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-07 13:32:11","outMoney":96.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":13.7,"dealDate":"2020-01-06 18:02:55","outMoney":105.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-06 17:26:46","outMoney":119.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-06 16:56:52","outMoney":122.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-06 16:56:05","outMoney":125.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2020-01-06 07:28:06","outMoney":134.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":6.5,"dealDate":"2020-01-06 07:26:01","outMoney":135.89},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-05 13:03:58","outMoney":142.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-05 13:03:23","outMoney":145.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆皮","transMoney":2,"dealDate":"2020-01-04 19:27:22","outMoney":154.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-04 11:57:04","outMoney":156.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/酸奶屋","transMoney":12,"dealDate":"2020-01-04 11:36:31","outMoney":159.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-03 18:07:41","outMoney":171.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-03 18:06:43","outMoney":174.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-03 18:05:07","outMoney":177.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2020-01-03 07:08:52","outMoney":186.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2020-01-03 07:08:06","outMoney":188.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":1.5,"dealDate":"2020-01-02 13:13:08","outMoney":189.99},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":2,"dealDate":"2020-01-02 13:12:46","outMoney":191.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":7,"dealDate":"2020-01-02 13:12:43","outMoney":193.49},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":200,"dealDate":"2020-01-02 13:12:12","outMoney":200.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-01 16:42:33","outMoney":0.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-01 12:56:40","outMoney":2.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2020-01-01 08:03:30","outMoney":11.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":3.5,"dealDate":"2020-01-01 08:01:44","outMoney":13.09},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-01 08:00:26","outMoney":16.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆皮","transMoney":2,"dealDate":"2019-12-31 18:42:53","outMoney":18.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2019-12-31 18:38:07","outMoney":20.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":2,"dealDate":"2019-12-31 18:36:52","outMoney":22.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2019-12-31 13:14:40","outMoney":24.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-31 13:11:51","outMoney":27.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-30 13:25:51","outMoney":36.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":4.9,"dealDate":"2019-12-29 20:18:41","outMoney":45.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":10,"dealDate":"2019-12-29 19:55:36","outMoney":50.09},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":4.03,"dealDate":"2019-12-29 08:13:27","outMoney":60.09},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2019-12-29 08:11:38","outMoney":64.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2019-12-27 19:04:54","outMoney":67.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2019-12-27 19:04:27","outMoney":70.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-27 18:55:05","outMoney":72.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-27 12:51:09","outMoney":81.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":1.5,"dealDate":"2019-12-27 12:50:10","outMoney":90.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2019-12-27 12:49:33","outMoney":91.62},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2019-12-27 07:38:31","outMoney":93.62},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.43,"dealDate":"2019-12-27 07:37:52","outMoney":95.62},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-26 13:01:58","outMoney":98.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-25 11:28:34","outMoney":107.05},{"dealName":"主机补助","orgName":"华中师范大学","transMoney":40,"dealDate":"2019-12-25 11:27:46","outMoney":116.05},{"dealName":"主机补助","orgName":"华中师范大学","transMoney":19,"dealDate":"2019-12-25 11:27:35","outMoney":76.05},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":50,"dealDate":"2019-12-25 11:27:26","outMoney":57.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":4,"dealDate":"2019-12-25 08:00:14","outMoney":7.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2019-12-25 07:59:30","outMoney":11.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2019-12-24 11:29:21","outMoney":13.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2019-12-24 11:12:15","outMoney":16.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-24 11:04:24","outMoney":19.05},{"dealName":"消费","orgName":"华中师范大学/保卫处/008车08车载机","transMoney":1,"dealDate":"2019-12-22 11:47:44","outMoney":28.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":50,"dealDate":"2019-12-21 22:13:42","outMoney":29.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":10,"dealDate":"2019-12-21 17:03:48","outMoney":79.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":50,"dealDate":"2019-12-19 16:15:25","outMoney":89.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-19 13:19:49","outMoney":139.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":15,"dealDate":"2019-12-18 19:04:23","outMoney":148.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":13.7,"dealDate":"2019-12-18 17:43:35","outMoney":163.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":8,"dealDate":"2019-12-17 22:17:12","outMoney":176.75},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":7.2,"dealDate":"2019-12-17 14:21:30","outMoney":184.75},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/鸭血粉丝","transMoney":10,"dealDate":"2019-12-17 13:54:31","outMoney":191.95}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * count : 100
         * list : [{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/中式套餐","transMoney":6.5,"dealDate":"2020-01-17 13:36:09","outMoney":26.96},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":8,"dealDate":"2020-01-16 13:15:52","outMoney":33.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":6,"dealDate":"2020-01-15 18:15:55","outMoney":41.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":8,"dealDate":"2020-01-15 12:51:14","outMoney":47.46},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":20,"dealDate":"2020-01-14 13:25:45","outMoney":55.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/港台风","transMoney":7,"dealDate":"2020-01-14 13:24:48","outMoney":35.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/川味粉丝煲","transMoney":12,"dealDate":"2020-01-13 12:57:00","outMoney":42.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":3,"dealDate":"2020-01-12 12:21:55","outMoney":54.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-12 12:13:56","outMoney":57.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.4,"dealDate":"2020-01-12 08:43:32","outMoney":66.46},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-12 08:43:00","outMoney":68.86},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/港台风","transMoney":8,"dealDate":"2020-01-11 12:46:39","outMoney":70.86},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.4,"dealDate":"2020-01-11 08:47:46","outMoney":78.86},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2020-01-11 08:46:49","outMoney":81.26},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":80,"dealDate":"2020-01-10 16:46:41","outMoney":83.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-10 16:20:04","outMoney":3.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-10 16:19:16","outMoney":6.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-10 16:18:18","outMoney":9.26},{"dealName":"消费","orgName":"华中师范大学/校内经营商户/九丘文化传媒公司倍阅华师店","transMoney":9,"dealDate":"2020-01-10 13:00:28","outMoney":18.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-10 10:15:53","outMoney":27.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-10 10:09:09","outMoney":30.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-09 18:06:24","outMoney":39.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/酸奶屋","transMoney":12,"dealDate":"2020-01-09 18:03:03","outMoney":42.26},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":50,"dealDate":"2020-01-09 17:59:59","outMoney":54.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":4,"dealDate":"2020-01-09 07:35:50","outMoney":4.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2020-01-09 07:33:46","outMoney":8.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":42.4,"dealDate":"2020-01-08 19:37:46","outMoney":10.26},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-08 19:07:53","outMoney":52.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-08 19:02:56","outMoney":55.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-08 19:01:59","outMoney":64.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-08 12:14:49","outMoney":67.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-08 11:49:47","outMoney":70.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":6.5,"dealDate":"2020-01-08 07:23:21","outMoney":79.66},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-07 17:09:49","outMoney":86.16},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.43,"dealDate":"2020-01-07 17:09:14","outMoney":88.16},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":6,"dealDate":"2020-01-07 13:59:11","outMoney":90.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-07 13:32:11","outMoney":96.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":13.7,"dealDate":"2020-01-06 18:02:55","outMoney":105.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-06 17:26:46","outMoney":119.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-06 16:56:52","outMoney":122.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-06 16:56:05","outMoney":125.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2020-01-06 07:28:06","outMoney":134.29},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":6.5,"dealDate":"2020-01-06 07:26:01","outMoney":135.89},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-05 13:03:58","outMoney":142.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-05 13:03:23","outMoney":145.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆皮","transMoney":2,"dealDate":"2020-01-04 19:27:22","outMoney":154.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-04 11:57:04","outMoney":156.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/酸奶屋","transMoney":12,"dealDate":"2020-01-04 11:36:31","outMoney":159.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2020-01-03 18:07:41","outMoney":171.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2020-01-03 18:06:43","outMoney":174.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-03 18:05:07","outMoney":177.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2020-01-03 07:08:52","outMoney":186.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2020-01-03 07:08:06","outMoney":188.39},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":1.5,"dealDate":"2020-01-02 13:13:08","outMoney":189.99},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":2,"dealDate":"2020-01-02 13:12:46","outMoney":191.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":7,"dealDate":"2020-01-02 13:12:43","outMoney":193.49},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":200,"dealDate":"2020-01-02 13:12:12","outMoney":200.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-01 16:42:33","outMoney":0.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2020-01-01 12:56:40","outMoney":2.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2020-01-01 08:03:30","outMoney":11.49},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":3.5,"dealDate":"2020-01-01 08:01:44","outMoney":13.09},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2020-01-01 08:00:26","outMoney":16.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆皮","transMoney":2,"dealDate":"2019-12-31 18:42:53","outMoney":18.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":1.6,"dealDate":"2019-12-31 18:38:07","outMoney":20.59},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/稀食","transMoney":2,"dealDate":"2019-12-31 18:36:52","outMoney":22.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2019-12-31 13:14:40","outMoney":24.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-31 13:11:51","outMoney":27.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-30 13:25:51","outMoney":36.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":4.9,"dealDate":"2019-12-29 20:18:41","outMoney":45.19},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":10,"dealDate":"2019-12-29 19:55:36","outMoney":50.09},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":4.03,"dealDate":"2019-12-29 08:13:27","outMoney":60.09},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2019-12-29 08:11:38","outMoney":64.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2019-12-27 19:04:54","outMoney":67.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2019-12-27 19:04:27","outMoney":70.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-27 18:55:05","outMoney":72.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-27 12:51:09","outMoney":81.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":1.5,"dealDate":"2019-12-27 12:50:10","outMoney":90.12},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2019-12-27 12:49:33","outMoney":91.62},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆1","transMoney":2,"dealDate":"2019-12-27 07:38:31","outMoney":93.62},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":2.43,"dealDate":"2019-12-27 07:37:52","outMoney":95.62},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-26 13:01:58","outMoney":98.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-25 11:28:34","outMoney":107.05},{"dealName":"主机补助","orgName":"华中师范大学","transMoney":40,"dealDate":"2019-12-25 11:27:46","outMoney":116.05},{"dealName":"主机补助","orgName":"华中师范大学","transMoney":19,"dealDate":"2019-12-25 11:27:35","outMoney":76.05},{"dealName":"圈存机充值","orgName":"华中师范大学","transMoney":50,"dealDate":"2019-12-25 11:27:26","outMoney":57.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/扬州包子","transMoney":4,"dealDate":"2019-12-25 08:00:14","outMoney":7.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":2,"dealDate":"2019-12-25 07:59:30","outMoney":11.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/豆浆2","transMoney":3,"dealDate":"2019-12-24 11:29:21","outMoney":13.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/南阳酱香饼","transMoney":3,"dealDate":"2019-12-24 11:12:15","outMoney":16.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-24 11:04:24","outMoney":19.05},{"dealName":"消费","orgName":"华中师范大学/保卫处/008车08车载机","transMoney":1,"dealDate":"2019-12-22 11:47:44","outMoney":28.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":50,"dealDate":"2019-12-21 22:13:42","outMoney":29.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":10,"dealDate":"2019-12-21 17:03:48","outMoney":79.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":50,"dealDate":"2019-12-19 16:15:25","outMoney":89.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/北方面食","transMoney":9,"dealDate":"2019-12-19 13:19:49","outMoney":139.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/商贸中心/超市/满江红超市","transMoney":15,"dealDate":"2019-12-18 19:04:23","outMoney":148.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":13.7,"dealDate":"2019-12-18 17:43:35","outMoney":163.05},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":8,"dealDate":"2019-12-17 22:17:12","outMoney":176.75},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/博雅园餐厅/一楼/面包房","transMoney":7.2,"dealDate":"2019-12-17 14:21:30","outMoney":184.75},{"dealName":"消费","orgName":"华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/鸭血粉丝","transMoney":10,"dealDate":"2019-12-17 13:54:31","outMoney":191.95}]
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * dealName : 消费
             * orgName : 华中师范大学/后勤集团/饮食中心/桂香园餐厅新/一楼/中式套餐
             * transMoney : 6.5
             * dealDate : 2020-01-17 13:36:09
             * outMoney : 26.96
             */

            private String dealName;
            private String orgName;
            private double transMoney;
            private String dealDate;
            private double outMoney;

            public String getDealName() {
                return dealName;
            }

            public void setDealName(String dealName) {
                this.dealName = dealName;
            }

            public String getOrgName() {
                return orgName;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
            }

            public double getTransMoney() {
                return transMoney;
            }

            public void setTransMoney(double transMoney) {
                this.transMoney = transMoney;
            }

            public String getDealDate() {
                return dealDate;
            }

            public void setDealDate(String dealDate) {
                this.dealDate = dealDate;
            }

            public double getOutMoney() {
                return outMoney;
            }

            public void setOutMoney(double outMoney) {
                this.outMoney = outMoney;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("code : " + this.getCode() + ",\n" +
                "message : " + this.getMessage() + ",\n" +
                "data : {\n" +
                "\tcount : " + this.getData().getCount() + ",\n" +
                "\tlist : [\n");

        for (CardAccount.DataBean.ListBean l : this.getData().getList()) {
            String t = "\t\t{" + "\n" +
                    "\t\t\tdealName : " + l.getDealName() + "\n" +
                    "\t\t\torgName : " + l.getOrgName() + "\n" +
                    "\t\t\ttransMoney : " + l.getTransMoney() + "\n" +
                    "\t\t\tdealDate : " + l.getDealDate() + "\n" +
                    "\t\t\toutMoney : " + l.getOutMoney() + "\n" +
                    "\t\t},\n";
            s.append(t);
        }

        s.append("\t]\n" + "}");

        return s.toString();
    }
}
