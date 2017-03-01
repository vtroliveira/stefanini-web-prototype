package br.com.stefanini.progress.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { // Fornece uma classe abstrata como base para a criação de uma instância de WebSecurityConfigurer. 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;	// Implementação de criptografia usando hash.

	@Autowired
	private DataSource dataSource; // Interface que fornece um método padrão para trabalhar com conexões de banco de dados.
	
	@Value("${spring.queries.login-query}") // Mapeamento da query estabelecida no properties.
	private String loginQuery;	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) // Método sobrescrito de WebSecurityConfigurerAdapter usado para padrão de implementação de authenticationManager() na tentativa de obter um gerenciamento de autenticação.
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(loginQuery)	// Obtem a query. 
				.dataSource(dataSource)		//Obtem conexão com o banco de dados.
				.passwordEncoder(bCryptPasswordEncoder);	// Criptografa a senha.
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception { 	//Sobrescrita de método para configuração do HttpSecurity.
		http.
		authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/register").permitAll().anyRequest()
			.authenticated().and().csrf().disable().formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.defaultSuccessUrl("/index")
			.usernameParameter("usuario")
			.passwordParameter("senha")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/forgotPassword");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {	//Sobrescrita de método para configuração do WebSecurity.
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
}
