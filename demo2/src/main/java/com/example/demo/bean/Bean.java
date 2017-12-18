package com.example.demo.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/6.
 */

public class Bean {


    /**
     * count : 1
     * start : 1
     * total : 250
     * subjects : [{"rating":{"max":10,"average":9.5,"stars":"50","min":0},"genres":["剧情","爱情","同性"],"title":"霸王别姬","casts":[{"alt":"https://movie.douban.com/celebrity/1003494/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp"},"name":"张国荣","id":"1003494"},{"alt":"https://movie.douban.com/celebrity/1050265/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp"},"name":"张丰毅","id":"1050265"},{"alt":"https://movie.douban.com/celebrity/1035641/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp"},"name":"巩俐","id":"1035641"}],"collect_count":833773,"original_title":"霸王别姬","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp"},"name":"陈凯歌","id":"1023040"}],"year":"1993","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp"},"alt":"https://movie.douban.com/subject/1291546/","id":"1291546"}]
     * title : 豆瓣电影Top250
     */

    public int count;
    public int start;
    public int total;
    public String title;
    public List<SubjectsBean> subjects;

    public static Bean objectFromData(String str) {

        return new Gson().fromJson(str, Bean.class);
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":9.5,"stars":"50","min":0}
         * genres : ["剧情","爱情","同性"]
         * title : 霸王别姬
         * casts : [{"alt":"https://movie.douban.com/celebrity/1003494/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp"},"name":"张国荣","id":"1003494"},{"alt":"https://movie.douban.com/celebrity/1050265/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp"},"name":"张丰毅","id":"1050265"},{"alt":"https://movie.douban.com/celebrity/1035641/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp"},"name":"巩俐","id":"1035641"}]
         * collect_count : 833773
         * original_title : 霸王别姬
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp"},"name":"陈凯歌","id":"1023040"}]
         * year : 1993
         * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp"}
         * alt : https://movie.douban.com/subject/1291546/
         * id : 1291546
         */

        public RatingBean rating;
        public String title;
        public int collect_count;
        public String original_title;
        public String subtype;
        public String year;
        public ImagesBean images;
        public String alt;
        public String id;
        public List<String> genres;
        public List<CastsBean> casts;
        public List<DirectorsBean> directors;

        public static SubjectsBean objectFromData(String str) {

            return new Gson().fromJson(str, SubjectsBean.class);
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 9.5
             * stars : 50
             * min : 0
             */

            public int max;
            public double average;
            public String stars;
            public int min;

            public static RatingBean objectFromData(String str) {

                return new Gson().fromJson(str, RatingBean.class);
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp
             */

            public String small;
            public String large;
            public String medium;

            public static ImagesBean objectFromData(String str) {

                return new Gson().fromJson(str, ImagesBean.class);
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1003494/
             * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp"}
             * name : 张国荣
             * id : 1003494
             */

            public String alt;
            public AvatarsBean avatars;
            public String name;
            public String id;

            public static CastsBean objectFromData(String str) {

                return new Gson().fromJson(str, CastsBean.class);
            }

            public static class AvatarsBean {
                /**
                 * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp
                 * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp
                 * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp
                 */

                public String small;
                public String large;
                public String medium;

                public static AvatarsBean objectFromData(String str) {

                    return new Gson().fromJson(str, AvatarsBean.class);
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1023040/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp"}
             * name : 陈凯歌
             * id : 1023040
             */

            public String alt;
            public AvatarsBeanX avatars;
            public String name;
            public String id;

            public static DirectorsBean objectFromData(String str) {

                return new Gson().fromJson(str, DirectorsBean.class);
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp
                 */

                public String small;
                public String large;
                public String medium;

                public static AvatarsBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, AvatarsBeanX.class);
                }
            }
        }
    }
}
