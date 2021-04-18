package java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2020-01-08 18:08
 */
public class SortTest {
    /**
     * list集合排序 倒序排序
     * @author hanqingsong
     * @date 2020-06-11
     */
    @Test
    public void sort(){
        List<Article> articleList = new ArrayList<Article>(10);
        Long current = System.currentTimeMillis();
        articleList.add(new Article(true, 1, 1, 5));
        articleList.add(new Article(false, 2, 0, 5));
        articleList.add(new Article(true, 3, 0, 3));
        articleList.add(new Article(false, 2, 0, 8));
        articleList.add(new Article(true, 1, 1, 1));
        articleList.add(new Article(true, 3, 1, 2));

        // 广告 时间
        // 话题类型  参与人数 时间
        articleList.sort(Comparator.comparing(Article::getAd).reversed()
                .thenComparing(Comparator.comparingInt(Article::getSubtype).reversed())
                .thenComparing(Comparator.comparingInt(Article::getJoinNum).reversed())
                .thenComparing(Comparator.comparingInt(Article::getCreateTime).reversed()));
        articleList.forEach(System.out::println);

        /**
         * 按views倒序排列
         */
        // articleList.sort(Comparator.comparing(Article::getViews).reversed());
        // System.out.println(articleList);
        /**
         * 先按views倒序，再按comments倒序
         */
        // articleList.sort(Comparator.comparingInt(Article::getViews).reversed().
        //         thenComparing(Comparator.comparingInt(Article::getComments).reversed()));
        // System.out.println(articleList);
        //[Article{articleId=1002, title='第二篇文章', views=29, comments=3, createTime=1548830876084},
        // Article{articleId=1001, title='第一篇文章', views=10, comments=5, createTime=1548830875084},
        // Article{articleId=1004, title='第四篇文章', views=9, comments=2, createTime=1548830880084},
        // Article{articleId=1003, title='第三篇文章', views=9, comments=1, createTime=1548830880084}]
    }

}
