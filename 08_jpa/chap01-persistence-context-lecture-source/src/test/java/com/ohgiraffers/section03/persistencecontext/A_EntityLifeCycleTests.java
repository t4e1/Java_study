package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class A_EntityLifeCycleTests {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    /* 필기.
     *  영속성 컨텍스트는 엔티티 매니저가 엔티티 객체를 저장하는 공간으로 엔티티 객체를 보관하고 관리한다.
     *  엔티티 매니저가 생성될 때 하나의 영속성 컨텍스트가 만들어진다.
     *
     * 필기.
     *  엔티티의 생명 주기
     *  비영속, 영속, 준영속, 삭제 상태
    * */
    @Test
    public void 비영속성_테스트() {
        Menu foundMenu = entityManager.find(Menu.class, 21);    // 영속성 컨텍스트가 관리하는 객체
        System.out.println("foundMenu = " + foundMenu);

        /* 설명. 영속 상태의 객체에서 값을 추출해 담더라도 새로 생성되어 영속성 컨텍스트와 관련 없는 객체는 비영속 상태이다. */
        Menu newMenu = new Menu();                                 // 비영속성 객체 (영속성 컨텍스트에서 관리 되지 않는 객체)
        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setCategoryCode(foundMenu.getCategoryCode());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());

        boolean isTrue = (foundMenu == newMenu);

        Assertions.assertFalse(isTrue);                             // foundMenu 와 newMenu가 같지 않으면 테스트 통과
    }

    @Test
    public void 영속성_연속_조회_테스트() {
        Menu foundMenu1 = entityManager.find(Menu.class, 21);
        Menu foundMenu2 = entityManager.find(Menu.class, 21);

        boolean isTrue = (foundMenu1 == foundMenu2);
        System.out.println("foundMenu1.hashCode() = " + foundMenu1.hashCode());
        System.out.println("foundMenu2.hashCode() = " + foundMenu2.hashCode());
        Assertions.assertTrue(isTrue);                              // 두 객체가 같으면 테스트 통과
    }

    @Test
    public void 영속성_객체_추가_테스트() {

        /* 설명.
         *  이 예제에서는 menuCode 필드 값에 직접 값을 주고자 한다. (auto_increment 개념 안 쓸 예정)
         *   @GeneratedValue(strategy = GenerationType.IDENTITY) 를 주석 처리하고 테스으를 작성한다.
        * */
        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(500);
        menuToRegist.setMenuName("수박죽");
        menuToRegist.setMenuPrice(10000);
        menuToRegist.setCategoryCode(10);
        menuToRegist.setOrderableStatus("Y");

        entityManager.persist(menuToRegist);
        Menu foundMenu = entityManager.find(Menu.class, 500);

        boolean isTrue = (menuToRegist == foundMenu);

        Assertions.assertTrue(isTrue);
    }

    @Test
    public void 영속성_객체_값_추가_값_변경_테스트() {

        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(500);
        menuToRegist.setMenuName("수박죽");
        menuToRegist.setMenuPrice(10000);
        menuToRegist.setCategoryCode(10);
        menuToRegist.setOrderableStatus("Y");

        entityManager.persist(menuToRegist);
        menuToRegist.setMenuName("메론죽");

        Menu foundMenu = entityManager.find(Menu.class, 500);

        Assertions.assertEquals("메론죽", foundMenu.getMenuName());

    }

    @Test
    public void 준영속성_detach_테스트() {

        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);

        /* 설명.
         *  영속성 컨텍스트가 관리하던 엔티티 객체를 관리하지 않는 상태가 되게 한 것을 준영속 상태라고 한다.
         *  detach가 준영속 상태를 만들기 위한 메소드이다.
        * */

        entityManager.detach(foundMenu2);

        foundMenu1.setMenuPrice(10000);
        foundMenu2.setMenuPrice(10000);

        Assertions.assertEquals(10000, entityManager.find(Menu.class, 11).getMenuPrice());
        Assertions.assertEquals(10000, entityManager.find(Menu.class, 12).getMenuPrice());

    }

    @Test
    public void 준영속성_clear_테스트() {

        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);

        // 설명. 영속성 컨텍스트로 관리되던 엔티티 객체들을 모두 비영속 상태로 바꿈
//        entityManager.clear();        // 영속성 컨텍스트를 전부 비워서 빈 공간으로 만듬

        /* 설명. 영속성 컨텍스트 및 entityManager까지 종료해 버린다. (사용 불가) */
        entityManager.close();

        foundMenu1.setMenuPrice(5000);      // clear 로 인해서 비영속 상태가 된 객체의 값을 변경
        foundMenu2.setMenuPrice(5000);

        /* 설명. DB에서 새로 조회 해온 객체를 영속 상태로 두기 때문에 전혀 다른 결과가 나온다. */
        /* 설명. 영속성 컨텍스트에 foundMenu1, foundMenu2가 없기 때문에 새로운 객체를 DB에서 불러오고, 다른 값이 나온다. */
        Assertions.assertEquals(5000, entityManager.find(Menu.class, 11).getMenuPrice());
        Assertions.assertEquals(5000, entityManager.find(Menu.class, 12).getMenuPrice());
    }

    @Test
    public void 병합_merge_수정_테스트() {
        Menu menuToDetach = entityManager.find(Menu.class, 2);
        entityManager.detach(2);

        menuToDetach.setMenuName("수박죽");        // detach 한 객체의 메뉴 이름 변경
        Menu refoundMenu = entityManager.find(Menu.class, 2);       //  다시 가져온 refoundMenu에는 기존의 메뉴 이름이 있다.

        System.out.println(menuToDetach.hashCode());
        System.out.println(refoundMenu.hashCode());

        entityManager.merge(menuToDetach);      // 제일 처음 수정된 detach 된 객체의 값이 refoundMenu 의 값을 덮어쓴다.

        Menu mergedMenu = entityManager.find(Menu.class, 2);
        Assertions.assertEquals("수박죽", mergedMenu.getMenuName());
    }

    @Test
    public void 병합_merge_삽입_테스트() {
        Menu menuToDetach = entityManager.find(Menu.class, 2);
        entityManager.detach(menuToDetach);

        menuToDetach.setMenuCode(999);
        menuToDetach.setMenuName("수박죽");

        entityManager.merge(menuToDetach);

        Menu newMenu = entityManager.find(Menu.class, 2);
        Menu mergedMenu = entityManager.find(Menu.class, 999);
        Assertions.assertNotEquals(mergedMenu.getMenuCode(), newMenu.getMenuCode());

    }

}
