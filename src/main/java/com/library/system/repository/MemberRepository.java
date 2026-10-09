package com.library.system.repository;

import java.util.List;
import java.util.Optional;

import com.library.system.Member;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(String memberId);
    List<Member> findAll();
}
