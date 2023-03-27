package com.inflearn.rentalcard.domain;

import com.inflearn.rentalcard.domain.vo.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Getter @Setter
@Data
@Entity
@NoArgsConstructor
public class RentalCard {

    @EmbeddedId
    private rentalCardNo rentalCardId;

    @Embedded
    private IDName member;
    private RentalStatus rentalStatus;
    @Embedded
    private LateFee totalLateFee;


    @ElementCollection
    private List<RentalItem> rentalItemList = new ArrayList<RentalItem>();

    @ElementCollection
    private List<ReturnItem> returnItemList = new ArrayList<ReturnItem>();


    public RentalCard rentItem(Item item) throws Exception {
        checkRentalAvailable();
        this.addRentalItem(RentalItem.createRentalItem(item));
        return this;
    }


    public RentalCard returnItem(Item item) throws Exception {
        RentalItem rentedItem = this.rentalItemList.stream().filter(i -> i.getItem().equals(item)).findFirst().get();
        calculateLateFee(rentedItem);
        this.addReturnItem(ReturnItem.createRetunItem(rentedItem));
        this.removeRentalItem(rentedItem);
        return this;
    }

    public RentalCard overdueItem(Item item){
        RentalItem rentedItem = this.rentalItemList.stream().filter(i -> i.getItem().equals(item)).findFirst().get();
        rentedItem.setOverdued(true);
        rentedItem.setOverdueStartDate(LocalDate.of(2022,10,20));
        //this.totalLateFee.addPoint(10);
        this.rentalStatus = RentalStatus.RENT_UNAVAILABLE;
        return this;
    }

    private void checkRentalAvailable() throws Exception {
        if (this.rentalStatus == RentalStatus.RENT_UNAVAILABLE) throw new Exception("대출 불가 상태입니다.");
        if ((long) this.rentalItemList.size() > 5) throw new Exception("이미 5권 대출하였습니다.");
    }

    private RentalCard calculateLateFee(RentalItem item){
        final Integer[] point = {this.totalLateFee.getPoint()};
        point[0] += Period.between(item.getOverdueStartDate(),LocalDate.now()).getDays() * 10 ;
        this.totalLateFee.addPoint(point[0]);
        return this;
    }
    public RentalCard calculateLateFee(){
        final Integer[] point = {this.totalLateFee.getPoint()};
        this.rentalItemList.forEach(new Consumer<RentalItem>() {
                                        @Override
                                        public void accept(RentalItem rentalItem) {
                                           if(rentalItem.getOverdueStartDate() != null)
                                           {
                                              point[0] += Period.between(rentalItem.getOverdueStartDate(),LocalDate.now()).getDays() * 10 ;
                                           }
                                        }
                                    }

        );
        this.totalLateFee.addPoint(point[0]);
        return this;
    }

    public RentalCard makeAvailableRental(Integer point) throws Exception {
        // 연체비 계산하기
        if ((long) this.rentalItemList.size() != 0) throw new Exception("모든 도서가 반납된 후 정지를 해제할 수 있습니다.");
        Integer lateFee = this.totalLateFee.getPoint();
        if (lateFee > point) throw new Exception("연체료가 더 커서 해당 포인트로 삭감할수 없습니다.");
        lateFee = lateFee - point;
        this.totalLateFee.addPoint(lateFee);
        if (lateFee == 0 )
        {
            this.rentalStatus = RentalStatus.RENT_AVAILABLE;
        }
        return this;
    }

//    public RentalCard returnItem(){
//
//    }

    public void addRentalItem(RentalItem rentalItem){
        this.getRentalItemList().add(rentalItem);
    }

    public void addReturnItem(ReturnItem returnItem){
        this.getReturnItemList().add(returnItem);
    }

    public void removeRentalItem(RentalItem rentalItem)
    {
        this.getRentalItemList().remove(rentalItem);
    }
    public static RentalCard sample(){
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardId(rentalCardNo.createRentalCardNo());
        rentalCard.setMember(IDName.sample());
        rentalCard.setRentalStatus(RentalStatus.RENT_AVAILABLE);
        rentalCard.setTotalLateFee(LateFee.sample());
        //rentalCard.getRentalItemList().add(RentalItem.sample());

        return rentalCard;
    }
}
