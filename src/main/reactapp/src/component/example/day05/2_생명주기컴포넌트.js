
// ================ js형식
import{ useState, useEffect } from 'react'

export default function 생명주기컴포넌트(){

    // 1. useState 함수를 이용한 초기값 0으로 하는 [변수, 수정함수] 리턴 받음
    let [ value, setValue ] = useState(0);
    const valueUpdate = e =>{
        setValue( ++value )
    }


    let [ data, setData ] = useState( 0 );
    const dataUpdate = e =>{
        setData( ++data );
    }

    // 2. 컴포넌트 생명주기 1.탄생 / 2.업데이트 / 3.제거
        // 1. 컴포넌트 탄생 / 업데이트
        // - 컴포넌트가 첫 실행과 업데이트될 때 실행되는 함수
            // useEffect(함수);
    useEffect( ()=>{
        console.log('[1]Effect 실행');
    })

        // 2. 컴포넌트 탄생
        // - 컴포넌트가 첫 실행될 때만 실행되는 함수
            // useEffect(함수 , []);
    useEffect( ()=>{
        console.log('[2]Effect 실행')
    }, [])

        // 3. 컴포넌트 탄생 / 특정 상태 업데이트
        // - 의존하고 있는 배열(상태변수)에 대해서만 업데이트
            // useEffect(함수 , [의존성배열(상태변수)]);
    useEffect( ()=>{
        console.log('[3]Effect 실행')
    }, [value])



    // -------------- jsx 형식

    return(<>

        <div> {value} </div>
        <button onClick={ valueUpdate }> + </button>

        <div> {data} </div>
        <button onClick={ dataUpdate }> + </button>

    </>)

    // -------------- jsx 형식 end

}
// ================ js형식 end



