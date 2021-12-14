package com.nttdata.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("deposit")
public class Deposit implements Serializable {

    private static final long serialVersionUID = 2063506695894198794L;

    @Id
    private String id;
    private String cardNumber;
    private String amount;
    private String description;
    private String date;
}
