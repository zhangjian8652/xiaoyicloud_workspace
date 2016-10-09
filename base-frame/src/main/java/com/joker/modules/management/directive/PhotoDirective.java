package com.joker.modules.management.directive;

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
 * @Date 2015/11/21
 */
public class PhotoDirective implements TemplateDirectiveModel {
    private final static String TYPE_ENTITY = "entity";
    private final static String TYPE = "type";
    private final static String USER_ID = "userid";

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String type = DirectiveUtils.getString(this.TYPE,map);
        if(!type.isEmpty() && this.TYPE_ENTITY.equals(type)){
        }

    }
}
