package com.joker.modules.management.shiro;


import com.joker.modules.management.entity.User;
import com.joker.modules.management.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author:zhangjian
 * date:2016-04-28
 * describe:
 **/
public class RMSRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(RMSRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(null);
        authorizationInfo.setStringPermissions(null);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            User user = userService.findUserByUsername(token.getUsername());

            logger.debug("login user name: [ " + user.getUsername() + " ]");
            if (user != null) {
                return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            } else {
                logger.debug("realm login failed!");
                return null;
            }
    }


}
