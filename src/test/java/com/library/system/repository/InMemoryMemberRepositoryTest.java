package com.library.system.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.library.system.Member;

public class InMemoryMemberRepositoryTest {
    
    InMemoryMemberRepository memberRepo;

    @BeforeEach 
    void setUp() {
        memberRepo = new InMemoryMemberRepository();
        Member member1 = new Member("M001", "John Doe");
        Member member2 = new Member("M002", "Jane Smith");
        memberRepo.save(member1);
        memberRepo.save(member2);
    }

    @ParameterizedTest 
    @CsvSource ({ "M001, John Doe", "M002, Jane Smith" })
    void testFindById(String memberId, String expectedName) {
        Member member = memberRepo.findById(memberId).orElseThrow();
        assertEquals(expectedName, member.name());
        
    }

    @ParameterizedTest
    @ValueSource (strings = { "M999" })
    void unknownMemberIdReturnsEmptyOptional(String memberId) {
        assertTrue(memberRepo.findById(memberId).isEmpty());
    }

    @Test
    void testFindAllReturnsUnmodifiableList() {
        List<Member> members = memberRepo.findAll();
        assertEquals(2, members.size());
        assertThrows(UnsupportedOperationException.class, () -> members.add(new Member("M003", "Alice Johnson")));
    }
}
