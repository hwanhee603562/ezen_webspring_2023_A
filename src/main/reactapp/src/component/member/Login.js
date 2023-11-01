
import { Link } from 'react-router-dom'; // Link 컴포넌트 호출
import styles from '../../css/login.css'; // css 호출
import axios from 'axios';

export default function Login( props ){

    // 1. 로그인 버튼을 클릭했을때.
    function onLogin(e){ console.log(e);
        // 2. axios를 이용한 restApi 로 spring Controller 데이터 전달
            // 3-1. 데이터구성[ JSON ]
            /*
            let info = {
                memail : document.querySelector('.memail').value ,
                mpassword : document.querySelector('.mpassword').value
            };
            */

            // 3-2. 데이터 구성[ FORM ]
            let loginForm = document.querySelectorAll('.loginForm')[0];
            let loginFormData = new FormData( loginForm );


            // 4. !! AXIOS  통신  [ *SPRING CONTROLLER 매핑 확인후 ]
            axios
                .post('/member/login' , loginFormData )
                .then( r => {
                    console.log(r);
                    if( r.data ){
                        alert('로그인 성공');
                        window.location.href = '/';
                    }
                    else{  alert('로그인 실패'); }
                 })
                 .catch( e => { console.log(e); })
            // CORS policy 오류 발생 해결방안
                // - 스프링 controller 클래스 @CrossOrigin("http://localhost:3000")
    }

    return(<>
        <div className="loginContainer">
            <h3> ReactEzen LOGIN </h3>

            {/* AXIOS가 아닌 configure를 이용한 방식 */}
            <form className='loginForm'>
                아이디 <input type="text" placeholder='email address' name='memail' className='memail' id='memail'/>
                비밀번호 <input type="password"  placeholder='password' name='mpassword' className='mpassword' id='mpassword' />
                <Link to=''>아이디찾기 </Link> <Link to=''> 비밀번호찾기 </Link>
                <button type="button" onClick={ onLogin }>로그인</button>
                <a className="oauthBtn" href="/oauth2/authorization/kakao"> 카카오 1초 로그인 </a>
                <a className="oauthBtn" href="/oauth2/authorization/naver"> 네이버 1초 로그인 </a>
                <a className="oauthBtn" href="/oauth2/authorization/google"> 구글 1초 로그인 </a>
            </form>
        </div>
    </>)
}

/*
    AXIOS를 이용한 로그인 전송방식
            <form>
                아이디 <input
                    type="text"
                    placeholder='email address'
                    className='memail' />

                비밀번호 <input type="password"
                    placeholder='password'
                    className='mpassword' />


                <Link to=''>아이디찾기 </Link> <Link to=''> 비밀번호찾기 </Link>
                <button onClick={ onLogin } type="button">로그인</button>
            </form>

*/