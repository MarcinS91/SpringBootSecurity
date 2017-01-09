package com.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username = ?")
				.authoritiesByUsernameQuery("select username, authority from authorities where username = ?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/hello").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and()
				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and()
				.logout().logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403").and()
				.csrf();
	}
}
