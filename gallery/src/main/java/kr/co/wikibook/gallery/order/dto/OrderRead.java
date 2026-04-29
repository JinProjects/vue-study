package kr.co.wikibook.gallery.order.dto;

import kr.co.wikibook.gallery.item.dto.ItemRead;
import kr.co.wikibook.gallery.order.entity.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class OrderRead {
    private Integer id;
    private String name;
    private String address;
    private String payment;
    private String cardNumber;
    private Long amount;
    private LocalDateTime created;
    private List<ItemRead> items;

}
