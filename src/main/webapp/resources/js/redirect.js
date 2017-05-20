
 

function goTo( page  ){
//    window.location = "/ADReport/" + page +".htm"; 
    window.location = host  + page +".htm"; 
}
 

function redirect( path, funct ){
    console.log( 'redirect to ' + path );
    //urlPrefix + 
    $.get( path + ".htm", funct );
}

//function append( data ){
//    console.log('start append');
//    $( "#mainContent" ).html( data );
//    console.log('finish append');
//}
 
