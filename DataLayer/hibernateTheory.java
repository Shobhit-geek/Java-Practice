package DataLayer;

/**
 * Hibernate Theory
 * ----------------
 * Hibernate is an open-source Object-Relational Mapping (ORM) framework for Java.
 * It sits on top of JDBC
 * It simplifies database interactions by mapping Java objects to database tables.
 *
 * Evolution from JDBC:
 * --------------------
 * - JDBC requires manual SQL queries, result set handling, and object mapping.
 * - Hibernate automates SQL generation, object mapping, and transaction management.
 * - Reduces boilerplate code and improves maintainability.
 *
 * JDBC vs Hibernate:
 * ------------------
 * | Feature         | JDBC                        | Hibernate                  |
 * |-----------------|----------------------------|----------------------------|
 * | SQL Handling    | Manual                     | Automatic (HQL/Criteria)   |
 * | Mapping         | Manual (ResultSet)         | Automatic (ORM)            |
 * | Transactions    | Manual                     | Automatic/Declarative      |
 * | Caching         | No                         | Yes                        |
 * | Portability     | Vendor-specific SQL         | Database-independent       |
 *
 * Internal Architecture
    Application
        ↓
    Hibernate ORM
        ↓
       JDBC
        ↓
      Database

 * Example Hibernate Query (HQL):
 * ------------------------------
 * String hql = "FROM Student WHERE marks > 80";
 * Query query = session.createQuery(hql);
 * List<Student> students = query.list();
 *
 * How to Code with Hibernate (Simple Example):
 * --------------------------------------------
 * 1. Add Hibernate dependencies (JARs or Maven/Gradle).
 * 2. Create a POJO (Plain Old Java Object) annotated with @Entity.
 * 3. Configure hibernate.cfg.xml (DB connection, mapping, etc).
 * 4. Use SessionFactory and Session to interact with DB.
 *
 * Example:
 * --------
 * // Student.java
 * @Entity
 * public class Student {
 *     @Id
 *     private int id;
 *     private String name;
 *     private int marks;
 *     // getters and setters
 * }
 *
 * // Main.java
 * import org.hibernate.*;
 * import org.hibernate.cfg.Configuration;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         SessionFactory factory = new Configuration().configure().buildSessionFactory();
 *         Session session = factory.openSession();
 *         Transaction tx = session.beginTransaction();
 *
 *         // Save a student
 *         Student s = new Student();
 *         s.setId(1);
 *         s.setName("John");
 *         s.setMarks(90);
 *         session.save(s);
 *
 *         // Query students
 *         List<Student> list = session.createQuery("FROM Student", Student.class).list();
 *         for (Student stu : list) {
 *             System.out.println(stu.getName());
 *         }
 *
 *         tx.commit();
 *         session.close();
 *         factory.close();
 *     }
 * }
 *
 * // hibernate.cfg.xml (example snippet)
 * <hibernate-configuration>
 *   <session-factory>
 *     <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/mydb</property>
 *     <property name="hibernate.connection.username">root</property>
 *     <property name="hibernate.connection.password">password</property>
 *     <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
 *     <mapping class="Student"/>
 *   </session-factory>
 * </hibernate-configuration>
 */
public class hibernateTheory {
	// See the comments above for Hibernate theory, differences, and example code.
}


/***************************************
 * HIBERNATE CACHING (Revision Notes) *
 ***************************************/

// Why Hibernate Needs Caching:
// - Hibernate sits on top of JDBC.
// - Without caching, every entity fetch = DB hit (slow).
// - Caching helps to:
//     • Reduce database calls
//     • Improve performance
//     • Improve scalability

// =============================
// TYPES OF CACHING IN HIBERNATE
// =============================

// ┌─────────────┐
// │ Application │
// └──────┬──────┘
//        ↓
//   ┌──────────┐
//   │Hibernate │
//   └────┬─────┘
//        ↓
//   ┌─────────────────────────────┐
//   │ 1️⃣ First-Level Cache (L1)  │ ← Mandatory (Session/Context)
//   └────────────┬────────────────┘
//                ↓ (miss)
//   ┌─────────────────────────────┐
//   │ 2️⃣ Second-Level Cache (L2) │ ← Optional (SessionFactory)
//   └────────────┬────────────────┘
//                ↓ (miss)
//            Database

