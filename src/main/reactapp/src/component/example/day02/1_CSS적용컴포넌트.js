// 1. 리액트 확장자 : jsx, js

    // 3. css 파일에서 순수 css 문법
        // 1. 마크업에 class명 정의
        // 2. css파일에서 css생성
        // 3.

import styles from './컴포넌트.css';    // css import

// 1. 컴포넌트 문법 원형
export default function CSS컴포넌트( props ){

    // 1. CSS를 객체에 속성[카멜표기법] 으로 선언하기
    const cssStryle = {
        backgroundColor: 'red',
        width: '500px',
        height: '100px',
        margin : '0 auto'
    }


    return(<>

        <div style={ cssStryle }> CSS 적용하는 방법1 </div>
        <div style = {{
            backgroundColor: 'red',
            width: '500px',
            height: '100px',
            margin : '0 auto'
        }}> CSS 적용하는 방법2 </div>
        <div class = "box3"> CSS 적용하는 방법3 </div>

    </>);
}

