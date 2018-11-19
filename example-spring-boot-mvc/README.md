# Spring boot MVC

**在spring配置mvc的时候，如果没有配置 `HandlerMapping` ，`HandlerAdapter` spring  会取默认配置**

`org.springframework.web.servlet.DispatcherServlet#initHandlerMappings`

```java
...
if (this.handlerMappings == null) {
			this.handlerMappings = getDefaultStrategies(context, HandlerMapping.class);
			if (logger.isDebugEnabled()) {
				logger.debug("No HandlerMappings found in servlet '" + getServletName() + "': using default");
			}
		}
...
```



来源于 `DispatcherServlet.properties` 文件

## 异常处理

* **自动装配**`ErrorMvcAutoConfiguration`

* 默认错误 `org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration.SpelView`

  `handler`处理返回的是`/error`

* 配置错误页面会进入 `BasicErrorController` 使用 `DefaultErrorViewResolver` 处理，在默认情况下会匹配 `ResourceProperties`所配置静态路径进入 `/error/statusCode.html`

  `handler` 返回 `view` 为`DefaultErrorViewResolver.HtmlResourceView`

  `org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver`

  ```java
  @Override
  public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status,
                                       Map<String, Object> model) {
      ModelAndView modelAndView = resolve(String.valueOf(status), model);
      ...
  }
  
  private ModelAndView resolve(String viewName, Map<String, Object> model) {
      String errorViewName = "error/" + viewName;
      ...
      return resolveResource(errorViewName, model);
  }
  private ModelAndView resolveResource(String viewName, Map<String, Object> model) {
      for (String location : this.resourceProperties.getStaticLocations()) {
          try {
              Resource resource = this.applicationContext.getResource(location);
              resource = resource.createRelative(viewName + ".html");
              if (resource.exists()) {
                  return new ModelAndView(new HtmlResourceView(resource), model);
              }
          }
          catch (Exception ex) {
          }
      }
      return null;
  }
  ```
  * `BasicErrorController` 通过遍历 `ErrorViewResolver` 实现来返回 `ModelAndView`

    ```java
    protected ModelAndView resolveErrorView(HttpServletRequest request,
    			HttpServletResponse response, HttpStatus status, Map<String, Object> model) {
    		for (ErrorViewResolver resolver : this.errorViewResolvers) {
    			ModelAndView modelAndView = resolver.resolveErrorView(request, status, model);
    			if (modelAndView != null) {
    				return modelAndView;
    			}
    		}
    		return null;
    	}
    ```

    可以通过自定义 实现`ErrorViewResolver` 进行扩展

* 配置 `ErrorPageRegistrar` 接口 

  ```java
  @Override
  public void registerErrorPages(ErrorPageRegistry registry) {
      registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/public/400.html"));
  }
  ```

  **页面前缀会使用 `org.springframework.boot.autoconfigure.web.ResourceProperties`配置静态**

  ```java
  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
  			"classpath:/META-INF/resources/", "classpath:/resources/",
  			"classpath:/static/", "classpath:/public/" };
  ```

  `org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory`

  ```java
  protected void configureContext(Context context,
  			ServletContextInitializer[] initializers) {
  
      ...
      for (ErrorPage errorPage : getErrorPages()) {
          new TomcatErrorPage(errorPage).addToContext(context);
      }
      ...
  
  }
  ```

  使用 `org.apache.catalina.core.StandardHostValve`

  ```java
  protected void throwable(Request request, Response response,
                               Throwable throwable) {
          ...
  
          ErrorPage errorPage = findErrorPage(context, throwable);
          if ((errorPage == null) && (realError != throwable)) {
              errorPage = findErrorPage(context, realError);
          }
  
         ...
  }
  
  
  private static ErrorPage findErrorPage
          (Context context, Throwable exception) {
          ...
          while (!Object.class.equals(clazz)) {
              ErrorPage errorPage = context.findErrorPage(name);
              if (errorPage != null) {
                  return (errorPage);
              }
           ...
       }
       return (null);
  
  }
  private void status(Request request, Response response) {
        ...
          ErrorPage errorPage = context.findErrorPage(statusCode);
          if (errorPage == null) {
              // Look for a default error page
              errorPage = context.findErrorPage(0);
          }
       ...  
  }
  
  
  ```

  重定向 到错误页面 默认是 /error 如果有配置直接定向错误页面

  ```java
  private boolean custom(Request request, Response response,
                               ErrorPage errorPage) {
  
      ...
          try {
              ...
              RequestDispatcher rd =
                  servletContext.getRequestDispatcher(errorPage.getLocation());
              ...
  
              if (response.isCommitted()) {
                  rd.include(request.getRequest(), response.getResponse());
              } else {
                  // Reset the response (keeping the real error code and message)
                  response.resetBuffer(true);
                  response.setContentLength(-1);
  
                  rd.forward(request.getRequest(), response.getResponse());
                  response.setSuspended(false);
              }
              ...
              return true;
  
          } catch (Throwable t) {
             ...
  
          }
      }
  ```

* 使用`@ControllerAdvice` `RestControllerAdvice` 全局异常处理，只处理服务器异常情况，该处理会优先于默认配置



### Servlet 规范错误常量

* `javax.servlet.error.exception`   异常
* `javax.servlet.error.status_code ` 错误码



## 静态资源

