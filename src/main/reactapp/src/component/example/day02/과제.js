

import styles from './과제.css'
export default function 과제 (){

    return  (<>
        <div className="todowrap">

                <h1> 나만의 할일 목록 </h1>

                <div class="todo_top">
                     <input className="tcontent" type="text" />
                    <button type="button"> 등록 </button>
                </div>

                <div className="todo_bottom">

                        <div className="todo">
                            <div className="tcontent"> 리액트배우기 </div>
                            <div className="ectbtns">
                                <button type="button"> 상태변경 </button>
                                <button type="button"> 제거하기 </button>
                            </div>
                        </div>
                        <div className="todo">
                            <div className="tcontent"> 자바배우기 </div>
                            <div className="ectbtns">
                                <button type="button"> 상태변경 </button>
                                <button type="button"> 제거하기 </button>
                            </div>
                        </div>
                        <div className="todo">
                            <div className="tcontent"> 파이썬배우기 </div>
                            <div className="ectbtns">
                                <button type="button"> 상태변경 </button>
                                <button type="button"> 제거하기 </button>
                            </div>
                        </div>
                        <div className="todo">
                            <div className="tcontent"> C언어배우기 </div>
                            <div className="ectbtns">
                                <button type="button"> 상태변경 </button>
                                <button type="button"> 제거하기 </button>
                            </div>
                        </div>

                </div>
        </div>

    </>);

}