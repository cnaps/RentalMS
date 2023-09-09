package com.msa.rentalcard.application.inputport;

import com.msa.rentalcard.application.outputport.EventOuputPort;
import com.msa.rentalcard.application.outputport.RentalCardOuputPort;
import com.msa.rentalcard.application.usecase.OverdueItemUsercase;
import com.msa.rentalcard.domain.model.RentalCard;
import com.msa.rentalcard.domain.model.vo.Item;
import com.msa.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.msa.rentalcard.framework.web.dto.UserItemInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class OverDueItemInputPort implements OverdueItemUsercase {

    private final RentalCardOuputPort rentalCardOuputPort;
    @Override
    public RentalCardOutputDTO overDueItem(UserItemInputDTO returnDto) throws Exception {
        RentalCard rental = rentalCardOuputPort.loadRentalCard(returnDto.getUserId());

        if (rental == null) new IllegalArgumentException("해당 카드가 존재하지 않습니다.");

        rental = rental.overdueItem(new Item(returnDto.getItemId(),returnDto.getItemTitle()));
        rental = rentalCardOuputPort.save(rental);

        return RentalCardOutputDTO.mapToDTO(rental);
    }
}
