package com.anchorage.web.swing;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@Getter @Setter class SwingBankAccount {
    public final static String BANK_NAME = "비트뱅크";
    public final static String ACCOUNT_TYPE = "기본통장";
    public final static String WITHDRAW_SUCCESS = "출금성공";
    public final static String WITHDRAW_FAIL = "잔액부족";
    public final static String DEPOSIT_SUCCESS = "입금성공";
    public final static String DEPOSIT_FAIL = "적합한 입력값이 아님";
    public int money, deposit, withdraw;
    public String name, uid, pass, accountNo, accountType, createDate;

    public String toString() {
        return String.format("%s \n %s \n 계좌번호 : %s \n 이름 : %s \n 생성일 : %s \n 잔액 : %s 원 \n 비밀번호 : %s ",
                BANK_NAME, accountType, accountNo, name, createDate, money,pass);
    }
}
@Getter @Setter class SwingBankMember {
    protected String uid,pass,name,ssn,addr,phone,email;
    @Override public String toString() {
        return "회원정보 [아이디:" + uid + ", "
                + "비밀번호:" + pass
                + ", 이름:" + name
                + ", 주민번호:" + ssn
                + ", 주소:" + addr
                + ", 전화번호:" + phone
                + ", 이메일: " + email
                + "]\n";
    }
}
@Getter @Setter class SwingBankAccountMinus extends SwingBankAccount{
    public final static String ACCOUNT_TYPE = "마이너스통장";
    public int limit; // 대출한도
    @Override public String toString() {
        return String.format("%s \n %s \n 계좌번호 : %s \n 이름 : %s \n 생성일 : %s \n 잔액 : %s 원 \n 한도 : %s 원 \n비밀번호 : ****** ",
                BANK_NAME, accountType, accountNo, name, createDate, money, limit);
    }
}
@Getter @Setter class SwingBankStaff extends SwingBankMember{
    private String accessNum;
    @Override public String toString() {
        return "회원정보 [아이디:" + uid + ", "
                + "비밀번호:" + pass
                + ", 이름:" + name
                + ", 주민번호:" + ssn
                + ", 주소:" + addr
                + ", 전화번호:" + phone
                + ", 이메일: " + email
                + ", 접근번호 : " + accessNum
                + "]\n";
    }
}
@Getter @Setter class SwingBankUser extends SwingBankMember {
    private String creditRating;
    @Override public String toString() {
        return "회원정보 [아이디:" + uid + ", "
                + "비밀번호:" + pass
                + ", 이름:" + name
                + ", 주민번호:" + ssn
                + ", 주소:" + addr
                + ", 전화번호:" + phone
                + ", 이메일: " + email
                + ", 신용등급 : " + creditRating
                + "]\n";
    }
}
interface SwingBankAccountRepository {
    void insertAccount(SwingBankAccount account);
    List<SwingBankAccount> selectAccountList();
    List<SwingBankAccount> selectAccountByName(String name);
    SwingBankAccount selectAccountByID(String id);
    int countAccounts();
    void updateAccount(SwingBankAccount account);
    void deleteAccount(SwingBankAccount account);
}
class SwingBankAccountRepositoryImpl implements SwingBankAccountRepository{
    private static SwingBankAccount instance = new SwingBankAccount();
    public static SwingBankAccount getInstance() {return instance;}
    private SwingBankAccountRepositoryImpl(){}


    @Override
    public void insertAccount(SwingBankAccount account) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SwingBankAccount> selectAccountList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SwingBankAccount> selectAccountByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SwingBankAccount selectAccountByID(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countAccounts() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void updateAccount(SwingBankAccount account) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAccount(SwingBankAccount account) {

    }

}
interface SwingBankMemberRepository {
    void insertMember(SwingBankMember member);
    List<SwingBankMember> selectMemberList();
    List<SwingBankMember> selectMemberByName(String name);
    SwingBankMember selectMemberByID(String id);
    SwingBankMember login(SwingBankMember member);
    int countMembers();
    void updateMember(SwingBankMember member);
    void deleteMember(SwingBankMember member);
}
class SwingBankMemberRepositoryImpl implements SwingBankMemberRepository{
    private static SwingBankMemberRepositoryImpl instance = new SwingBankMemberRepositoryImpl();
    public static SwingBankMemberRepositoryImpl getInstance() {return instance;}
    private SwingBankMemberRepositoryImpl(){}


