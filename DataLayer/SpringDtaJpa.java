package DataLayer;

/**********************************************
 * SPRING DATA JPA (Revision Notes)           *
 **********************************************/
public class SpringDtaJpa {

	/*
	1️⃣ Where We Were After JPA
	--------------------------
	After JPA:
	  ✔ Standard ORM
	  ✔ Portable code
	  ✔ Entity lifecycle defined
	But pain still existed:
	  - Repetitive CRUD code
	  - Too many DAOs
	  - EntityManager handling everywhere
	  - Boilerplate across projects
	  📌 Same CRUD logic, different entities

	// Typical JPA Code (Pre–Spring Data)
	@Repository
	public class UserRepository {
		@PersistenceContext
		private EntityManager em;

		public User findById(Long id) {
			return em.find(User.class, id);
		}

		public void save(User user) {
			em.persist(user);
		}
	}

	2️⃣ Why Spring Data JPA Was Introduced
	--------------------------------------
	- “If 80% of repositories do the same CRUD operations, why write them again?”
	- Goal: Eliminate DAO boilerplate, standardize repository patterns, increase productivity

	3️⃣ What Spring Data JPA Is
	--------------------------
	- Spring abstraction built on top of JPA
	- Generates repository implementations at runtime
	- Does NOT replace JPA or Hibernate

	4️⃣ Evolution Stack (Very Important)
	-----------------------------------
		Spring Data JPA
			  ↓
		JPA (Specification)
			  ↓
		Hibernate (Implementation)
			  ↓
		JDBC
			  ↓
		Database

	5️⃣ The Big Evolution: Repositories
	-----------------------------------
	Before (JPA): You wrote DAOs manually.
	After (Spring Data JPA): You only write interfaces.

	// Spring Data JPA Repository Example

	public interface UserRepository extends JpaRepository<User, Long> {
		// Custom query methods can be added here
		User findByEmail(String email);
		List<User> findByStatusAndAge(String status, int age);
		@Query("SELECT u FROM User u WHERE u.email = :email")
		User getUserByEmail(@Param("email") String email);
	}
	// 💥 Implementation generated automatically at runtime

	6️⃣ Key Repository Interfaces (with Explanation)
	-----------------------------------------------
	| Interface                  | Extends         | Key Features                        |
	|---------------------------|-----------------|--------------------------------------|
	| CrudRepository<T, ID>      | -               | Basic CRUD (save, findById, delete)  |
	| PagingAndSortingRepository | CrudRepository  | Adds paging & sorting                |
	| JpaRepository<T, ID>       | PagingAndSorting| JPA-specific, batch, flush, etc.     |

    “CrudRepository provides basic CRUD operations. JpaRepository extends 
    PagingAndSortingRepository and CrudRepository and adds JPA-specific features 
    like batch operations, flush control, and pagination. In real-world Spring applications, 
    JpaRepository is preferred because it offers more control and better performance.”
    
	// Example Usage:
	// CrudRepository
	public interface ProductRepo extends CrudRepository<Product, Long> {}

	// PagingAndSortingRepository
	public interface OrderRepo extends PagingAndSortingRepository<Order, Long> {}

	// JpaRepository
	public interface CustomerRepo extends JpaRepository<Customer, Long> {}

	// Common Methods:
	// save(), findById(), findAll(), deleteById(), count(), existsById()

	7️⃣ Query Method Derivation (Huge Feature)
	-----------------------------------------
	// Spring parses method names and builds JPQL automatically
	User findByEmail(String email);
	List<User> findByStatusAndAge(String status, int age);

	8️⃣ Custom Queries with @Query
	-----------------------------
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User getUserByEmail(@Param("email") String email);
	// Supports JPQL and native SQL

	9️⃣ Pagination & Sorting (Out of the Box)
	-----------------------------------------
	Page<User> users = repo.findAll(PageRequest.of(0, 10));

	🔟 No EntityManager Handling
	---------------------------
	- Spring injects it internally
	- Transaction-bound automatically
	- Cleaner service layer

	1️⃣1️⃣ What Spring Data JPA Improved Over JPA
	--------------------------------------------
	| Aspect         | JPA         | Spring Data JPA |
	|---------------|-------------|-----------------|
	| DAO Code      | Manual      | Auto-generated  |
	| Boilerplate   | Medium      | Minimal         |
	| Productivity  | Medium      | Very High       |
	| Pagination    | Manual      | Built-in        |
	| Query Creation| JPQL        | Method/@Query   |

	1️⃣2️⃣ What Spring Data JPA Does NOT Do
	--------------------------------------
	- ❌ Does not define ORM rules
	- ❌ Does not replace Hibernate
	- ❌ Does not manage persistence context itself
	- 📌 Delegates everything to JPA/Hibernate

	1️⃣3️⃣ Interview Traps (Answer Smart)
	------------------------------------
	Q: Is Spring Data JPA a replacement for JPA?
	   → No, it’s an abstraction on top of JPA.
	Q: Is Hibernate required?
	   → A JPA implementation is required; Hibernate is the most common.
	Q: Who executes SQL?
	   → Hibernate via JDBC.

	1️⃣4️⃣ 1-Minute Interview Answer (Perfect)
	-----------------------------------------
	“Spring Data JPA was introduced to reduce the boilerplate required when using JPA. 
    While JPA standardized ORM, developers still had to write repetitive repository code. 
    Spring Data JPA builds on top of JPA and automatically generates repository implementations at 
    runtime, supports query derivation, pagination, and sorting, and integrates seamlessly 
    with Spring’s transaction management, significantly improving productivity.”
	*/
}
