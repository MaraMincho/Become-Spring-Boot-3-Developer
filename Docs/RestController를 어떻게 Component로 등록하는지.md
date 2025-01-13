# @RestController
@RestController를 클릭시 `RestController.java`로 이동합니다.

```java
package org.springframework.web.bind.annotation;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController {
    @AliasFor(
        annotation = Controller.class
    )
    String value() default "";
}

```

상기 코드는 @Controller, @ResponseBody 에너테이션이 함께 있습니다. 코드를 보면 @Controller 애너테이션에 @ResponseBody애너테이션이 합쳐진 결과물이 @RestController 애너테이션임을 알 수 있습니다.  Controller를 다시 depth를 타게 되면 `Controller.java`의 구현체로 이동하게 됩니다. 


```java

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.springframework.stereotype;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Controller {
    @AliasFor(
        annotation = Component.class
    )
    String value() default "";
}

```

`@Controller`에너테이션에서 `@Component`애너테이션을 갖고 있습니다. 따라서 @Controller 는 Component를 등록하는데 도움을 줍니다. 

+ @Configuration, @Repository, @Service 애너테이션 모두 @Component 애너테이션을 갖고 있습니다. 

