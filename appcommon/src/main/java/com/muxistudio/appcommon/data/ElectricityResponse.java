package com.muxistudio.appcommon.data;

import java.util.List;

public class ElectricityResponse {

    /**
     * code : 0
     * message : OK
     * data : {"building":"东7","room":"301B","has_light":true,"light":{"kind":"light","remain_power":"202.55","read_time":"2020-09-12 02:10:20","consumption":{"usage":"3.06","charge":"1.82"}},"has_air":true,"air":{"kind":"air","remain_power":"75.53","read_time":"2020-09-12 02:05:39","consumption":{"usage":"1.02","charge":"0.61"}},"has_more":true,"more_data":[{"kind":"客厅-空调","remain_power":"35.60","read_time":"2020-09-12 02:10:45","consumption":{"usage":"0.03","charge":"0.02"}}]}
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
         * building : 东7
         * room : 301B
         * has_light : true
         * light : {"kind":"light","remain_power":"202.55","read_time":"2020-09-12 02:10:20","consumption":{"usage":"3.06","charge":"1.82"}}
         * has_air : true
         * air : {"kind":"air","remain_power":"75.53","read_time":"2020-09-12 02:05:39","consumption":{"usage":"1.02","charge":"0.61"}}
         * has_more : true
         * more_data : [{"kind":"客厅-空调","remain_power":"35.60","read_time":"2020-09-12 02:10:45","consumption":{"usage":"0.03","charge":"0.02"}}]
         */

        private String building;
        private String room;
        private boolean has_light;
        private LightBean light;
        private boolean has_air;
        private AirBean air;
        private boolean has_more;
        private List<MoreDataBean> more_data;

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public boolean isHas_light() {
            return has_light;
        }

        public void setHas_light(boolean has_light) {
            this.has_light = has_light;
        }

        public LightBean getLight() {
            return light;
        }

        public void setLight(LightBean light) {
            this.light = light;
        }

        public boolean isHas_air() {
            return has_air;
        }

        public void setHas_air(boolean has_air) {
            this.has_air = has_air;
        }

        public AirBean getAir() {
            return air;
        }

        public void setAir(AirBean air) {
            this.air = air;
        }

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public List<MoreDataBean> getMore_data() {
            return more_data;
        }

        public void setMore_data(List<MoreDataBean> more_data) {
            this.more_data = more_data;
        }

        public static class LightBean {
            /**
             * kind : light
             * remain_power : 202.55
             * read_time : 2020-09-12 02:10:20
             * consumption : {"usage":"3.06","charge":"1.82"}
             */

            private String kind;
            private String remain_power;
            private String read_time;
            private ConsumptionBean consumption;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getRemain_power() {
                return remain_power;
            }

            public void setRemain_power(String remain_power) {
                this.remain_power = remain_power;
            }

            public String getRead_time() {
                return read_time;
            }

            public void setRead_time(String read_time) {
                this.read_time = read_time;
            }

            public ConsumptionBean getConsumption() {
                return consumption;
            }

            public void setConsumption(ConsumptionBean consumption) {
                this.consumption = consumption;
            }

            public static class ConsumptionBean {
                /**
                 * usage : 3.06
                 * charge : 1.82
                 */

                private String usage;
                private String charge;

                public String getUsage() {
                    return usage;
                }

                public void setUsage(String usage) {
                    this.usage = usage;
                }

                public String getCharge() {
                    return charge;
                }

                public void setCharge(String charge) {
                    this.charge = charge;
                }
            }
        }

        public static class AirBean {
            /**
             * kind : air
             * remain_power : 75.53
             * read_time : 2020-09-12 02:05:39
             * consumption : {"usage":"1.02","charge":"0.61"}
             */

            private String kind;
            private String remain_power;
            private String read_time;
            private ConsumptionBeanX consumption;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getRemain_power() {
                return remain_power;
            }

            public void setRemain_power(String remain_power) {
                this.remain_power = remain_power;
            }

            public String getRead_time() {
                return read_time;
            }

            public void setRead_time(String read_time) {
                this.read_time = read_time;
            }

            public ConsumptionBeanX getConsumption() {
                return consumption;
            }

            public void setConsumption(ConsumptionBeanX consumption) {
                this.consumption = consumption;
            }

            public static class ConsumptionBeanX {
                /**
                 * usage : 1.02
                 * charge : 0.61
                 */

                private String usage;
                private String charge;

                public String getUsage() {
                    return usage;
                }

                public void setUsage(String usage) {
                    this.usage = usage;
                }

                public String getCharge() {
                    return charge;
                }

                public void setCharge(String charge) {
                    this.charge = charge;
                }
            }
        }

        public static class MoreDataBean {
            /**
             * kind : 客厅-空调
             * remain_power : 35.60
             * read_time : 2020-09-12 02:10:45
             * consumption : {"usage":"0.03","charge":"0.02"}
             */

            private String kind;
            private String remain_power;
            private String read_time;
            private ConsumptionBeanXX consumption;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getRemain_power() {
                return remain_power;
            }

            public void setRemain_power(String remain_power) {
                this.remain_power = remain_power;
            }

            public String getRead_time() {
                return read_time;
            }

            public void setRead_time(String read_time) {
                this.read_time = read_time;
            }

            public ConsumptionBeanXX getConsumption() {
                return consumption;
            }

            public void setConsumption(ConsumptionBeanXX consumption) {
                this.consumption = consumption;
            }

            public static class ConsumptionBeanXX {
                /**
                 * usage : 0.03
                 * charge : 0.02
                 */

                private String usage;
                private String charge;

                public String getUsage() {
                    return usage;
                }

                public void setUsage(String usage) {
                    this.usage = usage;
                }

                public String getCharge() {
                    return charge;
                }

                public void setCharge(String charge) {
                    this.charge = charge;
                }
            }
        }
    }
}