// -----------------------------------
// 1️⃣ FIRST-LEVEL CACHE (L1 CACHE)
// -----------------------------------
// - Default cache in Hibernate
// - Associated with Session (Persistence Context)
// - Enabled by default (cannot be disabled)
// - Works within a single session
// - Stores managed entities

// Example:
// Session session = sessionFactory.openSession();
// User u1 = session.get(User.class, 1L); // DB hit
// User u2 = session.get(User.class, 1L); // NO DB hit (L1 cache)

// Key Points:
// - Same object instance returned
// - Prevents duplicate queries in one session
// - Cleared when session is closed

// -----------------------------------
// 2️⃣ SECOND-LEVEL CACHE (L2 CACHE)
// -----------------------------------
// - Optional cache
// - Shared across sessions
// - Scoped to SessionFactory

// Session vs SessionFactory:
//   Session: Short-lived, per request/transaction, owns L1 cache
//   SessionFactory: Long-lived (singleton), created at startup, owns L2 cache

// Example:
// @Entity
// @Cacheable
// @org.hibernate.annotations.Cache(
//    usage = CacheConcurrencyStrategy.READ_WRITE
// )
// class User { }

// Key Points:
// - Prevents DB hits across sessions
// - Ideal for read-heavy data
// - Needs configuration

// Flow:
// Session A          Session B
//    ↓                  ↓
//  [ L1 Cache ]      [ L1 Cache ]
//       ↓                 ↓
//       └────── L2 Cache ─┘
//               ↓
//            Database

// -----------------------------------
// 3️⃣ QUERY CACHE (Built on L2 Cache)
// -----------------------------------
// - Caches query results (IDs), not entities
// - Uses L2 cache internally

// Example:
// query.setCacheable(true);

// Key Points:
// - Query cache stores only primary keys
// - Entities still resolved from L2 or DB

// Query → Query Cache → Entity Cache → DB

// -----------------------------------
// CACHE HIT FLOW (FULL PICTURE)
// -----------------------------------
// get(User, id)
//    ↓
// L1 Cache (Session)
//    ↓ (miss)
// L2 Cache (SessionFactory)
//    ↓ (miss)
// Database
//    ↓
// Store in L2 → Store in L1

// ****** FULL FETCH FLOW (Step-by-Step)
// Scenario: User with ID = 1

// Request 1 (Session 1):
//   → L1 miss
//   → L2 miss
//   → DB hit
//   → Store in L2
//   → Store in L1

// Request 2 (Session 2):
//   → L1 miss (new session)
//   → L2 hit ✅
//   → NO DB call
//   → Store in L1

// 👉 This is how caching works even when sessions are new

// -----------------------------------
// CACHE CONCURRENCY STRATEGIES
// -----------------------------------
// | Strategy              | Use Case                |
// |-----------------------|-------------------------|
// | READ_ONLY             | Static data             |
// | READ_WRITE            | Frequently updated data |
// | NONSTRICT_READ_WRITE  | Slightly stale allowed  |
// | TRANSACTIONAL         | JTA environments        |

// -----------------------------------
// WHAT IS NOT CACHED BY DEFAULT?
// -----------------------------------
// - Native SQL queries
// - Bulk updates
// - Stateless sessions
// - Large result sets

// -----------------------------------
// L1 vs L2 CACHE SUMMARY TABLE
// -----------------------------------
// | Feature        | L1 Cache (Session) | L2 Cache (SessionFactory) |
// |---------------|-------------------|--------------------------|
// | Default       | Yes               | No                       |
// | Shared        | No                | Yes                      |
// | Config Needed | No                | Yes                      |
// | Use Case      | Avoid duplicate    | Reduce DB load           |
// |               | hits in session   |                          |

// -----------------------------------
// COMMON INTERVIEW TRAPS
// -----------------------------------
// Q: Can we disable L1 cache?
//    → No
// Q: Does L2 replace DB?
//    → No, it's a performance optimization
// Q: Is cache transactional?
//    → Depends on concurrency strategy