package com.inflearn.rentalcard.domain;
import com.inflearn.rentalcard.domain.repository.RentalCardRepository;
import com.inflearn.rentalcard.domain.vo.*;
import org.assertj.core.api.ListAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RentalCardTest2 {

    @Autowired
    RentalCardRepository rentalCardRepository;

    @Before
    public void setUp() {
        RentalCard card = RentalCard.sample();
        rentalCardRepository.save(card);
    }

    @After
    public void tearDown() {
        rentalCardRepository.deleteAll();
    }

    @Test
    public void RentalCard_findByMemberID() throws Exception {
        RentalCard rentalCard = rentalCardRepository.findByMemberId(IDName.sample().getId()).get();
        assertThat(rentalCard.getMember().getId()).isEqualTo("scant");


        rentalCard.rentItem(Item.sample());
        rentalCard.returnItem(Item.sample());

        System.out.println(rentalCard);


    }

        @Test
    public void RentalCard_findByMember(){
        RentalCard rentalCard = rentalCardRepository.findByMember(IDName.sample()).get();
        assertThat(rentalCard.getMember().getId()).isEqualTo("scant");
    }

}