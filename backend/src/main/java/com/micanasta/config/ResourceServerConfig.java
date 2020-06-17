package com.micanasta.config;

import com.micanasta.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

//Determinar que URL se deben proteger
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private ResourceServerTokenServices tokenServices;

	@Value("${security.jwt.resource-ids}")
	private String resourceIds;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(resourceIds).tokenServices(tokenServices);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().authenticationEntryPoint(new AuthException()).and().requestMatchers().and()
				.authorizeRequests().antMatchers("/heartbeat/**").anonymous().antMatchers("/swagger-ui.html")
				.anonymous().antMatchers("/webjars/**").anonymous().antMatchers("/usuarios").anonymous()
				.antMatchers("**").access("#oauth2.hasScope('write')");
	}

}
