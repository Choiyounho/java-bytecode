package com.soten;

import com.soten.di.Inject;

public class AccountService {

    @Inject
    AccountRepository accountRepository;

    public void join() {
        System.out.println("Service Join");
        accountRepository.save();
    }

}
