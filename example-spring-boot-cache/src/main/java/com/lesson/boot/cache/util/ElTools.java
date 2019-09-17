package com.lesson.boot.cache.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.ObjectUtils;

public class ElTools {

    static ExpressionParser parser = new SpelExpressionParser();


    public static String after(String before,String[] paramsNames,Object[] args) {

        Expression exp = parser.parseExpression(before);

        EvaluationContext context = new StandardEvaluationContext();

        if (ObjectUtils.isEmpty(args)){
            return null;
        }

        for (int i=0;i<args.length;i++) {
            context.setVariable(paramsNames[i],args[i]);

        }


        return exp.getValue(context,String.class);



    }
    public static String afterTemplate(String before,String[] paramsNames,Object[] args) {

        Expression exp = parser.parseExpression(before);


        ParserContext context = new TemplateParserContext();

        if (ObjectUtils.isEmpty(args)){
            return null;
        }


        return exp.getValue(context,String.class);

    }

    public static void main(String[] args) {


        System.out.println();
    }

}
