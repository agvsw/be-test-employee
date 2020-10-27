package com.agus.test.controller;

import com.agus.test.dao.PositionDao;
import com.agus.test.dto.CommonResponse;
import com.agus.test.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PositionController {

    @Autowired
    private PositionDao positionDao;

    @PostMapping(value = "/position")
    public CommonResponse<Position> addPosition(@RequestBody Position position){
        CommonResponse<Position> response = new CommonResponse<>();
        response.setData(positionDao.addPosition(position));
        return response;
    }

    @GetMapping(value = "/positions")
    public CommonResponse<List<Position>> getAllPosition(){
        CommonResponse<List<Position>> response = new CommonResponse<>();
        response.setData(positionDao.getAllPosition());
        return response;
    }
}
