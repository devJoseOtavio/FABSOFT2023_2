function test(){
    document.getElementById("js-delete").addEventListener("click", function () {
        var modal = new bootstrap.Modal(document.getElementById("modalProduct"));
        modal.show();
    });
}