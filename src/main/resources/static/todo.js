console.log('Hello World!');

// 1. get
getContent()
function getContent(){
    console.log('get');
    $.ajax({
        url: '/todo',
        type: 'get',
        data: {},
        success: s => {
            console.log(s);
            let todo_bottom = document.querySelector('.todo_bottom');
            let html = ``

            s.forEach( p =>{

                if( p.tstate ){
                     html += `
                        <div class="todo">
                            <div class="tcontent"> ${p.tcontent} </div>
                            <div class="ectbtns">
                                <button onclick="putContent( ${p.tno}, '${p.tcontent}', '${p.tstate}' )" type="button"> 상태변경 </button>
                                <button onclick="deleteContent( ${p.tno} )" type="button"> 제거하기 </button>
                            </div>
                        </div>
                    `
                } else {
                    html += `
                        <div class="todo successTodo">
                            <div class="tcontent"> ${p.tcontent} </div>
                            <div class="ectbtns">
                                <button onclick="putContent( ${p.tno}, '${p.tcontent}', '${p.tstate}' )" type="button"> 상태변경 </button>
                                <button onclick="deleteContent( ${p.tno} )" type="button"> 제거하기 </button>
                            </div>
                        </div>
                    `
                }

            })

            todo_bottom.innerHTML = html;

        },
        error: e => {
            console.log('에러발생');
        }
    })
}

// 2. post
function uploadPost(){
    console.log('post');
    let tcontent = document.querySelector('.tcontent').value;

    $.ajax({
        url: '/todo',
        type: 'post',
        async: false,
        contentType:
            'application/json',
            data: JSON.stringify({
                tno: 0,
                tcontent: tcontent,
                tstate: true }),
        success: s => {

            if( s ){
                console.log('PUTsuccess');
            }



        },
        error: e => {
            console.log('에러발생');
        }
    })
    tcontent = '';
    getContent();

}

// 3. put
function putContent( tno, tcontent, tstate ){

        $.ajax({
            url: '/todo',
            type: 'put',
            async: false,
            contentType: 'application/json',
                    data: JSON.stringify({
                    tno: tno,
                    tcontent: tcontent,
                    tstate: tstate }),
            success: s => {

                if( s ){
                    console.log('PUTsuccess');
                }
            },
            error: e => {
                console.log('에러발생');
            }
        })

    getContent();
}

// 4. delete
function deleteContent( tno ){

        $.ajax({
            url: '/todo',
            type: 'delete',
            data: {
                tno: tno,
            },
            success: s => {

                if( s ){
                    console.log('PUTsuccess');
                }
            },
            error: e => {
                console.log('에러발생');
            }

        })

    getContent();
}