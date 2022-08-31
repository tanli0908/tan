function contranst(){
    var  tableOne= $("#tableOne").val();
    var  tableTwo= $("#tableTwo").val();
   console.log(tableOne+"======"+tableTwo);
    $("#tableOneLeft").val(leftData(tableOne,tableTwo));
    $("#tableMiddle").val(middleData(tableOne,tableTwo));
    $("#tableOneRight").val(rightData(tableOne,tableTwo));
}
function spitValue(str) {
    return str.split("\n");
}
function leftData(tableOne,tableTwo){
    var arr_tableOne= spitValue(tableOne);
    var arr_tableTwo= spitValue(tableTwo);
    var arr_lef=[];
    for (let i = 0; i < arr_tableTwo.length; i++) {
        var a=0;
        for (let j = 0; j < arr_tableOne.length; j++) {
            if(arr_tableOne[j]==arr_tableTwo[i]){
                a=1;
            }
        }
        if(a==0){
            arr_lef.push(arr_tableTwo[i]);
        }
    }
    return arrNewline(arr_lef);
}
function middleData(tableOne,tableTwo) {
    var arr_tableOne= spitValue(tableOne);
    var arr_tableTwo= spitValue(tableTwo);
    var arr_lef=[];
    for (let i = 0; i < arr_tableTwo.length; i++) {
        var a=0;
        for (let j = 0; j < arr_tableOne.length; j++) {
            if(arr_tableOne[i]==arr_tableTwo[j]){
                a=1
            }
        }
        if(a==1){
            arr_lef.push(arr_tableTwo[i])
        }
    }
    return arrNewline(arr_lef);
}
function rightData(tableOne,tableTwo) {
    var arr_tableOne= spitValue(tableOne);
    var arr_tableTwo= spitValue(tableTwo);
    var arr_lef=[];
    for (let i = 0; i < arr_tableOne.length; i++) {
        var a=0;
        for (let j = 0; j < arr_tableTwo.length; j++) {
            if(arr_tableOne[i]==arr_tableTwo[j]){
                a=1
            }
        }
        if(a==0){
            arr_lef.push(arr_tableOne[i])
        }
    }
    return arrNewline(arr_lef);
}
function arrNewline(arr) {
    if(arr.length>0){
        var sttr="";
        for (let i = 0; i < arr.length; i++) {
            if(i==0){
                sttr+=arr[i];
            }else{
                sttr+="\n"+arr[i];
            }
            
        }
        return sttr;
    }
    return ""; 
}
