package com.DadoSoft.DadoVentas;

import com.DadoSoft.DadoVentas.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    UsuariosServicio usuarioServicios;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder administreadorDeAutenticaciones) throws Exception {
        administreadorDeAutenticaciones
                .userDetailsService(usuarioServicios)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .antMatchers("/admin/*").hasRole("ADMINISTRADOR")
                .antMatchers("/css/*", "/js/*", "/img/*", "/**")
                .permitAll()
        /*.and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loguearse")
                .usernameParameter("usr")
                .passwordParameter("pass")
                .defaultSuccessUrl("/PaginaPrincipal")
                .failureUrl("/failLoad")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/PaginaPrincipal")
                .permitAll()  */
                .and().csrf()
                .disable();
    }

}
