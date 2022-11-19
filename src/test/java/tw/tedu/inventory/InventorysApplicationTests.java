package tw.tedu.inventory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventorysApplicationTests {

    @Autowired
    DataSource datasource;

    // 定義一個 Logger 記錄器物件，名字為Main類的全限定名，即 com.nobody.Main
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
                // 在 info 級別上輸出紀錄檔 Hello Logback!
        logger.info("Hello Logback!");

    }

    @Test
    public void getConnection() throws SQLException {
        Connection conn = datasource.getConnection();
        System.err.println(conn);
    }



}
