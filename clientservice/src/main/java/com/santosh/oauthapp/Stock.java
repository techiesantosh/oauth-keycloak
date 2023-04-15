package com.santosh.oauthapp;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

  private String id;
  private String name;
  @NonNull
  private BigDecimal price;
  private String currency;
}
