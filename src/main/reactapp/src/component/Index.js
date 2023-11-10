
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
import Info from './member/Info';
import Signup from './member/Signup';

/* Axios */
import Axios from './example/day04/1_Axios컴포넌트';

/* Board */
import BoardWrite from './board/BoardWrite';
import BoardList from './board/BoardList';
import BoardView from './board/BoardView';
import BoardUpdate from './board/BoardUpdate';

/* Product */
import ProductAdmin from './product/ProductAdmin';

export default function Index( props ){
    return <>
        <div className="webContainer">
            <BrowserRouter>
                <Header />
                <Routes >

                    {/* '/'로 접근할 시 메인페이지를 보여줌 */}
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

                    {/* MEMBER */}
                    <Route path='/login' element = {< Login />} />
                    <Route path='/info' element = {< Info />} />
                    <Route path='/signup' element = {< Signup />} />

                    <Route path='/example/day04/Axios' element = {< Axios />} />

                    {/* BOARD */}
                    <Route path='/board/list' element = {< BoardList />} />
                    <Route path='/board/write' element = {< BoardWrite />} />
                    <Route path='/board/view' element = {< BoardView />} />
                    <Route path='/board/update' element = {< BoardUpdate />} />

                    {/* ADMIN */}
                    <Route path='/admin/product' element = {< ProductAdmin />} />

                </Routes >
                <Footer />
            </BrowserRouter>
        </div>
    </>
}





















