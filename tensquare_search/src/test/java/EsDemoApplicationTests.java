import com.tensquare.search.SearchApplication;
import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class EsDemoApplicationTests {

    @Autowired
    private com.tensquare.search.dao.ArticleSearchDao articleSearchDao;

    @Test
    public void insert() {
        Article article = new Article();
        article.setId("3");
        article.setContent("你好啊");
        article.setTitle("测试");
       articleSearchDao.save(article);
    }
    @Test
    public void find() {

        Iterable<Article> all = articleSearchDao.findAll();
        System.out.println(all);
    }
}

