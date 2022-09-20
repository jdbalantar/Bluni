let sidebar = document.querySelector(".sidebar");
let closeBtn = document.querySelector("#btn");
closeBtn.addEventListener("click", () => {
    sidebar.classList.toggle("open");
    menuBtnChange();//calling the function(optional)
});

function menuBtnChange() {
    if (sidebar.classList.contains("open")) {
        document.getElementById("header").style.left = "250px";
        document.getElementById("header").style.width = "calc(100% - 250px)";
        closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");
    } else {
        document.getElementById("header").style.left = "78px";
        document.getElementById("header").style.width = "calc(100% - 78px)";
        closeBtn.classList.replace("bx-menu-alt-right", "bx-menu");
    }
}

function limpiarCampos() {
    window.location='/views/computers/';
}

$(document).ready(function() {
    $(".contactclass").click(function () {
        $('html,body').animate({
            scrollTop: $("#D_contact").offset().top
        }, 500);
    });
});

$(document).ready(function() {
    $(".aboutclass").click(function () {
        $('html,body').animate({
            scrollTop: $("#aboutid").offset().top
        }, 1);
    });
});