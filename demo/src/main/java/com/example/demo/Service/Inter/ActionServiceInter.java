package com.example.demo.Service.Inter;

import com.example.demo.Form.ActionForm;
import org.springframework.dao.DataAccessException;

import java.sql.SQLDataException;

public interface ActionServiceInter {
    void saveActionToDb(ActionForm actionForm) throws DataAccessException;
}
