/**
 *  * Copyright (c) 2015 Gondor
 * All rights reserved.
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 *
 */

package com.gondor.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gondor.util.XmlConverter;


/**
 *
 * @author Vipin Kumar
 * @created 22-Jun-2015
 *
 *    Application Context Configuration for Gondor
 *
 */
@Configuration
@EnableJpaRepositories ( basePackages = { "com.gondor.repository" })
@PropertySource ( { "classpath:config.properties" })
@EnableTransactionManagement
@ComponentScan ( basePackages = "com.gondor", excludeFilters = {
    @ComponentScan.Filter ( value = Controller.class, type = FilterType.ANNOTATION),
    @ComponentScan.Filter ( value = Configuration.class, type = FilterType.ANNOTATION) })
public class ApplicationContextConfig extends RepositoryRestMvcConfiguration
{


    @Override
    protected void configureRepositoryRestConfiguration( RepositoryRestConfiguration config )
    {
        super.configureRepositoryRestConfiguration( config );
        try {
            config.setBaseUri( new URI( "/api" ) );
        } catch ( URISyntaxException e ) {
            e.printStackTrace();
        }
    }


    @Bean ( name = "dataSource")
    public DataSource getDataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
        dataSource.setUrl( "jdbc:mysql://localhost:3306/usersdb" );
        dataSource.setUsername( "root" );
        dataSource.setPassword( "root" );
        return dataSource;
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter()
    {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql( true );
        adapter.setGenerateDdl( true );
        adapter.setDatabase( Database.MYSQL );
        return adapter;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException
    {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource( getDataSource() );
        factoryBean.setPackagesToScan( "com.gondor.model.orm" );
        factoryBean.setJpaVendorAdapter( jpaVendorAdapter() );
        factoryBean.setJpaProperties( getHibernateProperties() );

        return factoryBean;
    }


    @Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory( entityManagerFactory().getObject() );
        return transactionManager;
    }


    private Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put( "hibernate.show_sql", "true" );
        properties.put( "hibernate.dialect", "org.hibernate.dialect.MySQLDialect" );
        properties.put( "hibernate.hbm2ddl.auto", "create" );
        properties.put( "hibernate.jdbc.batch_size ", 25 );
        return properties;
    }


    @Bean ( autowire = Autowire.BY_TYPE)
    public CastorMarshaller getMarshaller()
    {

        CastorMarshaller marshaller = new CastorMarshaller();
        marshaller.setTargetClass( com.gondor.model.oxm.Configuration.class );
        return marshaller;
    }


    @Bean ( autowire = Autowire.BY_TYPE)
    public XmlConverter getXmlConverter()
    {
        return new XmlConverter( getMarshaller(), getMarshaller() );
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        PropertySourcesPlaceholderConfigurer propertySource = new PropertySourcesPlaceholderConfigurer();
        propertySource.setIgnoreUnresolvablePlaceholders( true );
        return propertySource;
    }
}