    @Override
    public void insertMember(SwingBankMember member) {

    }

    @Override
    public List<SwingBankMember> selectMemberList() {
        return null;
    }

    @Override
    public List<SwingBankMember> selectMemberByName(String name) {
        return null;
    }

    @Override
    public SwingBankMember selectMemberByID(String id) {
        return null;
    }

    @Override
    public SwingBankMember login(SwingBankMember member) {
        return null;
    }

    @Override
    public int countMembers() {
        return 0;
    }

    @Override
    public void updateMember(SwingBankMember member) {

    }

    @Override
    public void deleteMember(SwingBankMember member) {

    }
}
interface SwingBankAccountService{
    void createAccount(SwingBankAccount account);
    SwingBankAccount findById(SwingBankAccount account);
    void delete(SwingBankAccount account);
    void update(SwingBankAccount account);
}
interface SwingBankAdminService {
    void createStaff(SwingBankStaff staff);
    List<SwingBankMember> memberList();  //Arraylist의 최상위 개념인 List로 써야 한다. StaffBean UserBean이 아닌 MemberBean을 쓰는 이유이다.
    List<SwingBankMember> findMemberByName(String param);
    SwingBankMember findMemberById(SwingBankMember member);
    List<SwingBankAccount> accountList();
    List<SwingBankAccount> findAccountByName(String param);
    String createRandom(int start, int end);
    String createDate();
    String createAccountNo();
}
interface SwingBankMemberService {
    void createUser(SwingBankUser member);
    String login(SwingBankMember member);
    void updatePassword(SwingBankMember member);
    void deleteMember(SwingBankMember member);
}
class SwingBankAccountServiceImpl implements SwingBankAccountService {
    private static SwingBankAccountService insatnce = new SwingBankAccountServiceImpl();
    public static SwingBankAccountService getInsatnce() {return insatnce;}
    private SwingBankAccountServiceImpl() {}

    @Override
    public void createAccount(SwingBankAccount account) {
		/*account.setCreateDate(createDate());
		account.setAccountType(AccountBean.ACCOUNT_TYPE);
		account.setAccountNo(createAccountNo());*/
        //list.add(account);
    }



    @Override
    public SwingBankAccount findById(SwingBankAccount account) {
        SwingBankAccount acc = new SwingBankAccount();
		/*for (AccountBean e : list) {
			if (account.getUid().equals(e.getUid())) {
				acc = e;break;
			}
		}*/
        return acc;

    }
    @Override
    public void delete(SwingBankAccount account) {
        //list.remove(list.indexOf(findById(account)));
    }

    @Override
    public void update(SwingBankAccount account) {
        //list.get(list.indexOf(findById(account))).setPass(account.getPass());
    }
}
class SwingBankAdminServiceImpl implements SwingBankAdminService {
    private static SwingBankAdminService instance = new SwingBankAdminServiceImpl();
    public static SwingBankAdminService getInstance() {return instance;}
    private SwingBankAdminServiceImpl() {}


    @Override
    public void createStaff(SwingBankStaff staff) {
        staff.setAccessNum("999");
        //list.add(staff);
    }

    @Override
    public List<SwingBankMember> memberList() {
        return null;
    }

    @Override
    public List<SwingBankMember> findMemberByName(String param) {
        List<SwingBankMember> temp = new ArrayList<>();
		/*for (MemberBean e : list) {
			if (param.equals(e.getName())) {
				temp.add(e);
			}
		}*/
        return temp;
    }

