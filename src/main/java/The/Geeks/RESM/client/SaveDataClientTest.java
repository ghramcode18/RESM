package The.Geeks.RESM.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.util.HibernateUtil;


public class SaveDataClientTest {
	
    public static void main(String[] args) {
		Transaction tx =  null;
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			tx = session.beginTransaction();
			
			EstatesEntity estatesEntity1 = new EstatesEntity();
		    estatesEntity1.setBuyerName("abd");
            estatesEntity1.setPropertyName("home4");
            estatesEntity1.setSellingPrice(110);
            estatesEntity1.setPrice(100);
            estatesEntity1.setSharesNumber(22);
			
			EstatesEntity estatesEntity2 = new EstatesEntity();
            estatesEntity2.setBuyerName("abd_alhady");
            estatesEntity2.setPropertyName("home4");
            estatesEntity2.setSellingPrice(110);
            estatesEntity2.setPrice(100);
            estatesEntity2.setSharesNumber(22);
			
			session.persist(estatesEntity1);
			session.persist(estatesEntity2);
			
			tx.commit();
		} catch (Exception e) {
			if(tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
	}
}