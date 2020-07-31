package com.lesson.boot.jdbc.mybatis;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author zhengshijun
 * @version created on 2020/7/31.
 */
public class Exist extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {

        String sql = "<script>%s SELECT %s FROM %s %s %s %s\n</script>";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql,
                sqlFirst(), "1", tableInfo.getTableName(),
                sqlWhereEntityWrapper(true, tableInfo), sqlComment(),"limit 1;"), modelClass);
        return this.addSelectMappedStatementForOther(mapperClass, "exist", sqlSource, Boolean.class);
    }
}
