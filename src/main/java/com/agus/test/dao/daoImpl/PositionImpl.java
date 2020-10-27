package com.agus.test.dao.daoImpl;

import com.agus.test.dao.PositionDao;
import com.agus.test.entity.Position;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PositionImpl implements PositionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Position addPosition(Position position) {
        return entityManager.merge(position);
    }

    @Override
    public List<Position> getAllPosition() {
        Query query = entityManager.createQuery("FROM Position WHERE isDelete = 0");
        return query.getResultList();
    }

    @Override
    public Position getById(Integer id) {
        Query query =entityManager.createQuery("FROM Position WHERE id = :id")
                .setParameter("id", id);
        return (Position) query.getSingleResult();
    }
}
