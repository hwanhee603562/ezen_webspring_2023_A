

// 1. get
getContent()
function getContent(){
    console.log('get');
    $.ajax({
        url: '/todos',
        type: 'get',
        data: {},
        success: s => {
            console.log(s);
            let todos_bottom = document.querySelector('.todos_bottom');
            let html = ``

            s.forEach( p =>{


                     html += `
                        <div class="todos">
                            <div class="outputPname"> ${p.pname} </div>
                            <div class="outputPhone"> ${p.phone} </div>
                            <div class="ectbtns">
                                <button onclick="putContent( ${p.pno} )" type="button"> 수정하기 </button>
                                <button onclick="deleteContent( ${p.pno} )" type="button"> 제거하기 </button>
                            </div>
                        </div>
                    `


            })

            todos_bottom.innerHTML = html;

        },
        error: e => {
            console.log('에러발생');
        }
    })
}

// 2. post
function uploadPost(){

    let pname = document.querySelector('.pname').value;
    let phone = document.querySelector('.phone').value;

    $.ajax({
        url: '/todos',
        type: 'post',
        async: false,
        contentType:
            'application/json',
            data: JSON.stringify({
                tno: 0,
                pname: pname,
                phone: phone }),
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

// 3. put
function putContent( pno ){

    var newName = prompt("수정할 이름");
    var newPhone = prompt("수정할 전화번호");


        $.ajax({
            url: '/todos',
            type: 'put',
            async: false,
            contentType: 'application/json',
                    data: JSON.stringify({
                    pno: pno,
                    pname: newName,
                    phone: newPhone }),
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
function deleteContent( pno ){

        $.ajax({
            url: '/todos',
            type: 'delete',
            async: false,
            data: {
                pno: pno,
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