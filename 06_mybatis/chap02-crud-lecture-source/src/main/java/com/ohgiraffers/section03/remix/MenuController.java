package com.ohgiraffers.section03.remix;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenu() {

        List<MenuDTO> menus = menuService.findAllMenu();

        if (!menus.isEmpty()) {
            printResult.printMenus(menus);
        } else {
            printResult.printErrorMessage("전체 메뉴 조회실패!");
        }
    }

    public void findMenuByCode(Map<String, String> parameter) {

        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        MenuDTO menu = menuService.findMenuByCode(menuCode);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menu.getMenuCode()+ "번 메뉴 조회에 실패했습니다.");
        }
    }

    public void registMenu(Map<String, String> parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.valueOf(parameter.get("menuPrice")));
        menu.setCategoryCode(Integer.valueOf(parameter.get("categoryCode")));

        if (menuService.registMenu(menu)) {
            printResult.printSuccessMessage("regist");
        } else {
            printResult.printErrorMessage("메뉴 등록에 실패하였습니다.");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(Integer.valueOf(parameter.get("menuCode")));
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.valueOf(parameter.get("menuPrice")));

        if (menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("modify");
        } else {
            printResult.printErrorMessage("메뉴 수정에 실패하였습니다. ");
        }
    }

    public void removeMenu(Map<String, String> parameter) {

        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        if (menuService.removeMenu(menuCode)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("메뉴 삭제에 실패하였습니다.");
        }


    }
}
