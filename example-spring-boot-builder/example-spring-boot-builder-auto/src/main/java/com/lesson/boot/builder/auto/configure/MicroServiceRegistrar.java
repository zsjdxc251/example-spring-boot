package com.lesson.boot.builder.auto.configure;

import com.lesson.boot.builder.auto.service.CacheService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2018/11/16.
 */

public class MicroServiceRegistrar implements ImportSelector {

    @Nonnull
    @Override
    public String[] selectImports(@Nonnull AnnotationMetadata importingClassMetadata) {


        Map<String,Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableMicroService.class.getName());
        if (attributes != null){
            AnnotationAttributes annotationAttributes = new AnnotationAttributes(attributes);
        }



        return StringUtils.splitPreserveAllTokens(CacheService.class.getName());
    }
}
