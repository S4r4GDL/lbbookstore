package br.ueg.progweb1.lbbookstore.model.cartItem;

import br.ueg.progweb1.lbbookstore.model.GenericModel;
import br.ueg.progweb1.lbbookstore.model.product.Product;
import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name="cart_item")
@Entity
public class CartItem implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    protected Long id;

    @Column(name="price", nullable = false)
    protected BigDecimal price;

    @Column(name="quantity", nullable = false)
    protected Integer quantity;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private  Product product;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart Cart;





}
