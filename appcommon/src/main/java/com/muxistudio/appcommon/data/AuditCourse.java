package com.muxistudio.appcommon.data;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kolibreath on 18-2-2.
 */
//这个是一个很大很大的list
public class AuditCourse {
    /**
     * code : 0
     * message : OK
     * data : [{"grade":2019,"name":"数据结构","teacher":"董石,","for_whom":"数字媒体技术","lesson_no":"48900004","kind":"通识必修课,公共必修课及专业课","place_and_time":[{"place":"N311","time":"星期一第1-2节{4-20周}"},{"place":"信技实验室","time":"星期三第5-6节{4-12周}"}]},{"grade":2019,"name":"数据结构","teacher":"董石,","for_whom":"数字媒体技术","lesson_no":"48900004","kind":"通识必修课,公共必修课及专业课","place_and_time":[{"place":"N311","time":"星期二第7-8节{4-20周}"},{"place":"信技实验室","time":"星期四第1-2节{4-12周}"}]},{"grade":2019,"name":"数据结构实验","teacher":"董石,","for_whom":"数字媒体技术","lesson_no":"48900008","kind":"通识必修课,公共必修课及专业课","place_and_time":[{"place":"信技实验室","time":"星期三第5-6节{13-20周}"}]},{"grade":2019,"name":"数据结构实验","teacher":"董石,","for_whom":"数字媒体技术","lesson_no":"48900008","kind":"通识必修课,公共必修课及专业课","place_and_time":[{"place":"信技实验室","time":"星期四第1-2节{13-20周}"}]}]
     */

    private int code;
    private String message;
    /**
     * grade : 2019
     * name : 数据结构
     * teacher : 董石,
     * for_whom : 数字媒体技术
     * lesson_no : 48900004
     * kind : 通识必修课,公共必修课及专业课
     * place_and_time : [{"place":"N311","time":"星期一第1-2节{4-20周}"},{"place":"信技实验室","time":"星期三第5-6节{4-12周}"}]
     */

    private List<DataBean> data;

    //获取(上课的时间和上课的节数)和(上课的周数)
    public static String[] getCourseTime(String when) {
        String s = "((.*)\\{(.*)\\})";
        Pattern pattern = Pattern.compile(s);
        Matcher m = pattern.matcher(when);
        String pieces[] = new String[2];
        while (m.find()) {
            pieces[0] = m.group(2);
            pieces[1] = m.group(3);
        }
        return pieces;
    }

    public List<DataBean> getRes() {
        return data;
    }

    public void setRes(List<DataBean> res) {
        this.data = res;
    }

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }



    public static class DataBean {
        private int grade;
        private String name;
        private String teacher;
        private String for_whom;
        private String lesson_no;
        private String kind;
        /**
         * place : N311
         * time : 星期一第1-2节{4-20周}
         */

        private List<PlaceAndTimeBean> place_and_time;

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getFor_whom() {
            return for_whom;
        }

        public void setFor_whom(String for_whom) {
            this.for_whom = for_whom;
        }

        public String getLesson_no() {
            return lesson_no;
        }

        public void setLesson_no(String lesson_no) {
            this.lesson_no = lesson_no;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public List<PlaceAndTimeBean> getPlace_and_time() {
            return place_and_time;
        }

        public void setPlace_and_time(List<PlaceAndTimeBean> place_and_time) {
            this.place_and_time = place_and_time;
        }

        public static class PlaceAndTimeBean {
            private String place;
            private String time;

            public String getPlace() {
                return place;
            }

            public void setPlace(String place) {
                this.place = place;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }
    }
}