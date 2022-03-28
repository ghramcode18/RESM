package The.Geeks.RESM.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.util.HibernateUtil;


public class SimulateOptimisticLockingTest {
 
	public static void main(String[] args) {
		Integer estatesId = 1;
		Thread t1 = new Thread(new Runnable() {
			Session session1 = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;

			@Override
			public void run() {
				EstatesEntity estatesEntity = session1.get(EstatesEntity.class, estatesId);
				if (estatesEntity != null) {
					tx = session1.beginTransaction();

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					estatesEntity.setBuyerName("ali@gmail");
					session1.update(estatesEntity);
					tx.commit();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;

			@Override
			public void run() {
				EstatesEntity estatesEntity = session2.get(EstatesEntity.class, estatesId);
				if (estatesEntity != null) {
					tx = session2.beginTransaction();
					estatesEntity.setBuyerName("ali@gmail");
					session2.update(estatesEntity);
					tx.commit();
				}
			}
		});

		t1.start();
		t2.start();
	}

}
