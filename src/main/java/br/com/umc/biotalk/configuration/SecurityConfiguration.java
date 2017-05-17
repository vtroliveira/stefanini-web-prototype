package br.com.umc.biotalk.configuration;

/*  
 * Fornece uma classe abstrata como base para a criação de uma instância de WebSecurityConfigurer. 
 * 
 * autor: Ana Carolina
 * **/

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 
	
	/*
	 * Interface que fornece um método padrão para trabalhar com conexões de banco de dados.
	 * **/
	
	@Autowired
	private DataSource primaryDatasource; 
	
	/*
	 * Mapeamento da query de login spring.queries.login-query declarada no properties.
	 * **/
	@Value("${spring.queries.login-query}") 
	private String loginQuery;	
	
	@Value("${spring.queries.auth-query}") 
	private String authQuery;	
	
	/*
	 * Método sobrescrito de WebSecurityConfigurerAdapter usado para padrão de implementação de authenticationManager() 
	 * na tentativa de obter um gerenciamento de autenticação.
	 * **/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(loginQuery)	// Obtem a query. 
				.authoritiesByUsernameQuery(authQuery)
				.dataSource(primaryDatasource);		//Obtem conexão com o banco de dados.
	}

	/*
	 * Sobrescrita de método para configuração do HttpSecurity.
	 * **/
	@Override
	protected void configure(HttpSecurity http) throws Exception { 	
		http.
		authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/forgotPassword").permitAll()
			.anyRequest()
			.authenticated().and().csrf().disable().formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.defaultSuccessUrl("/index")
			.usernameParameter("user")
			.passwordParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/forgotPassword");
	}
	
	/*
	 * Sobrescrita de método para configuração do WebSecurity.
	 * **/
	@Override
	public void configure(WebSecurity web) throws Exception {	
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
}
