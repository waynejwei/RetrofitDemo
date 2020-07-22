package com.example.retrofitdemo.domain;

import java.util.List;

public class JsonResult {

    /**
     * success : true
     * code : 10000
     * message : 获取成功
     * data : [{"id":"1285588535117721600","title":"Android加载大图片，解决OOM问题","viewCount":194,"commentCount":107,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/6.png"},{"id":"1285588535117721601","title":"Volley/Xutils对大图片处理算法源码分析","viewCount":291,"commentCount":78,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/10.png"},{"id":"1285588535117721602","title":"Android开发网络安全配置","viewCount":107,"commentCount":25,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/11.png"},{"id":"1285588535117721603","title":"Android开发网络编程，请求图片","viewCount":265,"commentCount":51,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/0.png"},{"id":"1285588535117721604","title":"Intent页面跳转工具类分享","viewCount":213,"commentCount":33,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/4.png"},{"id":"1285588535117721605","title":"阳光沙滩商城的API文档","viewCount":149,"commentCount":64,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/3.png"},{"id":"1285588535117721606","title":"Android课程视频打包下载","viewCount":257,"commentCount":75,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/5.png"},{"id":"1285588535117721607","title":"非常轻量级的gif录制软件","viewCount":265,"commentCount":96,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/9.png"},{"id":"1285588535117721608","title":"Fiddler抓包工具，墙裂推荐，功能很强大很全的一个工具","viewCount":178,"commentCount":99,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/12.png"},{"id":"1285588535117721609","title":"AndroidStudio奇淫技巧-代码管理","viewCount":80,"commentCount":90,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/6.png"},{"id":"1285588535117721610","title":"OC和Swift混编","viewCount":74,"commentCount":90,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/11.png"},{"id":"1285588535117721611","title":"最新的Android studio是不是没有Android Device Monitor","viewCount":161,"commentCount":17,"publishTime":"2020-07-21T14:52:46.509+0000","userName":"程序员拉大锯","cover":"/imgs/12.png"}]
     */

    private boolean success;
    private int code;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
        /**
         * id : 1285588535117721600
         * title : Android加载大图片，解决OOM问题
         * viewCount : 194
         * commentCount : 107
         * publishTime : 2020-07-21T14:52:46.509+0000
         * userName : 程序员拉大锯
         * cover : /imgs/6.png
         */

        private String id;
        private String title;
        private int viewCount;
        private int commentCount;
        private String publishTime;
        private String userName;
        private String cover;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }
    }
}