    @Override
    public SwingBankMember findMemberById(SwingBankMember member) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SwingBankAccount> accountList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SwingBankAccount> findAccountByName(String param) {
        List<SwingBankAccount> temp = new ArrayList<>();
		/*for (AccountBean e : list) {
			if (param.equals(e.getName())) {
				temp.add(e);
			}
		}*/
        return temp;
    }

    @Override
    public String createRandom(int start, int end) {
        return String.valueOf((int) (Math.random() * (end + 1)) + start);
    }

    @Override
    public String createDate() {
        return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
    }

    @Override
    public String createAccountNo() {
        String accountNum = "";
        for (int i = 0; i < 3; i++) {
            accountNum += (i != 2) ? String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "-"
                    : String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "";
        }
        return accountNum;
    }


}
class SwingBankMemberServiceImpl implements SwingBankMemberService {
    private static SwingBankMemberService instance = new SwingBankMemberServiceImpl();
    public static SwingBankMemberService getInstance() {return instance;}
    private SwingBankMemberServiceImpl() {}

    @Override
    public void createUser(SwingBankUser member) {

        System.out.println("========= 멤버 서비스 ===========");
        System.out.println("컨트롤러에서 넘어온 객체:"+member);
        member.setCreditRating("7등급");
        SwingBankMemberRepositoryImpl.getInstance().insertMember(member);
    }

    @Override
    public String login(SwingBankMember member) {
        SwingBankMember mbr = new SwingBankMember();
		/*for (MemberBean e : list) {
			if (member.getUid().equals(e.getUid())) {
				mbr = e;
				break;
			}
		}*/
        return "";
    }

    @Override
    public void updatePassword(SwingBankMember member) { // new pass만 가지고 있을 것 같음
        String oldPass = member.getPass().split("/")[0];
        String newPass = member.getPass().split("/")[1];
        SwingBankMember mbr = new SwingBankMember();
        mbr.setPass(oldPass);
        //list.get(list.indexOf(findById(mbr))).setPass(newPass);
    }

    @Override
    public void deleteMember(SwingBankMember member) {
        //list.remove(list.indexOf(findById(member)));
        // list.remove(search(member)); 위를 줄이면 아래와같이 할 수 있다.
    }
}
class SwingBankAccountController {
    private static SwingBankAccountController instance = new SwingBankAccountController();
    public static SwingBankAccountController getInstance() {return instance;}
    private SwingBankAccountController(){};


    public void account() {
        SwingBankAccount account = null;
        account = new SwingBankAccount();
        account.setName(JOptionPane.showInputDialog("Name?"));
        account.setUid(JOptionPane.showInputDialog("ID?"));
        account.setPass(JOptionPane.showInputDialog("Pass?"));
        SwingBankAccountServiceImpl.getInsatnce().createAccount(account);
    }



    public void findById() {
        SwingBankAccount account = null;
        account = new SwingBankAccount();
        account.setUid(JOptionPane.showInputDialog("ID?"));
        JOptionPane.showMessageDialog(null, SwingBankAccountServiceImpl.getInsatnce().findById(account));
    }

    public void changePass() {
        SwingBankAccount account = null;
        account = new SwingBankAccount();
        account.setUid(JOptionPane.showInputDialog("ID?"));
        account.setPass((JOptionPane.showInputDialog("old Pass?") + "/" + (JOptionPane.showInputDialog("New Pass?"))));
        SwingBankAccountServiceImpl.getInsatnce().update(account);
    }

    public void deleteAccount() {
        SwingBankAccount account = null;
        account = new SwingBankAccount();
        account.setUid(JOptionPane.showInputDialog("ID?"));
        SwingBankAccountServiceImpl.getInsatnce().delete(account);
    }
}
class SwingBankAdminController {
    private static SwingBankAdminController instance = new SwingBankAdminController();
    public static SwingBankAdminController getInstance() {return instance;}
    private SwingBankAdminController(){}


