# Spring boot MVC

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

  