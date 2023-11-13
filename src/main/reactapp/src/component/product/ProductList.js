import axios from 'axios';
import { useEffect, useState } from 'react';

export default function ProductList( props ){

    // 0. 상태변수
    const [ productList, setProductList ] = useState([]);

    // 1. 제품호출 [ 컴포넌트 실행될 때 ]
    const onProductAll = e =>{

        axios.get( '/product' ).then( r =>{
            console.log(r.data)
            setProductList( r.data )
        })

    }

    useEffect( ()=>{
        onProductAll();
    }, [])

    return (<>
        <h3> 제품 목록 </h3>
        <table style={{ width : '100%' }}>
            <tr>
                <th> 제품번호 </th>
                <th> 대표이미지 </th>
                <th> 카테고리명 </th>
                <th> 제품명 </th>
                <th> 제품가격 </th>
                <th> 상태 </th>
                <th> 재고 </th>
                <th> 비고 </th>
            </tr>
            {
                productList.map( p =>{
                    return (<>
                        <tr>
                            <td> { p.pno } </td>
                            <td>
                                <img style={{width : '100%'}} src={"http://localhost:80/static/media/"+p.imgList[0].uuidFileName} />
                            </td>
                            <td> { p.categoryDto.pcname } </td>
                            <td> { p.pname } </td>
                            {/* 1000 단위 쉼표 */}
                            <td> { p.pprice.toLocaleString() } </td>
                            <td> { p.pstate } </td>
                            <td> { p.pstock } </td>
                            <td> 비고 </td>

                        </tr>
                    </>)
                })
            }
        </table>
    </>)
}