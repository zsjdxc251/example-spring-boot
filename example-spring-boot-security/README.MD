







## Security Spring

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