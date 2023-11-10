import * as React from 'react';
import Box from '@mui/material/Box';
import Tab from '@mui/material/Tab';
import TabContext from '@mui/lab/TabContext';
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';

import CategoryWrite from './CategoryWrite';
import ProductInfo from './ProductInfo';
import ProductList from './ProductList';
import ProductWrite from './ProductWrite';
import axios from 'axios';
import { useEffect, useState } from 'react';
export default function ProductAdmin( props ){

    // 0.출력할 카테고리 목록 을 저장하는 상태변수
    const [ categoryList , setCategoryList ] = useState( [] );

    // 2. 카테고리 출력 AXIOS // 컴포넌트가 열렸을때 / 등록되었을때[재랜더링] // 삭제되었을때
    const printCategory = (e)=>{
        axios.get('/product/category')
            .then( r => { console.log(r.data); setCategoryList(r.data); } );
    }
    useEffect( ()=>{ printCategory() } , [ ] )

    const [value, setValue] = React.useState('1');

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (<>
        <h3> 제품 관리 페이지 </h3>

        <Box sx={{ width: '100%', typography: 'body1' }}>
            <TabContext value={value}>
                <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
                    {/* 탭에 포함된 제목들 */}
                    <TabList onChange={handleChange} aria-label="lab API tabs example" indicatorColor={"secondary"} centered >
                        <Tab label="카테고리 등록" value="1" />
                        <Tab label="제품 등록" value="2" />
                        <Tab label="제품 목록" value="3" />
                        <Tab label="제품 상태" value="4" />
                    </TabList>
                </Box>
                {/* 탭 선택시 출력되는 내용물 */}
                <TabPanel value="1"> <CategoryWrite
                                    categoryList={categoryList}
                                    printCategory={ printCategory }
                /> </TabPanel>
                <TabPanel value="2"> <ProductWrite
                                    categoryList={categoryList}
                                    printCategory={ printCategory }
                /> </TabPanel>
                <TabPanel value="3"> <ProductList/> </TabPanel>
                <TabPanel value="4"> <ProductInfo/> </TabPanel>
            </TabContext>
        </Box>

    </>)
}