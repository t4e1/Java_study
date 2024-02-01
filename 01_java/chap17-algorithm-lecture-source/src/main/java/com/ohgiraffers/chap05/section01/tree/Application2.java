package com.ohgiraffers.chap05.section01.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application2 {
    static class Node {

        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;

        }
    }
    static List<Node>[] list;

    static StringBuilder sb = new StringBuilder();

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        int n = Integer.parseInt(br.readLine());            // Integer 타입으로 입력받은 첫번째 줄 변경, 몇 개의 리스트를 생성할 것인지 결정

        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {                    // n = 7 이니 1~7까지 7개를 작성하기 위해 n+1
            list[i] = new ArrayList<>();                    // 다형성을 위한 ArrayList : list[1], list[2], .... list[7]
        }

        for(int i = 1; i < n + 1; i++) {
            String[] alphabet = br.readLine().split(" ");   // readLine을 통해 읽어온 문자열을 공백을 기준으로 나눠서 저장하는 String배열

            /* 영어를 숫자로 변경해주는 부분 ( 인덱스 개념을 이용하기 위하여 ) */
            int data = alphabet[0].charAt(0) - 'A' + 1;     // 입력 받은 데이터의 첫번째 알파벳을 인덱스로 사용
            int left = alphabet[1].charAt(0) - 'A' + 1;     // B = 2
            int right = alphabet[2].charAt(0) - 'A' + 1;    // C = 3
            list[data].add(new Node(left, right));          // list[1].add(new Node(2, 3));
        }

        preorder(1);        // 전위 계산
        sb.append("\n");
        inorder(1);         // 중위 계산
        sb.append("\n");
        postorder(1);       // 후위 계산
        return sb.toString();       // StringBuilder로 만들었기 때문에 toString으로 String타입으로 반환

    }

    static void preorder(int start) {
        for(Node node : list[start]) {  // list[1], list[2],...,list[7] 의 모든 list를 node로 불러와서 출력
            int l = node.left;          // node 의 첫 번째 자식을 l에 담는다
            int r = node.right;         // node 의 두 번째 자식을 r에 담는다 (이진 트리기 때문에 l, r 두 개만 구분)

            sb.append((char)(start+'A'-1)); // StringBuilder에 다시 원래의 알파벳으로 출력하기 위해 인덱스로 계산했던 값들을 되돌림 (start+'A'-1) = (1+65-1) = 65 = 'A'
            if((l + 'A' - 1) != '.') preorder(l);   // 2+65-1 = 66 = B, 'B' != '.' 이면 preorder(2) 실행 -> DFS 방식으로 왼쪽 자식 먼저 쭉 진행
            if(r != '.' - 'A' + 1) preorder(r);     //
//            if(r != -18) preorder(r);  // '.' 은 아스키코드 46, r이 'A'가 아닐 경우 preorder(r) 실행
        }
    }

    static void inorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) inorder(l);
            sb.append((char)(start+'A'-1));
            if(r != -18) inorder(r);
        }
    }

    static void postorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) postorder(l);
            if(r != -18) postorder(r);
            sb.append((char)(start+'A'-1));
        }
    }


}
