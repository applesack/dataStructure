package test.sqlite;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月05日 21:25
 */

@Slf4j
public class DAO {

    private final Connection connection;
    private static final String URL_PREFIX = "jdbc:sqlite:";
    private static final String File_PREFIX =
            Paths.get("src", "main", "java", "test", "sqlite", "db")
                    .toString();
    private static final String FILE_POSTFIX = ".db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            log.warn("连接异常");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * 初始化
     */
    DAO(String dbName) throws SQLException {
        connection = DriverManager
                .getConnection(URL_PREFIX + File_PREFIX + File.separator +  dbName + FILE_POSTFIX);
//        log.info("获取连接成功: " + connection.getCatalog());
    }

}
