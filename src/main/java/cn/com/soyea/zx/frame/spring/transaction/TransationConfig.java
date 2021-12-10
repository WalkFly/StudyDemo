package cn.com.soyea.zx.frame.spring.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 *
 * @author zx
 * @date 2021/12/10 16:03
 */
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"cn.com.soyea.zx.frame.spring.transaction"})
public class TransationConfig {

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("soyea_commnet_nbiot");
        dataSource.setPassword("SoyeaCommnetNBIOT2018@#");
        dataSource.setUrl("jdbc:mysql://192.9.50.35:4306/demo");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    /**
     *  配置JdbcTemplate Bean组件
     *     <bean class="org.springframework.jdbc.core.JdbcTemplate" id="jdbcTemplate">
     *         <property name="dataSource" ref="dataSource" ></property>
     *     </bean>
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     *  配置事务管理器
     *     <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="transactionManager">
     *         <property name="dataSource" ref="dataSource"></property>
     *     </bean>
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
