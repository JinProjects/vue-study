package kr.co.wikibook.gallery.cart.dto;

import kr.co.wikibook.gallery.cart.entity.Cart;
import lombok.Getter;

@Getter
public class CartRequest {
    private Integer itemId;
    //장바구니 상품 담기 요청 DTO(CartRequest)를 엔티티 객체로 변환하는 메서드입니다. 매개변수로
    //회원 아이디를 받습니다. 이 회원 아이디와 상품 아이디 필드 값을 인수로 사용해 장바구니 엔티티 객체를 생성하고 이
    //를 리턴합니다. 이 메서드는 추후 장바구니 서비스에서 데이터를 저장할 때 사용됩니다.
    public Cart toEntity(Integer memberId){
        return new Cart(memberId, itemId);
    }
}
