package com.glsiA.projet.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListVenteDto {
     public List<VenteDto> venteDtoList = new ArrayList<>();

    public double getTotal() {
        double a=0;

        for(int i = 0; i < venteDtoList.size(); i++ ){

            VenteDto b= venteDtoList.get(i);
           // a= a+ 1;
            a= a + ( b.getQuantite() * b.getProduit().getPrix());
        }
        return a;
    }




}
