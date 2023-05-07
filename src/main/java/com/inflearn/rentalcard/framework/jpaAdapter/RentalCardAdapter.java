package com.inflearn.rentalcard.framework.jpaAdapter;

import com.inflearn.rentalcard.application.ouputPort.RentalCardOuputPort;
import com.inflearn.rentalcard.domain.model.RentalCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RentalCardAdapter implements RentalCardOuputPort {

    private final com.inflearn.rentalcard.domain.repository.RentalCardRepository rentalCardRepository;
    @Override
    public RentalCard loadRentalCard(String userId) {
        return rentalCardRepository.findByMemberId(userId).get();
    }

    @Override
    public RentalCard save(RentalCard rentalCard) {
        return rentalCardRepository.save(rentalCard);
    }
}
