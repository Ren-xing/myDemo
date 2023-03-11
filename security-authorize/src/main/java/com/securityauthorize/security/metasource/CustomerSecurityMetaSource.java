package com.securityauthorize.security.metasource;

import com.securityauthorize.entity.Menu;
import com.securityauthorize.entity.Role;
import com.securityauthorize.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomerSecurityMetaSource implements FilterInvocationSecurityMetadataSource {

    private final MenuService menuService;

    @Autowired
    public CustomerSecurityMetaSource(MenuService menuService) {
        this.menuService = menuService;
    }

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    /**
     * 自定义动态资源权限元数据信息
     * @param object the object being secured
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //1.当前请求对象
        String requestURI = ((FilterInvocation) object).getRequest().getRequestURI();
        //2.查询所有菜单
        List<Menu> allMenu = menuService.getAllMenu();

        for (Menu menu : allMenu) {
            //进行url匹配，?匹配一个字符，*匹配0个或多个字符，**匹配0个或多个路径，而我们的url恰恰就是user/**
            if (antPathMatcher.match(menu.getPattern(), requestURI)) {
                //将url匹配的角色转为字符串数组
                String[] roles = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                //根据筛选的url，将所匹配的角色返回
                return SecurityConfig.createList(roles);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
