package com.muxistudio.appcommon.data;

public class CardBalance {

    /**
     * code : 0
     * message : OK
     * data : {"balance":26.96,"status":"在用"}
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
         * balance : 26.96
         * status : 在用
         */

        private double balance;
        private String status;

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "code : "+this.getCode()+"\n" +
                "message : "+this.getMessage()+"\n" +
                "data : {\n" +
                "\tbalance : "+this.getData().getBalance()+"\n" +
                "\tstatus : "+this.getData().getStatus()+"\n" +
                "}";
    }
}
