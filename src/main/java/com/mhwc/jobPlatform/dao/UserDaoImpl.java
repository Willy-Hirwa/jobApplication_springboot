package com.mhwc.jobPlatform.dao;

import com.mhwc.jobPlatform.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where username=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public User findByEmail(String email) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where email=:uemail", User.class);
		theQuery.setParameter("uemail", email);
		User theEmail = null;
		try{
			theEmail = theQuery.getSingleResult();
		}catch(Exception e){
			theEmail = null;
		}
		return theEmail;
	}

	@Override
	public User findById(Long id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where id=:uid", User.class);
		theQuery.setParameter("uid", id);
		User theUser = null;
		try{
			theUser = theQuery.getSingleResult();
		}catch(Exception e){
			theUser = null;
		}
		return theUser;
	}

	@Override
	public User findByEmailAndPhoneNumber(String email, String phoneNumber) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where email=:uemail and phoneNumber=:uphone", User.class);
		theQuery.setParameter("uemail", email);
		theQuery.setParameter("uphone",phoneNumber);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public User save(User theUser) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
		return theUser;
	}



}
