package com.example.demo.services;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseResponse {

    private String orderTrackingNumber;


}
