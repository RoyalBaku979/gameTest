package com.example.demo.Service.Impl;

import com.example.demo.Dao.Inter.ActionDaoInter;
import com.example.demo.Entity.Action;
import com.example.demo.Form.ActionForm;
import com.example.demo.Service.Inter.ActionServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionServiceInter {
    private final ActionDaoInter actionDaoInter;

    @Autowired
    public ActionServiceImpl(ActionDaoInter actionDaoInter) {
        this.actionDaoInter = actionDaoInter;
    }

    @Override
    public void saveActionToDb(ActionForm actionForm) throws DataAccessException {
        actionDaoInter.save(new Action(actionForm.getUserId(), actionForm.getGameId(), actionForm.getAction()));
    }



}
