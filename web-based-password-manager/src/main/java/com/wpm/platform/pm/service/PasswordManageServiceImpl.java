package com.wpm.platform.pm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpm.platform.pm.domain.PasswordManage;
import com.wpm.platform.pm.repo.PasswordManageRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PasswordManageServiceImpl implements PasswordManageService{
	
	@Autowired
	private  PasswordManageRepository passwordManageRepository;

	@Override
	public PasswordManage savePassword(PasswordManage passwordManage) {
//		Todo : Need to impliment Encrypt Pass Logic here
		passwordManage.setPassword("ABC");
		
		return passwordManageRepository.save(passwordManage);
	}
	
}
