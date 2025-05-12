package org.example.lab4_oop;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MarketService {
    public List<Market> getAllMarkets() {
        return Arrays.asList(Market.values());
    }
}
