package com.example.dell.zhihu.Bean;

import java.util.List;

public class DaliBaner {

    /**
     * date : 20190301
     * stories : [{"images":["https://pic4.zhimg.com/v2-7889956e1f47b311f289083e3077e94b.jpg"],"type":0,"id":9708360,"ga_prefix":"030119","title":"人人都想做产品经理，但这几条「硬杠杠」很少有人能达到"},{"images":["https://pic2.zhimg.com/v2-f321af6e6b25ceed8263ba11ecfc6a65.jpg"],"type":0,"id":9708142,"ga_prefix":"030116","title":"NBA 最好的三分手时代，就是现在"},{"title":"生命有没有轮回我不知道，但时尚一生都在轮回","ga_prefix":"030109","images":["https://pic2.zhimg.com/v2-538f991f27eda7c5ad47b6d3e5134e55.jpg"],"multipic":true,"type":0,"id":9708285},{"title":"临沂没有网戒中心","ga_prefix":"030108","images":["https://pic1.zhimg.com/v2-d9d3dfee470c10ca5e6c7bd5a5b231b0.jpg"],"multipic":true,"type":0,"id":9708298},{"title":"律师的天堂指南","ga_prefix":"030107","images":["https://pic3.zhimg.com/v2-39f7faf228d2c5e2353f11ad50c72ab2.jpg"],"multipic":true,"type":0,"id":9708307},{"images":["https://pic2.zhimg.com/v2-12afe447e40a31ef64dff98e9dc4e099.jpg"],"type":0,"id":9708274,"ga_prefix":"030106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-4952a40ce6ce98df54a072bd53af432b.jpg","type":0,"id":9708298,"ga_prefix":"030108","title":"临沂没有网戒中心"},{"image":"https://pic4.zhimg.com/v2-7ec9f61856b088babc03b9cb3053b34f.jpg","type":0,"id":9708279,"ga_prefix":"022815","title":"万元抗癌药被认定为假药，仿佛「药神」走进了现实"},{"image":"https://pic1.zhimg.com/v2-8b4ed8b534a72d16aad77b1e4d6db040.jpg","type":0,"id":9708256,"ga_prefix":"022807","title":"星巴克的「圣杯战争」"},{"image":"https://pic4.zhimg.com/v2-5e7da4a76d33042771425f0d837ec967.jpg","type":0,"id":9708071,"ga_prefix":"022707","title":"全国突然停电一天，不夸张地说，我们会痛苦一年"},{"image":"https://pic2.zhimg.com/v2-7a3c0e35e9caaadb68edfe73d717d0bd.jpg","type":0,"id":9708108,"ga_prefix":"022618","title":"我不碰你的皮，就能回首掏你一个洞"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-7889956e1f47b311f289083e3077e94b.jpg"]
         * type : 0
         * id : 9708360
         * ga_prefix : 030119
         * title : 人人都想做产品经理，但这几条「硬杠杠」很少有人能达到
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-4952a40ce6ce98df54a072bd53af432b.jpg
         * type : 0
         * id : 9708298
         * ga_prefix : 030108
         * title : 临沂没有网戒中心
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
