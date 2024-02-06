package com.ohgiraffers.section02.update;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {

    public void modifyMenu(Menu modifyMenu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.modifyMenu(con, modifyMenu);
        if (result > 0) {
            System.out.println("성공");
            commit(con);
        } else {
            System.out.println("실패");
            rollback(con);
        }

        close(con);
    }
}
