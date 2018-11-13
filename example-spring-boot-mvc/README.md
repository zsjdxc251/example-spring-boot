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
