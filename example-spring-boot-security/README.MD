







## Security · Servlet

### WebApplicationInitializer

* javax.servlet.ServletContainerInitializer

  * org.springframework.web.SpringServletContainerInitializer

    * org.springframework.web.WebApplicationInitializer

      * org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer

      * 进入 `onStartup` 方法

      * 初始化  `org.springframework.web.filter.DelegatingFilterProxy`

        `org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer#insertSpringSecurityFilterChain`

### FilterChainProxy

* 生产 生成被代理 filter
  * org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
    * `org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration#springSecurityFilterChain`
  
* 程序经过调用之后会进入 `DelegatingFilterProxy`
  * 然后委派给 `FilterChainProxy`  然后进入 `org.springframework.security.web.FilterChainProxy.VirtualFilterChain`
  * 迭代交给其他`filter` 处理
  
* `Firewalled`
  
  * 在`org.springframework.security.web.FilterChainProxy#doFilterInternal` 处理中转为`FirewalledRequest`
  
* `org.springframework.security.web.SecurityFilterChain` 接口

  * 默认实现 `DefaultSecurityFilterChain` 

  * 在 `FilterChainProxy` 代理之后 遍历寻找进入哪个 `Chain` 然后获取到 `Filter` 列表

    ```java
    org.springframework.security.web.FilterChainProxy#doFilterInternal;
    	private void doFilterInternal(ServletRequest request, ServletResponse response,
    			FilterChain chain) throws IOException, ServletException {
    
    		FirewalledRequest fwRequest = firewall
    				.getFirewalledRequest((HttpServletRequest) request);
    		HttpServletResponse fwResponse = firewall
    				.getFirewalledResponse((HttpServletResponse) response);
    
    		List<Filter> filters = getFilters(fwRequest);
    
    		if (filters == null || filters.size() == 0) {
    			if (logger.isDebugEnabled()) {
    				logger.debug(UrlUtils.buildRequestUrl(fwRequest)
    						+ (filters == null ? " has no matching filters"
    								: " has an empty filter list"));
    			}
    
    			fwRequest.reset();
    
    			chain.doFilter(fwRequest, fwResponse);
    
    			return;
    		}
    
    		VirtualFilterChain vfc = new VirtualFilterChain(fwRequest, chain, filters);
    		vfc.doFilter(fwRequest, fwResponse);
    	}
    	private List<Filter> getFilters(HttpServletRequest request) {
    		for (SecurityFilterChain chain : filterChains) {
    			if (chain.matches(request)) {
    				return chain.getFilters();
    			}
    		}
    
    		return null;
    	}
    ```



### HttpSecurity

* `HttpSecurity` 核心是`Filter`

* 每一个Filter 对应一个功能

  * `org.springframework.security.web.csrf.CsrfFilter`
  * `org.springframework.security.web.header.HeaderWriterFilter`
  * `org.springframework.security.web.session.SessionManagementFilter`
  * `org.springframework.web.filter.CorsFilter`
  * `org.springframework.security.web.access.ExceptionTranslationFilter`
    * 该接口过滤器用于处理处理异常情况捕捉 401 和 403
  * `org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter`
    * 需要认证的过滤器实现继承`org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter`通过该接口方法实现
    * 认证成功回调`org.springframework.security.web.authentication.session.SessionAuthenticationStrategy` 实现方法
  * `org.springframework.security.web.access.intercept.FilterSecurityInterceptor`
    * 实现权限控制核心过滤器 `org.springframework.security.access.intercept.AbstractSecurityInterceptor`
  * `org.springframework.security.web.authentication.AnonymousAuthenticationFilter`
    * 用于处理`SecurityContextHolder#getContext()` 为空是设置为匿名`AnonymousAuthenticationToken`

* Filter 扩展配置

  * `org.springframework.security.config.annotation.web.configurers.CsrfConfigurer`

  * `org.springframework.security.config.annotation.web.configurers.HeadersConfigurer`

  * `org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer`

  * `org.springframework.security.config.annotation.web.configurers.CorsConfigurer`

  * `org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer`

    * `HttpSecurity#exceptionHandling()`  该返回返回`Configurer`

    * `ExceptionHandlingConfigurer#accessDeniedHandler` 用于处理 没有权限的情况
    * `ExceptionHandlingConfigurer#authenticationEntryPoint` 用于处理认证失败的情况

  * `org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer`

  * `org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer`

    * `HttpSecurity#authorizeRequests()`

  * `org.springframework.security.config.annotation.web.configurers.AnonymousConfigurer`

* Filter 内置排序

  * `org.springframework.security.config.annotation.web.builders.FilterComparator` 通过该类实现内部排序

* 禁止掉Filter

  * `AbstractHttpConfigurer#disable`

* 扩展

  * 通过`org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder#apply(C)` 实现可配置的Buildr式Filter
  * 也可以通过`org.springframework.security.config.annotation.web.builders.HttpSecurity#addFilter` 添加策略Filter

* 

### WebSecurity

* `WebSecurity` 核心是`Chain`
* `WebSecurity#ignoring` 处理忽略不仅过核心`Chain`
  * `WebSecurity#addSecurityFilterChainBuilder` 自定义 Chain



### Security Core

* `AuthenticationManager`
  * 默认实现`org.springframework.security.authentication.ProviderManager`
* `AuthenticationProvider`
* `Authentication`
  * `Authentication#getAuthorities`
    * 辅助工具类`AuthorityUtils`
* `UserDetailsService`
  * `UserDetails`
    * `UserDetails#getAuthorities`
      * 用于存储用户角色或者其他标识用户权限信息
* `SecurityContextHolder`
* `AbstractSecurityInterceptor`
  * `MethodSecurityInterceptor` 
  * `FilterSecurityInterceptor`  Web Servlet 的实现拦截器权限
* `AccessDecisionManager`
* `SecurityMetadataSource`