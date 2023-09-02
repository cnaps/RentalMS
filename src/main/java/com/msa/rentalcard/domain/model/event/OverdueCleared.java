package com.msa.rentalcard.domain.model.event;

import com.msa.rentalcard.domain.model.vo.IDName;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OverdueCleared {
    public IDName idName;
    public long point;
}
