package com.yc.init;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
public class SocialConfig {
	
	@Resource
	private Environment env;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory(
				env.getRequiredProperty("facebook.clientId"),
				env.getRequiredProperty("facebook.clientSecret")));
		return registry;
	}
	
	@Bean
	public TextEncryptor textEncryptor() {
		return Encryptors.noOpText();
	}
	
	 @Bean
	 public UsersConnectionRepository usersConnectionRepository() {
		 return new JdbcUsersConnectionRepository(dataSource,
			 connectionFactoryLocator(),
			 textEncryptor());
	 }
	 
	 @Bean
	 @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	 public ConnectionRepository connectionRepository() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 if (authentication == null)
			 throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		 return usersConnectionRepository().createConnectionRepository(authentication.getName());
	 }
	 
	 @Bean
	 public ConnectController connectController() {
		 ConnectController controller = new ConnectController(connectionFactoryLocator(), connectionRepository());
		 controller.setApplicationUrl(env.getRequiredProperty("application.url"));
		 return controller;
	 }

}
