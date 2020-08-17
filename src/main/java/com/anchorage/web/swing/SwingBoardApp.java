package com.anchorage.web.swing;

import lombok.*;
import java.io.ObjectInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@AllArgsConstructor @NoArgsConstructor @ToString @Getter @Setter
class SwingBoard implements Serializable {
        private int no;
        private String title;
        private String writer;
        private Date regDate;
}
class SwingBoardSequence implements Serializable {
        private static int no;
        private FileOutputStream fos;
        private ObjectOutputStream oos;
        public synchronized int getNo() {

                try {
                        fos = new FileOutputStream("D:/sequence.txt");
                        oos = new ObjectOutputStream(fos);

                        oos.writeInt(no);

                } catch (Exception e) {
                        e.printStackTrace();
                }finally{
                        try {
                                if(oos != null)
                                        oos.close();
                                if(fos != null)
                                        fos.close();
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }

                }
                //System.err.println(no);
                return no++;
        }

        public synchronized void setNo(int no){
                this.no = no;
        }
}
interface SwingBoardService{
        void insertBoard(SwingBoard board);
        boolean updateBoard(SwingBoard board);
        boolean deleteBoard(SwingBoard board);
        SwingBoard selectOneBoard(SwingBoard board);
        ArrayList selectBoard();
        void exitBoard();
        int getSeq();
}
class SwingBoardServiceImpl implements SwingBoardService{

        private SwingBoardRepository repository;
        private SwingBoardSequence seq;

        public SwingBoardServiceImpl() {
                repository = new SwingBoardRepositoryImpl();
                seq = new SwingBoardSequence();
                seq.setNo(getSeq());
        }


        @Override
        public void insertBoard(SwingBoard board) {
                board.setNo(seq.getNo());
                board.setRegDate(new Date());
                repository.insertBoard(board);
        }

        @Override
        public boolean updateBoard(SwingBoard board) {
                return repository.updateBoard(board);
        }

        @Override
        public boolean deleteBoard(SwingBoard board) {
                return repository.deleteBoard(board);
        }

        @Override
        public SwingBoard selectOneBoard(SwingBoard board) {
                return repository.selectOneBoard(board);
        }

        @Override
        public ArrayList selectBoard() {
                return repository.selectBoard();
        }
        @Override public void exitBoard() {
                repository.exitBoard();
        }
        @Override public int getSeq() {
                FileInputStream fis =null;
                ObjectInputStream ois = null;
                int no = 1;
                try {
                        fis = new FileInputStream("D:/sequence.txt");
                        ois = new ObjectInputStream(fis);
                        no = (int)ois.readInt()+1;

                } catch (Exception e) {
                        //e.printStackTrace();
                        no = 1;
                }finally{
                        try {
                                if(fis != null)
                                        fis.close();
                                if(ois != null)
                                        ois.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }

                return no;
        }
}
class SwingBoardServiceFactory{
        private static SwingBoardServiceImpl service = null;
        public static synchronized SwingBoardServiceImpl getInstance(){
                if(service ==null){
                        service = new SwingBoardServiceImpl();
                }
                return service;
        }
}
interface SwingBoardRepository{
        void insertBoard(SwingBoard board);
        SwingBoard selectOneBoard(SwingBoard board);
        ArrayList selectBoard();
        boolean updateBoard(SwingBoard board);
        boolean deleteBoard(SwingBoard board);
        void exitBoard();
}
class SwingBoardRepositoryImpl implements SwingBoardRepository{
        ArrayList<SwingBoard> boardList;
        private FileOutputStream fos = null;
        private ObjectOutputStream oos = null;
        private FileInputStream fis = null;
        private ObjectInputStream ois = null;
        public SwingBoardRepositoryImpl() {
                boardList = new ArrayList<>();
                try {
                        fis = new FileInputStream("D:/file.txt");
                        ois = new ObjectInputStream(fis);

                        int size = (int)ois.readInt();

                        for (int i =0; i < size; i ++){
                                SwingBoard vo = (SwingBoard) ois.readObject();
                                boardList.add(vo);
                        }


                } catch (Exception e) {
                        //e.printStackTrace();
                } finally {
                        try {
                                if (ois != null)
                                        ois.close();
                                if (fis != null)
                                        fis.close();
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }

        }
        @Override
        public void insertBoard(SwingBoard board) {
                boardList.add(board);
        }

        @Override
        public SwingBoard selectOneBoard(SwingBoard board) {
                for (SwingBoard vo : boardList) {
                        if (vo != null && vo.getNo() == board.getNo())
                                return vo;
                }
                return null;
        }

        @Override
        public ArrayList selectBoard() {
                return boardList;
        }

        @Override
        public boolean updateBoard(SwingBoard board) {
                if (boardList.isEmpty())
                        return false;

                for (SwingBoard vo : boardList) {
                        if (board.getNo() == vo.getNo()) {
                                vo.setTitle(board.getTitle());
                                return true;
                        }
                }
                return false;
        }

        @Override
        public boolean deleteBoard(SwingBoard board) {
                if (boardList.isEmpty())
                        return false;

                for (SwingBoard vo : boardList) {
                        if (vo != null && vo.getNo() == board.getNo()) {
                                boardList.remove(vo);
                                return true;
                        }
                }

                return false;
        }

        @Override
        public void exitBoard() {
                try {
                        fos = new FileOutputStream("D:/file.txt");
                        oos = new ObjectOutputStream(fos);

                        oos.writeInt(boardList.size());

                        for (SwingBoard vo : boardList) {
                                oos.writeObject(vo);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (fos != null)
                                        fos.close();
                                if (oos != null)
                                        oos.close();
                        } catch (IOException e) {
                        }

                }
        }
}
interface SwingUIBoardInterface {
        void execute() throws Exception;
}
abstract class SwingUIBase implements SwingUIBoardInterface{
        private Scanner scan;
        protected SwingBoardService service;

