package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price")
    @JsonProperty("package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    @JsonProperty("party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @JsonProperty("status")
    private StatusType status;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    //@JsonProperty("customer")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", fetch = FetchType.LAZY)
    private Set<CartItem> cartItem = new HashSet<>();

    public void add(CartItem item) {
        if (item != null) {
            this.cartItem.add(item);
            item.setCart(this);
        }
        else {
            cartItem = new HashSet<>();
        }

    }
}
