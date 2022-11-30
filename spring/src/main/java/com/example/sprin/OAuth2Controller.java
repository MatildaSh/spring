package com.example.sprin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class OAuth2Controller {
    private final OAuth2AuthorizedClientService oauthService;

    @Autowired
    public OAuth2Controller(
            OAuth2AuthorizedClientService oauthService
    ) {
        this.oauthService = oauthService;
    }

    @GetMapping("/user")
    public Map<String,Object> user(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
    return oAuth2AuthenticationToken.getPrincipal().getAttributes();

    }


}

/*    @Autowired
    public OAuth2Controller(
            OAuth2AuthorizedClientService oauthService
    ) {
        this.oauthService = oauthService;
    }

*/




 /*   @Override
    protected void configure(HttpSecurity http)
        throws Exception{
        http.authorizeRequests(auth->auth
                .antMatchers("/user")
                .permitAll()
                .anyRequest().
                authenticated())
                .antMatcher("/**")
                .oauth2Login();

}     private final OAuth2AuthorizedClientService oauthService;

      @Autowired
      public OAuth2Controller(
            OAuth2AuthorizedClientService oauthService
    ) {
        this.oauthService = oauthService;
    }
   @GetMapping("/user")
    public Map<String, Object> user(
            @AuthenticationPrincipal OAuth2User principal,
            Authentication auth
    ) {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) auth;
        OAuth2AuthorizedClient client =
                oauthService.loadAuthorizedClient(
                        oauthToken.getAuthorizedClientRegistrationId(),
                        oauthToken.getName());

        System.out.println(client.getAccessToken().getTokenValue());
        return principal.getAttributes();
    }
   @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login();
        // @formatter:on
    }*/

