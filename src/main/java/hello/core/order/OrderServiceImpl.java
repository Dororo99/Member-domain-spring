package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 얘를 Rate로 바꿔줘야함
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    // DIP 위반: 구체(구현) 클래스에 의존 중
//    // OCP 위반: 이런식으로 코드를 아예 바꿔줘야 함!

    // DIP 위반을 막자
    private DiscountPolicy discountPolicy; // interface에만 의존함

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인을 어떻게 할 지는 몰라~ 그냥 알아서 결과를 던져줘 -> SRP 잘 지킴!!!
        // member를 넘길지, grade를 넘길지도 고민해보자!
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
