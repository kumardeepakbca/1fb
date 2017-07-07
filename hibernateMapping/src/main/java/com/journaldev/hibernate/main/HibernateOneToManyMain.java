package com.journaldev.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Cart1;
import com.journaldev.hibernate.model.Items1;
import com.journaldev.hibernate.util.HibernateAnnotationUtil;

public class HibernateOneToManyMain {
	public static void main(String[] args) {

		Cart1 cart = new Cart1();
		cart.setName("MyCart");
		
		Items1 item1 = new Items1("I1", 10, 1, cart);
		Items1 item2 = new Items1("I2", 20, 2, cart);
		Set<Items1> itemsSet = new HashSet<Items1>();
		itemsSet.add(item1); itemsSet.add(item2);
		
		cart.setItems1(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		
		//Save the Model objects
		session.save(cart);
		session.save(item1);
		session.save(item2);
		
		//Commit transaction
		tx.commit();
		System.out.println("Cart ID="+cart.getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
}