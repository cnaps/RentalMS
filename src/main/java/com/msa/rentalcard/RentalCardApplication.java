package com.msa.rentalcard;

import com.msa.rentalcard.domain.model.RentalCard;
import com.msa.rentalcard.domain.model.vo.Item;
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

        System.out.println("◉◉◉◉◉◉◉◉◉ 도메인 모델 테스트 진행 ◉◉◉◉◉◉◉◉◉");
        System.out.println("▶▶▶ 도서카드 생성");
        RentalCard sampleCard = RentalCard.sample();

        showcardStatus(sampleCard);

        var sample1 = new Item(1,"도서1");
        var sample2 = new Item(2, "도서2");
        
        System.out.println("▶▶▶ 도서명: " + sample1.getTitle() + " 대여됨");
        sampleCard.rentItem(sample1);
        System.out.println("▶▶▶ 도서명: " + sample2.getTitle() + " 대여됨");
        sampleCard.rentItem(sample2);

        showcardStatus(sampleCard);

        System.out.println("▶▶▶ 도서명: " + sample1.getTitle()+" 반납됨");
        sampleCard.returnItem(sample1, LocalDate.now());

        showcardStatus(sampleCard);


        System.out.println("▶▶▶ 도서명: " + sample2.getTitle() + " 강제 연체");
        sampleCard.overdueItem(sample2);

        showcardStatus(sampleCard);


        //sampleCard.calculateLateFee();
        System.out.println("▶▶▶ 도서명: " + sample2.getTitle()+" 반납됨");
        sampleCard.returnItem(sample2,LocalDate.now());

        showcardStatus(sampleCard);

        System.out.println("▶▶▶ 정지해제처리");
        Integer minusPoint = sampleCard.makeAvailableRental(sampleCard.getTotalLateFee().getPoint());

        System.out.println("▶▶▶ 현재 남은 연체료는 " + sampleCard.getTotalLateFee().getPoint());
        System.out.println("▶▶▶ 회원포인트에서 삭감될 포인트는 " + minusPoint);

    }

    private static void showcardStatus(RentalCard sampleCard) {
        System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
        System.out.println("--- [           " + sampleCard.getMember().getName()+ " 도서카드 ");
        System.out.println("--- [           대여도서 연체상태 : " + sampleCard.getRentItemList().stream().map(m->m.isOverdued()).collect(Collectors.toList()));
        System.out.println("--- [           총연체료: " + sampleCard.getTotalLateFee().getPoint());
        System.out.println("--- [           대여가능여부: " + sampleCard.getRentStatus().toString());
        System.out.println("--- [           대여 목록");
        System.out.println("--- [           " + sampleCard.getRentItemList().stream().map(m->m.getItem().getTitle()).collect(Collectors.toList()));
        System.out.println("--- [           반납목록");
        System.out.println("--- [           " + sampleCard.getReturnItemList().stream().map(m->m.getItem().getItem().getTitle()).collect(Collectors.toList()));
        System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
    }
}
