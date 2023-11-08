/*

    mui : 리액트 전용 라이브러리
        1. 설치
            npm install @mui/material @emotion/react @emotion/styled
            npm install @mui/material @mui/styled-engine-sc styled-components

        2. 예제
            import Button from '@mui/material/Button';

*/



import axios from 'axios';
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';


/* MUI TABLE 관련 컴포넌트 import */
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
/* MUI 페이지네이션 */
import Pagination from '@mui/material/Pagination';
//import Stack from '@mui/material/Stack';


// ---------------------------- MUI table sample



export default function BoardList(props){

    // 0. 스프링에게 전달할 객체
    let [ pageDto, setPageDto ] = useState({
        boardDtos : [],
        totalPages : 0
    }); // 스프링에서 전달해주는 DTO와 일치화

    // 1. axios를 이용한 스프링의 컨트롤과 통신
    const [pageInfo, setPageInfo] = useState({
        page : 1 ,
        key : 'btitle' ,
        keyword : '',
        view : 5
    });
    console.log( pageInfo )

    // 1-1. axios를 이용한 스프링의 컨트롤과 통신
    const getBoard = e =>{
        // 1. axios를 이용한 스프링의 컨트롤과 통신
        axios.get('/board', { params : pageInfo }).then( r => {

            console.log(r.data)
            setPageDto(r.data);    // 응답 받은 모든 게시물을 상태변수에 저장
            // setState : 해당 컴포넌트가 업데이트(재랜더링/return재실행)

        });
    }


    // 1-2. 컴포넌트가 생성될 때
    useEffect( ()=> {

        getBoard();

    }, [ pageInfo.page, pageInfo.view ])   // + 의존성배열 : page 변경될 때

    // 2. 페이지 번호를 클릭했을 때
    const onPageSelect = (e, value) =>{

        pageInfo.page = value;          // 클릭한 페이지번호로 변경
        setPageInfo( {...pageInfo} )    // 새로고침 [상태변수의 주소값이 바뀌면 재랜더링]

    }

    // 3. 검색 버튼을 눌렀을 때  // 첫페이지 1페이지 초기화
    const onSearch = e => {

        setPageInfo( {...pageInfo, page : 1} )  // 첫 페이지 1페이지 초기화
        getBoard();

    }



    // 4.

    return(<>

        <h3>게시물 목록</h3>
        <a href="/board/write"> 글쓰기 </a>

        <p> page : { pageInfo.page } totalCount : { pageDto.totalCount } </p>

        <select value={ pageInfo.view } onChange={ e => {
            setPageInfo( { ...pageInfo, view : e.target.value } )
        } }>
            <option value="5"> 5 </option>
            <option value="10"> 10 </option>
            <option value="20"> 20 </option>
        </select>
        <button type="button" onClick={ e => {
            setPageInfo( { ...pageInfo, key : '', keyword : '', page : 1 } )
            getBoard()
        } } > 검색제거 </button>

        <TableContainer component={Paper}>
              <Table sx={{ minWidth: 650 }} aria-label="simple table">


                {/* 테이블 제목 구역 */}
                <TableHead>
                  <TableRow>
                    <TableCell style={{ minWidth : '10%' }} align="center" align="center">번호</TableCell>
                    <TableCell style={{ minWidth : '55%' }} align="center" align="center">제목</TableCell>
                    <TableCell style={{ minWidth : '10%' }} align="center" align="center">작성자</TableCell>
                    <TableCell style={{ minWidth : '10%' }} align="center" align="center">작성일</TableCell>
                    <TableCell style={{ minWidth : '10%' }} align="center" align="center">조회수</TableCell>
                  </TableRow>
                </TableHead>

                {/* 테이블 내용 구역 */}
                <TableBody>
                  {pageDto.boardDtos.map((row) => (
                    <TableRow key={row.name} sx={{ '&:last-child td, &:last-child th': { border: 0 } }} >
                      <TableCell align="center">{row.bno}</TableCell>
                      <TableCell align="center">
                        <Link to={"/board/view?bno="+row.bno}> {row.btitle} </Link>
                      </TableCell>
                      <TableCell align="center">{row.memail}</TableCell>
                      <TableCell align="center">{row.cdate}</TableCell>
                      <TableCell align="center">{row.bview}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>


              </Table>
            </TableContainer>

        <div style={{ display : 'flex' , flexDirection : 'column' , alignItems : 'center' , margin : '10px' }}>

            {/* count : 전체 페이지 수   onChange : 페이지번호를 클릭/변경 했을 때 이벤트 */}
            <Pagination page={ pageInfo.page } count={ pageDto.totalPages } variant="outlined" onChange={ onPageSelect } />
        </div>

        {/* 검색 */}
        <div style= {{ margin : '20px' }}>
            <select
                value={ pageInfo.key }
                onChange={
                    e =>{ setPageInfo(
                        { ...pageInfo, key : e.target.value } ) }
                }
            >
                <option value="btitle"> 제목 </option>
                <option value="bcontent"> 내용 </option>
            </select>
                <input
                    type="text"
                    value={ pageInfo.keyword }
                    onChange={
                        e =>{ setPageInfo(
                            { ...pageInfo, keyword : e.target.value } ) }
                    }
                />
                <button type="button" onClick={ onSearch }> 검색 </button>
        </div>








    </>)
}