(function() {
    $("#tabProduct").on("click", ".js-delete", function() {
        let buttonClicked = $(this);
        $("#btnsim").attr("data-id", buttonClicked.attr("data-id"));
        $("#modalProduct").modal("show");
    });

    $("#btnsim").on("click", function() {
        let buttonYep = $(this);
        let id = buttonYep.attr("data-id");
        $.ajax(
            {
                url: "/products/delete/" + id,
                method: "GET",
                success: function() {
                    window.location.href = "/products";
                }
            }
        );
    });
})();