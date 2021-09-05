/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function renderPager(id, pageindex, totalpage, gap) {

    var container = document.getElementById(id);
    container.innerHTML += "<a href='#'>&laquo;</a>";
//    if (pageindex > gap + 1)
//    {
//        container.innerHTML += "<a href='ManageProducts?page=1'>First</a>"
//    container.innerHTML += "<a href='ManageProducts?page=1'>First</a>";
//    }

    for (var i = pageindex - gap; i < pageindex; i++)
    {
        if (i >= 1)
        {
//            container.innerHTML += "<a href='ManageProducts?page=" + i + "'>" + i + "</a>"
            container.innerHTML += "<a  href='ManageQuiz?page=" + i + "' class='page-link'>" + i + "</a>";
        }
    }

    //container.innerHTML += "<span>" + pageindex + "</span>"
    container.innerHTML += "<a class='active' href='ManageQuiz?page=" + pageindex + "' class='page-link'>" + pageindex + "</a>";

    for (var i = pageindex + 1; i <= pageindex + gap; i++)
    {
        if (i <= totalpage)
        {
//            container.innerHTML += "<a href='ManageProducts?page=" + i + "'>" + i + "</a>"
            container.innerHTML += "<a href='ManageQuiz?page=" + i + "' class='page-link'>" + i + "</a>";
        }
    }

//    if (pageindex < totalpage - gap)
//    {
//        container.innerHTML += "<a href='ManageProducts?page=" + totalpage + "'>Last</a>"
//    container.innerHTML += "<a href='ManageProducts?page=" + totalpage + "'>Last</a>";
//    }
    container.innerHTML += "<a href='#'>&raquo;</a>";
}

function renderPagerForSearch(id, pageindex, totalpage, gap, searchStr) {

    var container = document.getElementById(id);
    container.innerHTML += "<a href='#'>&laquo;</a>";
//    if (pageindex > gap + 1)
//    {
//        container.innerHTML += "<a href='ManageProducts?page=1'>First</a>"
//    container.innerHTML += "<a href='ManageProducts?page=1'>First</a>";
//    }

    for (var i = pageindex - gap; i < pageindex; i++)
    {
        if (i >= 1)
        {
//            container.innerHTML += "<a href='ManageProducts?page=" + i + "'>" + i + "</a>"
            container.innerHTML += "<a  href='SearchProducts?q=" + searchStr + "&page=" + i + "' class='page-link'>" + i + "</a>";
        }
    }

    //container.innerHTML += "<span>" + pageindex + "</span>"
    container.innerHTML += "<a class='active' href='SearchProducts?q=" + searchStr + "&page=" + pageindex + "' class='page-link'>" + pageindex + "</a>";

    for (var i = pageindex + 1; i <= pageindex + gap; i++)
    {
        if (i <= totalpage)
        {
//            container.innerHTML += "<a href='ManageProducts?page=" + i + "'>" + i + "</a>"
            container.innerHTML += "<a href='SearchProducts?q=" + searchStr + "&page=" + i + "' class='page-link'>" + i + "</a>";
        }
    }

//    if (pageindex < totalpage - gap)
//    {
//        container.innerHTML += "<a href='ManageProducts?page=" + totalpage + "'>Last</a>"
//    container.innerHTML += "<a href='ManageProducts?page=" + totalpage + "'>Last</a>";
//    }
    container.innerHTML += "<a href='#'>&raquo;</a>";
}

$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});

function handleAction() {

//    const id = document.getElementById('id').value;
//    const name = document.getElementById('name').value;
    const image = document.getElementById('imgAdd').value;
//    const price = document.getElementById('price').value;

//    document.getElementById('edit-id').value = id;
//    document.getElementById('edit-name').value = name;
    document.getElementById('imageAdd').innerHTML = "<img src='"+image+"' style='width:200px;height:150px'>";
//    document.getElementById('edit-price').value = price;

}



