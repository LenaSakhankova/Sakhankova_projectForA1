package com.unauthorizeddeliveries.dtos;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostingDTO {

   //@CsvBindByName(column = "Mat. Doc.")
   //@CsvBindByPosition(position = 0)
    private String matDoc;

    //@CsvBindByName(column = "Item")
   //@CsvBindByPosition(position = 1)
    private String item;

  // @CsvBindByName(column = "Doc. Date")
    //@CsvBindByPosition(position = 2)
    private String docDate;

     //@CsvBindByName(column ="Pstng Date")
  // @CsvBindByPosition(position = 3)
    private String pstngDate;

  //  @CsvBindByName(column = "Material Description")
   // @CsvBindByPosition(position = 4)
    private String materialDescription;

   // @CsvBindByName(column = "Quantity")
  // @CsvBindByPosition(position = 5)
    private String quantity;

  //  @CsvBindByName(column = "BUn")
  // @CsvBindByPosition(position = 6)
    private String bun;

   // @CsvBindByName(column = "Amount LC")
  // @CsvBindByPosition(position = 7)
    private String amountLc;

   // @CsvBindByName(column = "Crcy")
  // @CsvBindByPosition(position = 8)
    private String crcy;

   // @CsvBindByName(column = "User Name")
  // @CsvBindByPosition(position = 9)
    private String userName;

    private Boolean authorizedDelivery = false;

}
