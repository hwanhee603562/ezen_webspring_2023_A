import axios from 'axios';
import { useEffect, useState } from 'react';

export default function ProductWrite( props ){

    return (<>
        <select>
            {
                props.categoryList.map( c => {
                    return (<> <option value={ c.pcno }> { c.pcname } </option> </>)
                })
            }
        </select>

    </>)

}