package com.muxistudio.appcommon.data;

import java.util.List;

/**
 * Created by december on 17/2/11.
 */

public class ClassRoom {

    /**
     * code : 0
     * message : OK
     * data : {"week":12,"day":1,"building":"8","list":[{"time":1,"rooms":["8101","8102","8103","8104","8106","8107","8108","8109","8111","8203","8205","8207","8208","8209","8212","8214","8302","8303","8304","8305","8306","8315","8405","8406","8413","8414","8415","8505","8506","8509","8513","8514","8516"]},{"time":2,"rooms":["8101","8102","8103","8104","8106","8107","8108","8109","8111","8203","8205","8207","8208","8209","8212","8214","8302","8303","8304","8305","8306","8315","8405","8406","8413","8414","8415","8505","8506","8509","8513","8514","8516"]},{"time":3,"rooms":["8101","8102","8106","8205","8213","8214","8302","8304","8306","8405","8406","8415","8505","8506","8509","8512","8513","8514","8516"]},{"time":4,"rooms":["8101","8102","8106","8205","8213","8214","8302","8304","8306","8405","8406","8415","8505","8506","8509","8512","8513","8514","8516"]},{"time":5,"rooms":["8101","8102","8106","8206","8207","8214","8216","8301","8306","8315","8405","8406","8414","8415","8505","8506","8510","8516"]},{"time":6,"rooms":["8101","8102","8106","8206","8207","8214","8216","8301","8306","8315","8405","8406","8414","8415","8505","8506","8510","8516"]},{"time":7,"rooms":["8101","8103","8106","8201","8203","8206","8207","8211","8212","8214","8306","8310","8315","8406","8413","8414","8415","8505","8506","8511","8513","8516"]},{"time":8,"rooms":["8101","8103","8106","8201","8203","8206","8207","8211","8212","8214","8306","8310","8315","8406","8413","8414","8415","8505","8506","8511","8513","8516"]},{"time":9,"rooms":["8101","8102","8104","8106","8108","8203","8206","8207","8214","8302","8303","8304","8306","8308","8309","8312","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8412","8413","8414","8415","8502","8503","8504","8505","8506","8507","8508","8509","8511","8512","8513","8514","8515","8516"]},{"time":10,"rooms":["8101","8102","8104","8106","8108","8203","8206","8207","8214","8302","8303","8304","8306","8308","8309","8312","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8412","8413","8414","8415","8502","8503","8504","8505","8506","8507","8508","8509","8511","8512","8513","8514","8515","8516"]},{"time":11,"rooms":["8101","8103","8105","8106","8108","8112","8201","8202","8203","8204","8205","8206","8207","8210","8211","8212","8213","8214","8215","8216","8301","8304","8305","8306","8307","8308","8309","8310","8312","8313","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8410","8412","8413","8414","8415","8416","8501","8502","8503","8504","8505","8506","8507","8508","8509","8510","8511","8512","8513","8514","8515","8516"]},{"time":12,"rooms":["8101","8103","8105","8106","8108","8109","8112","8201","8202","8203","8204","8205","8206","8207","8210","8211","8212","8213","8214","8215","8216","8301","8304","8305","8306","8307","8308","8309","8310","8312","8313","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8410","8412","8413","8414","8415","8416","8501","8502","8503","8504","8505","8506","8507","8508","8509","8510","8511","8512","8513","8514","8515","8516"]}]}
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
         * week : 12
         * day : 1
         * building : 8
         * list : [{"time":1,"rooms":["8101","8102","8103","8104","8106","8107","8108","8109","8111","8203","8205","8207","8208","8209","8212","8214","8302","8303","8304","8305","8306","8315","8405","8406","8413","8414","8415","8505","8506","8509","8513","8514","8516"]},{"time":2,"rooms":["8101","8102","8103","8104","8106","8107","8108","8109","8111","8203","8205","8207","8208","8209","8212","8214","8302","8303","8304","8305","8306","8315","8405","8406","8413","8414","8415","8505","8506","8509","8513","8514","8516"]},{"time":3,"rooms":["8101","8102","8106","8205","8213","8214","8302","8304","8306","8405","8406","8415","8505","8506","8509","8512","8513","8514","8516"]},{"time":4,"rooms":["8101","8102","8106","8205","8213","8214","8302","8304","8306","8405","8406","8415","8505","8506","8509","8512","8513","8514","8516"]},{"time":5,"rooms":["8101","8102","8106","8206","8207","8214","8216","8301","8306","8315","8405","8406","8414","8415","8505","8506","8510","8516"]},{"time":6,"rooms":["8101","8102","8106","8206","8207","8214","8216","8301","8306","8315","8405","8406","8414","8415","8505","8506","8510","8516"]},{"time":7,"rooms":["8101","8103","8106","8201","8203","8206","8207","8211","8212","8214","8306","8310","8315","8406","8413","8414","8415","8505","8506","8511","8513","8516"]},{"time":8,"rooms":["8101","8103","8106","8201","8203","8206","8207","8211","8212","8214","8306","8310","8315","8406","8413","8414","8415","8505","8506","8511","8513","8516"]},{"time":9,"rooms":["8101","8102","8104","8106","8108","8203","8206","8207","8214","8302","8303","8304","8306","8308","8309","8312","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8412","8413","8414","8415","8502","8503","8504","8505","8506","8507","8508","8509","8511","8512","8513","8514","8515","8516"]},{"time":10,"rooms":["8101","8102","8104","8106","8108","8203","8206","8207","8214","8302","8303","8304","8306","8308","8309","8312","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8412","8413","8414","8415","8502","8503","8504","8505","8506","8507","8508","8509","8511","8512","8513","8514","8515","8516"]},{"time":11,"rooms":["8101","8103","8105","8106","8108","8112","8201","8202","8203","8204","8205","8206","8207","8210","8211","8212","8213","8214","8215","8216","8301","8304","8305","8306","8307","8308","8309","8310","8312","8313","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8410","8412","8413","8414","8415","8416","8501","8502","8503","8504","8505","8506","8507","8508","8509","8510","8511","8512","8513","8514","8515","8516"]},{"time":12,"rooms":["8101","8103","8105","8106","8108","8109","8112","8201","8202","8203","8204","8205","8206","8207","8210","8211","8212","8213","8214","8215","8216","8301","8304","8305","8306","8307","8308","8309","8310","8312","8313","8314","8315","8402","8403","8404","8405","8406","8407","8408","8409","8410","8412","8413","8414","8415","8416","8501","8502","8503","8504","8505","8506","8507","8508","8509","8510","8511","8512","8513","8514","8515","8516"]}]
         */

        private int week;
        private int day;
        private String building;
        private List<ListBean> list;

        public int getWeek() {
            return week;
        }

        public void setWeek(int week) {
            this.week = week;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * time : 1
             * rooms : ["8101","8102","8103","8104","8106","8107","8108","8109","8111","8203","8205","8207","8208","8209","8212","8214","8302","8303","8304","8305","8306","8315","8405","8406","8413","8414","8415","8505","8506","8509","8513","8514","8516"]
             */

            private int time;
            private List<String> rooms;

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public List<String> getRooms() {
                return rooms;
            }

            public void setRooms(List<String> rooms) {
                this.rooms = rooms;
            }
        }
    }
}
