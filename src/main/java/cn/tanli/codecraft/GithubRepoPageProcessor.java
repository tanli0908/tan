//package cn.tanli.codecraft;
//
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//
///**
// * @ClassName GithubRepoPageProcessor
// * @Description TODO
// * @Author Tan.li
// * @Date 2021-03-24
// * @Since 1.0
// */
//public class GithubRepoPageProcessor implements PageProcessor {
//
//    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
//
//    /**
//     * process the page, extract urls to fetch, extract the data and store
//     *
//     * @param page page
//     */
//    @Override
//    public void process(Page page) {
//        page.addTargetRequests(page.getHtml().links().regex("(https://gitee\\.com/\\w+/\\w+)").all());
//        page.putField("author", page.getUrl().regex("https://gitee\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//
//
//    }
//
//    /**
//     * get the site settings
//     *
//     * @return site
//     * @see Site
//     */
////    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    public static void main(String[] args) {
//        Spider.create(new GithubRepoPageProcessor()).addUrl("https://gitee.com/lvyeyou").thread(5).run();
//    }
//}
