package com.ohgiraffers.section04.assignment.service;

import com.ohgiraffers.section04.assignment.aggregate.Member;
import com.ohgiraffers.section04.assignment.repository.MemberRepository;
import java.util.ArrayList;

/* 설명. 트랜잭션 성공실패 여부 확인 및 회원 관련 비즈니스 로직 처리하는 클래스 */
public class MemberService {

    private final MemberRepository mr = new MemberRepository();

    public void selectAllMembers() {
        ArrayList<Member> selectedMembers = mr.selectAllMembers();

        /* 설명. 회원이 한명도 없어서 조회 결과가 없더라도 ArrayList객체는 넘어온다.(Empty 상태로) */
        /* 항상 != null 이 아니라 객체를 만들어서 isEmpty 로 판단해야 한다. */
        if(!selectedMembers.isEmpty()){     // 회원이 한명이라도 조회 된다면
            //        System.out.println("==== service까지 잘 반환되어 오나 확인 ====");
            for (Member m : selectedMembers) {
                System.out.println(m);
            }

            return;                         // 이후 코드와 상관 없이 메소드 종료
        }

        /* 설명. 조건이 맞지 않는 경우(회원이 조회되지 않는 경우) 출력 되는 구문(위의 조건이 맞으면 실행되지 않음)(feat. else 안 쓰기) */
        System.out.println("아직 등록된 회원이 없습니다.");
    }

    /* 설명. 전달된 회원 번호를 활용해 레포지터리에 있는 memberList로부터 해당 회원 찾아 반환 받기 */
    public void selectMember(int memNo) {
        Member selectedMember = mr.selectMember(memNo);

        if (selectedMember != null) {
            System.out.println("조회된 회원은: " + selectedMember);
        } else {
            System.out.println("그런 회원이 없습니다 ");
        }
    }

    /* 설명. 입력받아 넘어온 회원이 가질 번호를 만들고 추가 후 repository로 전달 후 결과 확인 */
    public void registMember(Member member) {
//        System.out.println("사용자가 입력해서 넘겨준 Member 확인: " + member);

        int lastMemberNo = mr.selectLastMemberNo();
        member.setMemNo(lastMemberNo + 1);

        int result = mr.saveMember(member);
        if (result == 1) {
            System.out.println(member.getId() + "님의 회원 가입이 성공하였습니다.");
        }
    }

    public void deleteMember(int memNo) {
        int result = mr.deleteMember(memNo);
        if (result > 0) {
            System.out.println(memNo + "번 회원 탈퇴 성공");
            return;
        }
        System.out.println("회원 탈퇴에 실패하였습니다.");
    }

    public void updateMember(int memNo, Member getInfo) {
        int result = mr.updateMember(memNo);
        if (result > 0) {
            System.out.println(memNo + "번 회원 탈퇴 성공");
            return;
        }
        System.out.println("회원 정보 수정에 실패하였습니다.");
    }
}
