package com.inflearn.rentalcard;

import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.stream.Collectors;

@SpringBootApplication
public class RentalCardApplication {

    public static void main(String[] args) throws Exception {
        domainTest();
        SpringApplication.run(RentalCardApplication.class, args);
    }


    public static void domainTest() throws Exception {


        System.out.println("1,2,3,4,5권 대여");
        System.out.println("5번 반납");
        System.out.println("1,2,4번 연체");
        System.out.println("4번 반납");
        System.out.println("1,2,3번 연체");

        System.out.println("------------도메인 모델 테스트 진행------------");
        RentalCard sampleCard = RentalCard.sample();
        System.out.println(sampleCard.getMember().getName());

        var sample3 = new Item(2,"노인과바다");
        var smaple4 = new Item(3, "홍길동전");
        var sample5 = new Item(4,"누구를 위하여 종을 울리나?");

        System.out.println("-------샘플3 대여하기---------------------");
        sampleCard.rentItem(sample3);
        System.out.println("-------샘플4 대여하기---------------------");
        sampleCard.rentItem(smaple4);
        System.out.println("-------샘플1 대여하기---------------------");
        sampleCard.rentItem(Item.sample());

        System.out.println(sampleCard.getMember().getName());
        System.out.println(sampleCard.getRentItemList().stream().map(m->m.getItem().getTitle()).collect(Collectors.toList()));
        System.out.println(sampleCard.getReturnItemList().stream().map(m->m.getItem().getItem().getTitle()).collect(Collectors.toList()));

        System.out.println("-------샘플1 반납하기---------------------");
        sampleCard.returnItem(Item.sample(), LocalDate.now());
        System.out.println(sampleCard.getMember().getName());
        System.out.println(sampleCard.getRentItemList().stream().map(m->m.getItem().getTitle()).collect(Collectors.toList()));
        System.out.println(sampleCard.getReturnItemList().stream().map(m->m.getItem().getItem().getTitle()).collect(Collectors.toList()));

        System.out.println("-------샘플2 대여하기---------------------");
        sampleCard.rentItem(Item.sample2());
        System.out.println(sampleCard.getMember().getName());
        System.out.println(sampleCard.getRentItemList().stream().map(m->m.getItem().getTitle()).collect(Collectors.toList()));
        System.out.println(sampleCard.getReturnItemList().stream().map(m->m.getItem().getItem().getTitle()).collect(Collectors.toList()));

        System.out.println("-------샘플2 연체하기---------------------");
        sampleCard.overdueItem(Item.sample2());
        System.out.println("-------샘플3 연체하기---------------------");
        sampleCard.overdueItem(sample3);


        System.out.println(sampleCard.getMember().getName());
        System.out.println(sampleCard.getRentItemList().stream().map(m->m.getItem().getTitle()).collect(Collectors.toList()));
        System.out.println(sampleCard.getReturnItemList().stream().map(m->m.getItem().getItem().getTitle()).collect(Collectors.toList()));

        System.out.println("-------현재도서카드 상태---------------------");
        System.out.println(sampleCard.getMember().getName());
        System.out.println(sampleCard.getRentItemList().stream().map(m->m.isOverdued()).collect(Collectors.toList()));
        System.out.println(sampleCard.getTotalLateFee().getPoint());
        System.out.println(sampleCard.getRentStatus().toString());



        sampleCard.calculateLateFee();

        System.out.println(sampleCard.getMember().getName());
        System.out.println(sampleCard.getTotalLateFee().getPoint());
        System.out.println(sampleCard.getRentItemList().stream().map(m->m.getItem().getTitle()).collect(Collectors.toList()));
        System.out.println(sampleCard.getReturnItemList().stream().map(m->m.getItem().getItem().getTitle()).collect(Collectors.toList()));

        sampleCard.rentItem(sample5);


    }
}
