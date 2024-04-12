// - refer : DDL, DML, ERD
// - callDao(/q/r/board/callDao) in QuestBoardController, QuestBoardService
// - CRUD 작성 : board와 comments 적용

package com.example.co_templates.quests.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

@Service
public class QuestCommentsService {
    @Autowired
    ShareDao shareDao;

    @Autowired
    Commons commons;

    public void callDao(HashMap<String, Object> dataMap){
        // 여러개 가져오기
        String sqlMapId = "BOARDS.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);

        // 입력
        sqlMapId = "BOARDS.insert";
        // (`PK_BOARDS`, `TITLE`, `CONTENTS`, `WRITER_ID`, `CREATE_DATE`, `PARENT_BOARDS`)
        // VALUES
        // ('news-001', 'Global Warming Crisis', 'The impact of global warming on our planet.', 'author-1', CURRENT_TIMESTAMP, 'environment');
        String pk_boards = commons.getUniqueSequence();
        dataMap.put("PK_BOARDS", pk_boards);
        dataMap.put("TITLE", "Global Warming Crisis");
        dataMap.put("CONTENTS", "The impact of global warming on our planet.");
        dataMap.put("WRITER_ID", "author-1");
        dataMap.put("CREATE_DATE", "CURRENT_TIMESTAMP");
        dataMap.put("PARENT_BOARDS", "environment");
        Object insert = shareDao.insert(sqlMapId, dataMap);

        // 수정
        sqlMapId = "BOARDS.update";
        dataMap.put("PK_BOARDS", pk_boards);
        dataMap.put("WRITER_ID", "user21");
        Object update = shareDao.update(sqlMapId, dataMap);

        // 삭제
        sqlMapId = "BOARDS.delete";
        dataMap.put("PK_BOARDS", pk_boards);
        Object delete = shareDao.delete(sqlMapId, dataMap);
        return;
    }
}
