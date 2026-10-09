package com.library.system;

public record Member (String memberId, String name){
    
    public Member {
        if(memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException("Member ID cannot be null or blank");
        }
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Member name cannot be null or blank");
        }
    }

    @Override 
    public boolean equals(Object o) {
        return (this == o) || (o instanceof Member other && memberId.equals(other.memberId));
    }

    @Override 
    public int hashCode() {
        return memberId.hashCode();
    }
}
