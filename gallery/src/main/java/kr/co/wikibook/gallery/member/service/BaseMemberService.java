package kr.co.wikibook.gallery.member.service;

import kr.co.wikibook.gallery.member.entity.Member;
import kr.co.wikibook.gallery.member.repository.MemberRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseMemberService implements MemberService{

    private final MemberRepositroy memberRepositroy;
    //회원 데이터 저장
    @Override
    public void save(String name, String loginId, String loginPw) {
        memberRepositroy.save(new Member(name, loginId, loginPw));
    }
    //회원 데이터 조회
    @Override
    public Member find(String loginId, String loginPw) {
        Optional<Member> memberOptional = memberRepositroy.findByLoginIdAndLoginPw(loginId, loginPw);
        return memberOptional.orElse(null);
    }
}
