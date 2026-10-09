package com.library.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MemberTest {
    @Test 
    void validMemberIsCreated() {
        Member member = new Member("M001", "John Doe");

        assertEquals("M001", member.memberId());
        assertEquals("John Doe", member.name());
    }

    @Test
    void memberIdCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Member("", "John Doe"));
    }

    @Test 
    void memberNameCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Member("M001", ""));
    }

    @Test 
    void sameIdDifferentNameMembersAreEqual() {
        Member member1 = new Member("M001", "John Doe");
        Member member2 = new Member("M001", "Jane Smith");

        assertEquals(member1, member2);
    }
}
