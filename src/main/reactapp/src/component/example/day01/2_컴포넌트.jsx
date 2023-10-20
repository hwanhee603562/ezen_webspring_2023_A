/*
    컴포넌트 만들기
        - 리액트 2가지 컴포넌트 [ 클래스형 컴포넌트 vs 함수형  ]
        - 1. 리액트 컴포넌트 만들 때 사용하는 확장자 JSX
        - 2. function 컴포넌트명() {}
            - js 함수 선언 비슷
        - 3. exeport default 컴포넌트명;
            - 해당 jsx 파일을 import 했을 때 내보내기할 컴포넌트 선언
        - 4. return HTML 문법 작성
             ** html 2줄 이상일 때는 이용한 시작과 끝 구분
                1. ( <> HTML문법 </> )
                2. ( <div> HTML문법 </div> )
 */

function 컴포넌트2(){

    return(<div>
        <h1> 컴포넌트(함수) 에서 HTML 작성 </h1>
        <div> HTML 2줄 이상일 때 </div>
    </div>)

}

export default 컴포넌트2;