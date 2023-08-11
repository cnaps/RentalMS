package com.msa.rentalcard.application.inputPort;

import com.msa.rentalcard.application.outputPort.ItemRentedOuputPort;
import com.msa.rentalcard.domain.model.event.ItemRented;
import com.msa.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.msa.rentalcard.domain.model.RentalCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msa.rentalcard.application.outputPort.RentalCardOuputPort;
import com.msa.rentalcard.application.usecase.RentItemUsecase;
import com.msa.rentalcard.domain.model.vo.IDName;
import com.msa.rentalcard.domain.model.vo.Item;
import com.msa.rentalcard.framework.web.dto.UserItemInputDTO;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase{

    private final RentalCardOuputPort rentalCardOuputPort;
    private final ItemRentedOuputPort rentedOuputPort;
    @Override
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws Exception {
        // Outport를 사용해서 해당 사용자의 RentalCard 검색해서
        // 없으면 만들고
        // 있으면 대여한뒤
        // Outport를 사용해서 저장한다.
        RentalCard userRentalCard = rentalCardOuputPort.loadRentalCard(rental.getUserId());
        
        if (userRentalCard == null)
        {
            userRentalCard = RentalCard.createRentalCard(new IDName(rental.getUserId(), rental.getUserNm()));
        }

        Item newItem = new Item(rental.getItemId(), rental.getItemTitle());
        userRentalCard.rentItem(newItem);

        userRentalCard = rentalCardOuputPort.save(userRentalCard);

        rentedOuputPort.occurEvent(new ItemRented(userRentalCard.getMember(),newItem,10L));

        return RentalCardOutputDTO.mapToDTO(userRentalCard);

    }
    
}
