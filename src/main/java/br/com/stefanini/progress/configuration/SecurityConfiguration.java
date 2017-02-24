package br.com.stefanini.progress.configuration;

import javax.sql.DataSource;

import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private DataSource dataSource;
	
	private String userQuery;
	
	private String rolesQuery;
	
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception{
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(userQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource);
//				.passwordEnconder();
		
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		
		http.
			authorizeRequests()
				.antMatchers("/").
					permitAll()
				.antMatchers("/progress/**")
					.hasAuthority("")
						.anyRequest()
				.authenticated()
			.and()
				.csrf()
				.disable()
				.formLogin()
					.loginPage("/login")
						.failureUrl("/login?error=true")
						.usernameParameter("login")
						.passwordParameter("password")
						.defaultSuccessUrl("progress/index")
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
