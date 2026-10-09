# Postmortem log

## 1. Mutable field in hashCode (BookCopy)

**What failed:** A `HashSet<BookCopy>` could no longer find a copy that was still
inside it, after the copy's status changed from AVAILABLE to BORROWED.

**Why:** `hashCode()` was based on `status`, a field that changes. The set filed
the copy in one bucket, then looked in a different bucket after the hash changed.
No exception was thrown; `contains()` just returned false.

**How I'd detect it in production:** A cache that never hits, a map entry that
can't be removed, or duplicates appearing in a set, all with no error logs.

**Fix:** Base `equals` and `hashCode` only on `copyId`, which is `final`.

**Rule learned:** Never use a mutable field in `equals` or `hashCode`.

## 2. equals without hashCode (Book)

**What failed:** A `HashSet<Book>` held 2 entries for books with the same ISBN.

**Why:** `equals` said they were the same, but the inherited `hashCode` put them
in different buckets, so `equals` was never called.

**Fix:** Override both together, using the same fields.