package com.leslia.resta.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class CasRealm extends org.apache.shiro.cas.CasRealm {

    private Logger logger= LoggerFactory.getLogger(CasRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("获取 [角色][权限]");
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> set=new HashSet<>();
        set.add(username);
        authorizationInfo.setRoles(set);
        authorizationInfo.setStringPermissions(set);
        Session session= SecurityUtils.getSubject().getSession();
        session.setAttribute("username",username);
        return authorizationInfo;
    }

}
