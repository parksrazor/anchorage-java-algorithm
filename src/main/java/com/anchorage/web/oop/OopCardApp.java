package com.anchorage.web.oop;
import lombok.*;

import java.util.Scanner;

@Getter @Setter class OopCard {
    private String kind;
    private int number;
}
interface OopCardService {
    void add(OopCard card);
    OopCard[] list();
    OopCard detail(OopCard card);
    int count();
    void update(OopCard card);
    void delete(OopCard card);
}
class SwingCardServiceImpl implements OopCardService{
    private OopCard[] cards;
    private int count;
    public SwingCardServiceImpl() {
        cards = new OopCard[3];
        count = 0;
    }
    public void add(OopCard card) {
        cards[count] = card;
        count++;
    }
    @Override
    public OopCard[] list() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OopCard detail(OopCard card) {
        // TODO Auto-generated method stub
        return null;
    }
    public int count() {
        return count;
    }
    @Override
    public void update(OopCard card) {
        // TODO Auto-generated method stub

    }
    @Override
    public void delete(OopCard card) {
        // TODO Auto-generated method stub

    }
}
class CardController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OopCardService service = new SwingCardServiceImpl();
        OopCard card = null;
        while(true) {
            System.out.println("0.Exit 1.카드 3장 받기 2.출력");
            switch(scanner.nextInt()) {
                case 0: return;
                case 1: System.out.println("카드 3장 받기 모양, 숫자");
                    for(int i=0;i < 3;i++) {
                        card = new OopCard();
                        card.setKind(scanner.next());
                        card.setNumber(scanner.nextInt());
                        service.add(card);
                    }
                    break;
                case 2:
                    OopCard[] cards = service.list();
                    for(int i=0;i<3;i++) {
                        System.out.println(String.format("카드모양 %s 카드넘버 %d ",
                                cards[i].getKind(), cards[i].getNumber()));
                    }
                    break;
            }

        }
    }
}