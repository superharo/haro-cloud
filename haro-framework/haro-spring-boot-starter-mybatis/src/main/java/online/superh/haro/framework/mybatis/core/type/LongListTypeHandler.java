package online.superh.haro.framework.mybatis.core.type;

import cn.hutool.core.collection.CollUtil;
import online.superh.haro.framework.common.util.string.StrUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *         List<Long> 的类型转换器实现类，对应数据库的 varchar 类型
 * @date: 2023-09-08 15:31
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class LongListTypeHandler  implements TypeHandler<List<Long>> {
    private static final String COMMA = ",";


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<Long> longs, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, CollUtil.join(longs, COMMA));
    }

    @Override
    public List<Long> getResult(ResultSet resultSet, String columnName) throws SQLException {
        String value = resultSet.getString(columnName);
        return getResult(value);
    }

    @Override
    public List<Long> getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String value = resultSet.getString(columnIndex);
        return getResult(value);
    }

    @Override
    public List<Long> getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String value = callableStatement.getString(columnIndex);
        return getResult(value);
    }

    private List<Long> getResult(String value) {
        if (value == null) {
            return null;
        }
        return StrUtils.splitToLong(value, COMMA);
    }

}
