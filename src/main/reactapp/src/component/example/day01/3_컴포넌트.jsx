/*

    컴포넌트 내부에서 다른 컴포넌트를 호출하는 방법
        1. 같은 jsx파일이면 import 생략
        2. 다른 jsx파일이면 import
        3. 컴포넌트를 호출하는 방법
             <호출할컴포넌트명 />


 */
{/* 주석 */}
function 컴포넌트3(){
    return(<>
        <h3> '컴포넌트3' 컴포넌트(함수)에서 작성된 HTML </h3>
        <내가만든태그 />
        <input />
    </>)
}
function 내가만든태그(){
    return(<>
        <div> '내가 만든 태그' 컴포넌트(함수)에서 작성된 HTML </div>
    </>)
}

export default 컴포넌트3;