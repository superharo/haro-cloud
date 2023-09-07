package online.superh.haro.framework.mybatis.core.enums;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-07 10:39
 */
public class SqlConstants {


    /**
     * 数据库的类型
     */
    public static DbType DB_TYPE;

    public static void init(DbType dbType) {
        DB_TYPE = dbType;
    }

}
