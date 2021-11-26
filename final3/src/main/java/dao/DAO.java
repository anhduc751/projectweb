
  package dao;
  
  import java.util.List;
  
  import org.hibernate.Session; 
  import org.hibernate.Transaction;
  
  import context.HibernateUtil; 
  import entity.*; 
  
  public class DAO {
  
 /**
	 * Get Product By Id
	 * 
	 * @param id
	 * @return
	 */

  
	  public Product getProduct(int pid) {

	        Transaction transaction = null;
	        Product product = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            product = session.get(Product.class, pid);
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return product;
	    }
  
  public Category getCategory(int id) {
  
  Transaction transaction = null; Category product = null; try (Session session
  = HibernateUtil.getSessionFactory().openSession()) { // start a transaction
  transaction = session.beginTransaction(); // get an user object product =
  session.get(Category.class, id); // commit transaction transaction.commit();
  } catch (Exception e) { if (transaction != null) { transaction.rollback(); }
  e.printStackTrace(); } return product; }
  
  
 /**
	 * Get all products
	 * 
	 * @return
	 */
		  @SuppressWarnings("unchecked") 
		  public List<Product> listAllProduct() { 
			  try {
		  return
		  HibernateUtil.getSessionFactory().openSession().createQuery("From Product").
		  getResultList(); } catch (Exception e) { e.printStackTrace(); 
		  } return null;
		  }
		  
		  @SuppressWarnings("unchecked") 
		  public List<Category> listAllCategory() { 
			  try
		  { 
				  return
		  HibernateUtil.getSessionFactory().openSession().createQuery("From Category").
		  getResultList(); 
				  } catch (Exception e) { e.printStackTrace(); } 
			  return null;
		  } 
		  @SuppressWarnings("unchecked") 
		  public List<Product> listProductByCate(int cid) { 
			  try {
		  return
		  HibernateUtil.getSessionFactory().openSession().createQuery("From Product Where cateid LIKE '"+cid+"'" ).
		  getResultList(); } catch (Exception e) { e.printStackTrace(); 
		  } return null;
		  }
		  @SuppressWarnings("unchecked") 
		  public List<Product> listProductByName(String Name) { 
			  try {
		  return
		  HibernateUtil.getSessionFactory().openSession().createQuery("From Product Where pname LIKE '%"+Name+"%'" ).
		  getResultList(); } catch (Exception e) { e.printStackTrace(); 
		  } return null;
		  }
		  
		  
		  public void saveUser(useraccount user) {
			        Transaction transaction = null;
			        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			            // start a transaction
			            transaction = session.beginTransaction();
			            // save the  object
			            session.save(user);
			            // commit transaction
			           transaction.commit();
			           
			        } catch (Exception e) {
			            if (transaction != null) {
			                transaction.rollback();
			            }
			            e.printStackTrace();
			        }
			    }

		   public boolean validate(String userName, String password) {

			        Transaction transaction = null;
			        useraccount user = null;
			        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			            // start a transaction
			            transaction = session.beginTransaction();
			            // get an user object
			            user = (useraccount) session.createQuery("FROM useraccount U WHERE U.uName = :userName").setParameter("userName", userName)
			                .uniqueResult();

			            if (user != null && user.getuPass().equals(password)) {
			                return true;
			            }
			            // commit transaction
			            transaction.commit();
			        } catch (Exception e) {
			            if (transaction != null) {
			                transaction.rollback();
			            }
			            e.printStackTrace();
			        }
			        return false;
			    }
		   public boolean accountcheck(String userName) {

		        Transaction transaction = null;
		        useraccount user = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start a transaction
		            transaction = session.beginTransaction();
		            // get an user object
		            user = (useraccount) session.createQuery("FROM useraccount U WHERE U.uName = :userName").setParameter("userName", userName)
		                .uniqueResult();

		            if (user.getuName().equals(userName)) {
		                return true;
		            }
		            // commit transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
		        }
		        return false;
		    }

			
		 
		 
  }
		 