    public void add() {
        SwingBankMember member = null;
        member = new SwingBankStaff();
        member.setName(JOptionPane.showInputDialog("Name?"));
        member.setUid(JOptionPane.showInputDialog("ID?"));
        member.setPass(JOptionPane.showInputDialog("Pass?"));
        member.setSsn(JOptionPane.showInputDialog("SSN?"));
        member.setAddr(JOptionPane.showInputDialog("ADRS?"));
        member.setPhone(JOptionPane.showInputDialog("PHONE?"));
        member.setEmail(JOptionPane.showInputDialog("EMAIL?"));
        //service.createStaff((StaffBean) member);
    }

    public void memberList() {
        //JOptionPane.showMessageDialog(null, service.list());
    }


    public void findMemberById() {
        SwingBankMember member = null;
        member = new SwingBankStaff();
        member.setUid(JOptionPane.showInputDialog("ID?"));
        //JOptionPane.showMessageDialog(null, service.findById(member));
    }

    public void findMemberByName() {
        //JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("name?")));
    }
    public void accountList() {
        //JOptionPane.showMessageDialog(null, service.list());
    }

    public void findByName() {
        //JOptionPane.showMessageDialog(null, service.findByName((JOptionPane.showInputDialog("Name?"))));
    }
}
class SwingBankMemberController {
    private static SwingBankMemberController instance = new SwingBankMemberController();
    public static SwingBankMemberController getInstance() {return instance;}
    private SwingBankMemberController() {}


    public void join(SwingBankUser member) {
        System.out.println("========= 멤버 컨트롤러 ===========");
        System.out.println("화면에서 넘어온 객체:"+member);
        SwingBankMemberServiceImpl.getInstance().createUser(member);
    }



    public void update() {
        SwingBankMember member = null;
        member = new SwingBankStaff();
        member.setUid(JOptionPane.showInputDialog("ID?"));
        member.setUid(JOptionPane.showInputDialog("OldPass?") + "/" + (JOptionPane.showInputDialog("NewPass?")));
        SwingBankMemberServiceImpl.getInstance().updatePassword(member);
    }

