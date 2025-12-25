package DataLayer;

import javax.naming.Context;

import Collections.Arraylist.operations;

/**********************************************
 * SPRING DATA JPA (Revision Notes) *
 **********************************************/
public class QNADataAccessLayer {

    // Interviewer:
    // Explain the evolution of data access in Java.

    // ✅ Expected Answer

    // “Initially, Java used JDBC, which required manual SQL, connection handling,
    // and result mapping. Hibernate was introduced as an ORM framework to automate
    // object–relational mapping and reduce boilerplate. Later, JPA standardized ORM
    // by defining a specification, which Hibernate implements. Finally, Spring Data
    // JPA was introduced to eliminate repository boilerplate and improve developer
    // productivity.”

    // Q2️⃣ JDBC vs Hibernate

    // Interviewer:
    // Why is Hibernate preferred over JDBC in enterprise applications?

    // ✅ Expected Answer

    // “Hibernate reduces boilerplate by automating SQL generation, provides ORM,
    // caching, lazy loading, and dirty checking. JDBC gives full control but is
    // verbose and harder to maintain, which makes Hibernate better suited for large
    // enterprise applications.”

    // Q3️⃣ What is JPA?

    // Interviewer:
    // Is JPA a framework?

    // ✅ Expected Answer

    // “No, JPA is a specification. It defines standard APIs, annotations, and
    // behavior for ORM, but does not provide an implementation. Hibernate,
    // EclipseLink, and OpenJPA are JPA implementations.”

    // Q4️⃣ Hibernate vs JPA

    // Interviewer:
    // If Hibernate already existed, why was JPA introduced?

    // ✅ Expected Answer

    // “Hibernate was vendor-specific. JPA was introduced to standardize ORM in
    // Java, reduce vendor lock-in, and make applications portable across ORM
    // implementations while still allowing Hibernate to be used underneath.”

    // Q5️⃣ Session and EntityManager

    // Interviewer:
    // What is the relationship between Session and EntityManager?

    // ✅ Expected Answer

    // “EntityManager is the JPA interface, while Session is Hibernate’s native API.
    // Internally, Hibernate provides an EntityManager implementation backed by a
    // Session.”

    // Q6️⃣ Persistence Context

    // Interviewer:
    // What is a Persistence Context?

    // ✅ Expected Answer

    // “A persistence context is a managed environment that tracks entity states and
    // ensures identity guarantee and dirty checking. In Hibernate, it is
    // implemented as the first-level cache and is scoped to a session or
    // EntityManager.”

    // Q7️⃣ Cache vs Persistence Context

    // Interviewer:
    // How is cache different from persistence context?

    // ✅ Expected Answer

    // “Persistence context manages entity lifecycle and tracks changes, while cache
    // is a performance optimization to reduce database hits. Cache does not manage
    // entity state or dirty checking.”

    // Q8️⃣ Hibernate Caching

    // Interviewer:
    // How does caching work if a new Session is created every time?

    // ✅ Expected Answer

    // “First-level cache is session-scoped and cleared when the session closes.
    // Second-level cache is session-factory scoped and shared across sessions,
    // which allows cached data to be reused even with new sessions.”

    // Q9️⃣ @Transactional

    // Interviewer:
    // What happens internally when a method is annotated with @Transactional?

    // ✅ Expected Answer

    // “Spring starts a transaction using AOP, opens a Hibernate Session, binds it
    // to the current thread, and creates a persistence context. Hibernate performs
    // dirty checking, flushes changes before commit, and closes the session after
    // commit or rollback.”

    // Q🔟 LazyInitializationException

    // Interviewer:
    // Why does LazyInitializationException occur?

    // ✅ Expected Answer

    // “It occurs when a lazy-loaded association is accessed outside the persistence
    // context after the session has been closed, usually because the transactional
    // boundary has ended.”

    // Q1️⃣1️⃣ JpaRepository vs CrudRepository

    // Interviewer:
    // What is the difference between JpaRepository and CrudRepository?

    // ✅ Expected Answer

    // “CrudRepository provides basic CRUD operations. JpaRepository extends it and
    // adds pagination, sorting, batch operations, and flush control. JpaRepository
    // is preferred in enterprise applications.”

    // Q1️⃣2️⃣ save vs saveAndFlush

    // Interviewer:
    // What is the difference between save() and saveAndFlush()?

    // ✅ Expected Answer

    // “save() persists the entity in the persistence context, but SQL may be
    // executed later. saveAndFlush() immediately flushes the persistence context,
    // forcing SQL execution.”

    // Q1️⃣3️⃣ N+1 Problem

    // Interviewer:
    // What is the N+1 query problem?

    // ✅ Expected Answer

    // “It occurs when one query fetches parent entities and additional queries are
    // executed for each child entity due to lazy loading. It can be solved using
    // fetch joins, entity graphs, or batch fetching.”

    // Q1️⃣4️⃣ Dirty Checking

    // Interviewer:
    // What is dirty checking?

    // ✅ Expected Answer

    // “Dirty checking is Hibernate’s mechanism where it automatically detects
    // changes to managed entities and synchronizes them with the database during
    // flush, without explicit save calls.”

    // Q1️⃣5️⃣ When NOT to Use Hibernate

    // Interviewer:
    // When would you avoid Hibernate?

    // ✅ Expected Answer

    // “For highly complex SQL queries, reporting systems, or performance-critical
    // paths where fine-grained SQL control is required, JDBC or native queries may
    // be preferred.”
}

// 1️⃣ What Is EntityManager?

// EntityManager is the primary JPA interface used to interact with the persistence context.

// It is responsible for:
    // Managing entities
    // Executing CRUD operations
    // Handling queries
    // Managing entity lifecycle

// 📌 EntityManager does not store entities itself
// 📌 It works with a persistence context

// 2️⃣ What Is Persistence Context?

// Persistence Context is a managed environment where JPA entities are stored and tracked.

// It:
    // Holds managed entity instances
    // Tracks changes (dirty checking)
    // Ensures identity guarantee
    // Synchronizes entities with the database
    // 📌 Persistence Context = First-Level Cache