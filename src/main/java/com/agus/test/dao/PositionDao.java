package com.agus.test.dao;

import com.agus.test.entity.Position;

import java.util.List;

public interface PositionDao {
    Position addPosition(Position position);
    List<Position> getAllPosition();
    Position getById(Integer id);
}
