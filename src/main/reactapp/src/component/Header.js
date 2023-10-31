import {Link} from 'react-router-dom';
import styles from '../css/Header.css';
import axios from 'axios';
import {useState, useEffect} from 'react';

export default function Header( props ){

    // 1. 로그인 상태를 저장할 상태변수 선언
    let [login, setLogin] = useState( null );

    // 로그아웃
    const logout = e =>{

        axios
        .get('/member/logout')
        .then( r=> {

            if(r.data){
                setLogin( null );
                sessionStorage.removeItem('login_token');
            }

        })
        .catch( err => {
            console.log( err );
        })

    }

    {/*회원정보 호출 [ 로그인 여부 확인 ]*/}
    useEffect( () => {
        axios.get('/member/get')
        .then( r=> {
            if( r.data != '' ){

                // 브라우저 세션/쿠키 : 브라우저 개발자도구 Local storage / Session strage
                    // localStorage
                    //      : 모든 브라우저 탭/창 공유[페이지 전환해도 유지] , 브라우저가 꺼져도 유지 - ex) 자동로그인 기능
                    // sessionStorage
                    //      : 탭/창 종료되면 사라짐 , 페이지 전환해도 유지 - ex) 로그인 여부

                    // 세션/쿠키 저장 : .setItem(key, value)
                    // 세션/쿠키 호출 : .getItem(key)
                    // 세션/쿠키 제거 : .removeItem(key)
                sessionStorage.setItem('login_token', JSON.stringify(r.data));
                        // JSON -> 문자열
                        // session 은 문자열만 저장되기에 형변환
                setLogin( JSON.parse( sessionStorage.getItem('login_token') ) );
                        // 문자열 -> JSON
                        // login 상태 변수에 JSON으로 저장하기 위해 형변환
            }
        })
        .catch( err => {
            console.log( err );
        })
    }, [])






    return <>
        <header>
            <h2> 이젠리액트 </h2>
            <ul>
                <li> <Link to='/example'> 리액트예제 </Link> </li>
                <li> <Link to='/'> TODO </Link> </li>
                <li> <Link to='/'> 비회원게시판 </Link> </li>
                <li> <Link to='/'> 회원게시판 </Link> </li>

                {/* 삼항연산자 */}
                {
                    login == null
                    ? (<>
                        <li> <Link to='/login'> 로그인 </Link> </li>
                        <li> <Link to='/signup'> 회원가입 </Link> </li>
                    </>)
                    : (<>
                        <li> { login.memail }님 </li>
                        <li> <a to='/info'> 내정보 </a> </li>
                        <li> <div onClick={logout}> 로그아웃 </div> </li>
                    </>)
                }

            </ul>
        </header>
    </>
}


























