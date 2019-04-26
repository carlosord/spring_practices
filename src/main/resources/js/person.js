$(document).ready(function(){

    $("#name").change( function(){
       $('#fullname').val( $('#name').val()+" "+ $('#lastname').val());
        });

     $("#lastname").change( function(){
       $('#fullname').val( $('#name').val()+" "+ $('#lastname').val());
         });
    });