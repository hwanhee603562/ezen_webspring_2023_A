import {Link} from 'react-router-dom';


export default function Footer( props ){
    return <>
        <footer>
            <nav>
                <a href="#" target='blank'> 회사소개 </a> |
                <a href="#" target='blank'> 개인정보규정 </a> |
                <a href="#" target='blank'> 환불규정 </a> |
                <a href="#" target='blank'> 찾아오시는길 </a> |
                <a href="#" target='blank'> 고객센터 </a>
            </nav>
            <p>
                <div className> 이젠 리액트 </div>
                <div> hwanhee603562@gmail.com </div>
                <div> 010-4025-6035 </div>
                <div> Copyright 2023. ezenreact. All Rights Reserved </div>
            </p>
        </footer>
    </>
}