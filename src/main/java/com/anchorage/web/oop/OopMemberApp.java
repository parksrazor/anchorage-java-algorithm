package com.anchorage.web.oop;

import lombok.Getter;
import lombok.Setter;

/**
 *  Domains
 *
 * */
@Getter @Setter  class OopMember {
    private String id, pass, name, ssn;
    @Override
    public String toString() {
        return "회원정보 [id=" + id + ", pass=" + pass + ", name=" + name + ", ssn=" + ssn + "]";
    }

}

@Getter @Setter class OopCustomer extends OopMember {
    private String credit;
    @Override public String toString() {
        return "고객정보 [아이디=" + getId() + ", 비번="
                + getPass() + ", 이름="
                + getName() + ", 주민번호="
                + getSsn() + ", 신용도="
                + credit+ "]";
    }

}
@Getter @Setter  class OopEmployee extends OopMember{
    private String sabun;
    @Override public String toString() {
        return "사원정보 [아이디=" + getId() + ", 비번="
                + getPass() + ", 이름="
                + getName() + ", 주민번호="
                + getSsn() + ", 신용도="
                + sabun+ "]";
    }
}
/**
 * 요구사항 (기능정의) Services
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 로그인
 * **********
 * <관리자기능>
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색
 * 4. 전체 회원수
 *
 * */
interface OopMemberArrayService {
    void join(OopCustomer param);
    void register(OopEmployee param);
    OopCustomer[] findAllCustomers();
    OopEmployee[] findAllEmployees();
    OopMember[] findByName(String name);
    OopMember findById(String id);
    boolean login(OopMember param);
    int countCustomers();
    int countEmployees();
    boolean existId(String id);
    void updatePass(OopMember param);
    void deleteMember(OopMember param);
}
class OopMemberArrayServiceImpl implements OopMemberArrayService{
    @Override public void join(OopCustomer param) {

    }
    @Override public void register(OopEmployee param) {

    }
    @Override public OopCustomer[] findAllCustomers() {
        return new OopCustomer[0];
    }
    @Override
    public OopEmployee[] findAllEmployees() {
        return new OopEmployee[0];
    }

    @Override
    public OopMember[] findByName(String name) {
        return new OopMember[0];
    }

    @Override
    public OopMember findById(String id) {
        return null;
    }

    @Override
    public boolean login(OopMember param) {
        return false;
    }

    @Override
    public int countCustomers() {
        return 0;
    }

    @Override
    public int countEmployees() {
        return 0;
    }

    @Override
    public boolean existId(String id) {
        return false;
    }

    @Override
    public void updatePass(OopMember param) {

    }

    @Override
    public void deleteMember(OopMember param) {

    }
}
interface OopMemberArrayRepository {
    void join(OopCustomer param);
    void register(OopEmployee param);
    OopCustomer[] findAllCustomers();
    OopEmployee[] findAllEmployees();
    OopMember[] findByName(String name);
    OopMember findById(String id);
    boolean login(OopMember param);
    int countCustomers();
    int countEmployees();
    boolean existId(String id);
    void updatePass(OopMember param);
    void deleteMember(OopMember param);
}
class OopMemberArrayRepositoryImpl implements OopMemberArrayRepository{

    private OopCustomer[] customers;
    private OopEmployee[] employees;

    private int custCount, empCount;
    OopMemberArrayRepositoryImpl() {
        customers = new OopCustomer[10];
        employees = new OopEmployee[10];
        custCount = 0;
        empCount = 0;
    }

    @Override
    public void join(OopCustomer param) {
        customers[custCount] = param;
        custCount++;

    }

    @Override
    public void register(OopEmployee param) {
        employees[empCount] = param;
        empCount++;
    }

    @Override
    public OopCustomer[] findAllCustomers() {
        return customers;
    }

    @Override
    public OopEmployee[] findAllEmployees() {
        return employees;
    }

    @Override
    public OopMember[] findByName(String name) {
        int count1 = 0, count2 = 0, count3 = 0;
        for(int i=0;i< custCount;i++) {
            if(name.equals(customers[i].getName())) {
                count1++;
                break;
            }
        }
        for(int i=0;i< empCount;i++) {
            if(name.equals(employees[i].getName())) {
                count2++;
                break;
            }
        }
        count3 = count1 + count2;
        OopMember[] members = new OopMember[count3];
        int j = 0;
        for(int i=0;i< custCount;i++) {
            if(name.equals(customers[i].getName())) {
                members[j] = customers[i];
                j++;
                if(count1==j) {
                    break;
                }

            }
        }
        int k = 0;
        for(int i=0;i< empCount;i++) {
            if(name.equals(employees[i].getName())) {
                members[j] = employees[i];
                k++;
                j++;
                if(count2==k) {
                    break;
                }
                break;
            }
        }
        return members;
    }

    @Override
    public OopMember findById(String id) {
        OopMember c = new OopMember();
        for(int i=0;i< custCount;i++) {
            if(id.equals(customers[i].getId())) {
                c = customers[i];
                break;
            }
        }
        for(int i=0;i< empCount;i++) {
            if(id.equals(employees[i].getId())) {
                c = employees[i];
                break;
            }
        }
        return c;
    }

    @Override
    public boolean login(OopMember param) {
        return findById(param.getId())
                .getPass()
                .equals(param.getPass());
    }

    @Override
    public int countCustomers() {
        return custCount;
    }

    @Override
    public int countEmployees() {
        return empCount;
    }

    @Override
    public boolean existId(String id) {
        boolean flag = false;
        for(int i=0;i< custCount;i++) {
            if(id.equals(customers[i].getId())) {
                flag = true;
                break;
            }
        }
        for(int i=0;i< empCount;i++) {
            if(id.equals(employees[i].getId())) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    /**
     *  비번 수정(ID, 옛날비번, 신규비번 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경 )
     *  비번변경후 로그인을 실행해서 새로 바뀐 비번이 로그인 성공, 옛날비번 로그인 실패
     * */
    @Override
    public void updatePass(OopMember param) {
        String id = param.getId();
        String[] passwords = param.getPass().split(",");
        String oldPass = passwords[0];
        String newPass = passwords[1];
        param.setPass(oldPass);
        if(login(param)) {
            for(int i=0;i< custCount;i++) {
                if(id.equals(customers[i].getId())) {
                    customers[i].setPass(newPass);;
                    break;
                }
            }
            for(int i=0;i< empCount;i++) {
                if(id.equals(employees[i].getId())) {
                    employees[i].setPass(newPass);
                    break;
                }
            }
        }


    }

    @Override
    public void deleteMember(OopMember param) {
        if(login(param)) {
            int i = 0;
            for(;i< custCount;i++) {
                if(customers[i].getId().equals(param.getId())) {
                    customers[i] = customers[custCount-1];
                    custCount--;
                    break;
                }
            }
            i = 0;
            for(;i< empCount;i++) {
                if(employees[i].getId().equals(param.getId())) {
                    employees[i] = employees[empCount-1];
                    empCount--;
                    break;
                }
            }
        }
    }
}

/**
 *  Controllers
 *
 * */