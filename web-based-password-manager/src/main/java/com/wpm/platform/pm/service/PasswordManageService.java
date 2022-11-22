package com.wpm.platform.pm.service;

import java.util.List;

import com.wpm.platform.pm.domain.PasswordManage;

public interface PasswordManageService {
	
	public PasswordManage savePassword(PasswordManage passwordManage);
	public List<PasswordManage> getAllData();
	public List<PasswordManage> deleteWebsiteById(int wid);

}
