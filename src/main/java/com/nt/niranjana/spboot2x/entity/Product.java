package com.nt.niranjana.spboot2x.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert//it is used for to tell to the hibernate to stop the fire/execute the insert query for all the field.Only mentioned field need to be insert not for all the fields
@DynamicUpdate //it is used for to tell to the hibernate to stop the fire/execute the update query for all the field.Only mentioned field need to be update not for all the fields
public class Product 
{
    @Id
    @GeneratedValue
    private  int id;
    private String name;
    private int quantity;
    private long price;

    public Product(String name, int quantity, long price) 
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
