package com.msa.rentalcard.application.inputport;

import com.msa.rentalcard.application.outputport.EventOuputPort;
import com.msa.rentalcard.application.outputport.RentalCardOuputPort;
import com.msa.rentalcard.application.usecase.ClearOverdueItemUsecase;
import com.msa.rentalcard.domain.model.RentalCard;
import com.msa.rentalcard.domain.model.event.OverdueCleared;
import com.msa.rentalcard.framework.web.dto.ClearOverdueInfoDTO;
import com.msa.rentalcard.framework.web.dto.RentalResultOuputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUsecase {
    final RentalCardOuputPort rentalCardOuputPort;
    final EventOuputPort eventOuputPort;


    @Override
    public RentalResultOuputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard loadRentalCard = rentalCardOuputPort.loadRentalCard(clearOverdueInfoDTO.UserId);

        loadRentalCard.makeAvailableRental(clearOverdueInfoDTO.getPoint());
        RentalCard rentalCard = rentalCardOuputPort.save(loadRentalCard);

        eventOuputPort.occurOverdueClearedEvent(new OverdueCleared(rentalCard.getMember(),clearOverdueInfoDTO.getPoint()));

        return RentalResultOuputDTO.mapToDTO(rentalCard);
    }
}
