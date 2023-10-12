package com.nt.niranjana.spboot2x.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAPIResponse<T> 
{

    int recordCount;
    T response;

}