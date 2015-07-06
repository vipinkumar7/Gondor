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

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.gondor.dao.impl.UserDAOImpl;
import com.gondor.dao.UserDao;
import com.gondor.model.Cluster;
import com.gondor.model.CoreSite;
import com.gondor.model.HdfsSite;
import com.gondor.model.Hosts;
import com.gondor.model.MapredSite;
import com.gondor.model.Resource;
import com.gondor.model.Role;
import com.gondor.model.Service;
import com.gondor.model.User;
import com.gondor.model.YarnSite;

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
@ComponentScan("com.gondor.controller")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/usersdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "create");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(
				dataSource);
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(HdfsSite.class);
		sessionBuilder.addAnnotatedClasses(Cluster.class);
		sessionBuilder.addAnnotatedClasses(Resource.class);
		sessionBuilder.addAnnotatedClasses(Service.class);
		sessionBuilder.addAnnotatedClasses(CoreSite.class);
		sessionBuilder.addAnnotatedClasses(Hosts.class);
		sessionBuilder.addAnnotatedClasses(MapredSite.class);
		sessionBuilder.addAnnotatedClasses(com.gondor.model.Process.class);
		sessionBuilder.addAnnotatedClasses(Role.class);
		sessionBuilder.addAnnotatedClasses(YarnSite.class);
		sessionBuilder.scanPackages("com.gondor.model");
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="messageConeverter")
	public RequestMappingHandlerAdapter getbean() {
		RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();

		MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();

		List<HttpMessageConverter<?>> msgcon = new ArrayList<HttpMessageConverter<?>>();
		msgcon.add(httpMessageConverter);
		handlerAdapter.setMessageConverters(msgcon);
		return handlerAdapter;
	}
	
	
}
