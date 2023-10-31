
import styles from '../../css/login.css'; // css 호출
import axios from 'axios';
import{ useState, useEffect } from 'react';


export default function Info( props ){  // 로그인 상태별로 / 회원 권한 mroll별로 페이지 접근 제한

    // axios로부터 전달받은 로그인된 회원정보를 상태변수에 저장
    const[ member, setMember ] = useState( null );

    // 로그인 정보를 호출해서 출력하기 / 최초 1번 실행
    useEffect( () => {

        axios
            .get('/member/get')
            .then( r=> {
                setMember( r.data )
            })
            .catch( err => {
                console.log( err );
        })

    }, [])

    // 1. 이름 입력했을 때 상태변경
    const mnameInputChange = e => {
        console.log( e.target.value );
        let mnameInput = e.target.value;

        //let changeMember = member;          // 기존 객체를 새로운 객체에 대입
        //changeMember.mname = mnameInput;    // 객체의 특정 속성만 새로운 값 대입
        //setMember( changeMember );          // 수정된 새로운 객체를 상태변수에 대입
            // 문제점 : setState()는 상태변수의 주소값이 변경될 때 반응/랜더링

        // 1. 객체 복사방법 {...객체명}, 2. 배열 복사 방법 [...배열명]
        // ... Spread Operator : 얕은복제 ( 번역 : 펼침연산자 )
        // { ...객체명, 속성명 : 값 }  // 복사할 때 해당 속성명이 있으면 수정(덮어쓰기) / 없으면 대입
        setMember( {...member, mname : mnameInput} );
    }


    // 2. 전화번호 변경 [ 이벤트 속성 직접 처리 ]


    // 3. 회원탈퇴
    const onDelete = e => {
        if( window.confirm('정말 탈퇴하시겠습니까?') ){
            axios

                .delete('/member/delete', { params : { 'mno' : member.mno} })
                .then( r=> {
                    if( r.data ){
                        alert('회원삭제되었습니다');
                        // 세션에서 삭제
                        sessionStorage.removeItem('login_token');
                        window.location.href="/"
                    } else alert('삭제 실패하였습니다')
                })
                .catch( err => {
                    console.log( err );
            })
        }
    }

    // 4. 회원수정
        // 새로운 비밀번호 2개가 일치한지 유효성검사 --> 프론트에서 해야함
        // 입력받은 패스워드 값을 저장하는 상태변수
    const[ newPassword, setNewPassword ] = useState({ mpassword : '', mpassword2 : '' })
    const onUpdate = e => {
            //서비스에게 보낼 데이터 구성
            let info = {
                mno : member.mno,
                mname : member.mname,
                mpassword : newPassword.mpassword,  // 새로 입력받은 패스워드를 전송
                mphone : member.mphone
            }
            console.log(info)

            axios



                .put('/member/update', info )
                .then( r => {
                    if( r.data ){
                        alert('수정되었습니다');
                        // 세션에서 삭제
                        window.location.href="/"
                    } else alert('수정 실패하였습니다')
                })
                .catch( err => {
                    console.log( err );
            })

    }

    return(<>
        <div className="loginContainer">
            <h3> ReactEzen Signup </h3>
            <form>
                회원등급 <div> { member != null ? member.mrol : '' } 접근권한 </div>
                이메일 <input value={ member != null ? member.memail : '' } disabled={true} type="text" placeholder='@포함 7~30글자' className='memail'
                    onChange={
                        e => setNewPassword( {...newPassword, mpassword : e.target.value} )
                    }
                />
                새 비밀번호 <input type="password" placeholder='특수문자 조합 5~30글자' className='mpassword'
                    onChange={
                        e => setNewPassword( {...newPassword, mpassword : e.target.value} )
                    }
                />
                새 비밀번호 확인 <input type="password" placeholder='특수문자 조합 5~30글자' className='mpassword2'
                    onChange={
                        e => setNewPassword( {...newPassword, mpassword2 : e.target.value} )
                    }
                />
                이름 <input value={ member != null ? member.mname : '' } type="text" placeholder='이름' className='mname'
                    onChange={ mnameInputChange }
                />
                전화번호 <input value={ member != null ? member.mphone : '' } type="text" placeholder='연락처' className='mphone'
                    onChange={ e => {
                    setMember({ ...member, mphone : e.target.value })} }
                />
                <button type="button" onClick={ onUpdate }>정보 수정</button>
                <button type="button" onClick={ onDelete }>회원 탈퇴</button>
            </form>
        </div>
    </>)
}