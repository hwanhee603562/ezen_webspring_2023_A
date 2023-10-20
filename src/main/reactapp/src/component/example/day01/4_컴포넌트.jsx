
/*

    jsp 구역
        1. (<> HTML 문법 </>)     : JSX 구역 표시
        2. (<> (JS문법) </>)      : JSX 구역에서 JS문법을 사용할 때는 {JS문법}

 */

function 컴포넌트4(){

    return (<>
        <input type="text" />
        <내가만든태그속성 이름="유재석" 나이={30} />
        <내가만든태그속성 이름="강호동" 나이={40} />
    </>)

}

function 내가만든태그속성( props ){ // props : 컴포넌트의 매개변수 (객체)
    // ---------------- js구역 -----------------
    console.log( props );
    // ---------------- jsx구역 -----------------
    return (<>
        <div> 컴포넌트4가 전달한 속성 : { props.이름 } / 나이 : { props.나이 } </div>
    </>)

}

export default 컴포넌트4;

