package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;      // 결과 페이지에 해당하는(View 개념의) 클래스

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {

        List<MenuDTO> menuList = menuService.findAllMenus();
//        System.out.println("menuList = " + menuList);     // Github에 올릴 때는 Println 문은 지우고 올린다. (주석이 아니라 완전 삭제하기)

        if (!menuList.isEmpty()) {
            printResult.printMenus(menuList);
        } else
            printResult.printErrorMessage("조회할 메뉴가 없습니다.");
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {

        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }

    public void registMenu(Map<String, String> parameter) {
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));
        int categoryCode = Integer.valueOf(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        /* 설명. 반환된 결과에 따라 상태코드 ( ex: 201, 500 ) 를 프론트 서버에 전달 -> 프론트 서버는 해당 상태 코드를 코드에 맞는 메세지를 출력 */
        //        boolean result = menuService.modifyMenu(menu);
        //        System.out.println("result = " + result);
        if (menuService.registMenu(menu)) {
            printResult.printSuccessMessage("regist");
        } else {
            printResult.printErrorMessage("메뉴 추가 실패!");
        }

    }

    public void modifyMenu(Map<String, String> parameter) {

        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        if (menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("modify");
        } else {
            printResult.printErrorMessage("메뉴 수정 실패!");
        }
    }

    public void removeMenu(Map<String, String> parameter) {

        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        if (menuService.removeMenu(menuCode)) {
            printResult.printSuccessMessage("remove");
        } else {
            printResult.printErrorMessage("메뉴 삭제 실패!");
        }
    }
}
