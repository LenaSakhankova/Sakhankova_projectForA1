package com.unauthorizeddeliveries.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "posting")
public class PostingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posting_id")
    private Long postingId;

    @Column(name = "mat_doc")
    private Long matDoc;

    @Column(name = "item")
    private Integer item;

    @Column(name = "doc_date")
    private Date docDate;

    @Column(name = "postng_date")
    private Date pstngDate;

    @Column(name = "material_description")
    private String materialDescription;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "bun")
    private String bun;

    @Column(name = "amount_lc")
    private Double amountLc;

    @Column(name = "crcy")
    private String crcy;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "authorized_delivery")
    private Boolean authorizedDelivery;
}
