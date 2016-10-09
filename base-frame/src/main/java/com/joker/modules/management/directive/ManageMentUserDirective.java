package com.joker.modules.management.directive;


import com.joker.common.util.DirectiveUtils;
import com.joker.modules.management.dao.ManagementUserDao;
import com.joker.modules.management.entity.User;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangjian
 * @Date 2015/12/3
 */
public class ManageMentUserDirective extends BaseDirective {

    @Autowired
    private ManagementUserDao managementUserDao;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String type = DirectiveUtils.getString(TYPE,map);
        switch (type){
            //如果为0则获取list entity
            case "list":list(environment,map,templateModels,templateDirectiveBody);
                break;
            //如果为1则获取entity
            case "entity":;
                break;
            //如果为2则boolean
            case "boolean":;
                break;
            default:;

        }

    }

    private void list(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) {
         List<User> users = managementUserDao.selectAll();
    }

}
