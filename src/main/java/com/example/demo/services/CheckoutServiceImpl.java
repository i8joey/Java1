package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    //private CustomerRepository customerRepository;

    private CartRepository cartRepository;


    public CheckoutServiceImpl(CartRepository cartRepository) {
        //this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        //Customer customer = purchase.getCustomer();

        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        Set<CartItem> cartItems = purchase.getCartItems();
        //cartItems.forEach(item -> {
        //    cart.add(item);
            //item.setCart(cart);
        //});
        cartItems.forEach(item -> cart.add(item));
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
