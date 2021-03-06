package rs.ac.uns.ftn.webshopservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double shippingPrice;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer maxQuantity;

    @Column(nullable = false)
    private Integer maxOrderQuantity;

    @Column(nullable = false)
    private Float quantityDiscount;

    @Column(nullable = false)
    private Integer orderQuantityDiscount; // koliko artikala treba odjednom naruciti da bi se primenio popust

    @Column(nullable = false)
    private Float discount;

    @Column(nullable = false)
    private Float maxDiscount;

    @Column(nullable = false)
    private String coupon;

    @Column(nullable = false)
    private Float couponDiscount;

    @ManyToOne
    private Store store;

    @OneToOne
    private ProductCategory category;
}
