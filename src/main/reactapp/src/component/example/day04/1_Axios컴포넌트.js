import axios from 'axios';

export default function Axios( props ) {


        // 컴포넌트(함수) 안에서 함수 정의하기
        // 1.
        function 함수1(e){    // e : event [ event 실행 후 상태/결과 저장된 매개변수 ]
            console.log(e);
        }


        // 2. 화살표함수를 저장하는 변수
        const 함수2 = e => {
            console.log(e);
        }

        // 3. 화살표함수 매개변수 받기
        const 함수3 = (e, data) =>{
            console.log(e);
            console.log(data);
        }


        // 1. GET
        function doGet(){
            {/* axios.메소드( url ).then( 리턴값 => {}) */}

            axios.get('http://jsonplaceholder.typicode.com/posts')
            .then( response => {
                console.log(response);
            });

            axios.get('http://jsonplaceholder.typicode.com/posts/1')
                .then( response => {
                console.log(response);
            });

            axios.get('http://jsonplaceholder.typicode.com/comments?postId=1')
                .then( r => {
                console.log(r);
            });

            axios.get('http://jsonplaceholder.typicode.com/comments?postId=1')
                .then( r => {
                console.log(r);
            });


        }

        return (<>
            {/*jsx에서 이벤트속성 [ 1. 이벤트명(카멜표기법) 2.{ 함수명 } ]*/}
            <h3> AXIOS 테스트 </h3>
            <button type="button" onClick={함수1}> 함수1 </button>
            <button type="button" onClick={함수2}> 함수2 </button>
            <button type="button" onClick={ e => 함수3(e, 3) }> 함수3 </button>

            {/* import axios from 'axios' */}
            <button type="button" onClick={ doGet() } > doGet AXIOS </button>
        </>)



}