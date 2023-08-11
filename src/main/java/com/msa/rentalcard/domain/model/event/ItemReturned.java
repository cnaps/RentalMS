package com.msa.rentalcard.domain.model.event;

import com.msa.rentalcard.domain.model.vo.IDName;
import com.msa.rentalcard.domain.model.vo.Item;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ItemReturned {
    private IDName idName;
    private Item item;
    private long point;
}
