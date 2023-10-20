
// 컴포넌트 호출하기 : import 컴포넌트명 from '파일경로'
import Comment from './Comment.js';
export default function CommentList ( props ){

    let response = [
        {name : '봉준호', content : '안녕하세요1'},
        {name : '손흥민', content : '안녕하세요2'},
        {name : '이환희', content : '안녕하세요3'} ];

    return(<>
        <div className="commentListBox">
            {
                response.map( r=>{
                    return( <Comment name = {r.name} content = {r.content} /> );
                })
            }

        </div>
    </>);

}