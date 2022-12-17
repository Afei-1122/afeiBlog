package com.aurora.annotation;

import java.lang.annotation.*;

/**
 * @author aFei
 * 操作日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {

    /**
     * @return 操作类型
     */
    String optType() default "";
}
