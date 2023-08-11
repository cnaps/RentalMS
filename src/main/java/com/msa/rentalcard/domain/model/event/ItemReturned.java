package com.inflearn.rentalcard.domain.model.event;

import com.inflearn.rentalcard.domain.model.vo.IDName;
import com.inflearn.rentalcard.domain.model.vo.Item;
import lombok.AllArgsConstructor;

import java.awt.*;
import java.io.Serializable;


@AllArgsConstructor
public class ItemReturned {
    private IDName idName;
    private Item item;
    private long point;
}