package online.superh.haro.framework.mybatis.core.type;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 *          字段字段的 TypeHandler 实现类，基于 {@link cn.hutool.crypto.symmetric.AES} 实现
 * @date: 2023-09-07 16:49
 */
public class EncryptTypeHandler extends BaseTypeHandler<String> {

    private static final String ENCRYPTOR_PROPERTY_NAME = "mybatis-plus.encryptor.password";

    private static AES aes;


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, encrypt(parameter));
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String parameter) throws SQLException {
        String value = resultSet.getString(parameter);
        return decrypt(value);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String value = resultSet.getString(i);
        return decrypt(value);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String value = callableStatement.getString(i);
        return decrypt(value);
    }

    private static String decrypt(String value) {
        if (value == null) {
            return null;
        }
        return getEncryptor().decryptStr(value);
    }

    public static String encrypt(String rawValue) {
        if (rawValue == null) {
            return null;
        }
        return getEncryptor().encryptBase64(rawValue);
    }
    
    private static AES getEncryptor() {
        if (aes != null) {
            return aes;
        }
        // 构建 AES
        String password = SpringUtil.getProperty(ENCRYPTOR_PROPERTY_NAME);
        Assert.notEmpty(password, "配置项({}) 不能为空", ENCRYPTOR_PROPERTY_NAME);
        aes = SecureUtil.aes(password.getBytes());
        return aes;
    }

}
