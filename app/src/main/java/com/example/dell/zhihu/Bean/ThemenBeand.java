package com.example.dell.zhihu.Bean;

import java.util.List;

public class ThemenBeand {

    /**
     * ERRORCODE : 0
     * RESULT : {"imgUrl":["http://inews.gtimg.com/newsapp_match/0/7955494782/0"],"publishTime":"2019-03-03 12:48:52","editor":"","source":"腾讯体育","category":"体育","title":"朗多超越德隆-威廉姆斯 生涯助攻总数进入历史前20","content":"<p>视频：【扣篮】君临天下！朗执导高抛詹姆斯空接炸筐，时长约40秒<\/p><p>腾讯体育3月3日讯 湖人今日背靠背迎战太阳队，首节比赛结束后，湖人队控卫拉简-朗多就达成了一项成就。【NBA专题】<\/p><p><img src=\"http://inews.gtimg.com/newsapp_match/0/7955494782/0\"><\/p><p>首节比赛送出三次助攻后，生涯的总助攻数已经来到了6820次，他因此完成了对德隆-威廉姆斯的超越，攀升至NBA生涯助攻榜的第20位，目前排在他前面的，是2014年入选了名人堂的盖伊-罗杰斯（6917次）和同样是名人堂成员的传奇球星鲍勃-库西（6955次）。<\/p><p class=\"text\">湖人队目前处在冲击季后赛的关键时期，形势不太乐观的他们，需要朗多在组织进攻上贡献更多的力量。<\/p><p class=\"text\">（牧羊人）<\/p><p>微博搜索\u201c腾讯体育NBA频道\u201d关注腾讯NBA官方微博，微信搜索\u201c腾讯NBA\u201d关注腾讯NBA官方微信，掌握NBA最精彩资讯，和鹅厂NBA小编来唠嗑~<\/p>"}
     */

    private String ERRORCODE;
    private RESULTBean RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public RESULTBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(RESULTBean RESULT) {
        this.RESULT = RESULT;
    }

    public static class RESULTBean {
        /**
         * imgUrl : ["http://inews.gtimg.com/newsapp_match/0/7955494782/0"]
         * publishTime : 2019-03-03 12:48:52
         * editor :
         * source : 腾讯体育
         * category : 体育
         * title : 朗多超越德隆-威廉姆斯 生涯助攻总数进入历史前20
         * content : <p>视频：【扣篮】君临天下！朗执导高抛詹姆斯空接炸筐，时长约40秒</p><p>腾讯体育3月3日讯 湖人今日背靠背迎战太阳队，首节比赛结束后，湖人队控卫拉简-朗多就达成了一项成就。【NBA专题】</p><p><img src="http://inews.gtimg.com/newsapp_match/0/7955494782/0"></p><p>首节比赛送出三次助攻后，生涯的总助攻数已经来到了6820次，他因此完成了对德隆-威廉姆斯的超越，攀升至NBA生涯助攻榜的第20位，目前排在他前面的，是2014年入选了名人堂的盖伊-罗杰斯（6917次）和同样是名人堂成员的传奇球星鲍勃-库西（6955次）。</p><p class="text">湖人队目前处在冲击季后赛的关键时期，形势不太乐观的他们，需要朗多在组织进攻上贡献更多的力量。</p><p class="text">（牧羊人）</p><p>微博搜索“腾讯体育NBA频道”关注腾讯NBA官方微博，微信搜索“腾讯NBA”关注腾讯NBA官方微信，掌握NBA最精彩资讯，和鹅厂NBA小编来唠嗑~</p>
         */

        private String publishTime;
        private String editor;
        private String source;
        private String category;
        private String title;
        private String content;
        private List<String> imgUrl;

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getEditor() {
            return editor;
        }

        public void setEditor(String editor) {
            this.editor = editor;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(List<String> imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
