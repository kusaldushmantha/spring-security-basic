package com.spring.security.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * Purpose: App configuration for the Spring MVC security project
 * Created By: Kusal Kankanamge
 * Created On: 01-May-2020
 */
@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.spring.security.demo" )
@PropertySource( "classpath:persistence-mysql.properties" )
public class DemoAppConfig
{

    private final Logger LOGGER = Logger.getLogger( getClass().getName() );

    @Autowired
    private Environment env;

    /**
     * This sets up the view resolver
     *
     * @return {@link ViewResolver} viewResolver
     */
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix( "/WEB-INF/view/" );
        internalResourceViewResolver.setSuffix( ".jsp" );
        return internalResourceViewResolver;
    }

    @Bean
    public DataSource securityDataSource()
    {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try
        {
            comboPooledDataSource.setDriverClass( env.getProperty( "jdbc.driver" ) );

            LOGGER.info( ">>>> JDBC URL : " + env.getProperty( "jdbc.url" ) );
            LOGGER.info( ">>>> JDBC USER : " + env.getProperty( "jdbc.user" ) );

            comboPooledDataSource.setJdbcUrl( env.getProperty( "jdbc.url" ) );
            comboPooledDataSource.setUser( env.getProperty( "jdbc.user" ) );
            comboPooledDataSource.setPassword( env.getProperty( "jdbc.password" ) );

            comboPooledDataSource.setInitialPoolSize( Integer.parseInt( env.getProperty( "connection.pool.initialPoolSize" ) ) );
            comboPooledDataSource.setMinPoolSize( Integer.parseInt( env.getProperty( "connection.pool.minPoolSize" ) ) );
            comboPooledDataSource.setMaxPoolSize( Integer.parseInt( env.getProperty( "connection.pool.maxPoolSize" ) ) );
            comboPooledDataSource.setMaxIdleTime( Integer.parseInt( env.getProperty( "connection.pool.maxIdleTime" ) ) );

        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }
}
