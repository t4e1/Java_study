package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /* 설명.
     *  @Qualifier를 통해 원하는 bean 이름(id)으로 하나의 빈을 주입 받을 수 있다.
     *  (@Praimary)보다 우선순위가 높다.
    * */
//    @Autowired
//    @Qualifier("squirtle")
    private Pokemon pokemon;

    /* 설명.
     *  @Autowired 는 생략하면 매개변수 있는 생성자에 자동으로 작성된다. (자동으로 생성자 주입이 됨)
     *  현재와 같이 Pokemon 타입의 빈이 2개 이상일 경우 @Primary 어노테이션을 통해 하나의 빈만 주입되게 할 수 있다.
    * */

    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}

