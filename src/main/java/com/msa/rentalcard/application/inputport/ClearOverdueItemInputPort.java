package com.msa.rentalcard.application.inputport;

import com.msa.rentalcard.application.outputport.RentalCardOuputPort;
import com.msa.rentalcard.application.usecase.ClearOverdueItemUsecase;
import com.msa.rentalcard.domain.model.RentalCard;
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


    @Override
    public RentalResultOuputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard loadRentalCard = rentalCardOuputPort.loadRentalCard(clearOverdueInfoDTO.UserId);

        loadRentalCard.makeAvailableRental(clearOverdueInfoDTO.getPoint());
        RentalCard rentalCard = rentalCardOuputPort.save(loadRentalCard);

        return RentalResultOuputDTO.mapToDTO(rentalCard);
    }
}
