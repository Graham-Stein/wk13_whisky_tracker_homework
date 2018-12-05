package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findAllDistilleriesInRegion(String region){
        List<Distillery> results = null;
        Session session = entityManager.unwrap(Session.class);
// 3) get all the distilleries for a particular region
        try{
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));
            results = cr.list();

        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Whisky> findAllWhiskyFromRegion(String region){
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));
            results = cr.list();

        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Whisky> findAllWhiskyFromDistilleryOfAge(String distillery, int age){
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            //   4) get all the whisky from a particular distillery that's a specific age (if the whisky has a specific age

            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("name", distillery));
            cr.add(Restrictions.eq("whisky.age", age));
            results = cr.list();

        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


}



// 5) Get distilleries that have whiskies that are 12 years old