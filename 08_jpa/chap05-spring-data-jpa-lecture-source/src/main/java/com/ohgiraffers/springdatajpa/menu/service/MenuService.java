package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/* 설명.
 *  Service 게층 : 비즈니스 로직, 트랜잭션 처리(@Transactional), DTO <-> Entity (modelmapper 라이브러리 활용)
 *  model mapper 사용 안할 시 : DTO를 get으로 꺼내서 Entity 에 넣는 메소드를 따로 빼내서 생성
* */
@Service
@Log4j2
public class MenuService {

    private final ModelMapper mapper;
    private final MenuRepository menuRepository;    // 쿼리를 날려주는 계층, DB를 쳐다보는 계층
    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuService(ModelMapper mapper, MenuRepository menuRepository, CategoryRepository categoryRepository) {
        this.mapper = mapper;
        this.menuRepository = menuRepository;
        this.categoryRepository = categoryRepository;
    }

    /* 설명. 1. findById 예제 & PathVariable */
    public MenuDTO findMenuByCode(int menuCode) {

        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        // findById는 내가 만들지는 않지만 JpaRepository가 물려준 메소드
        // orElseThrow 는 조회했는데 결과가 없을 때, 어떤 예외를 던질지 정한다.

        return mapper.map(menu, MenuDTO.class);
    }

    /* 설명. 2. findAll (페이징 처리 전) 예제 */
    public List<MenuDTO> findMenuList() {

        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());

        return menuList.stream().map(menu -> mapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
    }

    /* 설명. 3. findAll (페이징 처리 후) 예제 */
    public Page<MenuDTO> findMenuList(Pageable pageable) {

        /* 설명.
         *  1. 넘어온 pageable에 담긴 페이지 번호를 인덱스 개념으로 바꿔서 인지 시킴
         *  2. 한 페이지에 뿌려질 데이터 크기
         *  3. 정렬 기준
        * */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending());

        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> mapper.map(menu, MenuDTO.class));
    }

    public List<MenuDTO> findMenuPrice(int menuPrice) {

        /* 설명. 전달 받은 가격을 초과하는 메뉴의 목록을 조회하는 메소드 */
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);

        return menuList.stream().map(menu -> mapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
    }

    public List<CategoryDTO> findAllCategory() {

        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream().map(category -> mapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public void registMenu(MenuDTO newMenu) {

        mapper.getConfiguration().setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setFieldMatchingEnabled(true);
        log.info("result after model mapper: {}", mapper.map(newMenu, Menu.class));
        menuRepository.save(mapper.map(newMenu, Menu.class));
    }

    @Transactional
    public void modifyMenu(MenuDTO modifyMenu) {

        Menu foundMenu = menuRepository.findById(modifyMenu.getMenuCode()).orElseThrow(IllegalArgumentException::new);
        foundMenu.setMenuName(modifyMenu.getMenuName());

    }

    @Transactional
    public void deleteMenu(int menuCode) {

        menuRepository.deleteById(menuCode);
    }
}
