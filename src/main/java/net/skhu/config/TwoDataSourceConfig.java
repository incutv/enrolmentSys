//package net.skhu.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//@Configuration
//@MapperScan(value = "net.skhu.mapper.read", sqlSessionFactoryRef = "factory2")
//public class TwoDataSourceConfig {
//    @Bean(name = "datasource2")
//    @ConfigurationProperties(prefix = "spring.datasource.read")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "factory2")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource2") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mapper/read/*.xml"));
//        return sqlSessionFactory.getObject();
//    }
//
//    @Bean(name = "sqlSession2")
//    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
