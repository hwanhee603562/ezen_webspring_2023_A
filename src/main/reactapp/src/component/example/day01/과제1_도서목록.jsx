function Component1(){
    return (<>
            <Component2 도서명="자바" 저자="유재석" 소비자가격={30000} />
            <Component2 도서명="파이썬" 저자="강호동" 소비자가격={25000} />
            <Component2 도서명="리액트" 저자="신동엽" 소비자가격={28000} />
        </>)
}

function Component2( props ){
    return (<>
        <h2> 도서명 : 이것이 { props.도서명 }다 </h2>
        <div> 저자 : { props.저자 } / 소비자가격 : { props.소비자가격 } </div>
    </>)
}

export default Component1;