        public SwingUIBase() {
                scan = new Scanner(System.in);
                service = SwingBoardServiceFactory.getInstance();

        }

        String scanStr(String msg) {
                System.out.print(msg);
                return scan.nextLine();
        }

        int scanInt(String msg) {
                System.out.print(msg);
                return Integer.parseInt(scan.nextLine());
        }
}
class SwingUIAdd extends SwingUIBase{
        private Scanner scan = new Scanner(System.in);

        public void execute() throws Exception {
                String title = scanStr("title: ");
                String writer = scanStr("writer: ");

                SwingBoard board = new SwingBoard();
                board.setTitle(title);
                board.setWriter(writer);
                service.insertBoard(board);
        }

        String scanStr(String msg) {
                System.out.print(msg);
                return scan.nextLine();
        }
}
class SwingUIDelete extends SwingUIBase{
        private Scanner scan = new Scanner(System.in);

        public void execute() throws Exception {
                int no = scanInt("Number: ");

                SwingBoard board = new SwingBoard();
                board.setNo(no);

                boolean bool = service.deleteBoard(board);
                if (bool) {
                        System.out.println(no + "");
                } else
                        System.out.println(no + "");
        }

        int scanInt(String msg) {
                System.out.print(msg);

                return Integer.parseInt(scan.nextLine());
        }
}
class SwingUIExit extends SwingUIBase {

        @Override
        public void execute() throws Exception {
                System.out.println("");
                service.exitBoard();
                System.exit(0);
        }

}
class SwingUISearchOne extends SwingUIBase {
        private Scanner scan = new Scanner(System.in);

        public void execute() throws Exception {
                int no = scanInt("Search Word: ");

                SwingBoard board = new SwingBoard();
                board.setNo(no);

                SwingBoard result = service.selectOneBoard(board);

                System.out.println("=================================================");
                if (result != null) {
                        System.out.println("Number: " + result.getNo());
                        System.out.println("Title: " + result.getTitle());
                        System.out.println("Writer: " + result.getWriter());
                        System.out.println("Regist Date: " + result.getRegDate());
                } else
                        System.out.println(no + ".");
                System.out.println("=================================================");

        }

        int scanInt(String msg) {
                System.out.print(msg);

                return Integer.parseInt(scan.nextLine());
        }
}
class SwingUISearch  extends SwingUIBase{

        @Override
        public void execute() throws Exception{
                ArrayList<SwingBoard> boardList = service.selectBoard();

                System.out.println("Size: "+ boardList.size());
                for(SwingBoard vo : boardList){
                        System.out.print(vo.getNo()+"\t");
                        System.out.print(vo.getWriter()+"\t");
                        System.out.print(vo.getRegDate()+"\t");
                        System.out.println(vo.getTitle()+"\t");
                }
                if(boardList.size() == 0)
                        System.out.println("");
                System.out.println("=================================================");
        }
}
class SwingUIUpdate extends SwingUIBase {

        private Scanner scan = new Scanner(System.in);

        public void execute() throws Exception {
                int no = scanInt("Number: ");
                String title = scanStr("Search Word: ");
                SwingBoard board = new SwingBoard();
                board.setNo(no);
                board.setTitle(title);

                boolean result = service.updateBoard(board);
                if (result)
                        System.out.println("Success");
                else
                        System.out.println(no + "Fail");
        }

        int scanInt(String msg) {
                System.out.print(msg);

                return Integer.parseInt(scan.nextLine());
        }

        String scanStr(String msg) {
                System.out.print(msg);
                return scan.nextLine();
        }

}

class SwingUIBoard extends SwingUIBase{

        public void excute() throws Exception{

                while (true) {
                        SwingUIBoardInterface ui = null;
                        String type = menu();
                        switch (type) {
                                case "1":
                                        ui = new SwingUISearch();
                                        break;
                                case "2":
                                        ui = new SwingUISearchOne();
                                        break;
                                case "3":
                                        ui = new SwingUIAdd();
                                        break;
                                case "4":
                                        ui = new SwingUIUpdate();
                                        break;
                                case "5":
                                        ui = new SwingUIDelete();
                                        break;
                                case "0":
                                        ui = new SwingUIExit();
                                        break;
                        }
                        ui.execute();
                }
        }

        @Override
        public void execute() throws Exception {
                // TODO Auto-generated method stub

        }

        String menu() {
                System.out.println("----------------------------------------");
                System.out.println("    Board");
                System.out.println("----------------------------------------");
                System.out.println("    1. Search");
                System.out.println("    2. SearchOne");
                System.out.println("    3. Add");
                System.out.println("    4. Update");
                System.out.println("    5. Delete");
                System.out.println("    0. Exit");
                System.out.println("----------------------------------------");
                String type = scanStr("Search Word: ");

                return type;
        }

}


public class SwingBoardApp{
        public static void main(String[] args) {
                SwingUIBoard ui = new SwingUIBoard();

                try {
                        ui.excute();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}