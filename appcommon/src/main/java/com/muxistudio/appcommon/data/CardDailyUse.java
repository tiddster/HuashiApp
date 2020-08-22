package com.muxistudio.appcommon.data;

import java.util.ArrayList;
import java.util.List;

public class CardDailyUse {

    /**
     * result : true
     * msg :
     * list : [{"title":"2018-05","data":[{"smtDealName":"消费","smtTransMoney":"3.0","smtDealDateTimeTxt":"2018-05-03 17:46:43","date":"05月03日","time":"17:46","smtOrgName":"学子超市","smtInMoney":"54.74","smtOutMoney":"51.74"},{"smtDealName":"消费","smtTransMoney":"2.0","smtDealDateTimeTxt":"2018-05-03 17:37:38","date":"05月03日","time":"17:37","smtOrgName":"原磨豆浆","smtInMoney":"56.74","smtOutMoney":"54.74"}]},{"title":"2018-04","data":[{"smtDealName":"消费","smtTransMoney":"2.7","smtDealDateTimeTxt":"2018-04-28 15:38:08","date":"04月28日","time":"15:38","smtOrgName":"沁园春超市","smtInMoney":"111.94","smtOutMoney":"109.24"},{"smtDealName":"消费","smtTransMoney":"3.0","smtDealDateTimeTxt":"2018-04-28 11:56:08","date":"04月28日","time":"11:56","smtOrgName":"吧台右","smtInMoney":"114.94","smtOutMoney":"111.94"}]}]
     */

    private boolean result;
    private String msg;
    private List<ListBean> list;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * title : 2018-05
         * data : [{"smtDealName":"消费","smtTransMoney":"3.0","smtDealDateTimeTxt":"2018-05-03 17:46:43","date":"05月03日","time":"17:46","smtOrgName":"学子超市","smtInMoney":"54.74","smtOutMoney":"51.74"},{"smtDealName":"消费","smtTransMoney":"2.0","smtDealDateTimeTxt":"2018-05-03 17:37:38","date":"05月03日","time":"17:37","smtOrgName":"原磨豆浆","smtInMoney":"56.74","smtOutMoney":"54.74"}]
         */

        private String title;
        private List<DataBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * smtDealName : 消费
             * smtTransMoney : 3.0
             * smtDealDateTimeTxt : 2018-05-03 17:46:43
             * date : 05月03日
             * time : 17:46
             * smtOrgName : 学子超市
             * smtInMoney : 54.74
             * smtOutMoney : 51.74
             */

            private String smtDealName;
            private String smtTransMoney;
            private String smtDealDateTimeTxt;
            private String date;
            private String time;
            private String smtOrgName;
            private String smtInMoney;
            private String smtOutMoney;

            public String getSmtDealName() {
                return smtDealName;
            }

            public void setSmtDealName(String smtDealName) {
                this.smtDealName = smtDealName;
            }

            public String getSmtTransMoney() {
                return smtTransMoney;
            }

            public void setSmtTransMoney(String smtTransMoney) {
                this.smtTransMoney = smtTransMoney;
            }

            public String getSmtDealDateTimeTxt() {
                return smtDealDateTimeTxt;
            }

            public void setSmtDealDateTimeTxt(String smtDealDateTimeTxt) {
                this.smtDealDateTimeTxt = smtDealDateTimeTxt;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSmtOrgName() {
                return smtOrgName;
            }

            public void setSmtOrgName(String smtOrgName) {
                this.smtOrgName = smtOrgName;
            }

            public String getSmtInMoney() {
                return smtInMoney;
            }

            public void setSmtInMoney(String smtInMoney) {
                this.smtInMoney = smtInMoney;
            }

            public String getSmtOutMoney() {
                return smtOutMoney;
            }

            public void setSmtOutMoney(String smtOutMoney) {
                this.smtOutMoney = smtOutMoney;
            }
        }
    }

    public static CardDailyUse convert(CardAccount cardAccount) {
        CardDailyUse c = new CardDailyUse();
        List<ListBean> l = new ArrayList<>();


        String t = "";
        List<ListBean.DataBean> dataBeans = new ArrayList<>();
        for (CardAccount.DataBean.ListBean data : cardAccount.getData().getList()) {
            if ( t.equals("") ) {
                t = data.getDealDate().substring(0,10);

            } else if ( t.equals(data.getDealDate().substring(0,10)) ) {
                ListBean listBean = new ListBean();
                List<ListBean.DataBean> tmp = new ArrayList<>();
                tmp.addAll(dataBeans);
                listBean.setData(tmp);
                listBean.setTitle(t);
                l.add(listBean);
            }

            ListBean.DataBean dataBean = new ListBean.DataBean();
            dataBean.setSmtDealDateTimeTxt(data.getDealDate());
            dataBean.setDate(data.getDealDate().substring(0,10));
            dataBean.setSmtDealName(data.getDealName());
            dataBean.setSmtOrgName(data.getOrgName());
            dataBean.setSmtOutMoney(Double.valueOf(data.getOutMoney()).toString());
            dataBean.setTime(data.getDealDate().substring(11,19));
            dataBean.setSmtTransMoney(Double.valueOf(data.getTransMoney()).toString());

            dataBeans.add(dataBean);

        }
        c.setList(l);

        return c;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(
                "result : "+this.isResult()+",\n" +
                "msg : "+this.getMsg()+",\n" +
                "list : "+"[\n");

        for ( CardDailyUse.ListBean listBean : this.getList() ) {
            StringBuilder l = new StringBuilder("\ttitle : "+listBean.getTitle()+",\n" +
                    "\tdata : [\n");
            for ( CardDailyUse.ListBean.DataBean dataBean : listBean.getData() ) {
                l.append("\t\t{\n" +
                        "\t\t\tsmtDealName : "+dataBean.getSmtDealName()+",\n" +
                        "\t\t\tsmtTransMoney : "+dataBean.getSmtTransMoney()+"\n" +
                        "\t\t\tsmtDealDateTimeTxt : "+dataBean.getSmtDealDateTimeTxt()+"\n" +
                        "\t\t\tdate : "+dataBean.getDate()+"\n" +
                        "\t\t\ttime : "+dataBean.getTime()+"\n" +
                        "\t\t\tsmtOrgName : "+dataBean.getSmtOrgName()+"\n" +
                        "\t\t\tsmtInMoney : "+dataBean.getSmtInMoney()+"\n" +
                        "\t\t\tsmtOutMoney : "+dataBean.getSmtOutMoney()+"\n" +
                        "\t\t},\n");
            }
            s.append(l.toString());
        }
        return s.toString();
    }
}
