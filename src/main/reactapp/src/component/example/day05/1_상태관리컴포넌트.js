
import{ useState } from 'react';    // 리액트 내장함수 중에 useState 훅 중 하나의 함수
export default function 상태관리컴포넌트(){



    let value1 = 10;
    function value1증가( e ) { value1++; }



    // useState 함수에 매개변수 전달하고 2개를 가지는 배열 리턴
        /*
            useState
                [0] : 값
                [1] : 그 값을 수정할 수 있는 함수
                    - name : "bound dispatchSetState"
                    - * 해당 컴포넌트만 재실행
                    - setValue2( 변경할값 ) : 변경할 값에 계산식 있을 경우
            let [ 변수명, set함수명 ] useState( 초기값 )
                - 해당 변수는 지역변수가 아닌 공유변수로 사용한다
                - 하지만 다른 컴포넌트에서는 사용불가
        */
    let 상태변수 = useState('훅이란무엇인가?');
    console.log(상태변수);
    console.log(상태변수[0]);
    console.log(상태변수[1]);

    let [value2, setValue2] = useState(10);
    function value2증가( e ) {
        setValue2( ++value2 );
    }

    {/*alert('컴포넌트 랜더링중');*/}

    let value3 = '텍스트입력';
    let [ value4, setValue4 ] = useState('텍스트입력')
    // - 입력값이 체인지될 때마다 실행되는 함수
    const value4변경 = e => {
        setValue4( e.target.value );
    }
    /*
        e : 함수를 실행한 이벤트 객체 ( 이벤트리스너의 객체 )
        e.target : 이벤트가 발생한 document 요소
        e.target.value : 해당 document 요소의 현재값
    */


    {/* -------------- jsx형식 -------------- */}
    return(<>

        <div> { value1 } <button onClick={ value1증가 }> value1증가 </button> </div>
        <div> { value2 } <button onClick={ value2증가 }> value2증가 </button> </div>
        <div> < input type="text" /> </div>
        <div> < input type="text" value={ value3 } /> </div>
        <div> < input type="text" value={ value4 } onChange = { value4변경 } /> </div>


    </>)
    {/* ------------ jsx형식 end ------------ */}
}


















