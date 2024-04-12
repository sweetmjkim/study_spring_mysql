// - refer : DDL, DML, ERD
// - callDao(/q/r/board/callDao) in QuestBoardController, QuestBoardService
// - CRUD 작성 : board와 comments 적용


package com.example.co_templates.quests.restapis;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.co_templates.quests.services.QuestBoardService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class QuestBoardController {

    @Autowired
    QuestBoardService questBoardService;

    @GetMapping("/q/r/board/callDao")
    public void callDao(HashMap dataMap) {
        questBoardService.callDao(dataMap);
        return;
    }
}
