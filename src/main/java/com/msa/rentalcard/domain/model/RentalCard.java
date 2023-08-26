package com.msa.rentalcard.domain.model;

import com.msa.rentalcard.domain.model.vo.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Data
@Entity
@NoArgsConstructor
public class RentalCard {

    @EmbeddedId
    private RentalCardNo rentalCardId;

    @Embedded
    private IDName member;
    private RentStatus rentStatus;
    @Embedded
    private LateFee totalLateFee;

    @ElementCollection
    private List<RentItem> rentItemList = new ArrayList<RentItem>();
    @ElementCollection
    private List<ReturnItem> returnItemList = new ArrayList<ReturnItem>();

    public static RentalCard createRentalCard(IDName creater)
    {
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardId(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(creater);
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setTotalLateFee(LateFee.creatLateFee());
        return rentalCard; 
    }

    public RentalCard rentItem(Item item) throws Exception {
        checkRentalAvailable();
        this.addRentalItem(RentItem.createRentItem(item));
        return this;
    }

    public RentalCard returnItem(Item item,LocalDate returnDate) throws Exception {
        RentItem rentedItem = this.rentItemList.stream().filter(i -> i.getItem().equals(item)).findFirst().get();
        calculateLateFee(rentedItem,returnDate);
        this.addReturnItem(ReturnItem.creatReturnItem(rentedItem));
        this.removeRentalItem(rentedItem);
        return this;
    }

    public RentalCard overdueItem(Item item){
        RentItem rentedItem = this.rentItemList.stream().filter(i -> i.getItem().equals(item)).findFirst().get();
        rentedItem.setOverdued(true);
        //rentedItem.setOverdueDate(LocalDate.of(2022,10,20));
        rentedItem.setOverdueDate(LocalDate.now().minusDays(1));
        //this.totalLateFee.addPoint(10);
        this.rentStatus = RentStatus.RENT_UNAVAILABLE;
        return this;
    }

    private void checkRentalAvailable() throws Exception {
        if (this.rentStatus == RentStatus.RENT_UNAVAILABLE) throw new IllegalStateException("대출 불가 상태입니다.");
        if ((long) this.rentItemList.size() > 5) throw new Exception("이미 5권 대출하였습니다.");
    }

    private void calculateLateFee(RentItem item, LocalDate returnDate){
        if (returnDate.compareTo(item.getOverdueDate())>0) {
            Integer point = 0;
            point += Period.between(item.getOverdueDate(), returnDate).getDays() * 10;
            LateFee addedPoint = this.totalLateFee.addPoint(point);
            this.setTotalLateFee(addedPoint);
         }
    }
    public RentalCard calculateLateFee(){
        this.rentItemList.forEach(new Consumer<RentItem>() {
                                        @Override
                                        public void accept(RentItem rentItem) {
                                           if(rentItem.getOverdueDate() != null)
                                           {
                                              calculateLateFee(rentItem,LocalDate.now());
                                           }
                                        }
                                    }

        );
        return this;
    }

    public Integer makeAvailableRental(Integer point) throws Exception {
        if (this.rentItemList.size() != 0) throw new IllegalArgumentException("모든 도서가 반납되어야 정지를 해제 할 수 있습니다.");
        if (this.getTotalLateFee().getPoint() != point) throw  new IllegalArgumentException("해당 포인트로 연체를 해제할 수 없습니다.");
        this.setTotalLateFee(totalLateFee.removePoint(point));
        if (this.getTotalLateFee().getPoint() == 0)
        {
            this.rentStatus = RentStatus.RENT_AVAILABLE;
        }
        return this.getTotalLateFee().getPoint();
    }


    private void addRentalItem(RentItem rentItem){
        this.getRentItemList().add(rentItem);
    }

    private void addReturnItem(ReturnItem returnItem){
        this.getReturnItemList().add(returnItem);
    }

    private void removeRentalItem(RentItem rentItem)
    {
        this.getRentItemList().remove(rentItem);
    }

    public static RentalCard sample(){
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardId(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(IDName.sample());
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setTotalLateFee(LateFee.sample());

        return rentalCard;
    }
}
