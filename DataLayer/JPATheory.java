package DataLayer;

/***************************************
 * JPA THEORY (Revision Notes)         *
 ***************************************/
public class JPATheory {

    /*
    1️⃣ What is JPA?
    ----------------
    - JPA (Java Persistence API) is a specification (not a framework).
    - Defines rules, APIs, and behavior for ORM in Java.
    - No implementation logic; implemented by vendors (Hibernate, EclipseLink, etc).
    - 📌 Think of it as a blueprint for ORM.

    2️⃣ Problem Before JPA (Pre-JPA Era)
    -------------------------------------
    - Hibernate was vendor-specific (no standard API).
    - Switching ORM = rewrite code (tight coupling).
    - Example (Hibernate-dependent):
        Session session = sessionFactory.openSession();
        User u = session.get(User.class, 1L);

    3️⃣ Why JPA Was Introduced
    --------------------------
    - To standardize ORM in Java.
    - Make applications implementation-independent.
    - Improve portability across vendors.
    - 📌 Hibernate influenced JPA, but JPA is not Hibernate.

    4️⃣ JPA Key Definition
    ----------------------
    - JPA defines how Java objects are persisted to relational databases.
    - It defines:
        • Standard annotations
        • Entity lifecycle
        • Persistence Context
        • Query language (JPQL)
        • Transaction semantics
    - ❗ JPA does NOT implement ORM; it needs an implementation.

    5️⃣ JPA vs Hibernate (Table)
    ---------------------------
    | Aspect           | Hibernate   | JPA (Spec)   |
    |------------------|------------|--------------|
    | Type             | Framework  | Specification|
    | Portability      | Low        | High         |
    | API Stability    | Varies     | Stable       |
    | Vendor Lock-in   | High       | Low          |
    | Learning Curve   | Higher     | Lower        |
    | Enterprise Sup.  | Partial    | Full         |

    6️⃣ Key Features Standardized by JPA
    -------------------------------------
    1. Standard Annotations:
        @Entity, @Table, @Id, @OneToMany, @ManyToOne, ...
        // Before JPA: Hibernate-specific
        // After JPA: Common standard

    2. Persistence Context:
        - JPA formally defined: Managed, Detached, Removed, New
        - Hibernate had it, JPA standardized it

    3. JPQL (Java Persistence Query Language):
        - Object-oriented queries (on entities, not tables)
        - Example:
            SELECT u FROM User u WHERE u.email = :email
        - Portable across DBs, independent of SQL dialect

    4. EntityManager API:
        - Standard operations:
            persist(), find(), merge(), remove()
        - Example:
            EntityManager em = ...;
            em.persist(user);
            User u = em.find(User.class, 1L);
            em.remove(u);

    5. Transaction Integration:
        - Works with JTA
        - Standard transactional semantics
        - Better enterprise support

    7️⃣ JPA Architecture (How it fits)
    -----------------------------------
        JPA API
          ↓
        Hibernate ORM (or EclipseLink, etc)
          ↓
        JDBC
          ↓
        Database

    8️⃣ Important Clarification (INTERVIEW GOLD)
    --------------------------------------------
    - JPA did NOT replace Hibernate
    - Hibernate became a JPA implementation

    9️⃣ When to Use Hibernate Features Directly
    -------------------------------------------
    - Even with JPA, you may use Hibernate-specific features for:
        • 2nd-level cache config
        • Custom types
        • Performance tuning

    -----------------------------------
    // CODE EXAMPLES
    -----------------------------------

    // 1. Entity Class Example
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String email;

        // getters and setters
    }

    // 2. Basic JPA Usage Example
    import javax.persistence.*;

    public class JpaExample {
        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // Create
            User user = new User();
            user.setName("Alice");
            user.setEmail("alice@email.com");
            em.persist(user);

            // Read
            User found = em.find(User.class, user.getId());

            // Update
            found.setEmail("alice@newmail.com");
            em.merge(found);

            // Delete
            em.remove(found);

            tx.commit();
            em.close();
            emf.close();
        }
    }

    // 3. JPQL Query Example
    String jpql = "SELECT u FROM User u WHERE u.email = :email";
    TypedQuery<User> query = em.createQuery(jpql, User.class);
    query.setParameter("email", "alice@email.com");
    List<User> users = query.getResultList();

    */
}
