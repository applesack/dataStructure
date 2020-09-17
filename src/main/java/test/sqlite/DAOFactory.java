package test.sqlite;

import java.sql.SQLException;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月05日 22:18
 */
public class DAOFactory {

    public static DAO getDAO(String dbName) {
        DAO dao = null;

        try {
            dao = new DAO(dbName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return dao;
    }

    public static void main(String[] args) {
//        getDAO("test");
        int res = 30 % (10^9 + 7);
        int f = (10^9 + 7);
        System.out.println(10 ^ 9 + 7);
        System.out.println(10 ^ (9 + 7));
        System.out.println((10 ^ 9) + 7);
        System.out.println(30 % 10);
        System.out.println(30 % (10 ^ (9 + 7)));
    }
}
