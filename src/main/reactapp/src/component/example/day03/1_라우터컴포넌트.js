/*

    컴포넌트 만들기
        - 파일명 : 아무거나.js 혹은 아무거나 [컴포넌트명과 동일하게하는 것을 권장]
        - 컴포넌트 원형
            - 컴포넌트명 : 첫글자는 대문자 [ 무조건 카멜표기법 ]
            export default function 컴포넌트( props ){
                return(<>

                </>)
            }

    컴포넌트 랜더링
        - 최상위 랜더링(가장 먼저 랜더링)
            1. index.js
                import 컴포넌트명 from '컴포넌트경로'
                root.render( <React.StrictMode> ) <컴포넌트명 />

        - 라우터 : 가상 url 만들기
            - 실제 라우터    : 연결 경로를 자동으로 전환해주는 기계
            - 리액트 라우터   : 가상 경로[url]를 만들어서 컴포넌트를 전환해주는 라이브러리
            <BrowserRouter>
                <고정컴포넌트 />
                <Routes >
                    <Route path='/day01/컴포넌트1' element = { <컴포넌트1/> }/>
                    <Route path='/day01/컴포넌트2' element = { <컴포넌트2/> }/>
                    <Route path='/day01/컴포넌트3' element = { <컴포넌트3/> }/>
                    <Route path='/day01/컴포넌트4' element = { <컴포넌트4/> }/>
                </Routes >

            </BrowserRouter>

        - 다른 컴포넌트에서 컴포넌트(페이지) 전환
            라우터경로 :
            1. <a href='(서버/라우터경로)'> </a>
            2. <Link to='(서버/라우터경로)'> </Link>



*/


import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'; // npm i react-router-dom 설치 후 가능
import 컴포넌트1 from '../day01/1_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트2 from '../day01/2_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트3 from '../day01/3_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트4 from '../day01/4_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출

export default function 라우터컴포넌트( props ){

    return(<>
        <BrowserRouter>{/* 브라우저 라우터 시작 */}
            <고정컴포넌트 />  {/* BrowserRouter 안에 있고 Routes 밖에 있는 컴포넌트 */}
            <Routes >{ /* 화면이 전환되는 컴포넌트들의 url 정의 공간 */ }
                <Route path='/day01/컴포넌트1' element = { <컴포넌트1/> }/>          {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
                <Route path='/day01/컴포넌트2' element = { <컴포넌트2/> }/>          {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
                <Route path='/day01/컴포넌트3' element = { <컴포넌트3/> }/>          {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
                <Route path='/day01/컴포넌트4' element = { <컴포넌트4/> }/>          {/* 컴포넌트로 연결할 가상 url 경로 정의 */}
            </Routes >

        </BrowserRouter>{/* 브라우저 라우터 끝 */}
    </>)
}

function 고정컴포넌트 ( props ){

    return (<>
        <div>   {/* a태그는 페이지 리로드 */}
            <a href='/day01/컴포넌트1'> 컴포넌트1 </a>
            <a href='/day01/컴포넌트2'> 컴포넌트2 </a>
            <a href='/day01/컴포넌트3'> 컴포넌트3 </a>
            <a href='/day01/컴포넌트4'> 컴포넌트4 </a>
        </div>
        <div>   {/* Link 컴포넌트는 페이지 리로드 x */}
            <Link to='/day01/컴포넌트1'> 컴포넌트1 </Link>
            <Link to='/day01/컴포넌트2'> 컴포넌트2 </Link>
            <Link to='/day01/컴포넌트3'> 컴포넌트3 </Link>
            <Link to='/day01/컴포넌트4'> 컴포넌트4 </Link>
        </div>
    </>)

}
