[参考范文](https://blog.coding.net/blog/spring-static-resource-process)

### webjars

**在`springboot`打包成jar包时是访问不到其`css` `js`资源的，需要`webjars`资源定义才能访问到**

```java
public class WebJarsResourceResolver extends AbstractResourceResolver {

	private static final String WEBJARS_LOCATION = "META-INF/resources/webjars/";
    ...
}
```

```properties
spring.resources.staticLocations[0]=classpath:/static
```



*放入到`webjars`路径下打包成 `jar` 包可以访问到否则 `404`*





## 内容协商

内容基于`org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties`配置

* `spring.mvc.pathmatch.use-registered-suffix-pattern=true`

  在`url`请求时`springboot` 默认禁用后缀模式匹配 意味着`/index/get.json` 匹配不到 `GetMapping("/index/get")`, 该配置打开后缀模式匹配 

  `http://localhost:8080/index/get.json`  

  `ResponseHeader` -> `Content-Type: application/json;charset=UTF-8`

  `spring.mvc.contentnegotiation.favor-path-extension=true` 

  着`index/get.html` 则不能访问

* `spring.mvc.contentnegotiation.media-types.markdown=text/markdown`

  请求地址为`http://localhost:8080/index/get.markdown` 添加媒体类型，可以通过后缀区分返回

  `Content-Type`

* `spring.mvc.contentnegotiation.favor-parameter=true`

  `springBoot` 还提供 参数名称 默认参数名称为`format` ，请求可以通过`/index/get?format=json`

  可以通过`spring.mvc.contentnegotiation.parameter-name=myParameter`修改参数名称定义

  `/index/get?myParameter=json`



## 自动装配

### Servlet SPI

**`javax.servlet.ServletContainerInitializer`** 在`tomcat` 容器启动的时候会调用该接口实现

#### Spring 扩展

* `org.springframework.web.SpringServletContainerInitializer`

  `Spring`封装简化处理 使用 `@HandlerTypes` 过滤指定`class`

  * `org.springframework.web.WebApplicationInitializer`
    * `AbstractContextLoaderInitializer`
      * `AbstractDispatcherServletInitializer` 编程驱动
        * `AbstractAnnotationConfigDispatcherServletInitializer` 注解驱动
  * `org.springframework.boot.web.servlet.support.SpringBootServletInitializer`

* `org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory.Initializer `

  `Spring`封装简化处理 使用 `@HandlerTypes` 过滤指定`class`

  * `org.springframework.boot.web.servlet.ServletContextInitializer`

    * `ServletRegistrationBean`

      * `DispatcherServletRegistrationBean` 来源 `DispatcherServletAutoConfiguration`

        

### Spring Boot 自动装配

* `DispatcherServlet`  -> `DispatcherServletAutoConfiguration`
* `EnableWebMvc` ->  `WebMvcAutoConfiguration`
* `Servlet` 容器 -> ` ServletWebServerFactoryAutoConfiguration `



### Spring Boot 嵌入式容器

* `org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory`

* `org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory`

* `org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory`

* `org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory`

* `org.springframework.boot.web.embedded.tomcat.TomcatReactiveWebServerFactory`

* `org.springframework.boot.web.embedded.jetty.JettyReactiveWebServerFactory`

* `org.springframework.boot.web.embedded.undertow.UndertowReactiveWebServerFactory`

* 核心代码提取

  ```java
          TomcatServletWebServerFactory tomcatServletWebServerFactory =
                  new TomcatServletWebServerFactory(8080);
  
  
          ServerProperties serverProperties = new ServerProperties();
          TomcatServletWebServerFactoryCustomizer customizer = new TomcatServletWebServerFactoryCustomizer(serverProperties);
          customizer.customize(tomcatServletWebServerFactory);
  
          WebMvcProperties webMvcProperties = new WebMvcProperties();
          DispatcherServlet dispatcherServlet = new DispatcherServlet();
          dispatcherServlet.setDispatchOptionsRequest(
                  webMvcProperties.isDispatchOptionsRequest());
          dispatcherServlet.setDispatchTraceRequest(
                  webMvcProperties.isDispatchTraceRequest());
          dispatcherServlet.setThrowExceptionIfNoHandlerFound(
                  webMvcProperties.isThrowExceptionIfNoHandlerFound());
          ServletContextInitializer servletContextInitializer = new DispatcherServletRegistrationBean(dispatcherServlet,"/");
          WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContextInitializer);
  
          webServer.start();
  ```

  

* 依赖顺序

  `org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration`

  * `org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration`
    * `org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration`
      * `ServletWebServerFactoryConfiguration.EmbeddedTomcat`
        * `TomcatServletWebServerFactory`
      * `ServletWebServerFactoryConfiguration.EmbeddedJetty`
        * `JettyServletWebServerFactory`
      * `ServletWebServerFactoryConfiguration.EmbeddedUndertow`
        * `UndertowServletWebServerFactory`

* `TomcatServletWebServerFactoryCustomizer` 与 `TomcatServletWebServerFactory` 关系

  通过`org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor` 前置初始化处理

  ```java
  ...
  private void postProcessBeforeInitialization(WebServerFactory webServerFactory) {
  		LambdaSafe
  				.callbacks(WebServerFactoryCustomizer.class, getCustomizers(),
  						webServerFactory)
  				.withLogger(WebServerFactoryCustomizerBeanPostProcessor.class)
  				.invoke((customizer) -> customizer.customize(webServerFactory));
  	}
  ...
  ```

  在 `ServletWebServerFactoryAutoConfiguration.BeanPostProcessorsRegistrar` 注册 `WebServerFactoryCustomizerBeanPostProcessor` ` 实体