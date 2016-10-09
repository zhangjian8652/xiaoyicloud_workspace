package com.joker.modules.web.directive;

import com.joker.common.util.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * @Author zhangjian
 * @Date 2015/9/5
 */
public class DefaultDirective implements TemplateDirectiveModel {
    /**
     *
     * @param environment
     * @param map 输入参数map对象
     * @param loopVars 输出变量数组
     * @param templateDirectiveBody
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] loopVars, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        String ss =   DirectiveUtils.getString("a",map);
        templateDirectiveBody.render(environment.getOut());

    }
}
