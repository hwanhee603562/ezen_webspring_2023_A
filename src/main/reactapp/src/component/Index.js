
/*
    Index : 여러 컴포넌트들을 연결하는 최상위 컴포넌트
*/

import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
/* 라우터에 적용할 컴포넌트 호출 */
import Header from './Header';
import Main from './Main';
import Footer from './Footer';

import ExampleList from './example/ExampleList'

/* 헤더 리액트 예제 */
import 컴포넌트1 from './example/day01/1_컴포넌트';
import 컴포넌트2 from './example/day01/2_컴포넌트';
import 컴포넌트3 from './example/day01/3_컴포넌트';
import 컴포넌트4 from './example/day01/4_컴포넌트';

import CSS적용컴포넌트 from './example/day02/1_CSS적용컴포넌트';
import CommentList from './example/day02/CommentList';

import 과제1 from './example/day01/과제1_도서목록';
import 과제2 from './example/day02/과제';

/* Member */
import Login from './member/Login';
import Signup from './member/Signup';

export default function Index( props ){
    return <>
        <div className="webContainer">
            <BrowserRouter>
                <Header />
                <Routes >

                    <Route path='/' element = {< Main />} />

                    {/* MAIN */}
                    <Route path='/example' element = {< ExampleList />} />

                    {/* EXAMPLE */}
                    <Route path='/example/day01/컴포넌트1' element = {< 컴포넌트1 />} />
                    <Route path='/example/day01/컴포넌트2' element = {< 컴포넌트2 />} />
                    <Route path='/example/day01/컴포넌트3' element = {< 컴포넌트3 />} />
                    <Route path='/example/day01/컴포넌트4' element = {< 컴포넌트4 />} />

                    <Route path='/example/day02/1_CSS적용컴포넌트' element = {< CSS적용컴포넌트 />} />
                    <Route path='/example/day02/CommentList' element = {< CommentList />} />

                    <Route path='/example/day01/과제1' element = {< 과제1 />} />
                    <Route path='/example/day02/과제2' element = {< 과제2 />} />

                    <Route path='/login' element = {< Login />} />
                    <Route path='/signup' element = {< Signup />} />

                </Routes >
                <Footer />
            </BrowserRouter>
        </div>
    </>
}




















