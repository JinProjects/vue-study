package kr.co.wikibook.gallery.cart.entity;

import jakarta.persistence.*;
import kr.co.wikibook.gallery.cart.dto.CartRead;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer memberId;
    @Column(nullable = false)
    private Integer itemId;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created;

    public Cart(){}

    public Cart(Integer memberId, Integer itemId) {
        this.memberId = memberId;
        this.itemId = itemId;
    }
    //엔티티 객체를 장바구니 조회 DTO(CartRead)로 변환하는 메서드입니다. 빌더를 활용해 필드의
    //값을 간편하게 초기화하고 객체를 생성합니다. 이 메서드는 추후 장바구니 서비스에서 데이터를 조회할 때 사용됩니다.
    public CartRead toRead(){
        return CartRead.builder()
                .id(id)
                .itemId(itemId)
                .build();
    }
}
