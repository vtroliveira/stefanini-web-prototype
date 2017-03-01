package br.com.stefanini.progress.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.login-query}")
	private String loginQuery;
	
	@Value("${spring.queries.profile-query}")
	private String profileQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception{
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(loginQuery)
				.authoritiesByUsernameQuery(profileQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.
			authorizeRequests()
				.antMatchers("/")
					.permitAll()
				.antMatchers("/login")
					.permitAll()
				.antMatchers("/registration")
					.permitAll()
				.antMatchers("/progress/**")
					.hasAuthority("USER")
						.anyRequest()
				.authenticated()
			.and()
				.csrf()
				.disable()
				.formLogin()
					.loginPage("/login")
						.failureUrl("/login?error=true")
						.usernameParameter("usuario")
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
