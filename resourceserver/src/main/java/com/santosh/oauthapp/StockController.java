package com.santosh.oauthapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

  private final List<Stock> stocks;

  public StockController() {
    stocks = new ArrayList<>();
    stocks.add(new Stock("1", "SBI", new BigDecimal("2.5"), "INR"));
    stocks.add(new Stock("2", "HDFC", new BigDecimal("5.5"), "INR"));
    stocks.add(new Stock("2", "TESLA", new BigDecimal("5.5"), "Dollar"));
  }

  @RequestMapping("/api/stocks")
  @PreAuthorize("hasAuthority('SCOPE_reader')")
  public List<Stock> getStocks() {
    return stocks;
  }
}
