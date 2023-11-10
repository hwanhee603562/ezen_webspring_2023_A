import axios from 'axios';
import { useEffect, useState } from 'react';

export default function Category( props ){
    // props : 속성객체{ 키 : 값, 키 : 값 }

    console.log( props )
    // props 객체의 category 키 호출  => value
    const category = props.category

    return (<>
        <div style={{ display:'flex' , justifyContent : 'space-between' }}>
            <div> {category.pcname} </div>

            {/* 전달 받은 props의 메서드 사용 */}
            <div>
                <button type="button"> 수정 </button>
                <button

                onClick={ e => {
                    props.deleteCategory( e, category.pcno )
                }}
                type="button"> 삭제 </button>
            </div>
        </div>
    </>)
}