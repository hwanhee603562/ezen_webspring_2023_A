import { useStateParams } from 'react-router-dom'
import {Link, useSearchParams} from "react-router-dom";
import axios from 'axios';
import { useState, useEffect } from 'react'

export default function BoardUpdate(props){
    const [searchPrams,setSearchParams] = useSearchParams()
    const bno = searchPrams.get("bno")

    // 1. 현재 게시물의 정보를 가지는 상태관리 변수
    const [ board, setBoard ] = useState( {} )

    // 2. 개별 게시물 출력 요청
        // 개별 게시물 출력 [ 실행조건 : 컴포넌트 최초 1번 실행 ]
    const onGet = e => {
        axios.get( '/board/doGet', { params : { bno : bno } } )
        .then( r =>{
            console.log( r.data )
            setBoard(r.data);

        })
    }
    useEffect( () => { onGet() }, [] )

    // 3. 개별 게시물 수정 요청
    const boardUpdate = e =>{

        const boardForm = document.querySelectorAll('.boardForm')[0]
        const boardFormData = new FormData( boardForm )

        boardFormData.set( 'bno', bno );    // 수정할 게시물 번호를 폼 속성에 추가

        axios.put('/board', boardFormData)
            .then( r => {

                if(r.data){

                    alert('글 수정 성공')
                    window.location.href = '/board/view?bno='+bno;

                } else {
                    alert('글 수정 실패')
                }

            })

    }


    return (<>
        <div>
            <h3>게시물 쓰기</h3>
            <form className="boardForm">
                <input type="text" placeholder='제목' name="btitle" value={ board.btitle }
                 onChange = { e =>{

                    setBoard( { ...board, btitle : e.target.value } )

                 }}/> <br/>

                <textarea placeholder='내용' name="bcontent" value={ board.bcontent }
                onChange = { e =>{

                    setBoard( { ...board, bcontent : e.target.value } )

                }}></textarea>  <br/>

                <button type="button" onClick={boardUpdate} > 수정 </button>
            </form>
        </div>
    </>)
}


























