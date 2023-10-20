
// 사진 호출하기 : import 사진명 from '사진경로';
import logo from '../../../logo.svg';
// css 파일 호출하기 : import styles form 'CSS파일경로'
import styles from './Comment.css'
export default function Comment ( props ){

    return(<>

        <div className="wrap">
            <img src={logo} className="pimg" /> {/* 작성자 프로필 */}
            <div className="commentBox">
                <div className="commentName"> {props.name} </div> {/* 작성자 이름 */}
                <div className="commentContent"> {props.content} </div> {/* 작성자 내용 */}
            </div>
        </div>


    </>);
}