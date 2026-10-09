package com.library.system.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.library.system.Member;

public class InMemoryMemberRepository implements MemberRepository {
    private final Map<String, Member> members = new HashMap<>();

    @Override
    public void save(Member member) {
        members.put(member.memberId(), member);
    }

    @Override
    public Optional<Member> findById(String memberId) {
        return Optional.ofNullable(members.get(memberId));
    }

    @Override
    public List<Member> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(members.values()));
    }
}
