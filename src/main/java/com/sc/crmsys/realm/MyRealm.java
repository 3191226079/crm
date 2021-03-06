package com.sc.crmsys.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.sc.crmsys.bean.PermissionInformationBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.RoleService;
import com.sc.crmsys.service.UserService;
import com.sc.crmsys.utils.MyUtils;

public class MyRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private RoleService roleServiceImpl;
	
	@Override
	public String getName() {
		return "MyRealm";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		
		UserBean userBean = (UserBean)principals.getPrimaryPrincipal();
		List<PermissionInformationBean> permissionList = roleServiceImpl.selectPermissionByUserId(userBean.getUserId());
		for(PermissionInformationBean p : permissionList)
		{
			String permission = p.getPermission();
			simpleAuthorizationInfo.addStringPermission(permission);
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String principal = (String)token.getPrincipal();
		UserBean userBean = userServiceImpl.selectByUserName(principal);
		if(userBean == null)
		{
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userBean, userBean.getUserPassword(), ByteSource.Util.bytes(userBean.getUserSalt()), getName());
		
		return simpleAuthenticationInfo;
	}
	
	public static void main(String[] args) {
		String salt = MyUtils.getSalt();
		String md5 = MyUtils.md5("123456", salt, 1);
		System.out.println(salt+"  "+md5);
	}

}
