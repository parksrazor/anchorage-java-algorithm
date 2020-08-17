package com.anchorage.web.oop;

import lombok.*;
import org.springframework.stereotype.Service;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 계좌 클래스
 * [속성]
 * 상수 : BANK_NAME
 * 멤버변수 :
 * 1. accountNum 계좌번호
 * 2. money 잔액
 * 3. today 해당일
 * [기능]
 * 1. generatorAccountNum() 계좌번호생성(랜덤)
 * 2. today() 해당일생성
 * 3. withdraw() 출금하기
 * 4. deposit() 입금하기
 * 5. info() 계좌정보
 * */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
class OopAccount {
    private String accountNumber, today, money;
    private String id;

    @Override
    public String toString() {
        return "계좌정보 [계좌번호=" + accountNumber
                + ", 거래일자=" + today
                + ", 금액=" + money + "]";
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
interface OopAccountService {
    void createAccount(int money);
    String createAccountNumber(); // 계좌번호 생성(1234-5678)
    OopAccount[] findAll();
    OopAccount findByAccountNumber(String accountNum);
    int countAccounts();
    boolean existAccountNumber(String accountNum);
    String findDate(); // 오늘날짜, 현재시간(분까지) 반환
    void depositMoney(OopAccount param);
    void withdrawMoney(OopAccount param);
    void deleteAccountNumber(String accountNum);
}
@Service @AllArgsConstructor
class OopAccountServiceImpl implements OopAccountService{
    private final OopAccountArrayRepository repository;
    @Override
    public void createAccount(int money) {
        OopAccount acc = new OopAccount();
        acc.setAccountNumber(createAccountNumber());
        acc.setMoney(money+"");
        acc.setToday(findDate());
        repository.save(acc);
    }

    @Override
    public String createAccountNumber() {
        String accountNumber = "";
        Random ran = new Random();
        for(int i=0;i<9;i++) {
            accountNumber += (i==4)?"-":ran.nextInt(10);
        }
        return accountNumber;
    }

    @Override
    public OopAccount[] findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OopAccount findByAccountNumber(String param) {
        return repository.findByAccountNumber(param);
    }

    @Override
    public int countAccounts() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean existAccountNumber(String accountNum) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String findDate() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm")
                .format(new Date());
    }

    @Override
    public void depositMoney(OopAccount param) {
        // TODO Auto-generated method stub

    }

    @Override
    public void withdrawMoney(OopAccount param) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAccountNumber(String accountNum) {
        // TODO Auto-generated method stub

    }

}
interface OopAccountArrayRepository{
    void save(OopAccount ba);
    OopAccount findByAccountNumber(String accountNum);
}

class OopAccountArrayRepositoryImpl implements OopAccountArrayRepository {
    private OopAccount[] accounts;
    private int count;

    public OopAccountArrayRepositoryImpl() {
        accounts = new OopAccount[10];
        count = 0;
    }

    @Override
    public void save(OopAccount acc) {
        accounts[count] = acc;
        count++;
    }

    @Override
    public OopAccount findByAccountNumber(String param) {
        OopAccount acc = new OopAccount();
        acc.setAccountNumber(param);
        return acc;
    }
}
