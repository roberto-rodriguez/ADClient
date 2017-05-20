
var host = "http://adreporttomcat-env.us-east-1.elasticbeanstalk.com/";
//var host = "http://localhost:8098/ADReport/"; 


function next() {
    goTo('next');
}
 
function back() {
    goTo('back');
}

function goTo(event) {
    $.ajax({
        type: "GET",
        url: $("#flowExecutionUrl").val() + "&_eventId=" + event,
        data: {
            // idAct: id
        },
        success: function (data) {
            $('#content').html(data);
        },
        error: function (response) {
            alert('error');
        }
    });
}
