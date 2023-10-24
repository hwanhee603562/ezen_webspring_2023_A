import{ Link } from 'react-router-dom';

export default function ExampleList( props ){
    return(<>
        <div>
            <Link to='/example/day01/컴포넌트1'> 컴포넌트1 예제 </Link>
            <Link to='/example/day01/컴포넌트2'> 컴포넌트2 예제 </Link>
            <Link to='/example/day01/컴포넌트3'> 컴포넌트3 예제 </Link>
            <Link to='/example/day01/컴포넌트4'> 컴포넌트4 예제 </Link>
            <Link to='/example/day02/1_CSS적용컴포넌트'> 컴포넌트5 예제 </Link>
            <Link to='/example/day02/CommentList'> 컴포넌트6 예제 </Link>
            <Link to='/example/day01/과제1'> 리액트과제1 </Link>
            <Link to='/example/day02/과제2'> 리액트과제2 </Link>
            <Link to='/example/day04/Axios'> Axios </Link>
        </div>
    </>)

}