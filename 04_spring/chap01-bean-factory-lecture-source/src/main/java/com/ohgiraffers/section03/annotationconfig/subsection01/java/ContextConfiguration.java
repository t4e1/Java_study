package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/* 설명. 설정용 클래스도 bean으로 관리되며, 이름(bean의 id)을 부여할 수 있다. */

@Configuration("configurationSection03")

/* 설명. 1. 단순히 범위 지정만으로 @Component계열의 어노테이션들을 모두 bean으로 관리하는 경우 */
//@ComponentScan(basePackages = "com.ohgiraffers")        // 구성요소(bean)를 스캔하겠다. 범위를 지정해주면 해당 범위 내의 모든 클래스의 어노테이션을 확인해서 bean으로 관리한다.

/* 설명. 2. 범위 및 필터를 적용해서 bean을 관리하는 경우(excludeFilters) */
//@ComponentScan(basePackages = "com.ohgiraffers",
//        excludeFilters = {
//                @ComponentScan.Filter(
//                    /* 설명. 2-1. 타입으로 필터 설정 */
////                    type = FilterType.ASSIGNABLE_TYPE,
////                    classes = {MemberDAO.class}    // 지정한 범위를 훑어주되 필터의 타입은 제외하고 적용
//
//                    /* 설명. 2-2. 어노테이션 종류로 필터 설정 */
//                    type = FilterType.ASSIGNABLE_TYPE,
//                    classes = {org.springframework.stereotype.Repository.class}
//
//                )
//
//        })

/* 설명. 3. 범위 및 필터를 적용해서 bean을 관리하는 경우(includeFilters) */
@ComponentScan(basePackages = {"com.ohgiraffers", "com"},
                useDefaultFilters = false,
                includeFilters = {
                    @ComponentScan.Filter(
                            type=FilterType.ASSIGNABLE_TYPE,
                            classes = {MemberDTO.class}
                    )
                }
)

/* 설명.
 *  @ComponentScan 은 필터의 경우 개념 정도만 알아도 되지만, 기본적으로 @Configuration 클래스가 위치한
 *  패키지와 해당 패키지 하위만 Scan하기 떄문에 더 상위 범위나 다른 패키지를 Scan하기 위해 주로 사용 된다.
* */
public class ContextConfiguration {


}
