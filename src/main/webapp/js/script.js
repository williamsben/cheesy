$(document).ready(function() {

    var table = $('#cheese-table').DataTable({
      "ajax": "/demo/cheeses",
      "columns": [
        { "data": "id" },
        { "data": "name" },
        { "data": "taste" }
      ],
      "paging": false,
      "searching": false,
      "info": false,
      "autoWidth": false
    });

    $('#add-button').click(function(e){
        $("#name").removeClass("error");
        $("#taste").removeClass("error");
        $("#name-error-message").remove();
        $("#taste-error-message").remove();
        $.post("/demo/", $("#cheese-form").serialize(), function(data){
            if(data.result){
                $("#name").val('');
                $("#taste").val($("#taste option:first").val());
                table.ajax.reload();
            }else{
                data.errors.forEach(function(error){
                    var selector = "#" + error.id;
                    var divSelector = "#" + error.id + "-wrapper";
                    $(selector).addClass("error");
                    var div = document.createElement("div");
                    div.classList.add("text-center");
                    div.textContent = error.message;
                    div.id = error.id + "-error-message";
                    $(divSelector).append(div);
                });
            }
        });
        return false;
    });

} );
