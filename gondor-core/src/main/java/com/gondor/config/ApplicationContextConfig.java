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

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;
import com.gondor.model.orm.Resource;
import com.gondor.model.orm.Role;
import com.gondor.model.orm.Service;
import com.gondor.model.orm.User;
import com.gondor.util.XmlConverter;


/**
 *
 * @author Vipin Kumar
 * @created 22-Jun-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan ( "com.gondor")
@PropertySource ( "classpath:config.properties")
@EnableTransactionManagement
public class ApplicationContextConfig
{

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


    private Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put( "hibernate.show_sql", "true" );
        properties.put( "hibernate.dialect", "org.hibernate.dialect.MySQLDialect" );
        properties.put( "hibernate.hbm2ddl.auto", "create" );
        properties.put( "hibernate.jdbc.batch_size ", 25 );
        return properties;
    }


    @Bean ( name = "sessionFactory")
    public SessionFactory getSessionFactory( DataSource dataSource )
    {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder( dataSource );
        sessionBuilder.addAnnotatedClasses( User.class );
        sessionBuilder.addAnnotatedClasses( Cluster.class );
        sessionBuilder.addAnnotatedClasses( Resource.class );
        sessionBuilder.addAnnotatedClasses( Service.class );
        sessionBuilder.addAnnotatedClasses( Host.class );
        sessionBuilder.addAnnotatedClasses( Process.class );
        sessionBuilder.addAnnotatedClasses( Role.class );
        sessionBuilder.scanPackages( "com.gondor.model" );
        sessionBuilder.addProperties( getHibernateProperties() );
        return sessionBuilder.buildSessionFactory();
    }


    @Bean ( name = "transactionManager")
    public HibernateTransactionManager getTransactionManager( SessionFactory sessionFactory )
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager( sessionFactory );

        return transactionManager;
    }


    @Bean ( autowire = Autowire.BY_TYPE)
    public CastorMarshaller getMarshaller()
    {

        CastorMarshaller marshaller = new CastorMarshaller();
        marshaller.setTargetClass( com.gondor.model.oxm.SimpleInputXMLConfiguration.class );
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
