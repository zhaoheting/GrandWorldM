$(function(){
    $(".btn").click(function(){
        $(this).button('loading').delay(1000).queue(function(){
            $(this).button('reset');
            $(this).dequeue();
        });
    });
});

function register(){
    window.location.href="http://localhost:8080/auth/register";
}