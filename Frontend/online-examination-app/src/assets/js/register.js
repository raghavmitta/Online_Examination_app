function register(showhide){
    if(showhide == "show"){
        document.getElementById('popup').style.visibility="visible";
        document.getElementById('homepage').style.visibility="hidden";
    }else if(showhide == "hide"){
        document.getElementById('popup').style.visibility="hidden"; 
        document.getElementById('homepage').style.visibility="visible";

    }
    }