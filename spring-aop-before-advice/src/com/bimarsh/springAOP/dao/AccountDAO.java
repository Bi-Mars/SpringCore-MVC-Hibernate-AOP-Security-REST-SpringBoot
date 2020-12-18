package com.bimarsh.springAOP.dao;

import org.springframework.stereotype.Component;

import com.bimarsh.springAOP.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding and Account");
	}
}
