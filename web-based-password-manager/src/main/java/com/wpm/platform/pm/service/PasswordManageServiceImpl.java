package com.wpm.platform.pm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
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
		int len=8;
		
		Random random=new Random();
		String up="ABCDEFGHIJKLMNOPQRSTUVWYZ";
		String low="abcdefghijklmnopqrstuvwxyz";
		String number="0123456789";
		String specialChars="!@#$%&*(){}?";
		String all= up + low + number+ specialChars;

		char[] pass=new char[len];
		for(int i=0;i<len;i++)
		{
			pass[i]=all.charAt(random.nextInt(all.length()));
		}
		passwordManage.setPassword(pass.toString());
		
		return passwordManageRepository.save(passwordManage);
	}

	@Override
	public List<PasswordManage> getAllData() {
		List<PasswordManage> pmList = new ArrayList<>();
		Iterator<PasswordManage> pmIt=passwordManageRepository.findAll().iterator();
		while(pmIt.hasNext())
		{
			PasswordManage pm=pmIt.next();
			pmList.add(pm);
		}
		log.info("I am in getAllData() method!" + pmList.toString());
		return pmList;
	}


	public PasswordManage getWebsiteById(int id) {
		log.info("I am in get customerById method!");
		PasswordManage passwordManage= passwordManageRepository.findById(id).get();
		return passwordManage;
	}
	
	@Override
	public List<PasswordManage> deleteWebsiteById(int wid) {
		// TODO Auto-generated method stub
		PasswordManage passwordManage=getWebsiteById(wid);
		if(passwordManage!=null)
		{
			passwordManageRepository.deleteById(wid);
		}
		return getAllData();
	}
	
}
