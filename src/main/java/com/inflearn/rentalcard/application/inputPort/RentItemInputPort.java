package com.inflearn.rentalcard.application.inputPort;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inflearn.rentalcard.application.ouputPort.RentalCardOuputPort;
import com.inflearn.rentalcard.application.usecase.RentItemUsecase;
import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.IDName;
import com.inflearn.rentalcard.domain.model.vo.Item;
import com.inflearn.rentalcard.framework.web.dto.RentalInputDTO;
import com.inflearn.rentalcard.framework.web.dto.RentalResultOuputDTO;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase{

    private final RentalCardOuputPort rentalCardOuputPort;
    @Override
    public RentalResultOuputDTO rentItem(RentalInputDTO rental) throws Exception {
        // Outport를 사용해서 해당 사용자의 RentalCard 검색해서
        // 없으면 만들고
        // 있으면 대여한뒤
        // Outport를 사용해서 저장한다.
        Optional<RentalCard> userRentalCard = rentalCardOuputPort.loadRentalCard(rental.getUserId());
        
        if (userRentalCard == null)
        {
            userRentalCard = Optional.of(RentalCard.createRentalCard(new IDName(rental.getUserId(), rental.getUserNm())));
        }
        userRentalCard.get().rentItem(new Item(rental.getItemId(),rental.getItemTitle()));

        userRentalCard = Optional.ofNullable(rentalCardOuputPort.save(userRentalCard));

        return RentalResultOuputDTO.mapToDTO(userRentalCard);

    }
    
}
