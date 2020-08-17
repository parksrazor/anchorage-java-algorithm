package com.anchorage.web.oop;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Data class OopAdmin {
    private String adminNum,name,pass,auth;
    @Override public String toString() {
        return "관리자 \n["
                + "관리자번호="+ adminNum
                + "\n 이름="+ name
                + "\n 비밀번호=" + pass
                + "\n 권한=" + auth + "]";
    }
}
interface OopAdminMapRepository {
    // CREAT
    void createAdmin(String name,String pass,String auth);
    // READ
    ArrayList<OopAdmin> list();
    ArrayList<OopAdmin> findByAuth(String auth);
    OopAdmin findById(String adminNum);
    int countAdmin();
    boolean existAdmin(String adminNum,String pass);
    // UPDATE
    void updatePass(String adminNum, String pass, String newPass);
    void updateAuth(String adminNum, String auth);
    // DELETE
    void deleteAdmin(String adminNum);
}
class OopAdminMapRepositoryImpl implements OopAdminMapRepository{
    private HashMap<String,OopAdmin> map;
    private int seq;
    public OopAdminMapRepositoryImpl() {
        map = new HashMap<>();
        seq = 1000;
    }

    @Override
    public void createAdmin(String name, String pass, String auth) {
        OopAdmin admin = new OopAdmin();
        admin.setAdminNum(String.valueOf(seq));
        admin.setAuth(auth); // staff 사원.. 일단은 디폴트
        admin.setName(name);
        admin.setPass(pass);
        map.put(admin.getAdminNum(), admin);
        seq++;
    }

    @Override
    public ArrayList<OopAdmin> list() {
        return (ArrayList<OopAdmin>) map.values();
    }

    @Override
    public ArrayList<OopAdmin> findByAuth(String auth) {
        ArrayList<OopAdmin> list = new ArrayList<>();
        Set<String> set = map.keySet();
        // for each loop 이라고 합니다
        // Set 은 인덱스가 없어요...
        // 그래서 int i = 0 이런식으로 못돌립니다.
        // 그래서 아래처럼 for 를 돌립니다.
        for(String key: set) {
            if(auth.equals(map.get(key).getAuth())) {
                list.add(map.get(key));
            }
        }
        return list;
    }

    @Override
    public OopAdmin findById(String adminNum) {
        return map.get(adminNum);
    }

    @Override
    public int countAdmin() {
        // TODO Auto-generated method stub
        return map.size();
    }

    @Override
    public boolean existAdmin(String adminNum, String pass) {
        boolean exist = false;
        if(map.containsKey(adminNum) &&
                map.get(adminNum).getPass().equals(pass)) {
            exist = true;
        }
        return exist;
    }

    @Override
    public void updatePass(String adminNum, String pass, String newPass) {
        if(map.get(adminNum).getPass().equals(pass)) {
            map.get(adminNum).setPass(newPass);
        }
    }

    @Override
    public void updateAuth(String adminNum, String auth) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAdmin(String adminNum) {
        map.remove(adminNum);

    }

}