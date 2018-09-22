package br.com.avantis.entregue.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // É possível configurar para buscar info no banco de dados
                .withClient("entregueapp")
                .secret("3ntr3gu3ap1")
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token") // permite obter novo access_token através do refresh_token
                .accessTokenValiditySeconds(1800) // 20 segundos para testes com refresh token
                .refreshTokenValiditySeconds(3600 * 24); // refresh_token válido por 1 dia
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore()) // É necessário armazenar o token em alguma lugar
                .accessTokenConverter(accessTokenConverter())
                .reuseRefreshTokens(false) // "Sempre que eu pedir um novo access_token usando refresh_token, um novo refresh_token será enviado"
                .authenticationManager(authenticationManager);
        // o angular buscará o token aqui e depois retornará esse string para que seja possível acessar a API
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("3ntr3gu3ap1");
        return accessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

}
