package cn.appsys.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * MyBatis的工具类
 */

public class MyBatisUtils {

    private static SqlSessionFactory factory;
    static {
        try {
            String file = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(file);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开会话对象，指定事务是否自动提交：true--自动提交，false--关闭自动提交
     * @return
     */
    public static SqlSession openSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    /**
     * 打开会话对象，事务模式为自动提交
     * @return
     */
    public static SqlSession openSession() {
        return factory.openSession();
    }

    /**
     * 关闭会话
     * @param session
     */
    public static void closeSession(SqlSession session) {
        if(null != session) {
            session.close();
        }
    }
}