    public void withdrawal() {
        SwingBankMember member = null;
        member = new SwingBankStaff();
        member.setUid(JOptionPane.showInputDialog("ID?"));
        member.setUid(JOptionPane.showInputDialog("Pass?"));
        SwingBankMemberServiceImpl.getInstance().deleteMember(member);
    }
}
class SwingBankUIButton {
    JButton btn1;
    public void create(){
        btn1 = new JButton("회원가입");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingBankUIRegister();
            }
        });
        //this.add(btn1); this 는 상위 컴포넌트
    }
}
class SwingBankUIRegister extends JFrame{
    private static final long serialVersionUID = 1L;
    JLabel topLab, idLab,passLab, nameLab, phoneLab,
            addrLab, ssnLab, emailLab;
    JTextField idTxt, passTxt, nameTxt, phoneTxt, addrTxt,
            ssnTxt, emailTxt;
    JButton addBtn;
    JPanel bottomPan, centerPan, idPan, passPan,
            namePan, phonePan, addrPan, ssnPan, emailPan;
    JComboBox<?> combo;
    String[] menu = {"사용자 등록","직원 추가"};
    public SwingBankUIRegister() {
        makeGui(); //화면구성
        setSize(400, 300);
        setLocation(100, 100);
        setVisible(true);
    }
    // uid,pass,name,ssn,phone,email,addr;
    public void makeGui() {
        topLab = new JLabel("회원가입", JLabel.CENTER);

        combo = new JComboBox<>(menu);
        idLab = new JLabel("I D : ", JLabel.CENTER);
        idTxt = new JTextField(15);
        idPan = new JPanel();
        idPan.add(idLab);
        idPan.add(idTxt);

        passLab = new JLabel("비밀번호 : ");
        passTxt = new JTextField(15);
        passPan = new JPanel();
        passPan.add(passLab);
        passPan.add(passTxt);

        nameLab = new JLabel("이 름 : ");
        nameTxt = new JTextField(15);
        namePan = new JPanel();
        namePan.add(nameLab);
        namePan.add(nameTxt);

        ssnLab = new JLabel("주민번호 : ");
        ssnTxt = new JTextField(15);
        ssnPan = new JPanel();
        ssnPan.add(ssnLab);
        ssnPan.add(ssnTxt);

        phoneLab = new JLabel("전 화 : ");
        phoneTxt = new JTextField(15);
        phonePan = new JPanel();
        phonePan.add(phoneLab);
        phonePan.add(phoneTxt);

        emailLab = new JLabel("이메일 : ");
        emailTxt = new JTextField(15);
        emailPan = new JPanel();
        emailPan.add(emailLab);
        emailPan.add(emailTxt);

        addrLab = new JLabel("주 소 : ");
        addrTxt = new JTextField(15);
        addrPan = new JPanel();
        addrPan.add(addrLab);
        addrPan.add(addrTxt);



        centerPan = new JPanel();
        centerPan.setLayout(new GridLayout(8, 1));
        centerPan.add(combo);
        centerPan.add(idPan);
        centerPan.add(passPan);
        centerPan.add(namePan);
        centerPan.add(ssnPan);
        centerPan.add(phonePan);
        centerPan.add(emailPan);
        centerPan.add(addrPan);


        addBtn = new JButton("추가");

        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingBankUser member = new SwingBankUser();
                member.setUid(idTxt.getText());
                member.setName(nameTxt.getText());
                member.setPass(passTxt.getText());
                member.setSsn(ssnTxt.getText());
                member.setAddr(addrTxt.getText());
                member.setPhone(phoneTxt.getText());
                member.setEmail(emailTxt.getText());
                if(((String) combo.getSelectedItem()).equals(menu[0])){
                    SwingBankMemberController.getInstance().join(member);
                }else{
                    //new AdminServiceImpl().createStaff( member);
                }
            }
        });


        bottomPan = new JPanel();
        bottomPan.add(addBtn);

        add(topLab, "North");
        add(centerPan, "Center");
        add(bottomPan, "South");
    }


}
class SwingBankUIComboBox {
    JPanel centerPan;
    JComboBox<?> combo;
    String[] menu = {"사용자 등록","직원 추가"};
    public void create(){
        centerPan = new JPanel();
        combo = new JComboBox<>(menu);
        centerPan.add(combo);
    }
}
class SwingBankUICreateLabel {
    JLabel idLab;
    JPanel idPan;
    public void create(){
        idLab  = new JLabel("ID", JLabel.CENTER);
        idPan = new JPanel();
        idPan.add(idLab);
    }
}
class SwingBankUITextField {
    JTextField idTxt;
    JPanel idPan;
    public void create(){
        idTxt  = new JTextField();
        idPan = new JPanel();
        idPan.add(idTxt);
    }
}
class SwingBankUIList extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel label, id, name, phone, address, company;
    JTextField fid, fname, fphone, faddress, fcompany, search;
    JButton add, delete, update, clear, all, sbutton;
    String items[] = { "이름", "주소", "회사" };
    JComboBox combo;
    JPanel bottompanel, leftpanel, center, pid, pname, pphone, padd, pcom;

    JScrollPane sp;
    Vector outer, title, noresult, msg; // noresult :검색결과없을때 테이블때문에
    JTable table;
    DefaultTableModel model;
    public SwingBankUIList() {
        makeGui(); //화면구성
        model.setDataVector(outer, title);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    public void makeGui() {

        label = new JLabel("Address Book", JLabel.CENTER);
        id = new JLabel("   I D :  ", JLabel.CENTER);

        fid = new JTextField(15);
        pid = new JPanel();
        pid.add(id);
        pid.add(fid);

        name = new JLabel("이름 : ");
        fname = new JTextField(15);
        pname = new JPanel();
        pname.add(name);
        pname.add(fname);

        phone = new JLabel("전화 : ");
        fphone = new JTextField(15);
        pphone = new JPanel();
        pphone.add(phone);
        pphone.add(fphone);

        address = new JLabel("주소 : ");
        faddress = new JTextField(15);
        padd = new JPanel();
        padd.add(address);
        padd.add(faddress);

        company = new JLabel("회사 : ");
        fcompany = new JTextField(15);
        pcom = new JPanel();
        pcom.add(company);
        pcom.add(fcompany);

        leftpanel = new JPanel();
        leftpanel.setLayout(new GridLayout(5, 1));
        leftpanel.add(pid);
        leftpanel.add(pname);
        leftpanel.add(pphone);
        leftpanel.add(padd);
        leftpanel.add(pcom);

        add = new JButton("추가");
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        delete = new JButton("삭제");
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        update = new JButton("수정");
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        combo = new JComboBox(items);

        search = new JTextField(15);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        sbutton = new JButton("검색");
        sbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        clear = new JButton("지우기");
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        all = new JButton("전체보기");
        all.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        bottompanel = new JPanel();
        bottompanel.add(add);
        bottompanel.add(delete);
        bottompanel.add(update);
        bottompanel.add(combo);
        bottompanel.add(search);
        bottompanel.add(sbutton);
        bottompanel.add(clear);
        bottompanel.add(all);

        title = new Vector();
        outer = new Vector();
        noresult = new Vector();
        msg = new Vector();

        title.add("ID");
        title.add("Name");
        title.add("Phone");
        title.add("Address");
        title.add("Company");

        noresult.add("실행 결과");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent w) {

                super.windowClosing(w);
            }
        });

        Container c = getContentPane();

        // DefaultTableModel 생성
        model = new DefaultTableModel();

        // model 사용해서 JTable 생성
        table = new JTable(model);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                // 클릭한 행의 인덱스 알아내기-->JTable의 메소드
                int index = table.getSelectedRow();

                // 인덱스 이용해서 out안의 작은 벡터 in 꺼내기
                Vector msg = (Vector) outer.get(index);

                // in 안에 들어 있는 번호,이름,주소 알아내서 텍스트 필드에 넣어주기
                String id = (String) msg.get(0);
                String name = (String) msg.get(1);
                String phone = (String) msg.get(2);
                String address = (String) msg.get(2);
                String company = (String) msg.get(2);

                fid.setText(id);
                fname.setText(name);
                fphone.setText(phone);
                faddress.setText(address);
                fcompany.setText(company);

                // 번호가 들어가는 텍스트 필드는 편집 불가 상태로 변경
                fid.setEditable(false);
            }
        });

        sp = new JScrollPane(table);

        center = new JPanel();
        center.add(leftpanel);
        center.add(sp);

        c.add(label, "North");
        c.add(center, "Center");
        c.add(bottompanel, "South");
    }
}
class SwingBankUIIndex extends JFrame{
    private static final long serialVersionUID = 1L;

    SwingBankUIIndex(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("관리자화면");
        this.setLayout(new GridLayout(3, 3,10,10));
        JButton btn1 = new JButton("회원가입");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingBankUIRegister();
            }
        });
        this.add(btn1);
        JButton btn2 = new JButton("통장생성");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn2);
        JButton btn3 = new JButton("목록보기");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn3);
        JButton btn4 = new JButton("ID 검색");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn4);
        JButton btn5 = new JButton("이름 검색");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn5);
        JButton btn6 = new JButton("비번 변경");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn6);
        JButton btn7 = new JButton("입금");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn7);
        JButton btn8 = new JButton("출금");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn8);
        JButton btn9 = new JButton("회원 탈퇴");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn9);
        setSize(600, 600);
        setLocation(100, 100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SwingBankUIIndex();
    }
}