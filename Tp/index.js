
let clicked=false;
let ishidden=false;


let btn1=document.getElementById("btn");
btn1.addEventListener('click',()=>{
  clicked=!clicked;


  if(clicked){
    document.getElementById("div1").style.backgroundColor="red"

  }else{
    document.getElementById("div1").style.backgroundColor="blue"

  }

});

let changevisibility=()=>{
    ishidden=!ishidden;
    if(ishidden){
        document.getElementById("visibleparagraph").style.visibility="hidden";

    }else{
        document.getElementById("visibleparagraph").style.visibility="visible";

    }


}
let tovalidate=(element)=>{
console.log(element);
//     if(document.getElementById("name").innerText===""){
// alert("WAAAAAAAAAA");
//     }
}
console.log("jjj");

let elements=["C","DEL","/","*",7,8,9,"-",4,5,6,"+",1,2,3,"=","0","."];
let PlaneCalculationInput="0";
let calinterface=document.getElementById("calInterface");
for(let i=0;i<18;i++){
let newelement=document.createElement('button');
newelement.innerText=elements[i];
newelement.addEventListener('click',()=>{
    PlaneCalculationInput==="0"?PlaneCalculationInput="":"";
        switch(elements[i]){
            case "C":PlaneCalculationInput="0";
            case "=":break;
            case "DEL":PlaneCalculationInput.length===1?PlaneCalculationInput="0":PlaneCalculationInput=PlaneCalculationInput.substring(0,PlaneCalculationInput.length-1);break;
            default:PlaneCalculationInput=PlaneCalculationInput+elements[i].toString();         
                }
                document.getElementById("PlaneCalculationInput").innerText=PlaneCalculationInput;
                if(newelement.innerText==="="){
                    document.getElementById("PlaneCalculationInput").innerText=eval(PlaneCalculationInput);
                             
                } 
});
calinterface.appendChild(newelement);
}