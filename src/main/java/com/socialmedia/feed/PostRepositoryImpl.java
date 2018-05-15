package com.socialmedia.feed;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class PostRepositoryImpl implements CustomPostRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Post> customMethod() {
		Query query  = em.createQuery("Select p from Post p where p.softDeleted=false and p.accountId = 2");
		 @SuppressWarnings("unchecked")
		List<Post> list = (List<Post>)query.getResultList( );
		 return list;
//		 for( Post p:list ) {
//	         System.out.print("Employee ID :" + p.getTitle());
//	      }
	}
	
}
