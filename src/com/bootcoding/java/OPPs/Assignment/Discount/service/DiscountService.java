package com.bootcoding.java.OPPs.Assignment.Discount.service;
import com.bootcoding.java.OPPs.Assignment.Discount.Customer;
import com.bootcoding.java.OPPs.Assignment.Discount.Discount;

public class DiscountService {
    private static final int LIMIT = 100;
    public Discount[] getAllCustomersDiscount(){
        Discount[] discounts = new Discount[LIMIT];
        CustomerService customerService = new CustomerService();
        Customer[] allCustomers = customerService.getAllCustomers();
        for(int i = 0; i<LIMIT;i++){
            Discount discount = buildDiscount();
            discounts[i]=discount;
        }
        return discounts;
    }
    private Discount buildDiscount(Customer customer){
        int visitCount = customer.getVisitCount();
        int orderCount =customer.getOrderCount();
        String name = customer.getName();

        int discountInPercentage = calculateDiscount( visitCount, orderCount);
        Discount discount = new Discount();
        discount.setCustomerName(name);
        discount.setDiscount(discountInPercentage);
        return discount;
    }

    private int calculateDiscount(int visitCount, int orderCount){
        int totalCount = visitCount + orderCount;
        if (totalCount >= 1000){
            return 50;
        }
    }
}
