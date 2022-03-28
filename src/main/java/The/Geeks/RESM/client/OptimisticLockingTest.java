package The.Geeks.RESM.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.util.HibernateUtil;


public class OptimisticLockingTest {
    public static void main(String[] args) {
		Transaction tx = null;
        
	//	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){

			Integer estatesEntityID = 1;
			EstatesEntity estatesEntity = session.get(EstatesEntity.class, estatesEntityID);

			if(estatesEntity != null){
				tx = session.beginTransaction();
				estatesEntity.setBuyerName("ali@gmail");
				session.update(estatesEntity);
				tx.commit();
			}else{
				System.out.println("estatesEntity details not found with ID: "+estatesEntityID);
			}
		}catch(Exception e){ 
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
	}
}